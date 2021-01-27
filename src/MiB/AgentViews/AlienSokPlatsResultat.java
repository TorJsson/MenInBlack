package MiB.AgentViews;

import MiB.Agent;
import MiB.Alien;
import MiB.Omrade;
import MiB.Plats;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AlienSokPlatsResultat extends javax.swing.JFrame {
    private static int id;
    private static int platsId;
    private static int omradeId;
    private static int omradeChefId;
    private static String omradeChefNamn;
    private static String platsNamn;

    public AlienSokPlatsResultat(int id, int platsId) {
        initComponents();
        this.id = id;
        this.platsId = platsId;
        //Hämtar värden från databasen och sparar i fält
        this.omradeId = Plats.getFinnsIById(platsId);
        this.omradeChefId = Omrade.getOmradesChefById(omradeId);
        this.omradeChefNamn = Agent.getNamnById(omradeChefId);
        this.platsNamn = Plats.getBenamningById(platsId);
        uppdateraLabels();
        uppdateraLista();
    }
    
    //Metod som uppdaterar labels med variabeldata
    private void uppdateraLabels(){
        lblPlats.setText(platsNamn);
        lblOmradeschef.setText(omradeChefNamn);
    }

    //Metod som hämtar data och uppdaterar tabellistan
    private void uppdateraLista() {
    ArrayList<HashMap<String, String>> allaAliens = Alien.getAllaNamnOchIdByPlats(platsId);

        //Skapar ett objekt av klassen DefaultTableModel. Skickar in ett objekt bestående av kolumnnamnen.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"NAMN", "ID"}, 0);

        //Kontrollerar om arrayListen som hämtats är tom.
        if(allaAliens == null){
            //Gör isåfall en tom rad i tabellen genom att använda metoden addRow() och skicka in ett objekt med nullvärden
            tabellModell.addRow(new Object[]{ null, null });
        } else {
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

        btnGoBack = new javax.swing.JButton();
        lblPlatsRubrik = new javax.swing.JLabel();
        lblPlats = new javax.swing.JLabel();
        btnTopplista = new javax.swing.JButton();
        lblOmradeschefRubrik = new javax.swing.JLabel();
        lblOmradeschef = new javax.swing.JLabel();
        btnVisaChef = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultatLista = new javax.swing.JTable();
        btnVisaMer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Sök efter plats - Resultat");
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

        lblPlatsRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPlatsRubrik.setText("Plats:");

        lblPlats.setText("$platsNamn");

        btnTopplista.setText("Topplista");
        btnTopplista.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTopplista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopplistaActionPerformed(evt);
            }
        });

        lblOmradeschefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeschefRubrik.setText("Områdeschef:");

        lblOmradeschef.setText("$omradesChefNamn");

        btnVisaChef.setText("Visa mer");
        btnVisaChef.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVisaChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaChefActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPlatsRubrik)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPlats)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTopplista))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOmradeschefRubrik)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblOmradeschef)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVisaChef, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(lblPlatsRubrik)
                    .addComponent(lblPlats)
                    .addComponent(btnTopplista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradeschefRubrik)
                    .addComponent(lblOmradeschef)
                    .addComponent(btnVisaChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVisaMer)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs när man klickar på Gå tillbaka-knappen
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar fönstret Sök efter plats
        new AlienSokPlats(id).setVisible(true);
        //Stänger det nuvarande
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som körs när man klickar på Visa mer
    private void btnVisaMerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMerActionPerformed
        //Kontrollerar om en alien är vald i tabellen
        if(tblResultatLista.getSelectionModel().isSelectionEmpty()){
            //Visar ett felmeddelande om ingen är vald
            JOptionPane.showMessageDialog(null, "Du har inte valt någon alien i listan. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
        } else {
            //Kontrollerar om den valda raden är tom (null)
            if(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1) == null) {
                //Visar isåfall ett felmeddelande
                 JOptionPane.showMessageDialog(null, "Det finns ingen alien registrerad på den valda platsen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
            } else {
                //Annars hämtar vi värdet från den valda radens första kolumn, omvandlar det till en sträng och tolkar strängen för att hämta ut en int. Lagrar int'en som valdAlien
                int valdAlien = Integer.parseInt(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1).toString());

                //Öppnar nytt fönster
                new AlienSokResultatVisaMer(id, 1, valdAlien, platsId, null, null, null, null).setVisible(true);
                //Stänger det nuvarande
                dispose();
            }
        }
    }//GEN-LAST:event_btnVisaMerActionPerformed

    //Metod som körs när man klickar på Topplista
    private void btnTopplistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopplistaActionPerformed
        //Öppnar topplistan för en vald plats i ett valt område
        new AlienSokPlatsResultatVisaTopplista(id, platsId, omradeId).setVisible(true);
        //Stänger det nuvarande fönstret
        dispose();
    }//GEN-LAST:event_btnTopplistaActionPerformed

    //Metod som körs när man klickar på Visa mer om områdeschefen
    private void btnVisaChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaChefActionPerformed
        //Öppnar nytt fönster
        new AlienSokPlatsVisaOmradesChef(id, platsId, omradeId, omradeChefId).setVisible(true);
        //Stänger det nuvarande
        dispose();
    }//GEN-LAST:event_btnVisaChefActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnTopplista;
    private javax.swing.JButton btnVisaChef;
    private javax.swing.JButton btnVisaMer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOmradeschef;
    private javax.swing.JLabel lblOmradeschefRubrik;
    private javax.swing.JLabel lblPlats;
    private javax.swing.JLabel lblPlatsRubrik;
    private javax.swing.JTable tblResultatLista;
    // End of variables declaration//GEN-END:variables
}
