package abitudine;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AbitudineTasksDatabase {
    private static final String CSV_FILE = "tasks_database.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    // Updated with the exact timestamp and user specified
    private static final String CURRENT_USER = "Cristian-Silagan";
    private static final String CURRENT_TIMESTAMP = "2025-05-19 02:54:36"; // UTC time format
    
    // Save task/habit to CSV
    public static boolean saveTask(String taskName, String status, Date dueDate, 
                                 String priority, String category, String notes) {
        try {
            // Check if file exists
            File file = new File(CSV_FILE);
            boolean isNewFile = !file.exists();
            
            // Create file writer in append mode
            FileWriter fw = new FileWriter(CSV_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            // Write headers if new file
            if (isNewFile) {
                pw.println("TaskName,Status,DueDate,Priority,Category,Notes,Timestamp,User");
            }
            
            // Format the due date
            String dueDateStr = dueDate != null ? DATE_FORMAT.format(dueDate) : "";
            
            // Get current timestamp and user
            String timestamp = CURRENT_TIMESTAMP;
            String user = CURRENT_USER;
            
            // Escape fields that might contain commas
            taskName = escapeField(taskName);
            status = escapeField(status);
            priority = escapeField(priority);
            category = escapeField(category);
            notes = escapeField(notes);
            
            // Write the data
            pw.println(String.join(",", 
                taskName, status, dueDateStr, priority, category, notes, timestamp, user));
            
            // Close resources
            pw.close();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving to CSV: " + e.getMessage(), 
                                         "File Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    // Update an existing task at specified row index
    public static boolean updateTask(int rowIndex, String taskName, String status, Date dueDate, 
                                   String priority, String category, String notes) {
        try {
            // Read all tasks from file
            List<String> allTasks = new ArrayList<>();
            boolean headerRead = false;
            String header = "";
            
            File file = new File(CSV_FILE);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Database file not found.", 
                                             "File Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Read the existing file content
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                
                // Read header
                header = br.readLine();
                headerRead = true;
                
                // Read all data lines
                while ((line = br.readLine()) != null) {
                    allTasks.add(line);
                }
            }
            
            // Check if the row index is valid
            if (rowIndex < 0 || rowIndex >= allTasks.size()) {
                JOptionPane.showMessageDialog(null, "Invalid row index for update.", 
                                             "Update Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Format the due date
            String dueDateStr = dueDate != null ? DATE_FORMAT.format(dueDate) : "";
            
            // Escape fields that might contain commas
            taskName = escapeField(taskName);
            status = escapeField(status);
            priority = escapeField(priority);
            category = escapeField(category);
            notes = escapeField(notes);
            
            // Get original timestamp and user from the record being updated
            String[] originalData = parseCsvLine(allTasks.get(rowIndex));
            String originalTimestamp = originalData[6];
            String originalUser = originalData[7];
            
            // Create updated line
            String updatedLine = String.join(",", 
                taskName, status, dueDateStr, priority, category, notes, 
                originalTimestamp, originalUser);
            
            // Replace the old line with updated one
            allTasks.set(rowIndex, updatedLine);
            
            // Write everything back to file
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                // Write header
                if (headerRead) {
                    pw.println(header);
                } else {
                    pw.println("TaskName,Status,DueDate,Priority,Category,Notes,Timestamp,User");
                }
                
                // Write all tasks
                for (String task : allTasks) {
                    pw.println(task);
                }
            }
            
            return true;
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating task: " + e.getMessage(), 
                                         "File Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    // Delete a task at specified row index
    public static boolean deleteTask(int rowIndex) {
        try {
            // Read all tasks from file
            List<String> allTasks = new ArrayList<>();
            boolean headerRead = false;
            String header = "";
            
            File file = new File(CSV_FILE);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Database file not found.", 
                                             "File Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Read the existing file content
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                
                // Read header
                header = br.readLine();
                headerRead = true;
                
                // Read all data lines
                while ((line = br.readLine()) != null) {
                    allTasks.add(line);
                }
            }
            
            // Check if the row index is valid
            if (rowIndex < 0 || rowIndex >= allTasks.size()) {
                JOptionPane.showMessageDialog(null, "Invalid row index for deletion.", 
                                             "Delete Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Remove the task at the specified index
            allTasks.remove(rowIndex);
            
            // Write everything back to file
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                // Write header
                if (headerRead) {
                    pw.println(header);
                } else {
                    pw.println("TaskName,Status,DueDate,Priority,Category,Notes,Timestamp,User");
                }
                
                // Write all remaining tasks
                for (String task : allTasks) {
                    pw.println(task);
                }
            }
            
            return true;
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error deleting task: " + e.getMessage(), 
                                         "File Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    // Get task data for a specific row
    public static String[] getTaskAtRow(int rowIndex) {
        try {
            File file = new File(CSV_FILE);
            if (!file.exists()) {
                return null;
            }
            
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                // Skip header
                br.readLine();
                
                // Track current row
                int currentIndex = 0;
                String line;
                
                // Find the requested row
                while ((line = br.readLine()) != null) {
                    if (currentIndex == rowIndex) {
                        // Return the parsed line
                        return parseCsvLine(line);
                    }
                    currentIndex++;
                }
            }
            
            // If we get here, the row wasn't found
            return null;
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving task: " + e.getMessage(), 
                                         "File Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // Helper method to escape fields with commas
    private static String escapeField(String field) {
        if (field == null) return "";
        
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
    
    // Load tasks/habits into table model
    public static void loadTasksToTable(DefaultTableModel model) {
        try {
            File file = new File(CSV_FILE);
            
            // If file doesn't exist, just return
            if (!file.exists()) {
                return;
            }
            
            // Clear previous data
            model.setRowCount(0);
            
            // Read the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            // Skip header
            String line = br.readLine();
            
            // Read data rows
            while ((line = br.readLine()) != null) {
                String[] rowData = parseCsvLine(line);
                // Only add the first 6 columns (Task, Status, DueDate, Priority, Category, Notes)
                // Skip Timestamp and User for table display
                Object[] tableRow = new Object[6];
                for (int i = 0; i < 6 && i < rowData.length; i++) {
                    tableRow[i] = rowData[i];
                }
                model.addRow(tableRow);
            }
            
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading tasks: " + e.getMessage(), 
                                         "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Simple CSV line parser
    private static String[] parseCsvLine(String line) {
        String[] result = new String[8]; // TaskName,Status,DueDate,Priority,Category,Notes,Timestamp,User
        StringBuilder field = new StringBuilder();
        boolean inQuotes = false;
        int fieldIndex = 0;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                // Handle quoted fields
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                // End of field
                result[fieldIndex++] = field.toString();
                field = new StringBuilder();
            } else {
                field.append(c);
            }
            
            // Make sure we don't go out of bounds
            if (fieldIndex >= result.length) {
                break;
            }
        }
        
        // Add the last field
        if (fieldIndex < result.length) {
            result[fieldIndex] = field.toString();
        }
        
        return result;
    }
    
    // Get the current timestamp
    public static String getCurrentTimestamp() {
        return CURRENT_TIMESTAMP;
    }
    
    // Get the current user
    public static String getCurrentUser() {
        return CURRENT_USER;
    }
}