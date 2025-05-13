/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package abitudine;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class AbitudineLoginForm extends javax.swing.JFrame {

    /**
     * Creates new form AbitudineLoginForm
     */
    public AbitudineLoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new javax.swing.ImageIcon("C:/Users/Cristian/Downloads/AbitudineLogo (1).png").getImage());
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        abitudineEmailField = new javax.swing.JTextField();
        abitudinePasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        abitudineloginbtn = new javax.swing.JButton();
        abitudineshowpassbox = new javax.swing.JCheckBox();
        abitudineregisterbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abitudine");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(675, 428));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineLogo.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 40, 140, 54);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineLoginDesign.gif")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 380, 428);

        abitudineEmailField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        abitudineEmailField.setAutoscrolls(false);
        abitudineEmailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        abitudineEmailField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        abitudineEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abitudineEmailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(abitudineEmailField);
        abitudineEmailField.setBounds(420, 150, 210, 30);

        abitudinePasswordField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        abitudinePasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        abitudinePasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abitudinePasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(abitudinePasswordField);
        abitudinePasswordField.setBounds(420, 210, 210, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineFile (3).png")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 30, 200, 90);

        abitudineloginbtn.setBackground(new java.awt.Color(255, 153, 0));
        abitudineloginbtn.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        abitudineloginbtn.setForeground(new java.awt.Color(255, 255, 255));
        abitudineloginbtn.setText("LOGIN");
        abitudineloginbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        abitudineloginbtn.setBorderPainted(false);
        abitudineloginbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abitudineloginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abitudineloginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(abitudineloginbtn);
        abitudineloginbtn.setBounds(420, 310, 100, 40);

        abitudineshowpassbox.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        abitudineshowpassbox.setForeground(new java.awt.Color(102, 102, 102));
        abitudineshowpassbox.setText("Show password");
        abitudineshowpassbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abitudineshowpassboxActionPerformed(evt);
            }
        });
        getContentPane().add(abitudineshowpassbox);
        abitudineshowpassbox.setBounds(420, 250, 140, 20);

        abitudineregisterbtn.setBackground(new java.awt.Color(255, 153, 0));
        abitudineregisterbtn.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        abitudineregisterbtn.setForeground(new java.awt.Color(255, 255, 255));
        abitudineregisterbtn.setText("REGISTER");
        abitudineregisterbtn.setBorder(null);
        abitudineregisterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abitudineregisterbtnActionPerformed(evt);
            }
        });
        getContentPane().add(abitudineregisterbtn);
        abitudineregisterbtn.setBounds(530, 310, 100, 40);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Email");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 130, 120, 20);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 190, 130, 14);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(330, 0, 360, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abitudineEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abitudineEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_abitudineEmailFieldActionPerformed

    private void abitudinePasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abitudinePasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_abitudinePasswordFieldActionPerformed

    private void abitudineloginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abitudineloginbtnActionPerformed
        String email = abitudineEmailField.getText();
        String password = new String(abitudinePasswordField.getName());
        
      if (email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your email.", "Missing Field", JOptionPane.WARNING_MESSAGE);
      } else if (password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your password.", "Missing Field", JOptionPane.WARNING_MESSAGE);
      } else {
        // Example: Check against hardcoded credentials
            if (email.equals("cristiansilagan15") && password.equals("password123")) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Proceed to the next step, e.g., open the main application window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_abitudineloginbtnActionPerformed

    private void abitudineshowpassboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abitudineshowpassboxActionPerformed
        if(abitudineshowpassbox.isSelected()) {
            abitudinePasswordField.setEchoChar((char) 0);
        } else {
            abitudinePasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_abitudineshowpassboxActionPerformed

    private void abitudineregisterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abitudineregisterbtnActionPerformed
        AbitudineRegisterForm register = new AbitudineRegisterForm();
        register.setLocationRelativeTo(null);
        register.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_abitudineregisterbtnActionPerformed

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
            java.util.logging.Logger.getLogger(AbitudineLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbitudineLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbitudineLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbitudineLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbitudineLoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField abitudineEmailField;
    private javax.swing.JPasswordField abitudinePasswordField;
    private javax.swing.JButton abitudineloginbtn;
    private javax.swing.JButton abitudineregisterbtn;
    private javax.swing.JCheckBox abitudineshowpassbox;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
