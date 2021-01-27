package MiB.AlienViews;

import MiB.Alien;
import MiB.Omrade;
import MiB.Agent;
import MiB.Plats;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

public class OmradeVisaChef extends javax.swing.JFrame {
    private static int alienId;
    private static int alienPlatsId;
    private static int alienOmradeId;
    private static String alienPlats;
    private static String alienOmrade;
    private static int agentId;
    private static String agentNamn;
    private static String agentTelefon;
    private static String agentAnstDatum;
    private static String agentFaltAgent;
    private static String agentOmradesChef;
    private static String agentKontorsChef;
    private static String agentAdmin;
    
    public OmradeVisaChef(int alienId) {
        initComponents();
        this.alienId = alienId;
        uppdateraSida();

    }
    private void uppdateraSida() {
        //Hämta från databas
        alienPlatsId = Integer.parseInt(Alien.getPlatsById(alienId));
        alienOmradeId = Plats.getFinnsIById(alienPlatsId);
        alienPlats = Plats.getBenamningById(alienPlatsId);
        alienOmrade = Omrade.getBenamningById(alienOmradeId);
        agentId = Omrade.getOmradesChefById(alienOmradeId);
        agentNamn = Agent.getNamnById(agentId);
        agentTelefon = Agent.getTelefonnummerById(agentId);
        agentAnstDatum = Agent.getAnstallningsdatumById(agentId);

                
        agentFaltAgent = "Nej";
        agentOmradesChef = "Nej";
        agentKontorsChef = "Nej";
        
        //Kontrollerar om agenten är fältagent/områdeschef/kontorschef
        if(Agent.getIsKontorsChef(agentId)) {
            agentKontorsChef = "Ja";
        }
        
        if (Agent.getIsOmradesChef(agentId)) {
            agentOmradesChef = "Ja";
        } 
        
        if (Agent.getIsFaltAgent(agentId)){
            agentFaltAgent = "Ja";
        }

        lblFaltAgent.setText(agentFaltAgent);
        lblOmradesChef.setText(agentOmradesChef);
        lblKontorsChef.setText(agentKontorsChef);
    
        //Kontrollerar om agenten är administratör
        if(Agent.getAdminStatusById(agentId)) {
            agentAdmin = "Ja";
        } else {
            agentAdmin = "Nej";
        }
        
        //Ändra text på labels
        lblOmrade.setText(alienPlats + ", " + alienOmrade);
        lblAnsvarigAgent.setText(agentNamn);
        lblAgentTelefon.setText(agentTelefon);
        lblAnstallningsdatum.setText(agentAnstDatum);
        lblAdministrator.setText(agentAdmin);
        
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblAnsvarigAgent = new javax.swing.JLabel();
        lblAgentTelefonRubrik = new javax.swing.JLabel();
        lblOmradeRubrik = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblAnsvarigAgentRubrik = new javax.swing.JLabel();
        lblAgentTelefon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblAnstallningsdatum = new javax.swing.JLabel();
        lblFaltAgentRubrik = new javax.swing.JLabel();
        lblFaltAgent = new javax.swing.JLabel();
        lblOmradesChefRubrik = new javax.swing.JLabel();
        lblOmradesChef = new javax.swing.JLabel();
        lblKontorsChefRubrik = new javax.swing.JLabel();
        lblKontorsChef = new javax.swing.JLabel();
        lblAdministratorRubrik = new javax.swing.JLabel();
        lblAdministrator = new javax.swing.JLabel();
        lblKlickbarSkickaMail = new javax.swing.JLabel();
        btnVisaUtrustning = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Visa områdeschef");
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

        lblAnsvarigAgent.setText("$agentNamn");

        lblAgentTelefonRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAgentTelefonRubrik.setText("Telefon:");

        lblOmradeRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeRubrik.setText("Område:");

        lblOmrade.setText("$område");

        lblAnsvarigAgentRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnsvarigAgentRubrik.setText("Agent:");

        lblAgentTelefon.setText("$agentTelefon");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Anställningsdatum:");

        lblAnstallningsdatum.setText("$agentAnstDatum");

        lblFaltAgentRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFaltAgentRubrik.setText("Fältagent:");

        lblFaltAgent.setText("$agentFaltAgent");

        lblOmradesChefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradesChefRubrik.setText("Områdeschef:");

        lblOmradesChef.setText("$agentOmradesChef");

        lblKontorsChefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblKontorsChefRubrik.setText("Kontorschef:");

        lblKontorsChef.setText("$agentKontorsChef");

        lblAdministratorRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAdministratorRubrik.setText("Administratör:");

        lblAdministrator.setText("$agentAdmin");

        lblKlickbarSkickaMail.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblKlickbarSkickaMail.setText("Klicka här för att skicka ett mail till agenten");
        lblKlickbarSkickaMail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKlickbarSkickaMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKlickbarSkickaMailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentTelefonRubrik)
                            .addComponent(lblOmradeRubrik)
                            .addComponent(lblAnsvarigAgentRubrik))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblOmrade))
                                .addGap(0, 23, Short.MAX_VALUE))))
                    .addComponent(lblKlickbarSkickaMail, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAnstallningsdatum))
                            .addComponent(lblKontorsChefRubrik)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFaltAgentRubrik)
                                    .addComponent(lblOmradesChefRubrik))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFaltAgent)
                                    .addComponent(lblOmradesChef)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAdministratorRubrik)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAdministrator)
                                    .addComponent(lblKontorsChef))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradeRubrik)
                    .addComponent(lblOmrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnsvarigAgentRubrik)
                    .addComponent(lblAnsvarigAgent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgentTelefonRubrik)
                    .addComponent(lblAgentTelefon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblAnstallningsdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFaltAgentRubrik)
                    .addComponent(lblFaltAgent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradesChefRubrik)
                    .addComponent(lblOmradesChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontorsChefRubrik)
                    .addComponent(lblKontorsChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdministratorRubrik)
                    .addComponent(lblAdministrator))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKlickbarSkickaMail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVisaUtrustning.setText("Utrustning");
        btnVisaUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaUtrustningActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisaUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisaUtrustning)
                        .addContainerGap(467, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs när man klickar på Gå tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar Områdes-menyn
        new MenyOmrade(alienId).setVisible(true);
        //Stänger det nuvarande fönstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som körs när man klickar på labeln "Skicka mail till agenten"
    private void lblKlickbarSkickaMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKlickbarSkickaMailMouseClicked
        try {
            //Skapar en sträng bestående av agentens namn där mellanslag/tomrum är utbytta till understreck. Omvandlar strängen till gemener.
            String namnTillMail = agentNamn.replace(" ", "_").toLowerCase();
            //Skapar ett objekt av klassen URI. Konkatenerar en sträng bestående av "mailto:" + strängen vi skapade ovan + "@mib.gov".
            URI mailadress = new URI("mailto:"+namnTillMail+"@mib.gov");
            //Anropar klassen Desktops metoder getDesktop().mail(). För att starta datorns standardprogram för epost.
            Desktop.getDesktop().mail(mailadress);            
        //Fångar fel
        } catch (URISyntaxException | IOException e) {
            //Visar felmeddelanden
             JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
             System.out.println("Felmeddelande: " + e.getMessage());
        }
        
    }//GEN-LAST:event_lblKlickbarSkickaMailMouseClicked

    //Metod som körs när man klickar på Utrustning
    private void btnVisaUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaUtrustningActionPerformed
       //Öppnar nytt fönster
        new OmradeVisaChefListaUtrustning(alienId, agentId).setVisible(true);
        //Stänger det nuvarande
        dispose();
    }//GEN-LAST:event_btnVisaUtrustningActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnVisaUtrustning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdministrator;
    private javax.swing.JLabel lblAdministratorRubrik;
    private javax.swing.JLabel lblAgentTelefon;
    private javax.swing.JLabel lblAgentTelefonRubrik;
    private javax.swing.JLabel lblAnstallningsdatum;
    private javax.swing.JLabel lblAnsvarigAgent;
    private javax.swing.JLabel lblAnsvarigAgentRubrik;
    private javax.swing.JLabel lblFaltAgent;
    private javax.swing.JLabel lblFaltAgentRubrik;
    private javax.swing.JLabel lblKlickbarSkickaMail;
    private javax.swing.JLabel lblKontorsChef;
    private javax.swing.JLabel lblKontorsChefRubrik;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblOmradeRubrik;
    private javax.swing.JLabel lblOmradesChef;
    private javax.swing.JLabel lblOmradesChefRubrik;
    // End of variables declaration//GEN-END:variables
}
