/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviereviewapp;

/**
 *
 * @author Alex
 */
public class AccountManagementPanel extends javax.swing.JPanel {

    private Account currentAccount = new Account("", "");

    /**
     * Creates new form AccountManagementPanel
     */
    public AccountManagementPanel() {
        initComponents();
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
        UserNameLabel.setText(currentAccount.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeLabel = new javax.swing.JLabel();
        UserNameLabel = new javax.swing.JLabel();
        UserNameLabel1 = new javax.swing.JLabel();
        scrollPane2 = new java.awt.ScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(new javax.swing.border.MatteBorder(null));
        setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N

        WelcomeLabel.setFont(new java.awt.Font("Josefin Sans", 0, 24)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeLabel.setText("Welcome to CineDex,");

        UserNameLabel.setFont(new java.awt.Font("Josefin Sans", 0, 24)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserNameLabel.setText("Username");

        UserNameLabel1.setFont(new java.awt.Font("Josefin Sans", 0, 24)); // NOI18N
        UserNameLabel1.setForeground(new java.awt.Color(255, 255, 255));
        UserNameLabel1.setText("The Premuim Movie Review Application");

        scrollPane2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/posters.png"))); // NOI18N
        jLabel1.setName(""); // NOI18N
        scrollPane2.add(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(WelcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserNameLabel))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(UserNameLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WelcomeLabel)
                    .addComponent(UserNameLabel))
                .addGap(8, 8, 8)
                .addComponent(UserNameLabel1)
                .addGap(10, 10, 10)
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JLabel UserNameLabel1;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel jLabel1;
    private java.awt.ScrollPane scrollPane2;
    // End of variables declaration//GEN-END:variables
}