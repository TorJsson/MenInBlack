package MiB.AgentViews;

import MiB.Agent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class AlienSokPlatsVisaOmradesChef extends javax.swing.JFrame {
    private static int id;
    private static int platsId;
    private static int omradesId;
    private static int omradesChefId;
    private static String omradesNamn;
    private static String agentNamn;
    private static String agentTelefon;
    private static String anstallningsDatum;
    private static String agentFaltAgent;
    private static String agentOmradesChef;
    private static String agentKontorsChef;
    private static String agentAdmin;
    
    public AlienSokPlatsVisaOmradesChef(int id, int platsId, int omradesId, int omradesChefId) {
        initComponents();
        this.id = id;
        this.platsId = platsId;
        this.omradesId = omradesId;
        this.omradesChefId = omradesChefId;
        
        uppdateraSida();
    }
    
    //Metod som hämtar data om områdeschefen och uppdaterar sidans labels
    private void uppdateraSida() {
        HashMap<String, String> allData = Agent.getAgentDataById(omradesChefId);
        
        //Instansierar variabler med värden från den, ovan hämtade, hashmapen
        agentNamn = allData.get("NAMN");
        agentTelefon = allData.get("TELEFON");
        anstallningsDatum = allData.get("ANSTALLNINGSDATUM");
        agentAdmin = allData.get("ADMINISTRATOR");
        omradesNamn = allData.get("BENAMNING");

      
        //Ändra text på labels
        lblOmrade.setText(omradesNamn);
        lblAnsvarigAgent.setText(agentNamn);
        lblAgentTelefon.setText(agentTelefon);
        lblAnstallningsdatum.setText(anstallningsDatum);

        //Kontrollerar om agentAdmin består av "J" eller "N". Ändrar värdet till "Ja" eller "Nej".
        if(agentAdmin.equals("J")) {
            agentAdmin = "Ja";
        } else {
            agentAdmin = "Nej";
        }
        
        lblAdministrator.setText(agentAdmin);
        
        agentFaltAgent = "Nej";
        agentOmradesChef = "Nej";
        agentKontorsChef = "Nej";
        
        //Kontrollerar om agenten är fältagent/områdeschef/kontorschef
        if(Agent.getIsKontorsChef(id)) {
            agentKontorsChef = "Ja";
        }
        
        if (Agent.getIsOmradesChef(id)) {
            agentOmradesChef = "Ja";
        } 
        
        if (Agent.getIsFaltAgent(id)){
            agentFaltAgent = "Ja";
        }

        lblFaltAgent.setText(agentFaltAgent);
        lblOmradesChef.setText(agentOmradesChef);
        lblKontorsChef.setText(agentKontorsChef);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOmradeRubrik = new javax.swing.JLabel();
        lblAnsvarigAgentRubrik = new javax.swing.JLabel();
        lblAgentTelefonRubrik = new javax.swing.JLabel();
        lblAnstallningsdatumRubrik = new javax.swing.JLabel();
        lblFaltAgentRubrik = new javax.swing.JLabel();
        lblAdministratorRubrik = new javax.swing.JLabel();
        lblKlickbarSkickaMail = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblAnsvarigAgent = new javax.swing.JLabel();
        lblAgentTelefon = new javax.swing.JLabel();
        lblAnstallningsdatum = new javax.swing.JLabel();
        lblFaltAgent = new javax.swing.JLabel();
        lblAdministrator = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        lblOmradesChef = new javax.swing.JLabel();
        lblOmradesChefRubrik = new javax.swing.JLabel();
        lblKontorsChef = new javax.swing.JLabel();
        lblKontorsChefRubrik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblOmradeRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeRubrik.setText("Område:");

        lblAnsvarigAgentRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnsvarigAgentRubrik.setText("Agent:");

        lblAgentTelefonRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAgentTelefonRubrik.setText("Telefon:");

        lblAnstallningsdatumRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnstallningsdatumRubrik.setText("Anställningsdatum:");

        lblFaltAgentRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFaltAgentRubrik.setText("Fältagent:");

        lblAdministratorRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAdministratorRubrik.setText("Administratör:");

        lblKlickbarSkickaMail.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblKlickbarSkickaMail.setText("Klicka här för att skicka ett mail till agenten");
        lblKlickbarSkickaMail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKlickbarSkickaMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKlickbarSkickaMailMouseClicked(evt);
            }
        });

        lblOmrade.setText("$område");

        lblAnsvarigAgent.setText("$agentNamn");

        lblAgentTelefon.setText("$agentTelefon");

        lblAnstallningsdatum.setText("$agentAnstDatum");

        lblFaltAgent.setText("$agentFaltAgent");

        lblAdministrator.setText("$agentAdmin");

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblOmradesChef.setText("$agentOmradesChef");

        lblOmradesChefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradesChefRubrik.setText("Områdeschef:");

        lblKontorsChef.setText("$agentKontorsChef");

        lblKontorsChefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblKontorsChefRubrik.setText("Kontorschef:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAgentTelefonRubrik)
                                    .addComponent(lblOmradeRubrik)
                                    .addComponent(lblAnsvarigAgentRubrik))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAnsvarigAgent, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(lblOmrade)
                                    .addComponent(lblAgentTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAnstallningsdatumRubrik)
                                    .addComponent(lblFaltAgentRubrik))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFaltAgent)
                                    .addComponent(lblAnstallningsdatum)
                                    .addComponent(lblOmradesChef))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKlickbarSkickaMail, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAdministratorRubrik)
                                .addGap(37, 37, 37)
                                .addComponent(lblAdministrator))
                            .addComponent(lblOmradesChefRubrik)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(lblKontorsChef))
                            .addComponent(lblKontorsChefRubrik))
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
                            .addComponent(lblOmradeRubrik)
                            .addComponent(lblOmrade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnsvarigAgentRubrik)
                            .addComponent(lblAnsvarigAgent)))
                    .addComponent(btnGoBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgentTelefonRubrik)
                    .addComponent(lblAgentTelefon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnstallningsdatumRubrik)
                    .addComponent(lblAnstallningsdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFaltAgentRubrik)
                    .addComponent(lblFaltAgent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradesChefRubrik)
                    .addComponent(lblOmradesChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontorsChefRubrik)
                    .addComponent(lblKontorsChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdministratorRubrik)
                    .addComponent(lblAdministrator))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKlickbarSkickaMail)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs när man klickar på labeln "Skicka mail till agenten"
    private void lblKlickbarSkickaMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKlickbarSkickaMailMouseClicked
        try {
            //Instansierar en sträng som representerar agentens mailadress (agentens namn, ersätter mellanslag/tomrum med understreck och omvandlar till gemener)
            String namnTillMail = agentNamn.replace(" ", "_").toLowerCase();
            //Skapar ett nytt objekt av klassen URI. Konkatenerar en sträng för att innehålla "mailto:" + ovan skapade sträng + "@mib.gov".
            URI mailadress = new URI("mailto:"+namnTillMail+"@mib.gov");
            //Använder klassen Desktops metoder getDesktop().mail() för att öppna datorns valda standardprogram för epost.
            Desktop.getDesktop().mail(mailadress);
        //Fångar möjliga exceptions
        } catch (URISyntaxException | IOException e) {
            //Skriver ut felmeddelanden
            JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.", "Ett fel har uppstått", JOptionPane.ERROR_MESSAGE);
            System.out.println("Felmeddelande: " + e.getMessage());
        }

    }//GEN-LAST:event_lblKlickbarSkickaMailMouseClicked

    //Metod som körs när man klickar på Gå tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar nytt sök efter plats resultat-fönster
        new AlienSokPlatsResultat(id, platsId).setVisible(true);
        //Stänger det nuvarande
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel lblAdministrator;
    private javax.swing.JLabel lblAdministratorRubrik;
    private javax.swing.JLabel lblAgentTelefon;
    private javax.swing.JLabel lblAgentTelefonRubrik;
    private javax.swing.JLabel lblAnstallningsdatum;
    private javax.swing.JLabel lblAnstallningsdatumRubrik;
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
