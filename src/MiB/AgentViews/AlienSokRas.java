package MiB.AgentViews;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlienSokRas extends javax.swing.JFrame {
    private static int id;
    private static String ras;
    private static ArrayList<String> allaRaser = new ArrayList<>();

    public AlienSokRas(int id) {
        initComponents();
        this.id = id;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        cbRas = new javax.swing.JComboBox<>();
        btnHamta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Sök efter ras");
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

        cbRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------ Välj ras ------", "Boglodite", "Squid", "Worm" }));

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
                    .addComponent(cbRas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 360, Short.MAX_VALUE)
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
                .addComponent(cbRas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(btnHamta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //metod som körs när man klickar på gå tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar Aliens-menyn
        new MenyAliens(id).setVisible(true);
        //Stänger det nuvarande
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som körs när man klickar på hämta
    private void btnHamtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaActionPerformed
        //Kontrollerar att en ras är vald i comboboxen
        if(cbRas.getSelectedItem().toString().isEmpty() || cbRas.getSelectedItem().equals(("------ Välj ras ------"))) {
            //Om inte så visas ett felmeddelande
            JOptionPane.showMessageDialog(null, "Du har inte valt någon ras", "Ingen ras vald", JOptionPane.ERROR_MESSAGE);
        } else {
            //Annars hämtas värdet från valet i comboboxen och omvandlas till en sträng
            ras = cbRas.getSelectedItem().toString();
            //Nytt fönster med resultat öppnas
            new AlienSokRasResultat(id, ras).setVisible(true);
            //Nuvarande fönster stängs
            dispose();
        }
        
    }//GEN-LAST:event_btnHamtaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHamta;
    private javax.swing.JComboBox<String> cbRas;
    // End of variables declaration//GEN-END:variables
}
