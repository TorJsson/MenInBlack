package MiB.AgentViews;

import MiB.Agent;
import MiB.Fordon;
import MiB.Kommunikation;
import MiB.Teknik;
import MiB.Utrustning;
import MiB.Vapen;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class UtrustningVisaUtkvitterad extends javax.swing.JFrame {
    private static int id;

    public UtrustningVisaUtkvitterad(int id) {
        initComponents();
        this.id = id;
        
        //S�tter defaultEditor till Object.class, null f�r att data i tabellen inte ska kunna redigeras, men kunna selekteras.
        tblUtrustningsLista.setDefaultEditor(Object.class, null);
        
        //St�nger av m�jligheten att �ndra kolumnordningen.
        tblUtrustningsLista.getTableHeader().setReorderingAllowed(false);

        //Till�t anv�ndaren att v�lja en rad i tabellen
        tblUtrustningsLista.setRowSelectionAllowed(true);
        
        //Begr�nsa radval till en rad
        tblUtrustningsLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        uppdateraSida();
    }
    
    private void uppdateraSida() {
        String agentNamn = Agent.getNamnById(id);
        lblAgentNamn.setText(agentNamn);
    }
    
    private void genereraFordonLista(){
        ArrayList<HashMap<String, String>> allaUtrustningId = Fordon.getListaData(id);

        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BESKRIVNING", "�RSMODELL", "REG.DATUM", "UTKVITTERINGSDATUM"}, 0);

        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String namn = rad.get("FORDONS_ID");
                String beskrivning = rad.get("FORDONSBESKRIVNING");
                String registreringsdatum = rad.get("REGISTRERINGSDATUM");
                String arsmodell = rad.get("ARSMODELL");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                //S�tter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ namn, beskrivning, arsmodell, registreringsdatum, utkvitteringsdatum });
            }
        }

        tblUtrustningsLista.setModel(tabellModell);

    }

    private void genereraKommunikationLista(){
        //Skapar en ArrayList<String> att lagra resultaten fr�n databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Kommunikation.getListaData(id);
        
        //Skapar en tabellModell av klassen DefaultTableModel och s�tter "rubriker" f�r kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BEN�MNING", "�VERF�RINGSTEKNIK", "UTKVITTERINGSDATUM"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String utrustningsId = rad.get("UTRUSTNINGS_ID");
                String namn = rad.get("BENAMNING");
                String overforingsteknik = rad.get("OVERFORINGSTEKNIK");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                //S�tter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ utrustningsId, namn, overforingsteknik, utkvitteringsdatum });
            }
        }
        
        tblUtrustningsLista.setModel(tabellModell);
    
    }
    
    private void genereraTeknikLista(){
        //Skapar en ArrayList<String> att lagra resultaten fr�n databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Teknik.getListaData(id);
        
        //Skapar en tabellModell av klassen DefaultTableModel och s�tter "rubriker" f�r kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BEN�MNING", "KRAFTK�LLA", "UTKVITTERINGSDATUM"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String utrustningsId = rad.get("UTRUSTNINGS_ID");
                String namn = rad.get("BENAMNING");
                String kraftkalla = rad.get("KRAFTKALLA");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                //S�tter in namn + alien_id i tabellen mha addRow()
                tabellModell.addRow(new Object[]{ utrustningsId, namn, kraftkalla, utkvitteringsdatum });
            }
        }
        
        tblUtrustningsLista.setModel(tabellModell);
    
    }
    
    private void genereraVapenLista(){
        //Skapar en ArrayList<String> att lagra resultaten fr�n databasen i.
        ArrayList<HashMap<String, String>> allaUtrustningId = Vapen.getListaData(id);
        
        //Skapar en tabellModell av klassen DefaultTableModel och s�tter "rubriker" f�r kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"ID", "BEN�MNING", "KALIBER", "UTKVITTERINGSDATUM"}, 0);
        
        if(allaUtrustningId == null){
            tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            for(HashMap<String, String> rad : allaUtrustningId) {
                String utrustningsId = rad.get("UTRUSTNINGS_ID");
                String namn = rad.get("BENAMNING");
                String kaliber = rad.get("KALIBER");
                String utkvitteringsdatum = rad.get("UTKVITTERINGSDATUM");
                
                tabellModell.addRow(new Object[]{ utrustningsId, namn, kaliber, utkvitteringsdatum });
            }
        }
        
        tblUtrustningsLista.setModel(tabellModell);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        lblVapenRubrik = new javax.swing.JLabel();
        lblAgentNamn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUtrustningsLista = new javax.swing.JTable();
        cbKategori = new javax.swing.JComboBox<>();
        btnAterlamna = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("G� tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblVapenRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVapenRubrik.setText("Utrustning som nyttjas av:");

        lblAgentNamn.setText("$agentNamn");

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

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj en kategori ---", "Fordon", "Vapen", "Kommunikation", "Teknik" }));
        cbKategori.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });

        btnAterlamna.setText("�terl�mna");
        btnAterlamna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAterlamnaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVapenRubrik)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAgentNamn))
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAterlamna)))
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
                .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAterlamna)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyUtrustning(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriActionPerformed
        if(cbKategori.getSelectedItem().equals("Fordon")) {
            genereraFordonLista();
        } else if(cbKategori.getSelectedItem().equals("Vapen")) {
            genereraVapenLista();
        } else if(cbKategori.getSelectedItem().equals("Kommunikation")) {
            genereraKommunikationLista();
        } else if(cbKategori.getSelectedItem().equals("Teknik")){
            genereraTeknikLista();
        }
    }//GEN-LAST:event_cbKategoriActionPerformed

    private void btnAterlamnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAterlamnaActionPerformed
        if(cbKategori.getSelectedItem().toString().isEmpty() || cbKategori.getSelectedItem().toString().equals("--- V�lj en kategori ---")) {
            JOptionPane.showMessageDialog(null, "Du har inte valt n�gon kategori", "Ingen kategori vald", JOptionPane.ERROR_MESSAGE);
        } else {
            String valdKategori = cbKategori.getSelectedItem().toString();
            if(tblUtrustningsLista.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Du har inte valt n�gon utrustning i listan.", "Fel uppstod", JOptionPane.ERROR_MESSAGE);
            } else if (tblUtrustningsLista.getValueAt(tblUtrustningsLista.getSelectedRow(), 0) == null ) {
                JOptionPane.showMessageDialog(null, "Du har inte kvitterat ut n�gon utrustning fr�n den h�r kategorin.", "Fel uppstod", JOptionPane.ERROR_MESSAGE);
            } else {
                //H�mta v�rdet i den nollte (f�rsta) kolumnen, ID, f�r den valda raden
                String valdUtrustning = tblUtrustningsLista.getValueAt(tblUtrustningsLista.getSelectedRow(), 0).toString();
                if(valdKategori.equals("Fordon")) {
                    //Kontrollera att fordonet �r utkvitterat av anv�ndaren som vill �terl�mna
                    if(Fordon.getUtkvitteratAv(valdUtrustning) == id) {
                        //�terl�mna (ta bort fr�n innehar_fordon)
                        if(Fordon.lamnaTillbaka(valdUtrustning)) {
                            JOptionPane.showMessageDialog(null, "Fordonet �r �terl�mnat.", "�terl�mnat", JOptionPane.INFORMATION_MESSAGE);
                            genereraFordonLista();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Fordonet du vill �terl�mna �r inte utkvitterat av dig.", "Ett fel uppstod", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    //Kontrollera att utrustningen �r utkvitterat av anv�ndaren som vill �terl�mna
                    if(Utrustning.getUtkvitteratAv(Integer.parseInt(valdUtrustning)) == id) {
                        //�terl�mna (ta bort utrustningen fr�n innehar_utrustning)
                        if(Utrustning.lamnaTillbaka(valdUtrustning)) {
                            JOptionPane.showMessageDialog(null, "Utrustningen �r �terl�mnad.", "�terl�mnat", JOptionPane.INFORMATION_MESSAGE);
                            if(valdKategori.equals("Kommunikation")) {
                                genereraKommunikationLista();
                            } else if(valdKategori.equals("Teknik")) {
                                genereraTeknikLista();
                            } else if(valdKategori.equals("Vapen")) {
                                genereraVapenLista();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Utrustningen du vill �terl�mna �r inte utkvitterad av dig.", "Ett fel uppstod", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
            

        
        
    }//GEN-LAST:event_btnAterlamnaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAterlamna;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JLabel lblVapenRubrik;
    private javax.swing.JTable tblUtrustningsLista;
    // End of variables declaration//GEN-END:variables
}
