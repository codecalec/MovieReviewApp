/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviereviewapp;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class LogInPanel extends javax.swing.JPanel {

    private String[][] accounts = new AccountsManager().getAccounts();
    private MovieAppFrame maf;
    /**
     * Creates new form LogInPanel
     */
    public LogInPanel(MovieAppFrame maf) {
        initComponents();
        this.maf = maf;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        logInButton = new javax.swing.JButton();
        passwordTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");
        add(jLabel1);
        jLabel1.setBounds(10, 20, 73, 19);

        jLabel2.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(10, 60, 68, 19);

        usernameTextField.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        usernameTextField.setText("alex");
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        add(usernameTextField);
        usernameTextField.setBounds(90, 10, 196, 30);

        logInButton.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        logInButton.setText("Log In");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });
        add(logInButton);
        logInButton.setBounds(10, 100, 79, 27);

        passwordTextField.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        passwordTextField.setText("12345");
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });
        add(passwordTextField);
        passwordTextField.setBounds(90, 50, 195, 30);

        jLabel3.setFont(new java.awt.Font("Josefin Sans", 0, 48)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/icon.png"))); // NOI18N
        jLabel3.setText("CineDex");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(jLabel3);
        jLabel3.setBounds(460, 50, 300, 360);
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        // TODO add your handling code here:
        String[] credentials = {usernameTextField.getText(),passwordTextField.getText()};
        boolean auth = false;
        for (String[] account : accounts) {
            if (Arrays.equals(credentials, account)) {
                auth = true;
                break;
            }
        }
        if (auth) {
            maf.setAuthenticated(auth);
            maf.successfulLogIn(new Account(usernameTextField.getText(),passwordTextField.getText()));            
        } else {
            JOptionPane.showMessageDialog(maf,"Incorrect Username or Password");
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logInButton;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
