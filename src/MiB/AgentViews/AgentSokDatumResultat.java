package MiB.AgentViews;

import MiB.Agent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AgentSokDatumResultat extends javax.swing.JFrame {
    private static int id;
    private static String startDatum;
    private static String slutDatum;

    public AgentSokDatumResultat(int id, String startDatum, String slutDatum) {
        initComponents();
        this.id = id;
        this.startDatum = startDatum;
        this.slutDatum = slutDatum; 
        uppdateraLista();
    }
    
    //Metod som hämtar och uppdaterar jTable'n
    private void uppdateraLista() {
        ArrayList<HashMap<String, String>> allaAgenter = Agent.getAllaNamnOchIdByDatum(startDatum, slutDatum);

        //Skapar en DefaultTableModel som sen används i vår tabell
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"NAMN", "ID"}, 0);
        
        //Kollar om ArrayListen med resultat innehåller data, annars skapas en tom rad i resultatlistan.
        if(allaAgenter == null){
           tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            //Itererar igenom resultaten
           for(HashMap<String, String> rad : allaAgenter) {
               String agentNamn = rad.get("NAMN");
               String agentId = rad.get("AGENT_ID");
               //Sätter in namn + alien_id i tabellmodellen mha addRow()
               tabellModell.addRow(new Object[]{ agentNamn, agentId });
           }
        }
        //Uppdaterar listan m.h.a. modellen vi skapat
        
        tblResultatLista.setModel(tabellModell);
        
        //Sätter den 2a kolumnen ("ID") till 0px bred (döljer den)
        tblResultatLista.getColumnModel().getColumn(1).setMinWidth(0);
        tblResultatLista.getColumnModel().getColumn(1).setMaxWidth(0);
        tblResultatLista.getColumnModel().getColumn(1).setWidth(0);
        
        //Inaktiverar redigering av tabellen genom att sätta defaultEditor till null
        tblResultatLista.setDefaultEditor(Object.class, null);
        
        //Låser kolumnordningen
        tblResultatLista.getTableHeader().setReorderingAllowed(false);
        
        //Tillåt användaren att välja en rad i tabellen
        tblResultatLista.setRowSelectionAllowed(true);
        
        //Begränsa radval till en rad
        tblResultatLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultatLista = new javax.swing.JTable();
        btnRedigera = new javax.swing.JButton();

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

        tblResultatLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResultatLista);

        btnRedigera.setText("Redigera");
        btnRedigera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraActionPerformed(evt);
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
                            .addComponent(btnRedigera, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnRedigera)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs när man klickar på Gå tillbaka-knappen
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Instansierar ett nytt fönster för att söka efter datum
        new AgentSokDatum(id).setVisible(true);
        //Stänger nuvarande fönstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som körs när man klickar på Redigera-knappen
    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        //Kontrollerar att en agent i listan är vald
        if(tblResultatLista.getSelectionModel().isSelectionEmpty()){
            //Visar felmeddelande om ingen är vald
            JOptionPane.showMessageDialog(null, "Du har inte valt någon agent i listan. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
        } else {
            if(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1) == null) {
                //Visar ett felmeddelande om ingen agent finns registrerad mellan de angivna datumen
                JOptionPane.showMessageDialog(null, "Det finns ingen agent anställd mellan de datumen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
            //Om en agent i listan är vald
            } else {
                //Hämtar värdet från den valda raden och 1a kolumnen (agentId) och omvandlar det till en string, för att sen tolka strängen, hämta ut en integer från den och spara den som int valdAgent
                int valdAgent = Integer.parseInt(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1).toString());
                //Öppnar redigeringsfönstret och skickar med den valda agentens id som en parameter
                new AgentRedigera(id, valdAgent).setVisible(true);
                //Stänger nuvarande fönstret
                dispose();
            }
        }
    }//GEN-LAST:event_btnRedigeraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnRedigera;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultatLista;
    // End of variables declaration//GEN-END:variables
}
