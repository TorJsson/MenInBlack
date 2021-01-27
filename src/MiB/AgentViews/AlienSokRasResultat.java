package MiB.AgentViews;

import MiB.Alien;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AlienSokRasResultat extends javax.swing.JFrame {
    private static int id;
    private static String ras;

    public AlienSokRasResultat(int id, String ras) {
        initComponents();
        this.id = id;
        this.ras = ras;
        uppdateraLista();
    }

    private void uppdateraLista() {
        ArrayList<HashMap<String, String>> allaAliens = Alien.getAllaNamnOchIdByRas(ras);

        //Skapar ett objekt av klassen DefaultTableModel, skickar in ett objekt som inneh�ller tabellkolumnernas namnv�rden
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

        btnVisaMer = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultatLista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

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
                            .addComponent(btnVisaMer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGoBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVisaMer)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisaMerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMerActionPerformed
        //Kontrollerar att en alien �r vald i listan
        if(tblResultatLista.getSelectionModel().isSelectionEmpty()){
            //Om inte s� visas ett felmeddelande
            JOptionPane.showMessageDialog(null, "Du har inte valt n�gon alien i listan. F�rs�k igen.", "Ett fel har uppst�tt", JOptionPane.ERROR_MESSAGE);
        } else {
            if(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1) == null) {
                //Om den valda raden �r null (tom rad, om inga aliens finns)
                JOptionPane.showMessageDialog(null, "Det finns ingen alien av den rasen.", "Ett fel har uppst�tt", JOptionPane.ERROR_MESSAGE);
            } else {
                //Annars h�mtas v�rdet fr�n valda radens 1a kolumn som en str�ng och tolkas till en int
                int valdAlien = Integer.parseInt(tblResultatLista.getValueAt(tblResultatLista.getSelectedRow(), 1).toString());

                //�ppnar nytt f�nster
                new AlienSokResultatVisaMer(id, 2, valdAlien, 0, null, ras, null, null).setVisible(true);
                //St�nger nuvarande
                dispose();
            }
        }
    }//GEN-LAST:event_btnVisaMerActionPerformed

    //Metod som k�rs n�r man klickar p� G� tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //�ppnar nytt f�nster
        new AlienSokRas(id).setVisible(true);
        //St�nger det nuvarande
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnVisaMer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultatLista;
    // End of variables declaration//GEN-END:variables
}
