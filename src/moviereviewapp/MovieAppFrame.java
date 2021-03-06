/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviereviewapp;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class MovieAppFrame extends javax.swing.JFrame {

    private MoviePanel mp = new MoviePanel();
    private UserPanel up = new UserPanel();
    private ReviewPanel rp = new ReviewPanel();
    private LogInPanel lip = new LogInPanel(this);
    private ChatPanel cp = new ChatPanel();
    private AccountManagementPanel amp = new AccountManagementPanel();
    private boolean authenticated;
    private Account currentAccount = null;

    /**
     * Creates new form MovieAppFrame
     */
    public MovieAppFrame() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ImagePackage/appIcon.png")));
        authenticated = false;
        initComponents();
        Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ImagePackage/cursor.png")), new Point(this.getX(), this.getY()), "img");
        this.setCursor(c);
        this.setLayout(null);

        mp.setBounds(0, 0, getWidth() - 12, getHeight() - 65);
        this.add(mp);
        mp.setVisible(false);

        up.setBounds(0, 0, getWidth() - 12, getHeight() - 65);
        this.add(up);
        up.setVisible(false);

        rp.setBounds(0, 0, getWidth() - 12, getHeight() - 65);
        this.add(rp);
        rp.setVisible(false);

        lip.setBounds(0, 0, getWidth() - 12, getHeight() - 65);
        this.add(lip);
        lip.setVisible(true);

        amp.setBounds(0, 0, getWidth() - 12, getHeight() - 65);
        this.add(amp);
        amp.setVisible(false);

        cp.setBounds(0, 0, getWidth() - 12, getHeight() - 65);
        this.add(cp);
        cp.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        AccountMenuItem = new javax.swing.JMenuItem();
        MovieMenuItem = new javax.swing.JMenuItem();
        UserMenuItem = new javax.swing.JMenuItem();
        ReviewMenuItem = new javax.swing.JMenuItem();
        chatMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CineFlux");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N

        jMenu3.setText("Menu");
        jMenu3.setContentAreaFilled(false);
        jMenu3.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N

        AccountMenuItem.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N
        AccountMenuItem.setText("Account");
        AccountMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(AccountMenuItem);

        MovieMenuItem.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N
        MovieMenuItem.setText("Movies");
        MovieMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovieMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(MovieMenuItem);

        UserMenuItem.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N
        UserMenuItem.setText("Users");
        UserMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(UserMenuItem);

        ReviewMenuItem.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N
        ReviewMenuItem.setText("Reviews");
        ReviewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(ReviewMenuItem);

        chatMenuItem.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N
        chatMenuItem.setText("Chat Room");
        chatMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(chatMenuItem);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Help");
        jMenu4.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N
        jMenuItem1.setText("Help PDF");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("CineDex");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MovieMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MovieMenuItemActionPerformed
        // TODO add your handling code here:\
        if (authenticated) {
            mp.setVisible(true);
            up.setVisible(false);
            rp.setVisible(false);
            amp.setVisible(false);
            cp.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Not Signed in");
        }
    }//GEN-LAST:event_MovieMenuItemActionPerformed

    private void ReviewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewMenuItemActionPerformed
        // TODO add your handling code here: 
        if (authenticated) {
            mp.setVisible(false);
            up.setVisible(false);
            rp.setVisible(true);
            amp.setVisible(false);
            cp.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Not Signed in");
        }
    }//GEN-LAST:event_ReviewMenuItemActionPerformed

    private void UserMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserMenuItemActionPerformed
        // TODO add your handling code here:
        if (authenticated) {
            mp.setVisible(false);
            up.setVisible(true);
            rp.setVisible(false);
            amp.setVisible(false);
            cp.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Not Signed in");
        }

    }//GEN-LAST:event_UserMenuItemActionPerformed

    private void chatMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatMenuItemActionPerformed
        // TODO add your handling code here:

        if (authenticated && cp.isAvailable()) {
            mp.setVisible(false);
            up.setVisible(false);
            rp.setVisible(false);
            amp.setVisible(false);
            cp.setVisible(true);
        } else if (authenticated) {
            JOptionPane.showMessageDialog(this, "Chat Server currently down");
        } else {
            JOptionPane.showMessageDialog(this, "Not Signed in");
        }
    }//GEN-LAST:event_chatMenuItemActionPerformed

    private void AccountMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountMenuItemActionPerformed
        // TODO add your handling code here:
        if (authenticated) {
            mp.setVisible(false);
            up.setVisible(false);
            rp.setVisible(false);
            amp.setVisible(true);
            cp.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Not Signed in");
        }
    }//GEN-LAST:event_AccountMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(getClass().getResource("/moviereviewapp/test.pdf").getFile());
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void successfulLogIn(Account a) {
        lip.setVisible(false);
        currentAccount = a;
        amp.setCurrentAccount(a);
        cp.setA(a);
        amp.setVisible(true);
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
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
            java.util.logging.Logger.getLogger(MovieAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        MovieAppFrame maf = new MovieAppFrame();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                maf.setVisible(true);
            }
        });
        try {
            maf.cp.run();
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AccountMenuItem;
    private javax.swing.JMenuItem MovieMenuItem;
    private javax.swing.JMenuItem ReviewMenuItem;
    private javax.swing.JMenuItem UserMenuItem;
    private javax.swing.JMenuItem chatMenuItem;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
