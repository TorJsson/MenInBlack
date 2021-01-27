package MiB.AgentViews;

import MiB.Alien;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AlienSokNamnResultat extends javax.swing.JFrame {
    private static int id;
    private static String namn;

    public AlienSokNamnResultat(int id, String namn) {
        initComponents();
        this.id = id;
        this.namn = namn;
        uppdateraLista();
    }
    
    //Metod som hämtar resultaten från sökningen och uppdaterar tabellen
    private void uppdateraLista() {
        ArrayList<HashMap<String, String>> allaAliens = Alien.getAllaNamnOchIdByNamn(namn);

        //Skapar ett objekt av klassen DefaultTableModel som används senare i metoden. Skickar in ett objekt som består av kolumnnamnen
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"NAMN", "ID"}, 0);
        
        //Kollar om ArrayListen med resultat innehåller data, annars skapas en tom rad i resultatlistan.
        if(allaAliens == null){
           tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            //Itererar igenom resultaten
           for(HashMap<String, String> rad : allaAliens) {
               String alienNamn = rad.get("NAMN");
               String alienId = rad.get("ALIEN_ID");
               //Sätter in namn + alien_id i tabellen mha addRow()
               tabellModell.addRow(new Object[]{ alienNamn, alienId });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultatLista = new javax.swing.JTable();
        btnVisaMer = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        tblResultatLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResultatLista);

        btnVisaMer.setText("Visa mer");
        btnVisaMer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVisaMer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaMerActionPerformed(evt);
            }
        });

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
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
                            .addComponent(btnVisaMer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVisaMer)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs när man klickar på visa mer
    private void btnVisaMerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMerActionPerformed
        //Kontrollerar att en alien är vald i tabellen
        if(tblResultatLista.getSelectionModel().isSelectionEmpty()){
            //Annars visas felmeddelande
            JOptionPane.showMessageDialog(null, "Du har inte valt någon alien i listan. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
        } else {
            //Kontrollerar att den valda alien inte är null (tom rad - skapas när arrayen med resultat är tom)
            if(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1) == null) {
                //Visar felmeddelande
                JOptionPane.showMessageDialog(null, "Det finns ingen alien med det namnet.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
            } else {
                //Annars hämtas värdet från den valda radens första kolumn, görs till sträng och tolkar strängen för att hämta ut en int.
                int valdAlien = Integer.parseInt(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1).toString());

                //Öppnar resultatfönstret
                new AlienSokResultatVisaMer(id, 3, valdAlien, 0, namn, null, null, null).setVisible(true);
                //Stänger det nuvarande
                dispose();
            }
        }
    }//GEN-LAST:event_btnVisaMerActionPerformed

     //Metod som körs när man klickar på Gå tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar alienmenyn
        new AlienSokNamn(id).setVisible(true);
        //Stänger det nuvarande fönstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnVisaMer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultatLista;
    // End of variables declaration//GEN-END:variables
}
