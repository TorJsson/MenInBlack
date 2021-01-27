package MiB.AgentViews;

import MiB.Agent;
import MiB.Fordon;
import MiB.Kommunikation;
import MiB.Teknik;
import MiB.Utrustning;
import MiB.Vapen;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class UtrustningVisaAll extends javax.swing.JFrame {
    private static int id;
    private static String kategori;

    public UtrustningVisaAll(int id, String kategori) {
        initComponents();
        this.id = id;
        this.kategori = kategori;
        
        //Sätter defaultEditor till Object.class, null för att data i tabellen inte ska kunna redigeras, men kunna selekteras.
        tblUtrustningsLista.setDefaultEditor(Object.class, null);
        
        //Stänger av möjligheten att ändra kolumnordningen.
        tblUtrustningsLista.getTableHeader().setReorderingAllowed(false);
        
        //Tillåt användaren att välja en rad i tabellen
        tblUtrustningsLista.setRowSelectionAllowed(true);
        
        //Begränsa radval till en rad
        tblUtrustningsLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Inaktivera Ta bort-knappen för icke-administratörer
        if(Agent.getAdminStatusById(id)) {
            btnTaBort.setEnabled(true);
        } else {
            btnTaBort.setEnabled(false);
        }
        
        if(this.kategori.equals("Fordon")) {
            genereraFordonLista();
        } else if(this.kategori.equals("Kommunikation")) {
            genereraKommunikationLista();
        } else if(this.kategori.equals("Teknik")) {
            genereraTeknikLista();
        } else if(this.kategori.equals("Vapen")) {
            genereraVapenLista();
        }
    }
    
    private void genereraFordonLista(){
        ArrayList<HashMap<String, String>> allaUtrustningId = Fordon.getAllListaData();

        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BESKRIVNING", "ÅRSMODELL", "REG.DATUM"}, 0);

        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String fordonsId = rad.get("FORDONS_ID");
                String beskrivning = rad.get("FORDONSBESKRIVNING");
                String registreringsdatum = rad.get("REGISTRERINGSDATUM");
                String arsmodell = rad.get("ARSMODELL");
                //Sätter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ fordonsId, beskrivning, arsmodell, registreringsdatum });
            }
        }

        tblUtrustningsLista.setModel(tabellModell);

    }

    private void genereraKommunikationLista(){
        //Skapar en ArrayList<String> att lagra resultaten från databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Kommunikation.getAllListaData();
        
        //Skapar en tabellModell av klassen DefaultTableModel och sätter "rubriker" för kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BENÄMNING", "ÖVERFÖRINGSTEKNIK"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("BENAMNING");
                String overforingsteknik = rad.get("OVERFORINGSTEKNIK");
                String utrustningsId = rad.get("UTRUSTNINGS_ID");
                //Sätter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ utrustningsId, namn, overforingsteknik });
            }
        }
        
        tblUtrustningsLista.setModel(tabellModell);
        tblUtrustningsLista.getColumnModel().getColumn(0).setMinWidth(0);
        tblUtrustningsLista.getColumnModel().getColumn(0).setMaxWidth(0);
        tblUtrustningsLista.getColumnModel().getColumn(0).setWidth(0);
    
    }
    
    private void genereraTeknikLista(){
        //Skapar en ArrayList<String> att lagra resultaten från databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Teknik.getAllListaData();
        
        //Skapar en tabellModell av klassen DefaultTableModel och sätter "rubriker" för kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BENÄMNING", "KRAFTKÄLLA"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("BENAMNING");
                String kraftkalla = rad.get("KRAFTKALLA");
                String utrustningsId = rad.get("UTRUSTNINGS_ID");
                //Sätter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ utrustningsId, namn, kraftkalla });
            }
        }
        
        tblUtrustningsLista.setModel(tabellModell);
        tblUtrustningsLista.getColumnModel().getColumn(0).setMinWidth(0);
        tblUtrustningsLista.getColumnModel().getColumn(0).setMaxWidth(0);
        tblUtrustningsLista.getColumnModel().getColumn(0).setWidth(0);
    }
    
    private void genereraVapenLista(){
        //Skapar en ArrayList<String> att lagra resultaten från databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Vapen.getAllListaData();
        
        //Skapar en tabellModell av klassen DefaultTableModel och sätter "rubriker" för kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BENÄMNING", "KALIBER"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("BENAMNING");
                String kaliber = rad.get("KALIBER");
                String utrustningsId = rad.get("UTRUSTNINGS_ID");
                
                tabellModell.addRow(new Object[]{ utrustningsId, namn, kaliber });
            }
        }
        
        tblUtrustningsLista.setModel(tabellModell);
        tblUtrustningsLista.getColumnModel().getColumn(0).setMinWidth(0);
        tblUtrustningsLista.getColumnModel().getColumn(0).setMaxWidth(0);
        tblUtrustningsLista.getColumnModel().getColumn(0).setWidth(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUtrustningsLista = new javax.swing.JTable();
        btnGoBack = new javax.swing.JButton();
        btnKvitteraUt = new javax.swing.JButton();
        btnTaBort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        tblUtrustningsLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblUtrustningsLista);

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnKvitteraUt.setText("Kvittera ut");
        btnKvitteraUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKvitteraUtActionPerformed(evt);
            }
        });

        btnTaBort.setText("Ta bort");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGoBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnTaBort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKvitteraUt)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKvitteraUt)
                    .addComponent(btnTaBort))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyUtrustning(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnKvitteraUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKvitteraUtActionPerformed
        if(kategori.equals("Fordon")) {
            if(tblUtrustningsLista.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Du har inte valt någon utrustning i listan. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
            } else {
                String valtFordon = tblUtrustningsLista.getValueAt(tblUtrustningsLista.getSelectedRow(), 0).toString();

                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String datum = LocalDate.now().format(format);
                if(!Fordon.arUtkvitterad(valtFordon)) {
                    if(Fordon.kvitteraUt(id, valtFordon, datum)) {
                        JOptionPane.showMessageDialog(null, "Du har kvitterat ut utrustningen.", "Utrustning utkvitterad", JOptionPane.INFORMATION_MESSAGE);
                        new MenyUtrustning(id).setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Utrustningen är redan utkvitterad.", "Kunde inte kvittera ut", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            if(tblUtrustningsLista.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Du har inte valt någon utrustning i listan. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
            } else {
                int valdUtrustning = Integer.parseInt(tblUtrustningsLista.getValueAt(tblUtrustningsLista.getSelectedRow(), 0).toString());

                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String datum = LocalDate.now().format(format);
                if(!Utrustning.arUtkvitterad(valdUtrustning)) {
                    if(Utrustning.kvitteraUt(id, valdUtrustning, datum)) {
                        JOptionPane.showMessageDialog(null, "Du har kvitterat ut utrustningen.", "Utrustning utkvitterad", JOptionPane.INFORMATION_MESSAGE);
                        new MenyUtrustning(id).setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Utrustningen är redan utkvitterad.", "Kunde inte kvittera ut", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnKvitteraUtActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        if(tblUtrustningsLista.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Du har inte valt någon utrustning i listan att ta bort", "Ingen utrustning vald", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //Ta bort utrustning
            String valdUtrustning = tblUtrustningsLista.getValueAt(tblUtrustningsLista.getSelectedRow(), 0).toString();
            
            if(kategori.equals("Fordon")) {
                //Kontrollerar om fordonet är utkvitterat av någon
                if(Fordon.arUtkvitterad(valdUtrustning)) {
                    //Ta bort från innehar_fordon
                    if(Fordon.lamnaTillbaka(valdUtrustning)) {
                        //Utrustningen är tillbakalämnad 
                    }
                }
                
                if(Fordon.taBort(valdUtrustning)) {
                    JOptionPane.showMessageDialog(null, "Fordonet är borttaget ur systemet", "Fordon borttaget", JOptionPane.INFORMATION_MESSAGE);
                    genereraFordonLista();
                }
                
            } else {
                //Kontrollerar om utrustningen är utkvitterad av någon
                if(Utrustning.arUtkvitterad(Integer.parseInt(valdUtrustning))) {
                    //Ta bort från innehar_utrustning
                    if(Utrustning.lamnaTillbaka(valdUtrustning)) {
                        //Utrustningen är tillbakalämnad
                    }
                }
                
                if(Utrustning.taBort(Integer.parseInt(valdUtrustning), kategori)) {
                    JOptionPane.showMessageDialog(null, "Utrustningen är borttagen ur systemet", "Utrustning borttagen", JOptionPane.INFORMATION_MESSAGE);
                    
                    //Genererar en ny lista baserat på vilken kategori som är vald
                    if(kategori.equals("Kommunikation")) {
                        genereraKommunikationLista();
                    } else if(kategori.equals("Teknik")) {
                        genereraTeknikLista();
                    } else if(kategori.equals("Vapen")) {
                        genereraVapenLista();
                    }
                    
                }
            }
            
        }
    }//GEN-LAST:event_btnTaBortActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnKvitteraUt;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUtrustningsLista;
    // End of variables declaration//GEN-END:variables

}
