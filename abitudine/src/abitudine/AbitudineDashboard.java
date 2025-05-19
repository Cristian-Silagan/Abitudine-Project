package abitudine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

    public class AbitudineDashboard extends javax.swing.JFrame {
            
        
//      PROFILE NAME 
        public AbitudineDashboard() {
            String firstName = "Guest";
            String lastName = "";

            // Read the last registered user from accounts.txt
            try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
                String line;
                String lastLine = null;

                // Read until the last line (last registered user)
                while ((line = reader.readLine()) != null) {
                    lastLine = line;
                }

                if (lastLine != null) {
                    // Split the last line to extract firstName and lastName
                    String[] userData = lastLine.split(",");
                    firstName = userData[0];
                    lastName = userData[1];
                }
            } catch (IOException e) {
                System.err.println("Error reading user data: " + e.getMessage());
            }

            initComponents();
            setLocationRelativeTo(null);
            setIconImage(new javax.swing.ImageIcon("C:/Users/Cristian/Downloads/AbitudineLogo (1).png").getImage());

            AbitudineUsername.setText(firstName + " " + lastName);

            // Initialize the tasks table
            initializeTasksTable();
        }
        
    private void initializeTasksTable() {
        // Create table model with the same columns as in your UI
        DefaultTableModel model = new DefaultTableModel(
            new String[] {"Task name", "Status", "Due Date", "Priority", "Category", "Notes"}, 0) {

            // Make cells non-editable if needed
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Set model to table
        AbitudineTasksTable.setModel(model);

        // Load data from database
        AbitudineTasksDatabase.loadTasksToTable(model);
    }
    
    public void refreshTasksTable() {
        DefaultTableModel model = (DefaultTableModel) AbitudineTasksTable.getModel();
        AbitudineTasksDatabase.loadTasksToTable(model);
}

        

        
//  MAIN CODE
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AbitudineDashboardBtn = new javax.swing.JLabel();
        AbitudineAddHabitBtn = new javax.swing.JLabel();
        AbitudineMngeHabitBtn = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        AbitudineExportBtn = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AbitudineUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        AbitudineDashboard = new javax.swing.JPanel();
        AbitudineAddHabit = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        AbitudineAddButton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AbitudineTasksTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AbitudineManageHabits = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        AbitudineExport = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abitudine");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(886, 571));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/Your paragraph text (100 x 100 px) (80 x 80 px).png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 10, 82, 50);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (9).png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 90, 40, 40);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(0, 60, 230, 13);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (21).png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 140, 40, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (22).png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 180, 40, 50);

        AbitudineDashboardBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineDashboardBtn.setForeground(new java.awt.Color(255, 153, 0));
        AbitudineDashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AbitudineDashboardBtn.setText("             DASHBOARD");
        AbitudineDashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineDashboardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineDashboardBtnMouseClicked(evt);
            }
        });
        jPanel1.add(AbitudineDashboardBtn);
        AbitudineDashboardBtn.setBounds(40, 96, 190, 30);

        AbitudineAddHabitBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineAddHabitBtn.setForeground(new java.awt.Color(255, 153, 0));
        AbitudineAddHabitBtn.setText("              ADD TASK");
        AbitudineAddHabitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineAddHabitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineAddHabitBtnMouseClicked(evt);
            }
        });
        jPanel1.add(AbitudineAddHabitBtn);
        AbitudineAddHabitBtn.setBounds(37, 140, 190, 40);

        AbitudineMngeHabitBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineMngeHabitBtn.setForeground(new java.awt.Color(255, 153, 0));
        AbitudineMngeHabitBtn.setText("             MANAGE HABITS");
        AbitudineMngeHabitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineMngeHabitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineMngeHabitBtnMouseClicked(evt);
            }
        });
        jPanel1.add(AbitudineMngeHabitBtn);
        AbitudineMngeHabitBtn.setBounds(40, 190, 190, 40);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(0, 250, 230, 10);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (23).png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 280, 40, 40);

        AbitudineExportBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineExportBtn.setForeground(new java.awt.Color(255, 153, 0));
        AbitudineExportBtn.setText("               EXPORT");
        AbitudineExportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineExportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineExportBtnMouseClicked(evt);
            }
        });
        jPanel1.add(AbitudineExportBtn);
        AbitudineExportBtn.setBounds(33, 286, 200, 30);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (19).png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 470, 50, 40);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("        LOGOUT");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel12);
        jLabel12.setBounds(40, 470, 100, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 230, 590);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        AbitudineUsername.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineUsername.setForeground(new java.awt.Color(255, 153, 0));
        AbitudineUsername.setText("USER");
        jPanel2.add(AbitudineUsername);
        AbitudineUsername.setBounds(480, 20, 120, 19);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (10).png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(430, 10, 40, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(230, 0, 740, 60);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(230, 60, 660, 10);

        AbitudineDashboard.setBackground(new java.awt.Color(255, 255, 255));
        AbitudineDashboard.setLayout(null);
        jTabbedPane2.addTab("tab1", AbitudineDashboard);

        AbitudineAddHabit.setBackground(new java.awt.Color(255, 255, 255));
        AbitudineAddHabit.setLayout(null);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (50 x 50 px) (1).png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineAddHabit.add(jLabel13);
        jLabel13.setBounds(470, 380, 50, 70);

        AbitudineAddButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AbitudineAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (14).png"))); // NOI18N
        AbitudineAddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineAddButtonMouseClicked(evt);
            }
        });
        AbitudineAddHabit.add(AbitudineAddButton);
        AbitudineAddButton.setBounds(530, 390, 50, 50);

        AbitudineTasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Task name", "Status", "Due Date", "Priority", "Category", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        AbitudineTasksTable.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        jScrollPane1.setViewportView(AbitudineTasksTable);

        AbitudineAddHabit.add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 590, 402);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineElement2.gif"))); // NOI18N
        AbitudineAddHabit.add(jLabel6);
        jLabel6.setBounds(30, 460, 650, 390);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineElement2.gif"))); // NOI18N
        jLabel7.setText("jLabel7");
        AbitudineAddHabit.add(jLabel7);
        jLabel7.setBounds(620, 30, 680, 460);

        jTabbedPane2.addTab("tab2", AbitudineAddHabit);

        AbitudineManageHabits.setBackground(new java.awt.Color(255, 255, 255));
        AbitudineManageHabits.setLayout(null);

        jLabel8.setText("TAB 3");
        AbitudineManageHabits.add(jLabel8);
        jLabel8.setBounds(320, 230, 31, 16);

        jTabbedPane2.addTab("tab3", AbitudineManageHabits);

        AbitudineExport.setBackground(new java.awt.Color(255, 255, 255));
        AbitudineExport.setLayout(null);

        jLabel10.setText("TAB 4");
        AbitudineExport.add(jLabel10);
        jLabel10.setBounds(340, 210, 31, 16);

        jTabbedPane2.addTab("tab4", AbitudineExport);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(230, -10, 660, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbitudineDashboardBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineDashboardBtnMouseClicked
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_AbitudineDashboardBtnMouseClicked

    private void AbitudineAddHabitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineAddHabitBtnMouseClicked
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_AbitudineAddHabitBtnMouseClicked

    private void AbitudineMngeHabitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineMngeHabitBtnMouseClicked
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_AbitudineMngeHabitBtnMouseClicked

    private void AbitudineExportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineExportBtnMouseClicked
        jTabbedPane2.setSelectedIndex(3);
    }//GEN-LAST:event_AbitudineExportBtnMouseClicked

    private void AbitudineAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineAddButtonMouseClicked
        AddHabitForm addhabit = new AddHabitForm();

        // Add a window listener to detect when the form is closed
        addhabit.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                // Refresh the table when the form is closed
                refreshTasksTable();
            }
        });

        addhabit.setVisible(true);
    }//GEN-LAST:event_AbitudineAddButtonMouseClicked
  
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
            java.util.logging.Logger.getLogger(AbitudineDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbitudineDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbitudineDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbitudineDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbitudineDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AbitudineAddButton;
    private javax.swing.JPanel AbitudineAddHabit;
    private javax.swing.JLabel AbitudineAddHabitBtn;
    private javax.swing.JPanel AbitudineDashboard;
    private javax.swing.JLabel AbitudineDashboardBtn;
    private javax.swing.JPanel AbitudineExport;
    private javax.swing.JLabel AbitudineExportBtn;
    private javax.swing.JPanel AbitudineManageHabits;
    private javax.swing.JLabel AbitudineMngeHabitBtn;
    private javax.swing.JTable AbitudineTasksTable;
    private javax.swing.JLabel AbitudineUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}







