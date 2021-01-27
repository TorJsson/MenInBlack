package MiB.AgentViews;

import MiB.Agent;
import MiB.CommonViews.Login;

public class AgentStart extends javax.swing.JFrame {
    private static int id;
    private static String namn;

    public AgentStart(int id) {
        initComponents();
        this.id = id;
        //H�mtar agentens namn utifr�n dess id mha getNamnById()-metoden
        namn = Agent.getNamnById(id);
        String anvandartyp = "";
        //Kontrollerar om agenten �r administrat�r eller inte
        if(Agent.getAdminStatusById(id)) {
            anvandartyp = "administrat�r";
        } else {
            anvandartyp = "agent";
        }
        //�ndrar lblValkommenRubrik till en str�ng med agentens namn och anv�ndartyp (agent/administrat�r)
        lblValkommenRubrik.setText("V�lkommen, " + namn + " (" + anvandartyp + ").");
        
        //Om agenten �r administrat�r s� aktiverar vi Agenter-knappen
        if(Agent.getAdminStatusById(id)) {
            btnAgenter.setEnabled(true);
        //Annars inaktiverar vi den
        } else {
            btnAgenter.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        lblValkommenRubrik = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnAliens = new javax.swing.JButton();
        btnUtrustning = new javax.swing.JButton();
        btnOmrade = new javax.swing.JButton();
        btnKonto = new javax.swing.JButton();
        btnAgenter = new javax.swing.JButton();

        jButton3.setText("�ndra information om alien");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB -  Inloggad");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName("agentLoggedIn"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblValkommenRubrik.setText("V�lkommen, $namn (agent/administrat�r).");

        btnLogOut.setText("Logga ut");
        btnLogOut.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnAliens.setText("Aliens");
        btnAliens.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAliens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAliensActionPerformed(evt);
            }
        });

        btnUtrustning.setText("Utrustning");
        btnUtrustning.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtrustningActionPerformed(evt);
            }
        });

        btnOmrade.setText("Visa omr�desinformation");
        btnOmrade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmradeActionPerformed(evt);
            }
        });

        btnKonto.setText("Konto");
        btnKonto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnKonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKontoActionPerformed(evt);
            }
        });

        btnAgenter.setText("Agenter");
        btnAgenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgenterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOmrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUtrustning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAliens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblValkommenRubrik, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValkommenRubrik)
                    .addComponent(btnLogOut))
                .addGap(18, 18, 18)
                .addComponent(btnAliens, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKonto, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        getAccessibleContext().setAccessibleName("MiB - Inloggad som agent");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Metod som k�rs n�r man klickar p� Logga ut
    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new Login().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnLogOutActionPerformed
    
    //Metod som k�rs n�r man klickar p� Aliens
    private void btnAliensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAliensActionPerformed
        new MenyAliens(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAliensActionPerformed
    
    //Metod som k�rs n�r man klickar p� Konto
    private void btnKontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKontoActionPerformed
        new MenyKonto(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKontoActionPerformed
    
    //Metod som k�rs n�r man klickar p� Utrustning
    private void btnUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtrustningActionPerformed
        new MenyUtrustning(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUtrustningActionPerformed
    
    //Metod som k�rs n�r man klickar p� Visa omr�desinformation
    private void btnOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmradeActionPerformed
        new MenyOmrade(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOmradeActionPerformed

    //Metod som k�rs n�r man klickar p� Agenter
    private void btnAgenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgenterActionPerformed
        new MenyAgent(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAgenterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgenter;
    private javax.swing.JButton btnAliens;
    private javax.swing.JButton btnKonto;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnOmrade;
    private javax.swing.JButton btnUtrustning;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lblValkommenRubrik;
    // End of variables declaration//GEN-END:variables
}
