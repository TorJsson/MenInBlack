package MiB.AlienViews;

import MiB.Alien;
import MiB.CommonViews.Login;

public class AlienStart extends javax.swing.JFrame {
    private static int id;
    private static String namn;

    public AlienStart(int id) {
        initComponents();
        this.id = id;
        namn = Alien.getNamnById(id);    
        lblValkommenRubrik.setText("Välkommen, " + namn + ".");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblValkommenRubrik = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnOpenOmradeAsAlien = new javax.swing.JButton();
        btnOpenKontoAsAlien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB -  Inloggad som alien");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName("alienLoggedIn"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblValkommenRubrik.setText("Välkommen, $namn.");

        btnLogOut.setText("Logga ut");
        btnLogOut.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnOpenOmradeAsAlien.setText("Område");
        btnOpenOmradeAsAlien.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnOpenOmradeAsAlien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpenOmradeAsAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenOmradeAsAlienActionPerformed(evt);
            }
        });

        btnOpenKontoAsAlien.setText("Konto");
        btnOpenKontoAsAlien.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnOpenKontoAsAlien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpenKontoAsAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenKontoAsAlienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOpenKontoAsAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpenOmradeAsAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblValkommenRubrik, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValkommenRubrik)
                    .addComponent(btnLogOut))
                .addGap(59, 59, 59)
                .addComponent(btnOpenOmradeAsAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOpenKontoAsAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("MiB - Inloggad som alien");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnOpenOmradeAsAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenOmradeAsAlienActionPerformed
        new MenyOmrade(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOpenOmradeAsAlienActionPerformed

    private void btnOpenKontoAsAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenKontoAsAlienActionPerformed
        new MenyKonto(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOpenKontoAsAlienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnOpenKontoAsAlien;
    private javax.swing.JButton btnOpenOmradeAsAlien;
    private javax.swing.JLabel lblValkommenRubrik;
    // End of variables declaration//GEN-END:variables
}
