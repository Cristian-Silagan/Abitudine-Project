package abitudine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.lang.Object;


    public class AbitudineDashboard extends javax.swing.JFrame {
        private java.util.List<Object[]> dashboardAllRows = new java.util.ArrayList<>();
        private String firstName;
        private String lastName;
        private String email;        
        
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
            
            // Make sure the array has at least 2 elements before accessing them
            if (userData.length >= 2) {
                firstName = userData[0];
                lastName = userData[1];
            } else {
                System.err.println("Invalid user data format in accounts.txt: " + lastLine);
                // Keep default values for firstName and lastName
            }
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
        
    // Add this method to initialize the table with right-click menu
    private void initializeTasksTable() {
        // Create table model with the same columns as in your UI
        DefaultTableModel model = new DefaultTableModel(
            new String[] {"Task name", "Status", "Due Date", "Priority", "Category", "Notes"}, 0) {

            // Make cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Set model to table
        AbitudineTasksTable.setModel(model);

        // Load data from database
        AbitudineTasksDatabase.loadTasksToTable(model);

        // Create popup menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("Edit Task");
        JMenuItem deleteItem = new JMenuItem("Delete Task");

        // Add items to popup menu
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        updateDashboardStatsAndTable();
        
        // Add action listeners for menu items
            editItem.addActionListener(e -> editSelectedTask());
            deleteItem.addActionListener(e -> deleteSelectedTask());


        // Add mouse listener for right-click events
        AbitudineTasksTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // Check for right-click
                if (e.isPopupTrigger()) {
                    // Get the row that was clicked
                    int row = AbitudineTasksTable.rowAtPoint(e.getPoint());

                    if (row >= 0 && row < AbitudineTasksTable.getRowCount()) {
                        // Select the row
                        AbitudineTasksTable.setRowSelectionInterval(row, row);

                        // Show popup menu
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });
    }
    
    public void refreshTasksTable() {
       DefaultTableModel model = (DefaultTableModel) AbitudineTasksTable.getModel();
       AbitudineTasksDatabase.loadTasksToTable(model);
       updateDashboardStatsAndTable();
}
    
    // Add inside your AbitudineDashboard class:
    private void updateDashboardStatsAndTable() {
        int dueToday = 0, upcoming = 0, overdue = 0;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate today = LocalDate.now();

            DefaultTableModel model = (DefaultTableModel) AbitudineTasksTable.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                String status = (String) model.getValueAt(i, 1); // Status column
                String dueDateStr = (String) model.getValueAt(i, 2); // Due Date column
                LocalDate dueDate;
                try {
                    dueDate = LocalDate.parse(dueDateStr, dtf);
                } catch (Exception e) {
                    continue; // skip invalid date
                }
                if (!status.equalsIgnoreCase("Completed")) {
                    if (dueDate.isEqual(today)) dueToday++;
                    else if (dueDate.isAfter(today)) upcoming++;
                    else if (dueDate.isBefore(today)) overdue++;
                }
            }

            // Update dashboard number labels (jLabel14, jLabel16, jLabel17)
            jLabel14.setText(String.valueOf(dueToday));   // Tasks Due Today
            jLabel16.setText(String.valueOf(upcoming));   // Upcoming Tasks
            jLabel17.setText(String.valueOf(overdue));    // Overdue Tasks

            // Sync AbitudineTasksTable to jTable1
            DefaultTableModel dashModel = (DefaultTableModel) jTable1.getModel();
            dashModel.setRowCount(0); // clear existing rows
            for (int i = 0; i < model.getRowCount(); i++) {
                int colCount = Math.min(4, model.getColumnCount());
                Object[] row = new Object[colCount];
                for (int j = 0; j < colCount; j++) row[j] = model.getValueAt(i, j);
                dashboardAllRows.add(row);
            }
            applyDashboardFilter();
    }
    
    private void applyDashboardFilter() {
        String statusFilter = (String) FilterComboBox1.getSelectedItem();
        String priorityFilter = (String) FilterComboBox2.getSelectedItem();
        DefaultTableModel dashModel = (DefaultTableModel) jTable1.getModel();
        dashModel.setRowCount(0);
        for (Object[] row : dashboardAllRows) {
            boolean show = true;
            if (!"All".equals(statusFilter) && row[1] != null && !statusFilter.equalsIgnoreCase(row[1].toString().trim())) show = false;
            if (!"All".equals(priorityFilter) && row[3] != null && !priorityFilter.equalsIgnoreCase(row[3].toString().trim())) show = false;
            if (show) dashModel.addRow(row);
    }
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
        AbitudineDashboardBtn = new javax.swing.JLabel();
        AbitudineAddHabitBtn = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        AbitudineExportBtn = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AbitudineUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        AbitudineDashboardPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        FilterComboBox1 = new javax.swing.JComboBox<>();
        FilterComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        AbitudineAddHabit = new javax.swing.JPanel();
        AbitudineEditBtn = new javax.swing.JLabel();
        AbitudineAddButton = new javax.swing.JLabel();
        AbitudineDeleteBtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AbitudineTasksTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
        jLabel2.setBounds(30, 80, 40, 40);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(0, 60, 230, 13);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (21).png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 130, 40, 40);

        AbitudineDashboardBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineDashboardBtn.setForeground(new java.awt.Color(255, 153, 0));
        AbitudineDashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AbitudineDashboardBtn.setText("           DASHBOARD");
        AbitudineDashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineDashboardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineDashboardBtnMouseClicked(evt);
            }
        });
        jPanel1.add(AbitudineDashboardBtn);
        AbitudineDashboardBtn.setBounds(40, 90, 190, 30);

        AbitudineAddHabitBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AbitudineAddHabitBtn.setForeground(new java.awt.Color(255, 153, 0));
        AbitudineAddHabitBtn.setText("             MANAGE HABITS");
        AbitudineAddHabitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineAddHabitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineAddHabitBtnMouseClicked(evt);
            }
        });
        jPanel1.add(AbitudineAddHabitBtn);
        AbitudineAddHabitBtn.setBounds(30, 130, 200, 40);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(0, 190, 230, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (23).png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 210, 40, 50);

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
        AbitudineExportBtn.setBounds(30, 220, 200, 30);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/AbitudineFile (19).png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 470, 50, 40);

        LogoutButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 153, 0));
        LogoutButton.setText("         LOGOUT");
        LogoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
            }
        });
        jPanel1.add(LogoutButton);
        LogoutButton.setBounds(30, 470, 110, 40);

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

        AbitudineDashboardPanel.setBackground(new java.awt.Color(255, 255, 255));
        AbitudineDashboardPanel.setLayout(null);
        AbitudineDashboardPanel.add(jPanel7);
        jPanel7.setBounds(332, 5, 10, 10);

        jPanel8.setBackground(new java.awt.Color(255, 153, 0));
        jPanel8.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 90)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("0");
        jPanel8.add(jLabel14);
        jLabel14.setBounds(50, 20, 130, 120);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tasks Due Today");
        jPanel8.add(jLabel15);
        jLabel15.setBounds(0, 170, 240, 23);

        AbitudineDashboardPanel.add(jPanel8);
        jPanel8.setBounds(50, 60, 240, 220);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        AbitudineDashboardPanel.add(jSeparator4);
        jSeparator4.setBounds(0, 30, 80, 520);

        jPanel9.setBackground(new java.awt.Color(255, 153, 0));
        jPanel9.setForeground(new java.awt.Color(255, 153, 0));
        jPanel9.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 70)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("0");
        jPanel9.add(jLabel16);
        jLabel16.setBounds(20, 20, 60, 60);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("UPCOMING TASKS");
        jPanel9.add(jLabel18);
        jLabel18.setBounds(90, 40, 170, 31);

        AbitudineDashboardPanel.add(jPanel9);
        jPanel9.setBounds(310, 60, 280, 110);

        jPanel6.setBackground(new java.awt.Color(255, 153, 0));
        jPanel6.setForeground(new java.awt.Color(255, 153, 0));
        jPanel6.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 70)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("0");
        jPanel6.add(jLabel17);
        jLabel17.setBounds(20, 10, 60, 70);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("OVERDUE TASKS");
        jPanel6.add(jLabel19);
        jLabel19.setBounds(90, 33, 170, 30);

        AbitudineDashboardPanel.add(jPanel6);
        jPanel6.setBounds(310, 180, 280, 100);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Task", "Status", "Due Date", "Priority"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        AbitudineDashboardPanel.add(jScrollPane2);
        jScrollPane2.setBounds(50, 350, 550, 140);

        FilterComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "In Progress", "Completed", "On Hold ", "Delayed", " " }));
        FilterComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterComboBox1ActionPerformed(evt);
            }
        });
        AbitudineDashboardPanel.add(FilterComboBox1);
        FilterComboBox1.setBounds(50, 320, 110, 22);

        FilterComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High", "Medium", "Low" }));
        FilterComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterComboBox2ActionPerformed(evt);
            }
        });
        AbitudineDashboardPanel.add(FilterComboBox2);
        FilterComboBox2.setBounds(170, 320, 110, 22);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Status");
        AbitudineDashboardPanel.add(jLabel4);
        jLabel4.setBounds(50, 300, 70, 16);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Priority");
        AbitudineDashboardPanel.add(jLabel8);
        jLabel8.setBounds(170, 300, 37, 16);

        jTabbedPane2.addTab("tab5", AbitudineDashboardPanel);

        AbitudineAddHabit.setBackground(new java.awt.Color(255, 255, 255));
        AbitudineAddHabit.setLayout(null);

        AbitudineEditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/2.png"))); // NOI18N
        AbitudineEditBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineEditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineEditBtnMouseClicked(evt);
            }
        });
        AbitudineAddHabit.add(AbitudineEditBtn);
        AbitudineEditBtn.setBounds(470, 380, 50, 70);

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

        AbitudineDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_images/3_1.png"))); // NOI18N
        AbitudineDeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbitudineDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineDeleteBtnMouseClicked(evt);
            }
        });
        AbitudineAddHabit.add(AbitudineDeleteBtn);
        AbitudineDeleteBtn.setBounds(410, 390, 50, 50);

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

    private void AbitudineExportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineExportBtnMouseClicked
        ExportCSVForm exportForm = new ExportCSVForm(AbitudineTasksTable);
        exportForm.setVisible(true);
    }//GEN-LAST:event_AbitudineExportBtnMouseClicked

    private void AbitudineAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineAddButtonMouseClicked
        AbitudineAddHabitForm addhabit = new AbitudineAddHabitForm();

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

    private void AbitudineEditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineEditBtnMouseClicked
        editSelectedTask();
    }//GEN-LAST:event_AbitudineEditBtnMouseClicked

    private void AbitudineDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineDeleteBtnMouseClicked
        deleteSelectedTask();
    }//GEN-LAST:event_AbitudineDeleteBtnMouseClicked

    private void FilterComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterComboBox1ActionPerformed
        applyDashboardFilter();
    }//GEN-LAST:event_FilterComboBox1ActionPerformed

    private void FilterComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterComboBox2ActionPerformed
        applyDashboardFilter();
    }//GEN-LAST:event_FilterComboBox2ActionPerformed

    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked
        logout();
    }//GEN-LAST:event_LogoutButtonMouseClicked
 
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to logout?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (confirm == JOptionPane.YES_OPTION) {
            // Show login form (if you have one)
            new AbitudineLoginForm().setVisible(true);
            // Close dashboard
            this.dispose();
            // Optionally, clear session data
        }
    }
    
    
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
    private javax.swing.JLabel AbitudineDashboardBtn;
    private javax.swing.JPanel AbitudineDashboardPanel;
    private javax.swing.JLabel AbitudineDeleteBtn;
    private javax.swing.JLabel AbitudineEditBtn;
    private javax.swing.JLabel AbitudineExportBtn;
    private javax.swing.JTable AbitudineTasksTable;
    private javax.swing.JLabel AbitudineUsername;
    private javax.swing.JComboBox<String> FilterComboBox1;
    private javax.swing.JComboBox<String> FilterComboBox2;
    private javax.swing.JLabel LogoutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void editSelectedTask() {
        int selectedRow = AbitudineTasksTable.getSelectedRow();

        if (selectedRow >= 0) {
            // Get data for the selected task
            String[] taskData = AbitudineTasksDatabase.getTaskAtRow(selectedRow);

            if (taskData != null) {
                // Open edit form with task data
                AbitudineEditHabitForm editForm = new AbitudineEditHabitForm(selectedRow, taskData);

                // Add window listener to refresh the table when the form is closed
                editForm.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent evt) {
                        refreshTasksTable();
                    }
                });

                editForm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Could not retrieve task data for editing.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Please select a task to edit.",
                "No Selection",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void deleteSelectedTask() {
        int selectedRow = AbitudineTasksTable.getSelectedRow();

        if (selectedRow >= 0) {
            // Ask for confirmation before deleting
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this task?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Delete the task
                boolean deleted = AbitudineTasksDatabase.deleteTask(selectedRow);

                if (deleted) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Task successfully deleted.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    // Refresh the table
                    refreshTasksTable();
                } else {
                    JOptionPane.showMessageDialog(
                        this,
                        "Error deleting task. Please try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Please select a task to delete.",
                "No Selection",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}







