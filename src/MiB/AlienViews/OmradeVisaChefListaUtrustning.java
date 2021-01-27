package MiB.AlienViews;

import MiB.Agent;
import MiB.Fordon;
import MiB.Kommunikation;
import MiB.Teknik;
import MiB.Vapen;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OmradeVisaChefListaUtrustning extends javax.swing.JFrame {
    private static int alienId;
    private static int agentId;

    public OmradeVisaChefListaUtrustning(int alienId, int agentId) {
        initComponents();
        this.alienId = alienId;
        this.agentId = agentId;
        
        //Sätter defaultEditor till Object.class, null för att data i tabellen inte ska kunna redigeras, men kunna selekteras.
        tblVapenLista.setDefaultEditor(Object.class, null);
        
        //Stänger av möjligheten att ändra kolumnordningen.
        tblVapenLista.getTableHeader().setReorderingAllowed(false);
        
        uppdateraSida();
    }
    
    private void uppdateraSida() {
        String agentNamn = Agent.getNamnById(agentId);
        lblAgentNamn.setText(agentNamn);
    }
    
    private void genereraFordonLista(){
        ArrayList<HashMap<String, String>> allaUtrustningId = Fordon.getListaData(agentId);

        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BESKRIVNING", "ÅRSMODELL", "REG.DATUM", "UTKVITTERINGSDATUM"}, 0);

        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("FORDONS_ID");
                String beskrivning = rad.get("FORDONSBESKRIVNING");
                String registreringsdatum = rad.get("REGISTRERINGSDATUM");
                String arsmodell = rad.get("ARSMODELL");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                //Sätter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ namn, beskrivning, arsmodell, registreringsdatum, utkvitteringsdatum });
            }
        }

        tblVapenLista.setModel(tabellModell);

    }

    private void genereraKommunikationLista(){
        //Skapar en ArrayList<String> att lagra resultaten från databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Kommunikation.getListaData(agentId);
        
        //Skapar en tabellModell av klassen DefaultTableModel och sätter "rubriker" för kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"BENÄMNING", "ÖVERFÖRINGSTEKNIK", "UTKVITTERINGSDATUM"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("BENAMNING");
                String overforingsteknik = rad.get("OVERFORINGSTEKNIK");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                //Sätter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ namn, overforingsteknik, utkvitteringsdatum });
            }
        }
        
        tblVapenLista.setModel(tabellModell);
    
    }
    
    private void genereraTeknikLista(){
        //Skapar en ArrayList<String> att lagra resultaten från databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Teknik.getListaData(agentId);
        
        //Skapar en tabellModell av klassen DefaultTableModel och sätter "rubriker" för kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"BENÄMNING", "KRAFTKÄLLA", "UTKVITTERINGSDATUM"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("BENAMNING");
                String kraftkalla = rad.get("KRAFTKALLA");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                //Sätter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ namn, kraftkalla, utkvitteringsdatum });
            }
        }
        
        tblVapenLista.setModel(tabellModell);
    
    }
    
    private void genereraVapenLista(){
        //Skapar en ArrayList<String> att lagra resultaten från databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Vapen.getListaData(agentId);
        
        //Skapar en tabellModell av klassen DefaultTableModel och sätter "rubriker" för kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"BENÄMNING", "KALIBER", "UTKVITTERINGSDATUM"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("BENAMNING");
                String kaliber = rad.get("KALIBER");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                
                tabellModell.addRow(new Object[]{ namn, kaliber, utkvitteringsdatum });
            }
        }
        
        tblVapenLista.setModel(tabellModell);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        lblVapenRubrik = new javax.swing.JLabel();
        lblAgentNamn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVapenLista = new javax.swing.JTable();
        cbKategori = new javax.swing.JComboBox<>();
        btnHamta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Visa områdeschef - Utrustning");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblVapenRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVapenRubrik.setText("Utrustning som nyttjas av:");

        lblAgentNamn.setText("$agentNamn");

        tblVapenLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVapenLista);

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj en kategori ---", "Fordon", "Vapen", "Kommunikation", "Teknik" }));
        cbKategori.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVapenRubrik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAgentNamn)
                        .addGap(18, 142, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHamta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(lblVapenRubrik)
                    .addComponent(lblAgentNamn))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHamta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHamtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaActionPerformed
        if(cbKategori.getSelectedItem().equals("Fordon")) {
            genereraFordonLista();
        } else if(cbKategori.getSelectedItem().equals("Vapen")) {
            genereraVapenLista();
        } else if(cbKategori.getSelectedItem().equals("Kommunikation")) {
            genereraKommunikationLista();
        } else if(cbKategori.getSelectedItem().equals("Teknik")){
            genereraTeknikLista();
        } else {
            JOptionPane.showMessageDialog(null, "Välj en kategori", "Ingen kategori vald", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHamtaActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new OmradeVisaChef(alienId).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHamta;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JLabel lblVapenRubrik;
    private javax.swing.JTable tblVapenLista;
    // End of variables declaration//GEN-END:variables
}
