package MiB.AgentViews;

import MiB.Agent;
import MiB.Omrade;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgentAndraOmradesChef extends javax.swing.JFrame {
    private static int id;
    public AgentAndraOmradesChef(int id) {
        initComponents();
        this.id = id;
        hamtaOmraden();
        hamtaAgenter();
        
        //Dölj labels och combobox per default
        lblNuvarandeOmradesChef.setVisible(false);
        lblNuvarandeOmradesChefRubrik.setVisible(false);
        lblNyOmradesChefRubrik.setVisible(false);
        cbValjAgent.setVisible(false);
        
        
    }
    
    //Metod som hämtar agentnamn för de agenter som inte är områdeschefer för något område
    private void hamtaAgenter() {
        ArrayList<String> agenter = Agent.listaAgenterUtanOmradesAnsvar();
        
        //Om arrayListen över agenter inte är tom...
        if(agenter != null) {
            //... så läggs namnen till i comboboxen
            for(String agent: agenter) {
                cbValjAgent.addItem(agent);
            }
        //Om arrayListen är tom...
        } else {
            //.. så tar removeAllItems() tar bort default-valet "--- Välj agent"---
            cbValjAgent.removeAllItems();
            
            //lägger till "--- Inga tillgängliga ---"
            cbValjAgent.addItem("--- Inga tillgängliga ---");
        }
    }
    
    //Metod som hämtar alla områdesbenämningar och sätter in de i comboboxen
    private void hamtaOmraden() {
        ArrayList<String> omraden = Omrade.getAllaOmradesBenamningar();
        //om ArrayListen över områden inte är tom...
        if(omraden != null) {
            //så läggs områdesbenämningarna till i comboboxen
            for(String omrade: omraden) {
               cbValjOmrade.addItem(omrade);
            }
        //om arraylisten är tom...
        } else {
            //.. så tar removeAllItems() tar bort default-valet "--- Välj område"---
            cbValjAgent.removeAllItems();
            
            //och lägger till "--- Inga tillgängliga ---"
            cbValjAgent.addItem("--- Inga tillgängliga ---");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        cbValjOmrade = new javax.swing.JComboBox<>();
        lblNuvarandeOmradesChefRubrik = new javax.swing.JLabel();
        lblNuvarandeOmradesChef = new javax.swing.JLabel();
        lblNyOmradesChefRubrik = new javax.swing.JLabel();
        cbValjAgent = new javax.swing.JComboBox<>();
        btnSpara = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        cbValjOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj område ---" }));
        cbValjOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbValjOmradeActionPerformed(evt);
            }
        });

        lblNuvarandeOmradesChefRubrik.setText("Nuvarande områdeschef:");

        lblNuvarandeOmradesChef.setText("agentNamn");

        lblNyOmradesChefRubrik.setText("Ny områdeschef:");

        cbValjAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj agent ---" }));

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSpara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbValjOmrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNuvarandeOmradesChefRubrik)
                            .addComponent(lblNyOmradesChefRubrik))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNuvarandeOmradesChef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbValjAgent, 0, 290, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbValjOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNuvarandeOmradesChefRubrik)
                    .addComponent(lblNuvarandeOmradesChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNyOmradesChefRubrik)
                    .addComponent(cbValjAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                .addComponent(btnSpara, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        //Kontrollerar att val är gjorda
        if(!cbValjOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
            if(!cbValjOmrade.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
                if(cbValjAgent.getSelectedItem().toString().equals("--- Välj agent ---")) {
                    JOptionPane.showMessageDialog(null, "Du har inte valt vilken agent som ska bli områdeschef");
                } else {
                    //Om inga agenter som inte redan är områdeschefer finns så visas --- Inga tillgängliga --- och ändring är inte möjlig
                    if(cbValjAgent.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
                        JOptionPane.showMessageDialog(null, "Det finns inga agenter som är tillgängliga för att bli områdeschefer");
                    } else {
                        //Hämtar värden från combobox och omvandlar till sträng
                        String omradesNamn = cbValjOmrade.getSelectedItem().toString();
                        //Hämtar områdesId genom klassen Omrades metod getIdByBenamning() mha områdesbenämningen
                        int omradesId = Integer.parseInt(Omrade.getIdByBenamning(omradesNamn));
                        //Hämtar områdets nuvarande chefs agentId genom metoden getOmradesChefById() på områdetsId
                        int nuvarandeChef = Omrade.getOmradesChefById(omradesId);
                        //Hämtar valda agentens namn från comboboxen och omvandlar till sträng
                        String valdNyAgentNamn = cbValjAgent.getSelectedItem().toString();
                        
                        //Försöker genomföra ändringen
                        if(Agent.andraOmradesChef(nuvarandeChef, valdNyAgentNamn)) {
                            //Visar meddelande om ändringen är genomförd, återgår till agentmenyn och stänger det nuvarande fönstret
                            JOptionPane.showMessageDialog(null, "Områdeschef har uppdaterats");
                            new MenyAgent(id).setVisible(true);
                            dispose();
                        }
                    }
                }
            } else {
                //Visar felmeddelande om inga tillgängliga områden finns
                JOptionPane.showMessageDialog(null, "Det finns inga tillgängliga områden registrerade");
            }
        } else {
            //Visar felmeddelande om inget område är valt
            JOptionPane.showMessageDialog(null, "Du har inte valt något område");
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void cbValjOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbValjOmradeActionPerformed
        if(!cbValjOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
            //Visa labels och combobox
            lblNuvarandeOmradesChef.setVisible(true);
            lblNuvarandeOmradesChefRubrik.setVisible(true);
            lblNyOmradesChefRubrik.setVisible(true);
            cbValjAgent.setVisible(true);
            
            //Hämtar valda området från combobox och omvandlar till sträng
            String omradesNamn = cbValjOmrade.getSelectedItem().toString();
            //Hämtar områdesId, omvandlar till int och instansierar int
            int omradesId = Integer.parseInt(Omrade.getIdByBenamning(omradesNamn));
            //Hämtar områdets chefs agentId och lagrar som int
            int omradesChefId = Omrade.getOmradesChefById(omradesId);
            //Hämtar områdeschefens namn genom getNamnById() på områdeschefens agentId
            String omradesChefNamn = Agent.getNamnById(omradesChefId);
            //Kontroll att områdeschefens namn inte är null
            if(omradesChefNamn.equals("0")) {
                //Om namnet av någon mystisk anledning saknas så sätts namnet som "Okänt"
                lblNuvarandeOmradesChef.setText("Okänt");
            } else {
                //Annars sätts lblNuvarandeOmradesChef till områdeschefens namn
                lblNuvarandeOmradesChef.setText(omradesChefNamn);
            }
        //Om inget område är valt...
        } else {
            //så dölj labels och combobox
            lblNuvarandeOmradesChef.setVisible(false);
            lblNuvarandeOmradesChefRubrik.setVisible(false);
            lblNyOmradesChefRubrik.setVisible(false);
            cbValjAgent.setVisible(false);
        }
    }//GEN-LAST:event_cbValjOmradeActionPerformed

    //Metod för Gå tillbaka-knappen
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Öppnar agentmenyn och stänger nuvarande fönstret
        new MenyAgent(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox<String> cbValjAgent;
    private javax.swing.JComboBox<String> cbValjOmrade;
    private javax.swing.JLabel lblNuvarandeOmradesChef;
    private javax.swing.JLabel lblNuvarandeOmradesChefRubrik;
    private javax.swing.JLabel lblNyOmradesChefRubrik;
    // End of variables declaration//GEN-END:variables
}
