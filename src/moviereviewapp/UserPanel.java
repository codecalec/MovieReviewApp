/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviereviewapp;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class UserPanel extends javax.swing.JPanel {

    private UserManager um = new UserManager();
    private AddUserFrame auf = new AddUserFrame(this);
    private boolean updatingTable = false;

    private Review[] r = new ReviewManager().getReviews();

    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        initComponents();
        refreshGUITable();

        this.userTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if (updatingTable) {
                    return;
                }
                int changedRow = e.getFirstRow();
                User u = new User(Integer.parseInt(userTable.getValueAt(changedRow, 0).toString()),
                        userTable.getValueAt(changedRow, 1).toString(), userTable.getValueAt(changedRow, 2).toString(),
                        Boolean.parseBoolean(userTable.getValueAt(changedRow, 3).toString()),
                        Integer.parseInt(userTable.getValueAt(changedRow, 4).toString()));
                um.edituser(u);
                refreshGUITable();
            }
        });
    }

    public void refreshGUITable() {

        updatingTable = true;

        User[] u = um.getUsers();

        while (userTable.getRowCount() > 0) {
            ((DefaultTableModel) (userTable.getModel())).removeRow(0);
        }

        for (User u1 : u) {
            addUserToGUITable(u1);
        }

        updatingTable = false;
    }

    public void addUserToGUITable(User u) {
        int count = 0;
        for (Review r1 : r) {
            if (r1.getUserID() == u.getID()) {
                count++;
            }
        }
        ((DefaultTableModel) (userTable.getModel())).addRow(new Object[]{u.getID(), u.getUsername(), u.getDateOfCreation(), u.isPremium(), count});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        deleteUserButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        userTable.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idUser", "User Name", "Date of Creation", "Premuim User", "Number Of Reviews"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        deleteUserButton.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        deleteUserButton.setText("DELETE");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        addUserButton.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        addUserButton.setText("ADD");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/user.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addUserButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteUserButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        // TODO add your handling code here:
        auf.setBounds(0, 0, auf.getWidth(), auf.getHeight());
        auf.setVisible(true);
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        refreshGUITable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        // TODO add your handling code here:
        int[] id = userTable.getSelectedRows();
        User[] arr = um.getUsers();
        for (int i : id) {
            for (User u : arr) {
                if (u.getID() == Integer.parseInt((userTable.getModel().getValueAt(i, 0)).toString())) {
                    um.deleteUser(u);
                    break;
                }
            }
        }
        refreshGUITable();
    }//GEN-LAST:event_deleteUserButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
