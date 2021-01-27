package MiB.AlienViews;

import MiB.Alien;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OmradeListaAliens extends javax.swing.JFrame {
    private static int id;
    

    public OmradeListaAliens(int id) {
        initComponents();
        this.id = id;
        //Anropar metoden genereraLista() för att hämta data från databasen och fylla tabellen med den datan.
        genereraLista();
    }
    
    //Populera listan med data från databasen.
    private void genereraLista() {
        //Skapar en ArrayList<HashMap<String,String>> att lagra resultaten från databasen i.
        ArrayList<HashMap<String, String>> allaRader = Alien.getAllaNamnOchIdByPlats(Integer.parseInt(Alien.getPlatsById(id)));
        
        //Skapar en tabellModell av klassen DefaultTableModel och sätter "rubriker" för kolumnerna.
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"Namn", "ID"}, 0);
        
        //Itererar igenom arrayListen allaRader och hämtar ut namn + alien_id
        for(HashMap<String, String> rad : allaRader) {
            String namn = rad.get("NAMN");
            String alien_id = rad.get("ALIEN_ID");
            //Sätter in namn + alien_id i tabellen mha addRow()
            tabellModell.addRow(new Object[]{ namn, alien_id });
        }
        
        //Säger att tblAlienLista ska använda sig av den modellen vi skapade ovan
        tblAlienLista.setModel(tabellModell);
        
        //Sätter defaultEditor till Object.class, null för att data i tabellen inte ska kunna redigeras, men kunna selekteras.
        tblAlienLista.setDefaultEditor(Object.class, null);
        
        //Stänger av möjligheten att ändra kolumnordningen.
        tblAlienLista.getTableHeader().setReorderingAllowed(false);
        
        //Sätter bredden på kolumnen som innehåller ID till 0px.
        //Vi vill inte att ID ska visas i listan men vill kunna använda IDt i metoden btnVisaMerActionPerformed()
        tblAlienLista.getColumnModel().getColumn(1).setMinWidth(0);
        tblAlienLista.getColumnModel().getColumn(1).setMaxWidth(0);
        tblAlienLista.getColumnModel().getColumn(1).setWidth(0);
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        btnVisaMer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlienLista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Visa aliens i mitt område");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnVisaMer.setText("Visa mer");
        btnVisaMer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVisaMer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaMerActionPerformed(evt);
            }
        });

        tblAlienLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAlienLista.setAutoscrolls(false);
        tblAlienLista.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblAlienLista);
        tblAlienLista.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("Välj en alien i listan nedan och klicka på \"Visa mer\"");

        jLabel2.setText("för att se mer information om en enskild alien.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVisaMer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGoBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGoBack)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVisaMer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisaMerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMerActionPerformed
        //Om ingen rad är vald, visa ett felmeddelande.
        if(tblAlienLista.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Du har inte valt någon alien i listan. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
        } else {
            //Hämtar ID från den raden som är selekterad i tabellen.
            int selectedAlienId = Integer.parseInt(tblAlienLista.getValueAt(tblAlienLista.getSelectedRow(), 1).toString());
            //Instansiera nytt OmradeVisaChef() med den valda radens ID som parameter och stäng fönstret.
            new OmradeListaAliensVisaMer(id, selectedAlienId).setVisible(true);
            //Stäng det nuvarande fönstret.
            dispose();
        }
    }//GEN-LAST:event_btnVisaMerActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppna ett nytt fönster av klassen MenyOmrade() när man trycker på Gå tillbaka-knappen.
        new MenyOmrade(id).setVisible(true);
        //Stäng och släng det nuvarande fönstret.
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnVisaMer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlienLista;
    // End of variables declaration//GEN-END:variables
}
