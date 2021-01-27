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
    
    //Metod som h�mtar resultaten fr�n s�kningen och uppdaterar tabellen
    private void uppdateraLista() {
        ArrayList<HashMap<String, String>> allaAliens = Alien.getAllaNamnOchIdByNamn(namn);

        //Skapar ett objekt av klassen DefaultTableModel som anv�nds senare i metoden. Skickar in ett objekt som best�r av kolumnnamnen
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"NAMN", "ID"}, 0);
        
        //Kollar om ArrayListen med resultat inneh�ller data, annars skapas en tom rad i resultatlistan.
        if(allaAliens == null){
           tabellModell.addRow(new Object[]{ null, null, null });
        } else {
            //Itererar igenom resultaten
           for(HashMap<String, String> rad : allaAliens) {
               String alienNamn = rad.get("NAMN");
               String alienId = rad.get("ALIEN_ID");
               //S�tter in namn + alien_id i tabellen mha addRow()
               tabellModell.addRow(new Object[]{ alienNamn, alienId });
           }
        }
        //Uppdaterar listan m.h.a. modellen vi skapat
        
        tblResultatLista.setModel(tabellModell);
        
        //S�tter den 2a kolumnen ("ID") till 0px bred (d�ljer den)
        tblResultatLista.getColumnModel().getColumn(1).setMinWidth(0);
        tblResultatLista.getColumnModel().getColumn(1).setMaxWidth(0);
        tblResultatLista.getColumnModel().getColumn(1).setWidth(0);
        
        //Inaktiverar redigering av tabellen genom att s�tta defaultEditor till null
        tblResultatLista.setDefaultEditor(Object.class, null);
        
        //L�ser kolumnordningen
        tblResultatLista.getTableHeader().setReorderingAllowed(false);
        
        //Till�t anv�ndaren att v�lja en rad i tabellen
        tblResultatLista.setRowSelectionAllowed(true);
        
        //Begr�nsa radval till en rad
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

        btnGoBack.setText("G� tillbaka");
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

    //Metod som k�rs n�r man klickar p� visa mer
    private void btnVisaMerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMerActionPerformed
        //Kontrollerar att en alien �r vald i tabellen
        if(tblResultatLista.getSelectionModel().isSelectionEmpty()){
            //Annars visas felmeddelande
            JOptionPane.showMessageDialog(null, "Du har inte valt n�gon alien i listan. F�rs�k igen.", "Ett fel har uppst�tt", JOptionPane.ERROR_MESSAGE);
        } else {
            //Kontrollerar att den valda alien inte �r null (tom rad - skapas n�r arrayen med resultat �r tom)
            if(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1) == null) {
                //Visar felmeddelande
                JOptionPane.showMessageDialog(null, "Det finns ingen alien med det namnet.", "Ett fel har uppst�tt", JOptionPane.ERROR_MESSAGE);
            } else {
                //Annars h�mtas v�rdet fr�n den valda radens f�rsta kolumn, g�rs till str�ng och tolkar str�ngen f�r att h�mta ut en int.
                int valdAlien = Integer.parseInt(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1).toString());

                //�ppnar resultatf�nstret
                new AlienSokResultatVisaMer(id, 3, valdAlien, 0, namn, null, null, null).setVisible(true);
                //St�nger det nuvarande
                dispose();
            }
        }
    }//GEN-LAST:event_btnVisaMerActionPerformed

     //Metod som k�rs n�r man klickar p� G� tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //�ppnar alienmenyn
        new AlienSokNamn(id).setVisible(true);
        //St�nger det nuvarande f�nstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnVisaMer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultatLista;
    // End of variables declaration//GEN-END:variables
}
