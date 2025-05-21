package abitudine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class ExportCSVForm extends JFrame {
    private JTextField filePathField;
    private JButton browseButton, exportButton, cancelButton;
    private JTable sourceTable;

    public ExportCSVForm(JTable tableToExport) {
        this.sourceTable = tableToExport;

        setTitle("Export Habits to CSV");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(470, 180);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Export Habits to CSV", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        titleLabel.setForeground(new Color(255, 153, 0));
        titleLabel.setBounds(10, 10, 440, 30);
        add(titleLabel);

        JLabel pathLabel = new JLabel("File path:");
        pathLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        pathLabel.setBounds(20, 55, 70, 25);
        add(pathLabel);

        filePathField = new JTextField();
        filePathField.setEditable(false);
        filePathField.setBackground(Color.WHITE);
        filePathField.setBounds(90, 55, 230, 25);
        add(filePathField);

        browseButton = new JButton("Browse...");
        browseButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        browseButton.setBackground(new Color(255, 153, 0));
        browseButton.setForeground(Color.WHITE);
        browseButton.setBounds(330, 55, 100, 25);
        add(browseButton);

        exportButton = new JButton("Export");
        exportButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
        exportButton.setBackground(new Color(255, 153, 0));
        exportButton.setForeground(Color.WHITE);
        exportButton.setBounds(110, 100, 100, 30);
        add(exportButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.setBounds(230, 100, 100, 30);
        add(cancelButton);

        // Button actions
        browseButton.addActionListener(e -> chooseFile());
        exportButton.addActionListener(e -> exportCSV());
        cancelButton.addActionListener(e -> dispose());
    }

    private void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select CSV file location");
        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            if (!path.toLowerCase().endsWith(".csv")) {
                path += ".csv";
            }
            filePathField.setText(path);
        }
    }

    private void exportCSV() {
        String path = filePathField.getText().trim();
        if (path.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a file path to save the CSV.", "No File Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try (FileWriter csvWriter = new FileWriter(path)) {
            // Microsoft To Do/Outlook CSV header
            csvWriter.append("Subject,Start Date,Due Date,Status,Priority,Categories,Body\n");

            DefaultTableModel model = (DefaultTableModel) sourceTable.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                String subject = safeGet(model, i, 0);
                String status = safeGet(model, i, 1);
                String dueDate = safeGet(model, i, 2);
                String priority = safeGet(model, i, 3);
                String category = safeGet(model, i, 4);
                String notes = safeGet(model, i, 5);

                // Convert status to Outlook-friendly
                String outlookStatus = "Not Started";
                if ("Completed".equalsIgnoreCase(status)) outlookStatus = "Completed";
                else if ("Pending".equalsIgnoreCase(status)) outlookStatus = "Not Started";
                else outlookStatus = status;

                // Convert priority to Outlook (1 = High, 2 = Normal, 3 = Low)
                String outPriority = "2";
                if ("High".equalsIgnoreCase(priority)) outPriority = "1";
                else if ("Low".equalsIgnoreCase(priority)) outPriority = "3";

                // Start date can be left blank or can be due date for simplicity
                String startDate = "";

                csvWriter.append(String.format("\"%s\",%s,%s,%s,%s,%s,\"%s\"\n",
                        subject.replace("\"", "\"\""),
                        startDate,
                        dueDate,
                        outlookStatus,
                        outPriority,
                        category.replace("\"", "\"\""),
                        notes.replace("\"", "\"\"")
                ));
            }
            csvWriter.flush();
            JOptionPane.showMessageDialog(this, "Exported successfully to:\n" + path, "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error exporting: " + ex.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String safeGet(DefaultTableModel model, int row, int col) {
        Object val = model.getValueAt(row, col);
        return val == null ? "" : val.toString();
    }
}