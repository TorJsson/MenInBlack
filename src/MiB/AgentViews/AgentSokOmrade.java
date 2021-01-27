package MiB.AgentViews;

import MiB.Omrade;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgentSokOmrade extends javax.swing.JFrame {
    private static int id;
    private static String omradeId;

    public AgentSokOmrade(int id) {
        initComponents();
        this.id = id;
        hamtaOmradesnamn();
    }
    
    private void hamtaOmradesnamn(){
        ArrayList<String> allaOmraden = Omrade.getAllaOmradesBenamningar();
        
        for(String omrade : allaOmraden) {
            cbPlats.addItem(omrade);
            
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        cbPlats = new javax.swing.JComboBox<>();
        btnHamta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setToolTipText("");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        cbPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------ Välj plats ------" }));

        btnHamta.setText("Hämta");
        btnHamta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnHamta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPlats, 0, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHamta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addGap(18, 18, 18)
                .addComponent(cbPlats, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(btnHamta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyAgent(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnHamtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaActionPerformed
        if(cbPlats.getSelectedItem().toString().isEmpty() || cbPlats.getSelectedItem().equals(("------ Välj plats ------"))) {
            JOptionPane.showMessageDialog(null, "Du har inte valt någon plats", "Ingen plats vald", JOptionPane.ERROR_MESSAGE);
        } else {
            omradeId = Omrade.getIdByBenamning(cbPlats.getSelectedItem().toString());
            new AgentSokOmradeResultat(id, Integer.parseInt(omradeId)).setVisible(true);
            dispose();

        }

    }//GEN-LAST:event_btnHamtaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHamta;
    private javax.swing.JComboBox<String> cbPlats;
    // End of variables declaration//GEN-END:variables
}
