
package abitudine;
import java.awt.Color;

public class AbitudineRegisterForm extends javax.swing.JFrame {
    
    public AbitudineRegisterForm() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new javax.swing.ImageIcon("C:/Users/Cristian/Downloads/AbitudineLogo (1).png").getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AbitudineRegisterBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AbitudineFirstName = new javax.swing.JTextField();
        AbitudineLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AbitudineEmailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        AbitudinePasswordField = new javax.swing.JPasswordField();
        AbitudineConfirmPassField = new javax.swing.JPasswordField();
        AbitudineShowBox1 = new javax.swing.JCheckBox();
        AbitudineShowBox2 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abitudine");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(710, 485));
        setResizable(false);
        setSize(new java.awt.Dimension(675, 428));
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineLogo.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(520, 30, 150, 69);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineElement.gif")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 0, 420, 490);

        AbitudineRegisterBtn.setText("REGISTER");
        AbitudineRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudineRegisterBtnActionPerformed(evt);
            }
        });
        getContentPane().add(AbitudineRegisterBtn);
        AbitudineRegisterBtn.setBounds(40, 380, 330, 40);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("First name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 70, 70, 16);

        AbitudineFirstName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AbitudineFirstName.setActionCommand("<Not Set>");
        AbitudineFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        AbitudineFirstName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbitudineFirstNameMouseClicked(evt);
            }
        });
        AbitudineFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudineFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(AbitudineFirstName);
        AbitudineFirstName.setBounds(40, 90, 160, 30);

        AbitudineLastName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AbitudineLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        AbitudineLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudineLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(AbitudineLastName);
        AbitudineLastName.setBounds(210, 90, 160, 30);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Last name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 70, 70, 14);

        AbitudineEmailField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AbitudineEmailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        getContentPane().add(AbitudineEmailField);
        AbitudineEmailField.setBounds(40, 150, 330, 30);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 130, 26, 14);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 190, 90, 14);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Confirm Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 280, 110, 16);

        jButton2.setText("<-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 30, 50, 23);

        AbitudinePasswordField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AbitudinePasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        AbitudinePasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudinePasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(AbitudinePasswordField);
        AbitudinePasswordField.setBounds(40, 210, 330, 30);

        AbitudineConfirmPassField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AbitudineConfirmPassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        AbitudineConfirmPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudineConfirmPassFieldActionPerformed(evt);
            }
        });
        getContentPane().add(AbitudineConfirmPassField);
        AbitudineConfirmPassField.setBounds(40, 300, 330, 30);

        AbitudineShowBox1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        AbitudineShowBox1.setForeground(new java.awt.Color(102, 102, 102));
        AbitudineShowBox1.setText("Show");
        AbitudineShowBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudineShowBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(AbitudineShowBox1);
        AbitudineShowBox1.setBounds(40, 250, 84, 20);

        AbitudineShowBox2.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        AbitudineShowBox2.setForeground(new java.awt.Color(102, 102, 102));
        AbitudineShowBox2.setText("Show");
        AbitudineShowBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbitudineShowBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(AbitudineShowBox2);
        AbitudineShowBox2.setBounds(40, 340, 84, 20);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 710, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbitudineRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudineRegisterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbitudineRegisterBtnActionPerformed

    private void AbitudineFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudineFirstNameActionPerformed
        if (AbitudineFirstName.getText().equals("Enter First Name")) {
            AbitudineFirstName.setText(""); 
            AbitudineFirstName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_AbitudineFirstNameActionPerformed

    private void AbitudineFirstNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbitudineFirstNameMouseClicked
        if (AbitudineLastName.getText().equals("Enter Last Name")) {
            AbitudineLastName.setText(""); 
            AbitudineLastName.setForeground(Color.GRAY);
      
        }
    }//GEN-LAST:event_AbitudineFirstNameMouseClicked

    private void AbitudineLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudineLastNameActionPerformed

    }//GEN-LAST:event_AbitudineLastNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AbitudineLoginForm login = new AbitudineLoginForm();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AbitudinePasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudinePasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbitudinePasswordFieldActionPerformed

    private void AbitudineConfirmPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudineConfirmPassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbitudineConfirmPassFieldActionPerformed

    private void AbitudineShowBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudineShowBox1ActionPerformed
        if(AbitudineShowBox1.isSelected()) {
            AbitudinePasswordField.setEchoChar((char) 0);
        } else {
            AbitudinePasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_AbitudineShowBox1ActionPerformed

    private void AbitudineShowBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbitudineShowBox2ActionPerformed
        if (AbitudineShowBox2.isSelected()) {
            AbitudineConfirmPassField.setEchoChar((char) 0);
        } else {
            AbitudineConfirmPassField.setEchoChar('*');
        }
    }//GEN-LAST:event_AbitudineShowBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(AbitudineRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbitudineRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbitudineRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbitudineRegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbitudineRegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField AbitudineConfirmPassField;
    private javax.swing.JTextField AbitudineEmailField;
    private javax.swing.JTextField AbitudineFirstName;
    private javax.swing.JTextField AbitudineLastName;
    private javax.swing.JPasswordField AbitudinePasswordField;
    private javax.swing.JButton AbitudineRegisterBtn;
    private javax.swing.JCheckBox AbitudineShowBox1;
    private javax.swing.JCheckBox AbitudineShowBox2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}


