package MiB.AgentViews;

import MiB.Agent;
import MiB.Omrade;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgentAndraKontorsChef extends javax.swing.JFrame {
    private static int id;

    public AgentAndraKontorsChef(int id) {
        initComponents();
        this.id = id;
        hamtaKontorsbeteckningar();
        hamtaAgenter();
        
        //Dölj labels och comboboxar per default
        lblNuvarandeChef.setVisible(false);
        lblNuvarandeChefRubrik.setVisible(false);
        lblNyChefRubrik.setVisible(false);
        cbValjAgent.setVisible(false);
    }

    //Hämtar alla kontorsbeteckningar och lägger till dom i comboboxen. Om inga kontorsbeteckningar finns läggs "--- Inga tillgängliga---" till i comboboxen
    private void hamtaKontorsbeteckningar() {
        ArrayList<String> allaKontor = Agent.getAllaKontorsbeteckningar();
        
        if(allaKontor != null) {
            for(String kontor: allaKontor) {
                cbValjKontor.addItem(kontor);
            }
        } else {
            cbValjAgent.removeAllItems();
            cbValjAgent.addItem("--- Inga tillgängliga ---");
        }
    }
    
    //Metod för att hämta alla agentnamn tillhörande agenter som inte redan är kontorschefer över ett kontor och lägga till namnen i comboboxen. Om inga tillgängliga agenter finns läggs "--- Inga tillgängliga---" till i comboboxen
    private void hamtaAgenter() {
        ArrayList<String> agenter = Agent.listaAgenterUtanKontorsAnsvar();

        if(agenter != null) {
            for(String agent: agenter) {
                cbValjAgent.addItem(agent);
            }
        } else {
            cbValjAgent.removeAllItems();
            cbValjAgent.addItem("--- Inga tillgängliga ---");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        cbValjKontor = new javax.swing.JComboBox<>();
        lblNuvarandeChefRubrik = new javax.swing.JLabel();
        lblNuvarandeChef = new javax.swing.JLabel();
        lblNyChefRubrik = new javax.swing.JLabel();
        cbValjAgent = new javax.swing.JComboBox<>();
        btnSpara = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        cbValjKontor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj kontorsbeteckning ---" }));
        cbValjKontor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbValjKontorActionPerformed(evt);
            }
        });

        lblNuvarandeChefRubrik.setText("Nuvarande kontorschef:");

        lblNuvarandeChef.setText("agentNamn");

        lblNyChefRubrik.setText("Ny kontorschef:");

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
                    .addComponent(cbValjKontor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNuvarandeChefRubrik)
                            .addComponent(lblNyChefRubrik))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNuvarandeChef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbValjAgent, 0, 345, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbValjKontor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNuvarandeChefRubrik)
                    .addComponent(lblNuvarandeChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNyChefRubrik)
                    .addComponent(cbValjAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(btnSpara, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod för att återgå till agentmenyn och stänga det fönster som är öppet
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyAgent(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod för att spara ändringar
    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        //Kontrollerar att val är gjorda
        if(!cbValjKontor.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
            if(!cbValjKontor.getSelectedItem().toString().equals("--- Välj kontorsbeteckning ---")) {
                if(cbValjAgent.getSelectedItem().toString().equals("--- Välj agent ---")) {
                    JOptionPane.showMessageDialog(null, "Du har inte valt vilken agent som ska bli områdeschef");
                } else {
                    if(cbValjAgent.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
                        JOptionPane.showMessageDialog(null, "Det finns inga agenter som är tillgängliga för att bli områdeschefer");
                    } else {
                        String valtKontor = cbValjKontor.getSelectedItem().toString();
                        String valdNyAgentNamn = cbValjAgent.getSelectedItem().toString();
                        
                        //Försöker genomföra ändringen genom att anropa Agentklassens andraKontorsChef()-metod. Visar meddelande om uppdateringen är genomförd och återgår till 
                        //agentmenyn och stänger det nuvarande fönstret.
                        if(Agent.andraKontorsChef(valtKontor, valdNyAgentNamn)) {
                            JOptionPane.showMessageDialog(null, "Kontorschef har uppdaterats");
                            new MenyAgent(id).setVisible(true);
                            dispose();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du har inte valt något kontor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Det finns inga registrerade kontor");
        }
    }//GEN-LAST:event_btnSparaActionPerformed
    
    //Metod som körs när ett val görs i comboboxen för att välja kontor
    private void cbValjKontorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbValjKontorActionPerformed
        //Kontrollerar om kontor är valt
        if(!cbValjKontor.getSelectedItem().toString().equals("--- Välj område ---")) {
            if(!cbValjKontor.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
                //Visa labels och combobox om kontor är valt
                lblNuvarandeChef.setVisible(true);
                lblNuvarandeChefRubrik.setVisible(true);
                lblNyChefRubrik.setVisible(true);
                cbValjAgent.setVisible(true);
                
                //Hämtar det valda kontoret från comboboxen, omvandlar det till en sträng och instansierar strängen kontor
                String kontor = cbValjKontor.getSelectedItem().toString();
                
                //Tolkar strängen och hämtar agentId för kontorschefen utifrån kontorsnamnet
                int kontorsChefId = Integer.parseInt(Agent.getKontorsChefIdByBenamning(kontor));
                
                //Om kontoret inte har någon registrerad kontorschef (av okänd anledning, bör inte hända), sätts labeln lblNuvarandeChef till "Okänt".
                if(kontorsChefId == 0) {
                    lblNuvarandeChef.setText("Okänt");
                //I annat fall sätta labeln lblNuvarandeChef till agentens namn
                } else {
                    //Hämtar kontorschefens namn utifrån agentens id
                    String kontorsChefNamn = Agent.getNamnById(kontorsChefId);
                    lblNuvarandeChef.setText(kontorsChefNamn);
                }
            } else {
                //Om inget kontor är valt så döljs fälten
                lblNuvarandeChef.setVisible(false);
                lblNuvarandeChefRubrik.setVisible(false);
                lblNyChefRubrik.setVisible(false);
                cbValjAgent.setVisible(false);
            }
        } else {
            //Dölj labels och combobox
            lblNuvarandeChef.setVisible(false);
            lblNuvarandeChefRubrik.setVisible(false);
            lblNyChefRubrik.setVisible(false);
            cbValjAgent.setVisible(false);
        }
    }//GEN-LAST:event_cbValjKontorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox<String> cbValjAgent;
    private javax.swing.JComboBox<String> cbValjKontor;
    private javax.swing.JLabel lblNuvarandeChef;
    private javax.swing.JLabel lblNuvarandeChefRubrik;
    private javax.swing.JLabel lblNyChefRubrik;
    // End of variables declaration//GEN-END:variables

}
