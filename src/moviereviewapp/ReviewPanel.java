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
public class ReviewPanel extends javax.swing.JPanel {

    private ReviewManager rm = new ReviewManager();
    private AddReviewFrame arf = new AddReviewFrame(this);
    private boolean updatingTable = false;

    /**
     * Creates new form ReviewPanel
     */
    public ReviewPanel() {
        initComponents();
        refreshGUITable();
        this.reviewTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if (updatingTable) {
                    return;
                }
                int changedRow = e.getFirstRow();
                Review r = new Review(Integer.parseInt(reviewTable.getValueAt(changedRow, 0).toString()),
                        Integer.parseInt(reviewTable.getValueAt(changedRow, 1).toString()),
                        Integer.parseInt(reviewTable.getValueAt(changedRow, 2).toString()),
                        reviewTable.getValueAt(changedRow, 3).toString(),
                        Integer.parseInt(reviewTable.getValueAt(changedRow, 4).toString()));
                rm.editReview(r);
                refreshGUITable();
            }
        });
    }

    public void refreshGUITable() {

        updatingTable = true;

        Review[] r = rm.getReviews();

        while (reviewTable.getModel().getRowCount() > 0) {
            ((DefaultTableModel) (reviewTable.getModel())).removeRow(0);
        }

        for (int i = 0; i < r.length; i++) {
            addReviewToGUITable(r[i]);
        }

        updatingTable = false;
    }

    public void addReviewToGUITable(Review r) {
        ((DefaultTableModel) (reviewTable.getModel())).addRow(new Object[]{r.getID(), r.getMovieID(), r.getUserID(), r.getDateOfSubmission(), r.getRating()});
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
        reviewTable = new javax.swing.JTable();
        addReviewButtonButton = new javax.swing.JButton();
        deleteReviewButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        reviewTable.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        reviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idReview", "Movie", "User", "Date of Submission", "Rating"
            }
        ));
        jScrollPane1.setViewportView(reviewTable);

        addReviewButtonButton.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        addReviewButtonButton.setText("ADD");
        addReviewButtonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReviewButtonButtonActionPerformed(evt);
            }
        });

        deleteReviewButton.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        deleteReviewButton.setText("DELETE");
        deleteReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReviewButtonActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/review.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addReviewButtonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addReviewButtonButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteReviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addReviewButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReviewButtonButtonActionPerformed
        // TODO add your handling code here:
        arf.setBounds(0, 0, arf.getWidth(), arf.getHeight());
        arf.setVisible(true);

    }//GEN-LAST:event_addReviewButtonButtonActionPerformed

    private void deleteReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReviewButtonActionPerformed
        // TODO add your handling code here:
        int[] id = reviewTable.getSelectedRows();
        Review[] arr = rm.getReviews();
        for (int i : id) {
            for (Review r : arr) {
                if (r.getID() == Integer.parseInt((reviewTable.getModel().getValueAt(i, 0)).toString())) {
                    rm.deleteReview(r);
                    break;
                }
            }
        }
        refreshGUITable();

    }//GEN-LAST:event_deleteReviewButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        refreshGUITable();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addReviewButtonButton;
    private javax.swing.JButton deleteReviewButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reviewTable;
    // End of variables declaration//GEN-END:variables
}