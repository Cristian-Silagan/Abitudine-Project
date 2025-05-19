package abitudine;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
        LoginEmailField = new javax.swing.JTextField();
        LoginPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        abitudineloginbtn = new javax.swing.JButton();
        abitudineshowpassbox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abitudine");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(678, 428));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineLogo.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 40, 140, 54);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineLoginDesign.gif")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 380, 428);

        LoginEmailField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LoginEmailField.setAutoscrolls(false);
        LoginEmailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        LoginEmailField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        LoginEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginEmailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(LoginEmailField);
        LoginEmailField.setBounds(420, 150, 210, 30);

        LoginPasswordField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LoginPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        LoginPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(LoginPasswordField);
        LoginPasswordField.setBounds(420, 210, 210, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristian\\Downloads\\AbitudineFile (3).png")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 30, 200, 90);

        abitudineloginbtn.setBackground(new java.awt.Color(255, 153, 0));
        abitudineloginbtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        abitudineloginbtn.setForeground(new java.awt.Color(255, 255, 255));
        abitudineloginbtn.setText("LOGIN");
        abitudineloginbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        abitudineloginbtn.setBorderPainted(false);
        abitudineloginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abitudineloginbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abitudineloginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abitudineloginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(abitudineloginbtn);
        abitudineloginbtn.setBounds(420, 290, 210, 40);

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

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel6.setText("Don't have an account?");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(430, 340, 160, 20);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Register");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 330, 50, 40);
        getContentPane().add(filler1);
        filler1.setBounds(570, 330, 10, 20);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(160, 0, 520, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginEmailFieldActionPerformed

    private void LoginPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPasswordFieldActionPerformed
        
    }//GEN-LAST:event_LoginPasswordFieldActionPerformed

    private void abitudineloginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abitudineloginbtnActionPerformed
        String email = LoginEmailField.getText();
        String password = LoginPasswordField.getText();
        
        try (FileReader fr = new FileReader("accounts.txt");
            Scanner reader = new Scanner(fr)) {

           boolean loginSuccessful = false;

           while(reader.hasNextLine()) {
               String line = reader.nextLine().trim();
               if(line.isEmpty()) continue;

               String[] parts = line.split(",");
               if(parts.length < 5) continue; // Skip invalid lines

               // Indexes based on registration format:
               // firstName (0), lastName (1), email (2), password (3), confirmPass (4)
               String storedEmail = parts[2].trim();
               String storedPassword = parts[3].trim();

               if(email.equals(storedEmail) && password.equals(storedPassword)) {
                   loginSuccessful = true;
                   AbitudineDashboard dashboard = new AbitudineDashboard();
                   dashboard.setVisible(true);
                   this.dispose();
                   break; // Exit loop immediately after successful login
               }
           }

           if(!loginSuccessful) {
               JOptionPane.showMessageDialog(null, "Invalid Login Details");
           }

       } catch (IOException e) {
           JOptionPane.showMessageDialog(null, "Error reading user data: " + e.getMessage(), 
               "Error", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_abitudineloginbtnActionPerformed

    private void abitudineshowpassboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abitudineshowpassboxActionPerformed
        if(abitudineshowpassbox.isSelected()) {
            LoginPasswordField.setEchoChar((char) 0);
        } else {
            LoginPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_abitudineshowpassboxActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        AbitudineRegisterForm register = new AbitudineRegisterForm();
        register.setLocationRelativeTo(null);
        register.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

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
    private javax.swing.JTextField LoginEmailField;
    private javax.swing.JPasswordField LoginPasswordField;
    private javax.swing.JButton abitudineloginbtn;
    private javax.swing.JCheckBox abitudineshowpassbox;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
