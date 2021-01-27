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
        
        //D�lj labels och comboboxar per default
        lblNuvarandeChef.setVisible(false);
        lblNuvarandeChefRubrik.setVisible(false);
        lblNyChefRubrik.setVisible(false);
        cbValjAgent.setVisible(false);
    }

    //H�mtar alla kontorsbeteckningar och l�gger till dom i comboboxen. Om inga kontorsbeteckningar finns l�ggs "--- Inga tillg�ngliga---" till i comboboxen
    private void hamtaKontorsbeteckningar() {
        ArrayList<String> allaKontor = Agent.getAllaKontorsbeteckningar();
        
        if(allaKontor != null) {
            for(String kontor: allaKontor) {
                cbValjKontor.addItem(kontor);
            }
        } else {
            cbValjAgent.removeAllItems();
            cbValjAgent.addItem("--- Inga tillg�ngliga ---");
        }
    }
    
    //Metod f�r att h�mta alla agentnamn tillh�rande agenter som inte redan �r kontorschefer �ver ett kontor och l�gga till namnen i comboboxen. Om inga tillg�ngliga agenter finns l�ggs "--- Inga tillg�ngliga---" till i comboboxen
    private void hamtaAgenter() {
        ArrayList<String> agenter = Agent.listaAgenterUtanKontorsAnsvar();

        if(agenter != null) {
            for(String agent: agenter) {
                cbValjAgent.addItem(agent);
            }
        } else {
            cbValjAgent.removeAllItems();
            cbValjAgent.addItem("--- Inga tillg�ngliga ---");
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

        btnGoBack.setText("G� tillbaka");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        cbValjKontor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj kontorsbeteckning ---" }));
        cbValjKontor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbValjKontorActionPerformed(evt);
            }
        });

        lblNuvarandeChefRubrik.setText("Nuvarande kontorschef:");

        lblNuvarandeChef.setText("agentNamn");

        lblNyChefRubrik.setText("Ny kontorschef:");

        cbValjAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj agent ---" }));

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

    //Metod f�r att �terg� till agentmenyn och st�nga det f�nster som �r �ppet
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyAgent(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod f�r att spara �ndringar
    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        //Kontrollerar att val �r gjorda
        if(!cbValjKontor.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
            if(!cbValjKontor.getSelectedItem().toString().equals("--- V�lj kontorsbeteckning ---")) {
                if(cbValjAgent.getSelectedItem().toString().equals("--- V�lj agent ---")) {
                    JOptionPane.showMessageDialog(null, "Du har inte valt vilken agent som ska bli omr�deschef");
                } else {
                    if(cbValjAgent.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
                        JOptionPane.showMessageDialog(null, "Det finns inga agenter som �r tillg�ngliga f�r att bli omr�deschefer");
                    } else {
                        String valtKontor = cbValjKontor.getSelectedItem().toString();
                        String valdNyAgentNamn = cbValjAgent.getSelectedItem().toString();
                        
                        //F�rs�ker genomf�ra �ndringen genom att anropa Agentklassens andraKontorsChef()-metod. Visar meddelande om uppdateringen �r genomf�rd och �terg�r till 
                        //agentmenyn och st�nger det nuvarande f�nstret.
                        if(Agent.andraKontorsChef(valtKontor, valdNyAgentNamn)) {
                            JOptionPane.showMessageDialog(null, "Kontorschef har uppdaterats");
                            new MenyAgent(id).setVisible(true);
                            dispose();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du har inte valt n�got kontor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Det finns inga registrerade kontor");
        }
    }//GEN-LAST:event_btnSparaActionPerformed
    
    //Metod som k�rs n�r ett val g�rs i comboboxen f�r att v�lja kontor
    private void cbValjKontorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbValjKontorActionPerformed
        //Kontrollerar om kontor �r valt
        if(!cbValjKontor.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
            if(!cbValjKontor.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
                //Visa labels och combobox om kontor �r valt
                lblNuvarandeChef.setVisible(true);
                lblNuvarandeChefRubrik.setVisible(true);
                lblNyChefRubrik.setVisible(true);
                cbValjAgent.setVisible(true);
                
                //H�mtar det valda kontoret fr�n comboboxen, omvandlar det till en str�ng och instansierar str�ngen kontor
                String kontor = cbValjKontor.getSelectedItem().toString();
                
                //Tolkar str�ngen och h�mtar agentId f�r kontorschefen utifr�n kontorsnamnet
                int kontorsChefId = Integer.parseInt(Agent.getKontorsChefIdByBenamning(kontor));
                
                //Om kontoret inte har n�gon registrerad kontorschef (av ok�nd anledning, b�r inte h�nda), s�tts labeln lblNuvarandeChef till "Ok�nt".
                if(kontorsChefId == 0) {
                    lblNuvarandeChef.setText("Ok�nt");
                //I annat fall s�tta labeln lblNuvarandeChef till agentens namn
                } else {
                    //H�mtar kontorschefens namn utifr�n agentens id
                    String kontorsChefNamn = Agent.getNamnById(kontorsChefId);
                    lblNuvarandeChef.setText(kontorsChefNamn);
                }
            } else {
                //Om inget kontor �r valt s� d�ljs f�lten
                lblNuvarandeChef.setVisible(false);
                lblNuvarandeChefRubrik.setVisible(false);
                lblNyChefRubrik.setVisible(false);
                cbValjAgent.setVisible(false);
            }
        } else {
            //D�lj labels och combobox
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
