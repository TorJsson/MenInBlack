package MiB.AgentViews;

import MiB.Alien;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class AlienSokPlatsResultatVisaTopplista extends javax.swing.JFrame {
    private static int omradeId;
    private static int platsId;
    private static int id;
   

    public AlienSokPlatsResultatVisaTopplista(int id, int platsId, int omradeId) {
        initComponents();
        this.id = id;
        this.platsId = platsId;
        this.omradeId = omradeId;
        
        SkrivUtTopplista();

        
        
    }
        //Metod som hämtar data och uppdaterar tabellen med den hämtade datan
        private void SkrivUtTopplista() {
        ArrayList<HashMap<String, String>> allaAntal = Alien.hamtaTopplista(omradeId);

        //Skapar ett objekt av klassen DefaultTableModel och skickar in ett objekt bestående av kolumnnamnen som parameter i klassens konstruktor
        DefaultTableModel tabellModell = new DefaultTableModel(new Object[]{"Agent", "Antal"}, 0);

        //Kollar om ArrayListen med resultat innehåller data, annars skapas en tom rad i resultatlistan.
        if (allaAntal == null) {
            tabellModell.addRow(new Object[]{null, null, null, null});
        } else {
            //Itererar igenom resultaten
            for (HashMap<String, String> rad : allaAntal) {
                String ansAgent = rad.get("NAMN");
                String antal = rad.get("COUNT");
                tabellModell.addRow(new Object[]{ansAgent, antal});
                
                
            }
        }
        //Uppdaterar listan m.h.a. modellen vi skapat

        tblTopplista.setModel(tabellModell);

        //Inaktiverar redigering av tabellen genom att sätta defaultEditor till null
        tblTopplista.setDefaultEditor(Object.class, null);

        //Låser kolumnordningen
        tblTopplista.getTableHeader().setReorderingAllowed(false);

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTopplista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

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

        tblTopplista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTopplista);

        jLabel1.setText("Topp 3 antal aliens per agent i området");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs när man klickar på Gå tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar nytt fönster
        new AlienSokPlatsResultat(id, platsId).setVisible(true);
        //Stänger det nuvarande
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTopplista;
    // End of variables declaration//GEN-END:variables
}
