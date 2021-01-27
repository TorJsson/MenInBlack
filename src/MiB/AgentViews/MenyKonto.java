package MiB.AgentViews;

import MiB.Agent;
import java.util.HashMap;

public class MenyKonto extends javax.swing.JFrame {
    private static int id;
    
    public MenyKonto(int id) {
        initComponents();
        this.id = id;
        uppdateraSida();   
    }

    private void uppdateraSida() {
        HashMap<String, String> allData = Agent.getAgentDataById(id);
        
        //Itererar igenom resultaten
        String namn = allData.get("NAMN");
        String omrade = allData.get("BENAMNING");
        String telefon = allData.get("TELEFON");
        String anstDatum = allData.get("ANSTALLNINGSDATUM");
        String admin = allData.get("ADMINISTRATOR");

        //Ändra text på labels
        lblOmrade.setText(omrade);
        lblAgentNamn.setText(namn);
        lblAgentTelefon.setText(telefon);
        lblAnstallningsdatum.setText(anstDatum);

        if(admin.equals("J")) {
            admin = "Ja";
        } else {
            admin = "Nej";
        }

        lblAdministrator.setText(admin);
            
        String agentFaltAgent = "Nej";
        String agentOmradesChef = "Nej";
        String agentKontorsChef = "Nej";
        
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

        btnGoBack = new javax.swing.JButton();
        pnlData = new javax.swing.JPanel();
        lblAdministrator = new javax.swing.JLabel();
        lblAdministratorRubrik = new javax.swing.JLabel();
        lblFaltAgentRubrik = new javax.swing.JLabel();
        lblFaltAgent = new javax.swing.JLabel();
        lblAnstallningsdatum = new javax.swing.JLabel();
        lblAnstallningsdatumRubrik = new javax.swing.JLabel();
        lblAgentTelefonRubrik = new javax.swing.JLabel();
        lblAgentTelefon = new javax.swing.JLabel();
        lblAgentNamn = new javax.swing.JLabel();
        lblAgentNamnRubrik = new javax.swing.JLabel();
        lblOmradeRubrik = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblOmradesChefRubrik = new javax.swing.JLabel();
        lblOmradesChef = new javax.swing.JLabel();
        lblKontorsChefRubrik = new javax.swing.JLabel();
        lblKontorsChef = new javax.swing.JLabel();
        btnOpenBytLosenord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblAdministrator.setText("$agentAdmin");

        lblAdministratorRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAdministratorRubrik.setText("Administratör:");

        lblFaltAgentRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFaltAgentRubrik.setText("Fältagent:");

        lblFaltAgent.setText("$faltAgent");

        lblAnstallningsdatum.setText("$agentAnstDatum");

        lblAnstallningsdatumRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnstallningsdatumRubrik.setText("Anställningsdatum:");

        lblAgentTelefonRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAgentTelefonRubrik.setText("Telefon:");

        lblAgentTelefon.setText("$agentTelefon");

        lblAgentNamn.setText("$agentNamn");

        lblAgentNamnRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAgentNamnRubrik.setText("Agent:");

        lblOmradeRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeRubrik.setText("Område:");

        lblOmrade.setText("$område");

        lblOmradesChefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradesChefRubrik.setText("Områdeschef:");

        lblOmradesChef.setText("$omradesChef");

        lblKontorsChefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblKontorsChefRubrik.setText("Kontorschef:");

        lblKontorsChef.setText("$kontorsChef");

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgentTelefonRubrik)
                    .addComponent(lblOmradeRubrik)
                    .addComponent(lblAgentNamnRubrik))
                .addGap(71, 71, 71)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgentTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOmrade))
                        .addGap(0, 27, Short.MAX_VALUE))))
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnstallningsdatumRubrik)
                    .addComponent(lblFaltAgentRubrik)
                    .addComponent(lblOmradesChefRubrik)
                    .addComponent(lblKontorsChefRubrik)
                    .addComponent(lblAdministratorRubrik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKontorsChef)
                    .addComponent(lblOmradesChef)
                    .addComponent(lblFaltAgent)
                    .addComponent(lblAnstallningsdatum)
                    .addComponent(lblAdministrator))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradeRubrik)
                    .addComponent(lblOmrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgentNamnRubrik)
                    .addComponent(lblAgentNamn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgentTelefonRubrik)
                    .addComponent(lblAgentTelefon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnstallningsdatumRubrik)
                    .addComponent(lblAnstallningsdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFaltAgentRubrik)
                    .addComponent(lblFaltAgent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradesChefRubrik)
                    .addComponent(lblOmradesChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontorsChefRubrik)
                    .addComponent(lblKontorsChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdministratorRubrik)
                    .addComponent(lblAdministrator))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        btnOpenBytLosenord.setText("Byt lösenord");
        btnOpenBytLosenord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnOpenBytLosenord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpenBytLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenBytLosenordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnOpenBytLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 149, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addContainerGap(470, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnOpenBytLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenBytLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenBytLosenordActionPerformed
        new KontoBytLosenord(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOpenBytLosenordActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
       new AgentStart(id).setVisible(true);
       dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnOpenBytLosenord;
    private javax.swing.JLabel lblAdministrator;
    private javax.swing.JLabel lblAdministratorRubrik;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JLabel lblAgentNamnRubrik;
    private javax.swing.JLabel lblAgentTelefon;
    private javax.swing.JLabel lblAgentTelefonRubrik;
    private javax.swing.JLabel lblAnstallningsdatum;
    private javax.swing.JLabel lblAnstallningsdatumRubrik;
    private javax.swing.JLabel lblFaltAgent;
    private javax.swing.JLabel lblFaltAgentRubrik;
    private javax.swing.JLabel lblKontorsChef;
    private javax.swing.JLabel lblKontorsChefRubrik;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblOmradeRubrik;
    private javax.swing.JLabel lblOmradesChef;
    private javax.swing.JLabel lblOmradesChefRubrik;
    private javax.swing.JPanel pnlData;
    // End of variables declaration//GEN-END:variables
}
