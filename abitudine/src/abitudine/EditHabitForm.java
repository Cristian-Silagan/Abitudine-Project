/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package abitudine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


        
public class EditHabitForm extends javax.swing.JFrame {

    private int rowIndex;
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    
    public EditHabitForm() {
        initComponents();
        setLocationRelativeTo(null);
        
        // Fix cancel button text
        AbitudineCancelBtn.setText("CANCEL");
        
        // Change default close operation to not exit application
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public EditHabitForm(int rowIndex, String[] taskData) {
        this(); // Call default constructor for UI setup
        
        // Set window title
        setTitle("Edit Task");
        
        // Store row index for update operation
        this.rowIndex = rowIndex;
        
        // Populate form fields with existing task data
        TaskName.setText(taskData[0]);
        StatusType.setSelectedItem(taskData[1]);
        
        // Parse and set date if it exists
        if (taskData[2] != null && !taskData[2].isEmpty()) {
            try {
                Date dueDate = DATE_FORMAT.parse(taskData[2]);
                DueDate.setDate(dueDate);
            } catch (ParseException e) {
                System.err.println("Error parsing date: " + taskData[2]);
                // Use current date as fallback
                DueDate.setDate(new Date());
            }
        }
        
        PriorityType.setSelectedItem(taskData[3]);
        CategoryType.setSelectedItem(taskData[4]);
        OptionalNotes.setText(taskData[5]);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TaskName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        StatusType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PriorityType = new javax.swing.JComboBox<>();
        jlabel = new javax.swing.JLabel();
        CategoryType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OptionalNotes = new javax.swing.JTextArea();
        UpdateTask = new javax.swing.JButton();
        DueDate = new de.wannawork.jcalendar.JCalendarComboBox();
        AbitudineCancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 565));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(350, 544));
        jPanel1.setMinimumSize(new java.awt.Dimension(350, 544));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 544));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EDIT TASK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel2)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 350, 60);

        TaskName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskNameActionPerformed(evt);
            }
        });
        jPanel1.add(TaskName);
        TaskName.setBounds(30, 130, 280, 30);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Task Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 110, 120, 14);

        StatusType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "In Progress", "Completed", "On Hold ", "Delayed", " " }));
        StatusType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusTypeActionPerformed(evt);
            }
        });
        jPanel1.add(StatusType);
        StatusType.setBounds(30, 190, 130, 30);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Status");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 170, 37, 16);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Due Date");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 170, 60, 14);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Priority");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 230, 70, 16);

        PriorityType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High", "Medium", "Low" }));
        jPanel1.add(PriorityType);
        PriorityType.setBounds(30, 250, 280, 30);

        jlabel.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jlabel.setForeground(new java.awt.Color(153, 153, 153));
        jlabel.setText("Category");
        jPanel1.add(jlabel);
        jlabel.setBounds(30, 290, 70, 14);

        CategoryType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Health", "Education", "Work", "Personal", "Finance", "Spiritual", "Social", "Fitness", "Creativity", "Productivity" }));
        jPanel1.add(CategoryType);
        CategoryType.setBounds(30, 310, 280, 30);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel6.setText("Notes");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 360, 29, 14);

        OptionalNotes.setColumns(20);
        OptionalNotes.setLineWrap(true);
        OptionalNotes.setRows(5);
        jScrollPane1.setViewportView(OptionalNotes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 380, 280, 110);

        UpdateTask.setBackground(new java.awt.Color(255, 153, 0));
        UpdateTask.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UpdateTask.setForeground(new java.awt.Color(255, 255, 255));
        UpdateTask.setText("UPDATE TASK");
        UpdateTask.setBorder(null);
        UpdateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTaskActionPerformed(evt);
            }
        });
        UpdateTask.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UpdateTaskKeyPressed(evt);
            }
        });
        jPanel1.add(UpdateTask);
        UpdateTask.setBounds(190, 510, 110, 30);
        jPanel1.add(DueDate);
        DueDate.setBounds(170, 190, 140, 30);

        AbitudineCancelBtn.setBackground(new java.awt.Color(255, 51, 51));
        AbitudineCancelBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        AbitudineCancelBtn.setText("CANCEL");
        AbitudineCancelBtn.setBorder(null);
        AbitudineCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudineCancelBtnActionPerformed(evt);
            }
        });
        AbitudineCancelBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AbitudineCancelBtnKeyPressed(evt);
            }
        });
        jPanel1.add(AbitudineCancelBtn);
        AbitudineCancelBtn.setBounds(40, 510, 110, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StatusTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusTypeActionPerformed

    private void TaskNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaskNameActionPerformed

    private void UpdateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTaskActionPerformed
        String task = TaskName.getText();
        String status = (String) StatusType.getSelectedItem(); 
        Date selectedDate = DueDate.getDate();
        String priority = (String) PriorityType.getSelectedItem();
        String category = (String) CategoryType.getSelectedItem();
        String notes = OptionalNotes.getText();
        
        String taskName = TaskName.getText().trim();
        if (taskName.isEmpty()) {
            // Show warning dialog if task name is empty
            JOptionPane.showMessageDialog(
                this, 
                "Please designate a task name before updating.", 
                "Task Name Required", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        } else {
            // Update task in database
            boolean updated = AbitudineTasksDatabase.updateTask(
                rowIndex, task, status, selectedDate, priority, category, notes
            );
            
            if (updated) {
                // Show confirmation message
                JOptionPane.showMessageDialog(
                    this,
                    "Habit successfully updated!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                // Close this form
                this.dispose();
            } else {
                // Show error message
                JOptionPane.showMessageDialog(
                    this,
                    "Error updating habit. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_UpdateTaskActionPerformed

    private void UpdateTaskKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateTaskKeyPressed
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
           UpdateTask.doClick(); // Simulates a button click
       }
    }//GEN-LAST:event_UpdateTaskKeyPressed

    private void AbitudineCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudineCancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbitudineCancelBtnActionPerformed

    private void AbitudineCancelBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AbitudineCancelBtnKeyPressed
        this.dispose();
    }//GEN-LAST:event_AbitudineCancelBtnKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditHabitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditHabitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditHabitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditHabitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditHabitForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbitudineCancelBtn;
    private javax.swing.JComboBox<String> CategoryType;
    private de.wannawork.jcalendar.JCalendarComboBox DueDate;
    private javax.swing.JTextArea OptionalNotes;
    private javax.swing.JComboBox<String> PriorityType;
    private javax.swing.JComboBox<String> StatusType;
    private javax.swing.JTextField TaskName;
    private javax.swing.JButton UpdateTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    // End of variables declaration//GEN-END:variables

    private void clearFormFields() {
        TaskName.setText("");
        StatusType.setSelectedIndex(0);
        DueDate.setDate(new Date()); // Reset to current date
        PriorityType.setSelectedIndex(0);
        CategoryType.setSelectedIndex(0);
        OptionalNotes.setText("");
        TaskName.requestFocus();
    }
}
