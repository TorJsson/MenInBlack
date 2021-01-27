package MiB.AlienViews;

public class MenyOmrade extends javax.swing.JFrame {
private static int id;

    public MenyOmrade(int id) {
        initComponents();
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        btnVisaOmradesChef = new javax.swing.JButton();
        btnListaAliensIOmradet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Mitt område");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnVisaOmradesChef.setText("Visa områdeschef");
        btnVisaOmradesChef.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVisaOmradesChef.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVisaOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaOmradesChefActionPerformed(evt);
            }
        });

        btnListaAliensIOmradet.setText("Lista aliens i mitt område");
        btnListaAliensIOmradet.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnListaAliensIOmradet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListaAliensIOmradet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAliensIOmradetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisaOmradesChef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaAliensIOmradet, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addGap(38, 38, 38)
                .addComponent(btnVisaOmradesChef, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListaAliensIOmradet, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new AlienStart(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnVisaOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaOmradesChefActionPerformed
        new OmradeVisaChef(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVisaOmradesChefActionPerformed

    private void btnListaAliensIOmradetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAliensIOmradetActionPerformed
        new OmradeListaAliens(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListaAliensIOmradetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnListaAliensIOmradet;
    private javax.swing.JButton btnVisaOmradesChef;
    // End of variables declaration//GEN-END:variables
}
