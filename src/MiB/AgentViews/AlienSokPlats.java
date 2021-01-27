package MiB.AgentViews;

import MiB.Plats;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlienSokPlats extends javax.swing.JFrame {
    private static int id;
    private static int platsId;

    public AlienSokPlats(int id) {
        initComponents();
        this.id = id;
        hamtaPlatsnamn();
    }
    
    //Metod som hämtar alla platsbenämningar
    private void hamtaPlatsnamn(){
        ArrayList<String> allaPlatser = Plats.getAllaPlatsNamn();
        
        //Itererar igenom resultaten
        for(String plats : allaPlatser) {
            //Stoppar in varje platsbenämning i comboboxen
            cbPlats.addItem(plats);
            
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

    //Metod som körs när man klickar på Gå tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar alienmenyn
        new MenyAliens(id).setVisible(true);
        //Stänger det nuvarande fönstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som körs när man klickar på Hämta
    private void btnHamtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaActionPerformed
        //Kontrollerar att en plats är vald i comboboxen
        if(cbPlats.getSelectedItem().toString().isEmpty() || cbPlats.getSelectedItem().equals(("------ Välj plats ------"))) {
            //Annars visas felmeddelande
            JOptionPane.showMessageDialog(null, "Du har inte valt någon plats", "Ingen plats vald", JOptionPane.ERROR_MESSAGE);
        } else {
            //Hämtar värdet från valet i comboboxen och omvandlar det till en sträng. använder getIdByBenamning() för att hämta platsId utifrån benämningen och tolkar till en int
            platsId = Integer.parseInt(Plats.getIdByBenamning(cbPlats.getSelectedItem().toString()));
            //Öppnar resultatfönstret
            new AlienSokPlatsResultat(id, platsId).setVisible(true);
            //Stänger det nuvarande
            dispose();
        }
        
    }//GEN-LAST:event_btnHamtaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHamta;
    private javax.swing.JComboBox<String> cbPlats;
    // End of variables declaration//GEN-END:variables
}
