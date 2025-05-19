package abitudine;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AbitudineTasksDatabase {
    private static final String CSV_FILE = "abitudine_task_database.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    // Current timestamp and user as provided
    private static final String CURRENT_USER = "";
    private static final String CURRENT_TIMESTAMP = ""; // UTC time format
    
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
            pw.println(taskName + "," + status + "," + dueDateStr + "," + priority + "," + 
                      category + "," + notes + "," + timestamp + "," + user);
            
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