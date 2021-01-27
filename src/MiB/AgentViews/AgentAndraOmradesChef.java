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
        
        //D�lj labels och combobox per default
        lblNuvarandeOmradesChef.setVisible(false);
        lblNuvarandeOmradesChefRubrik.setVisible(false);
        lblNyOmradesChefRubrik.setVisible(false);
        cbValjAgent.setVisible(false);
        
        
    }
    
    //Metod som h�mtar agentnamn f�r de agenter som inte �r omr�deschefer f�r n�got omr�de
    private void hamtaAgenter() {
        ArrayList<String> agenter = Agent.listaAgenterUtanOmradesAnsvar();
        
        //Om arrayListen �ver agenter inte �r tom...
        if(agenter != null) {
            //... s� l�ggs namnen till i comboboxen
            for(String agent: agenter) {
                cbValjAgent.addItem(agent);
            }
        //Om arrayListen �r tom...
        } else {
            //.. s� tar removeAllItems() tar bort default-valet "--- V�lj agent"---
            cbValjAgent.removeAllItems();
            
            //l�gger till "--- Inga tillg�ngliga ---"
            cbValjAgent.addItem("--- Inga tillg�ngliga ---");
        }
    }
    
    //Metod som h�mtar alla omr�desben�mningar och s�tter in de i comboboxen
    private void hamtaOmraden() {
        ArrayList<String> omraden = Omrade.getAllaOmradesBenamningar();
        //om ArrayListen �ver omr�den inte �r tom...
        if(omraden != null) {
            //s� l�ggs omr�desben�mningarna till i comboboxen
            for(String omrade: omraden) {
               cbValjOmrade.addItem(omrade);
            }
        //om arraylisten �r tom...
        } else {
            //.. s� tar removeAllItems() tar bort default-valet "--- V�lj omr�de"---
            cbValjAgent.removeAllItems();
            
            //och l�gger till "--- Inga tillg�ngliga ---"
            cbValjAgent.addItem("--- Inga tillg�ngliga ---");
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

        btnGoBack.setText("G� tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        cbValjOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj omr�de ---" }));
        cbValjOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbValjOmradeActionPerformed(evt);
            }
        });

        lblNuvarandeOmradesChefRubrik.setText("Nuvarande omr�deschef:");

        lblNuvarandeOmradesChef.setText("agentNamn");

        lblNyOmradesChefRubrik.setText("Ny omr�deschef:");

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
        //Kontrollerar att val �r gjorda
        if(!cbValjOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
            if(!cbValjOmrade.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
                if(cbValjAgent.getSelectedItem().toString().equals("--- V�lj agent ---")) {
                    JOptionPane.showMessageDialog(null, "Du har inte valt vilken agent som ska bli omr�deschef");
                } else {
                    //Om inga agenter som inte redan �r omr�deschefer finns s� visas --- Inga tillg�ngliga --- och �ndring �r inte m�jlig
                    if(cbValjAgent.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
                        JOptionPane.showMessageDialog(null, "Det finns inga agenter som �r tillg�ngliga f�r att bli omr�deschefer");
                    } else {
                        //H�mtar v�rden fr�n combobox och omvandlar till str�ng
                        String omradesNamn = cbValjOmrade.getSelectedItem().toString();
                        //H�mtar omr�desId genom klassen Omrades metod getIdByBenamning() mha omr�desben�mningen
                        int omradesId = Integer.parseInt(Omrade.getIdByBenamning(omradesNamn));
                        //H�mtar omr�dets nuvarande chefs agentId genom metoden getOmradesChefById() p� omr�detsId
                        int nuvarandeChef = Omrade.getOmradesChefById(omradesId);
                        //H�mtar valda agentens namn fr�n comboboxen och omvandlar till str�ng
                        String valdNyAgentNamn = cbValjAgent.getSelectedItem().toString();
                        
                        //F�rs�ker genomf�ra �ndringen
                        if(Agent.andraOmradesChef(nuvarandeChef, valdNyAgentNamn)) {
                            //Visar meddelande om �ndringen �r genomf�rd, �terg�r till agentmenyn och st�nger det nuvarande f�nstret
                            JOptionPane.showMessageDialog(null, "Omr�deschef har uppdaterats");
                            new MenyAgent(id).setVisible(true);
                            dispose();
                        }
                    }
                }
            } else {
                //Visar felmeddelande om inga tillg�ngliga omr�den finns
                JOptionPane.showMessageDialog(null, "Det finns inga tillg�ngliga omr�den registrerade");
            }
        } else {
            //Visar felmeddelande om inget omr�de �r valt
            JOptionPane.showMessageDialog(null, "Du har inte valt n�got omr�de");
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void cbValjOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbValjOmradeActionPerformed
        if(!cbValjOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
            //Visa labels och combobox
            lblNuvarandeOmradesChef.setVisible(true);
            lblNuvarandeOmradesChefRubrik.setVisible(true);
            lblNyOmradesChefRubrik.setVisible(true);
            cbValjAgent.setVisible(true);
            
            //H�mtar valda omr�det fr�n combobox och omvandlar till str�ng
            String omradesNamn = cbValjOmrade.getSelectedItem().toString();
            //H�mtar omr�desId, omvandlar till int och instansierar int
            int omradesId = Integer.parseInt(Omrade.getIdByBenamning(omradesNamn));
            //H�mtar omr�dets chefs agentId och lagrar som int
            int omradesChefId = Omrade.getOmradesChefById(omradesId);
            //H�mtar omr�deschefens namn genom getNamnById() p� omr�deschefens agentId
            String omradesChefNamn = Agent.getNamnById(omradesChefId);
            //Kontroll att omr�deschefens namn inte �r null
            if(omradesChefNamn.equals("0")) {
                //Om namnet av n�gon mystisk anledning saknas s� s�tts namnet som "Ok�nt"
                lblNuvarandeOmradesChef.setText("Ok�nt");
            } else {
                //Annars s�tts lblNuvarandeOmradesChef till omr�deschefens namn
                lblNuvarandeOmradesChef.setText(omradesChefNamn);
            }
        //Om inget omr�de �r valt...
        } else {
            //s� d�lj labels och combobox
            lblNuvarandeOmradesChef.setVisible(false);
            lblNuvarandeOmradesChefRubrik.setVisible(false);
            lblNyOmradesChefRubrik.setVisible(false);
            cbValjAgent.setVisible(false);
        }
    }//GEN-LAST:event_cbValjOmradeActionPerformed

    //Metod f�r G� tillbaka-knappen
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //�ppnar agentmenyn och st�nger nuvarande f�nstret
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
