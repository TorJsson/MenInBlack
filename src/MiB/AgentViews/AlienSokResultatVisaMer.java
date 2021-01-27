package MiB.AgentViews;

import MiB.Agent;
import MiB.Alien;
import MiB.Omrade;
import MiB.Plats;
import java.util.ArrayList;
import java.util.HashMap;

public class AlienSokResultatVisaMer extends javax.swing.JFrame {
    private static int id;
    private static int typAvSokning;
    private static int valdAlien;
    private static int soktPlats;
    private static String soktNamn;
    private static String soktRas;
    private static String soktStartDatum;
    private static String soktSlutDatum;
    
    
    public AlienSokResultatVisaMer(int id, int typAvSokning, int valdAlien, int soktPlats, String soktNamn, String soktRas, String soktStartDatum, String soktSlutDatum  ) {
        initComponents();
        this.id = id;
        this.typAvSokning = typAvSokning;
        this.valdAlien = valdAlien;
        this.soktPlats = soktPlats;
        this.soktNamn = soktNamn;
        this.soktRas = soktRas;
        this.soktStartDatum = soktStartDatum;
        this.soktSlutDatum = soktSlutDatum;
        uppdateraSida();
        
    }
    
    //Metod som hämtar data och uppdaterar sidan med aliens information
    public void uppdateraSida() {
        ArrayList<HashMap<String, String>> allData = Alien.getAllaById(valdAlien);
            //Itererar igenom resultaten
            for(HashMap<String, String> rad : allData) {
                String alienNamn = rad.get("NAMN");
                String agentNamn = Agent.getNamnById(Integer.parseInt(rad.get("ANSVARIG_AGENT")));//FetchRow returnerar bara ett fält med kolumnnamnet "NAMN" 
                                                                                                  //(vilket gör att agent- "slår ut" alien-namn) 
                                                                                                  //- är det här en ok lösning? Samma gäller för "BENÄMNING" på plats resp. område.
                String alienId = rad.get("ALIEN_ID");
                String plats = rad.get("BENAMNING");
                String omrade = Omrade.getBenamningById(Plats.getFinnsIById(Integer.parseInt(rad.get("PLATS_ID"))));
                String registreringsdatum = rad.get("REGISTRERINGSDATUM");
                String telefonnummer = rad.get("TELEFON");
                String ras = Alien.getRas(Integer.parseInt(rad.get("ALIEN_ID")));
                //Fyll i fält
                lblNamn.setText(alienNamn);
                lblId.setText(alienId);
                lblOmrade.setText(plats + ", " + omrade);
                lblOmradesChef.setText(Agent.getNamnById(Omrade.getOmradesChefById(Plats.getFinnsIById(Integer.parseInt(rad.get("PLATS_ID"))))));
                lblRegistreringsdatum.setText(registreringsdatum);
                lblTelefonnummer.setText(telefonnummer);
                lblRas.setText(ras);
                
                //Fyll bara fälten lblRasInfoRubrik och lblRasInfo om alien är boglodite eller squid.
                if(ras.equals("Boglodite") || ras.equals("Squid")) {
                   String rasAttribut = Alien.getRasAttribut(ras);
                   int rasAttributData = Alien.getRasAttributData(ras, Integer.parseInt(rad.get("ALIEN_ID")));
                   lblRasInfoRubrik.setText(rasAttribut + ":");
                   lblRasInfo.setText(Integer.toString(rasAttributData));
                } else {
                    //Om alien är av en annan ras så döljs fälten
                    lblRasInfoRubrik.setText("");
                    lblRasInfo.setText("");
                }

                lblAnsvarigAgent.setText(agentNamn);
            }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNySokning = new javax.swing.JButton();
        lblNamnRubrik = new javax.swing.JLabel();
        lblRasInfo = new javax.swing.JLabel();
        lblRasInfoRubrik = new javax.swing.JLabel();
        lblRasRubrik = new javax.swing.JLabel();
        lblRas = new javax.swing.JLabel();
        lblRegistreringsdatum = new javax.swing.JLabel();
        lblRegistreringsdatumRubrik = new javax.swing.JLabel();
        lblOmradeRubrik = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblTelefonnummer = new javax.swing.JLabel();
        lblTelefonnummerRubrik = new javax.swing.JLabel();
        lblIdRubrik = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblAnsvarigAgentRubrik = new javax.swing.JLabel();
        lblAnsvarigAgent = new javax.swing.JLabel();
        lblOmradesChefRubrik = new javax.swing.JLabel();
        lblOmradesChef = new javax.swing.JLabel();
        btnRedigeraAlien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Sökresultat - Visa mer");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnNySokning.setText("Ny sökning");
        btnNySokning.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNySokning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNySokningActionPerformed(evt);
            }
        });

        lblNamnRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNamnRubrik.setText("Namn:");

        lblRasInfo.setText("$rasInfo");

        lblRasInfoRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasInfoRubrik.setText("$rasInfo");

        lblRasRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasRubrik.setText("Ras:");

        lblRas.setForeground(new java.awt.Color(51, 51, 51));
        lblRas.setText("$ras");

        lblRegistreringsdatum.setForeground(new java.awt.Color(51, 51, 51));
        lblRegistreringsdatum.setText("$regdatum");

        lblRegistreringsdatumRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistreringsdatumRubrik.setText("Registreringsdatum:");

        lblOmradeRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeRubrik.setText("Plats:");

        lblOmrade.setForeground(new java.awt.Color(51, 51, 51));
        lblOmrade.setText("$plats, $område");

        lblTelefonnummer.setForeground(new java.awt.Color(51, 51, 51));
        lblTelefonnummer.setText("$telefonnummer");

        lblTelefonnummerRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefonnummerRubrik.setText("Telefonnummer:");

        lblIdRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdRubrik.setText("ID:");

        lblId.setForeground(new java.awt.Color(51, 51, 51));
        lblId.setText("$id");

        lblNamn.setText("$alienNamn");

        lblAnsvarigAgentRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnsvarigAgentRubrik.setText("Ansvarig agent:");

        lblAnsvarigAgent.setText("$agentNamn");

        lblOmradesChefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradesChefRubrik.setText("Områdeschef:");

        lblOmradesChef.setText("$omradesChefAgentNamn");

        btnRedigeraAlien.setText("Redigera");
        btnRedigeraAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraAlienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdRubrik)
                            .addComponent(lblTelefonnummerRubrik)
                            .addComponent(lblOmradeRubrik)
                            .addComponent(lblNamnRubrik))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamn)
                            .addComponent(lblOmrade)
                            .addComponent(lblTelefonnummer)
                            .addComponent(lblId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(btnNySokning, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblRegistreringsdatumRubrik)
                                        .addComponent(lblRasRubrik)
                                        .addComponent(lblRasInfoRubrik))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblRasInfo)
                                        .addComponent(lblRas)
                                        .addComponent(lblRegistreringsdatum)
                                        .addComponent(lblAnsvarigAgent)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAnsvarigAgentRubrik)
                                    .addGap(106, 106, 106)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOmradesChefRubrik)
                                .addGap(57, 57, 57)
                                .addComponent(lblOmradesChef))
                            .addComponent(btnRedigeraAlien))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamnRubrik)
                            .addComponent(lblNamn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdRubrik)
                            .addComponent(lblId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefonnummerRubrik)
                            .addComponent(lblTelefonnummer))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOmradeRubrik)
                            .addComponent(lblOmrade)))
                    .addComponent(btnNySokning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradesChefRubrik)
                    .addComponent(lblOmradesChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistreringsdatumRubrik)
                    .addComponent(lblRegistreringsdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRasRubrik)
                    .addComponent(lblRas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRasInfoRubrik)
                    .addComponent(lblRasInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnsvarigAgentRubrik)
                    .addComponent(lblAnsvarigAgent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRedigeraAlien)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs om man klickar på Ny sökning
    private void btnNySokningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNySokningActionPerformed
        //Kontrollerar värdet på variabeln typAvSokning och öppnar rätt sökfönster beroende på värdet. Stänger nuvarande fönstret
        if(typAvSokning == 1) { //plats
            new AlienSokPlats(id).setVisible(true);
            dispose();
        } else if(typAvSokning == 2) { //ras
            new AlienSokRas(id).setVisible(true);
            dispose();
        } else if(typAvSokning == 3) { //namn
            new AlienSokNamn(id).setVisible(true);
            dispose();
        } else if(typAvSokning == 4) { //datum
            new AlienSokDatum(id).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnNySokningActionPerformed

    //Metod som körs om man klickar på redigera-knappen
    private void btnRedigeraAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraAlienActionPerformed
        new AlienRedigera(id, typAvSokning, valdAlien).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRedigeraAlienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNySokning;
    private javax.swing.JButton btnRedigeraAlien;
    private javax.swing.JLabel lblAnsvarigAgent;
    private javax.swing.JLabel lblAnsvarigAgentRubrik;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdRubrik;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblNamnRubrik;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblOmradeRubrik;
    private javax.swing.JLabel lblOmradesChef;
    private javax.swing.JLabel lblOmradesChefRubrik;
    private javax.swing.JLabel lblRas;
    private javax.swing.JLabel lblRasInfo;
    private javax.swing.JLabel lblRasInfoRubrik;
    private javax.swing.JLabel lblRasRubrik;
    private javax.swing.JLabel lblRegistreringsdatum;
    private javax.swing.JLabel lblRegistreringsdatumRubrik;
    private javax.swing.JLabel lblTelefonnummer;
    private javax.swing.JLabel lblTelefonnummerRubrik;
    // End of variables declaration//GEN-END:variables
}
