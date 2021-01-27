package MiB.AgentViews;

public class MenyAgent extends javax.swing.JFrame {
    private static int id;

    public MenyAgent(int id) {
        initComponents();
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        btnNy = new javax.swing.JButton();
        btnDatum = new javax.swing.JButton();
        btnNamn = new javax.swing.JButton();
        btnAgentTyp = new javax.swing.JButton();
        btnOmrade = new javax.swing.JButton();
        btnAndraKontorschef = new javax.swing.JButton();
        btnAndraOmradesChef = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnNy.setText("Registrera ny");
        btnNy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyActionPerformed(evt);
            }
        });

        btnDatum.setText("Sök efter anställningsdatum");
        btnDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatumActionPerformed(evt);
            }
        });

        btnNamn.setText("Sök efter namn");
        btnNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNamnActionPerformed(evt);
            }
        });

        btnAgentTyp.setText("Sök efter agenttyp");
        btnAgentTyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgentTypActionPerformed(evt);
            }
        });

        btnOmrade.setText("Sök efter område");
        btnOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmradeActionPerformed(evt);
            }
        });

        btnAndraKontorschef.setText("Ändra kontorschef");
        btnAndraKontorschef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraKontorschefActionPerformed(evt);
            }
        });

        btnAndraOmradesChef.setText("Ändra områdeschef");
        btnAndraOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraOmradesChefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOmrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgentTyp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(btnNy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAndraKontorschef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAndraOmradesChef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addGap(18, 18, 18)
                .addComponent(btnOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgentTyp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAndraOmradesChef, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAndraKontorschef, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new AgentStart(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnNyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyActionPerformed
        new AgentRegistrera(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNyActionPerformed

    private void btnDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatumActionPerformed
        new AgentSokDatum(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDatumActionPerformed

    private void btnNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNamnActionPerformed
        new AgentSokNamn(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNamnActionPerformed

    private void btnAgentTypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgentTypActionPerformed
        new AgentSokTyp(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAgentTypActionPerformed

    private void btnOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmradeActionPerformed
        new AgentSokOmrade(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOmradeActionPerformed

    private void btnAndraKontorschefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraKontorschefActionPerformed
        new AgentAndraKontorsChef(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAndraKontorschefActionPerformed

    private void btnAndraOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraOmradesChefActionPerformed
        new AgentAndraOmradesChef(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAndraOmradesChefActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgentTyp;
    private javax.swing.JButton btnAndraKontorschef;
    private javax.swing.JButton btnAndraOmradesChef;
    private javax.swing.JButton btnDatum;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnNamn;
    private javax.swing.JButton btnNy;
    private javax.swing.JButton btnOmrade;
    // End of variables declaration//GEN-END:variables
}
