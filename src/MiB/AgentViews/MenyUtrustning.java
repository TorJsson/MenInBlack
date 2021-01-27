package MiB.AgentViews;


public class MenyUtrustning extends javax.swing.JFrame {
    private static int id;
    
    public MenyUtrustning(int id) {
        initComponents();
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        btnTeknik = new javax.swing.JButton();
        btnKommunikation = new javax.swing.JButton();
        btnVisaUtkvitterad = new javax.swing.JButton();
        btnVapen = new javax.swing.JButton();
        btnFordon = new javax.swing.JButton();
        btnRegistrera = new javax.swing.JButton();

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

        btnTeknik.setText("Teknisk utrustning");
        btnTeknik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeknikActionPerformed(evt);
            }
        });

        btnKommunikation.setText("Kommunikationsutrustning");
        btnKommunikation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKommunikationActionPerformed(evt);
            }
        });

        btnVisaUtkvitterad.setText("Visa min utkvitterade utrustning");
        btnVisaUtkvitterad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaUtkvitteradActionPerformed(evt);
            }
        });

        btnVapen.setText("Vapen");
        btnVapen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVapenActionPerformed(evt);
            }
        });

        btnFordon.setText("Fordon");
        btnFordon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFordonActionPerformed(evt);
            }
        });

        btnRegistrera.setText("Registrera ny utrustning");
        btnRegistrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreraActionPerformed(evt);
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
                    .addComponent(btnTeknik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVisaUtkvitterad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVapen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFordon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrera, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnKommunikation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addGap(87, 87, 87)
                .addComponent(btnTeknik, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVapen, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFordon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrera, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVisaUtkvitterad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(btnKommunikation, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(394, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreraActionPerformed
        new UtrustningRegistreraNy(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegistreraActionPerformed

    private void btnKommunikationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKommunikationActionPerformed
        new UtrustningVisaAll(id, "Kommunikation").setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKommunikationActionPerformed

    private void btnTeknikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeknikActionPerformed
        new UtrustningVisaAll(id, "Teknik").setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTeknikActionPerformed

    private void btnVapenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVapenActionPerformed
        new UtrustningVisaAll(id, "Vapen").setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVapenActionPerformed

    private void btnFordonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFordonActionPerformed
        new UtrustningVisaAll(id, "Fordon").setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFordonActionPerformed

    private void btnVisaUtkvitteradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaUtkvitteradActionPerformed
        new UtrustningVisaUtkvitterad(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVisaUtkvitteradActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new AgentStart(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFordon;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnKommunikation;
    private javax.swing.JButton btnRegistrera;
    private javax.swing.JButton btnTeknik;
    private javax.swing.JButton btnVapen;
    private javax.swing.JButton btnVisaUtkvitterad;
    // End of variables declaration//GEN-END:variables
}
