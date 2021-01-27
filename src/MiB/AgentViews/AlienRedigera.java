package MiB.AgentViews;

import MiB.Agent;
import MiB.Alien;
import MiB.Plats;
import MiB.Validering;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class AlienRedigera extends javax.swing.JFrame {
    private static int id;
    private static int typAvSokning;
    private static int valdAlien;
    
    public AlienRedigera(int id, int typAvSokning, int valdAlien) {
        initComponents();
        this.id = id;
        this.typAvSokning = typAvSokning;
        this.valdAlien = valdAlien;
        
        //Hämtar data och genererar listor
        hamtaPlatser();
        hamtaAgenter();
        
        //Hämtar data och fyller i textfält
        fyllIFalt();
        
        //Aktiverar/inaktiverar ta bort-knappen beroende på om användaren är administratör eller inte.
        if(Agent.getAdminStatusById(id)) {
            btnTaBortAlien.setEnabled(true);
        } else {
            btnTaBortAlien.setEnabled(false);
        }
    }
    
    //Metod som hämtar alla platsnamn
    private void hamtaPlatser(){
        ArrayList<String> allaPlatser = Plats.getAllaPlatsNamn();
        //Itererar igenom resultaten och lägger till varje platsnamn i comboboxen för plats
        for(String plats : allaPlatser) {
            cbPlats.addItem(plats);
        }
    }
    
    //Metod som hämtar alla agenter
    private void hamtaAgenter(){
        ArrayList<String> allaAgenter = Agent.getAllaAgentNamn();
        //Itererar igenom resultaten och lägger till varje agentnamn i comboboxen för agenter
        for(String agent : allaAgenter) {
            cbAnsvarigAgent.addItem(agent);
        }
    }
    
    //Metod som hämtar aliendata och fyller i fälten med den sparade datan
    private void fyllIFalt() {
        ArrayList<HashMap<String, String>> allData = Alien.getAllaById(valdAlien);
        //Itererar igenom resultaten
        for(HashMap<String, String> rad : allData) {
            String alienNamn = rad.get("NAMN");
            String agentNamn = Agent.getNamnById(Integer.parseInt(rad.get("ANSVARIG_AGENT")));//FetchRow returnerar bara ett fält med kolumnnamnet "NAMN" 
                                                                                              //(vilket gör att agent- "slår ut" alien-namn) 
                                                                                              //- är det här en ok lösning? Samma gäller för "BENÄMNING" på plats resp. område.
            String alienId = rad.get("ALIEN_ID");
            String plats = rad.get("BENAMNING");
            String telefonnummer = rad.get("TELEFON");
            String losenord = rad.get("LOSENORD");
            String ras = Alien.getRas(Integer.parseInt(rad.get("ALIEN_ID")));
            
            //Fyll i fält
            txtNamn.setText(alienNamn);
            txtTelefon.setText(telefonnummer);
            pwLosenord.setText(losenord);
            cbRas.setSelectedItem(Alien.getRas(Integer.parseInt(alienId)));
            cbAnsvarigAgent.setSelectedItem(agentNamn);
            cbPlats.setSelectedItem(plats);


            //Fyll bara fälten lblRasInfoRubrik och lblRasInfo om alien är boglodite eller squid.
            if(cbRas.getSelectedItem().toString().equals("Boglodite") || cbRas.getSelectedItem().toString().equals("Squid")) {
               String rasAttribut = Alien.getRasAttribut(ras);
               int rasAttributData = Alien.getRasAttributData(ras, Integer.parseInt(rad.get("ALIEN_ID")));
               lblRasAttributRubrik.setText(rasAttribut + ":");
               txtRasAttribut.setText(Integer.toString(rasAttributData));
               txtRasAttribut.setEnabled(true);
               txtRasAttribut.setVisible(true);
            } else {
                lblRasAttributRubrik.setText("");
                txtRasAttribut.setVisible(false);
                txtRasAttribut.setEnabled(false);
            }
        }
    }
    
    //Metod som körs när man klickar på Gå tillbaka. Beroende på vilket värde typAvSokning har fått så tas man tillbaka till rätt sökmeny
    private void gaTillbaka() {
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblNamnRubrik = new javax.swing.JLabel();
        lblTelefonnummerRubrik = new javax.swing.JLabel();
        lblOmradeRubrik = new javax.swing.JLabel();
        lblRasRubrik = new javax.swing.JLabel();
        lblAnsvarigAgentRubrik = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        cbPlats = new javax.swing.JComboBox<>();
        cbRas = new javax.swing.JComboBox<>();
        cbAnsvarigAgent = new javax.swing.JComboBox<>();
        btnNySokning = new javax.swing.JButton();
        btnSpara = new javax.swing.JButton();
        lblRasAttributRubrik = new javax.swing.JLabel();
        txtRasAttribut = new javax.swing.JTextField();
        lblLosenordRubrik = new javax.swing.JLabel();
        pwLosenord = new javax.swing.JPasswordField();
        btnTaBortAlien = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblNamnRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNamnRubrik.setText("Namn:");

        lblTelefonnummerRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefonnummerRubrik.setText("Telefonnummer:");

        lblOmradeRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeRubrik.setText("Plats:");

        lblRasRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasRubrik.setText("Ras:");

        lblAnsvarigAgentRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnsvarigAgentRubrik.setText("Ansvarig agent:");

        cbRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boglodite", "Squid", "Worm" }));
        cbRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRasActionPerformed(evt);
            }
        });

        btnNySokning.setText("Ny sökning");
        btnNySokning.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNySokning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNySokningActionPerformed(evt);
            }
        });

        btnSpara.setText("Spara");
        btnSpara.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        lblRasAttributRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasAttributRubrik.setText("RasAttribut:");

        lblLosenordRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLosenordRubrik.setText("Lösenord:");

        pwLosenord.setText("jPasswordField1");

        btnTaBortAlien.setText("Ta bort alien");
        btnTaBortAlien.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTaBortAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortAlienActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbRas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPlats, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pwLosenord, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamnRubrik, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefonnummerRubrik, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(btnNySokning, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblOmradeRubrik)
                            .addComponent(lblRasRubrik)
                            .addComponent(txtRasAttribut)
                            .addComponent(lblRasAttributRubrik)
                            .addComponent(lblAnsvarigAgentRubrik)
                            .addComponent(cbAnsvarigAgent, 0, 200, Short.MAX_VALUE)
                            .addComponent(lblLosenordRubrik)
                            .addComponent(btnTaBortAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNamnRubrik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNySokning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefonnummerRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLosenordRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOmradeRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRasRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRasAttributRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRasAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnsvarigAgentRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTaBortAlien, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSpara, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        //Hämtar nuvarande rasen (för att kunna ta bort alien från respektive tabell)
        String ras = Alien.getRas(valdAlien);
        //Hämtar strängvärde från Ansvarig agent-rullistan (finns alltid ett val)
        String nyAnsvarigAgent = cbAnsvarigAgent.getSelectedItem().toString();
        
        if(Validering.txtFaltHarVarde(txtNamn)) {
            //Kontrollerar genom klassen Validerings metod getLedigtNamn() att det angivna namnet är ledigt
            if(Alien.getLedigtNamn(txtNamn.getText()) || txtNamn.getText().equals(Alien.getNamnById(valdAlien))) {
                //Kontrollerar att namnet är mellan 1 och 20 tecken långt.
                if(Validering.valideraLangd(txtNamn.getText(), 1, 20)) {
                    String nyttNamn = txtNamn.getText();
                    //Kontrollerar att telefonnummerfältet är ifyllt
                    if(Validering.txtFaltHarVarde(txtTelefon)) {
                        //Kontrollerar att telefonnumret är mellan 1 och 30 tecken långt.
                        if(Validering.valideraLangd(txtTelefon.getText(), 1, 30)) {
                            String nyttTfn = txtTelefon.getText();
                            //Kontrollerar att telefonnumret är i rätt format
                            if(Validering.valideraTelefonnummer(txtTelefon.getText())) {
                                //Kontrollerar att lösenordsfältet är ifyllt
                                if(Validering.pwdFaltHarVarde(pwLosenord)) {
                                    //Kontrollerar att lösenordet är mellan 1 och 6 tecken långt
                                    if(Validering.valideraLangd(new String(pwLosenord.getPassword()), 1, 6)) {
                                        String nyttLosenord = new String(pwLosenord.getPassword());
                                        //Kontrollerar att en ras är vald
                                        if(!cbRas.getSelectedItem().toString().isEmpty()) {
                                            String nyRas = cbRas.getSelectedItem().toString();
                                                //Kontrollerar att en plats är vald
                                                if(!cbPlats.getSelectedItem().toString().isEmpty()) {
                                                    String nyPlats = cbPlats.getSelectedItem().toString();
                                                    //Kontrollerar om rasen är Boglodite eller Squid
                                                    if(cbRas.getSelectedItem().equals("Boglodite") || cbRas.getSelectedItem().equals("Squid")) {
                                                        //Kontrollerar att fältet för rasattribut (antal armar/antal boogies) är ifyllt
                                                        if(Validering.txtFaltHarVarde(txtRasAttribut)) {
                                                            //Kontrollerar att fältet för rasattribut enbart innehåller siffror
                                                            if(Validering.enbartSiffror(txtRasAttribut.getText())) {
                                                                //Kontrollerar att fältet rasattribut har mellan 1 och 10 tecken.
                                                                if(Validering.valideraLangd(txtRasAttribut.getText(), 1, 10)) {
                                                                    //Försöker uppdatera en alien
                                                                    String nyttRasAttribut = "0";
                                                                    if(nyRas.equals("Boglodite") || nyRas.equals("Squid")) {
                                                                        nyttRasAttribut = txtRasAttribut.getText();
                                                                    }
                                                                    if(Alien.uppdateraAlien(nyttNamn, nyttTfn, nyPlats, nyttLosenord, ras, nyRas, nyttRasAttribut, nyAnsvarigAgent, valdAlien)) {
                                                                        //Visar ett meddelande om att en alien är tillagd
                                                                        JOptionPane.showMessageDialog(null, "Alien har uppdaterats");
                                                                        //Går tillbaka till föregående fönster och stänger det nuvarande
                                                                        gaTillbaka();
                                                                    //Visar ett felmeddelande om någonting gick fel när data skulle läggas till i databasen
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Någonting gick fel när alien skulle uppdateras. Försök igen.", "Ett fel har uppstått!", JOptionPane.ERROR_MESSAGE);
                                                                    }
                                                                //Felmeddelande om fältet för rasattribut är längre än 10 tecken.
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Du har angett ett för högt värde i fältet " + lblRasAttributRubrik.getText() + ". Max 10 siffror långt.", "Felaktigt värde", JOptionPane.ERROR_MESSAGE);
                                                                }
                                                            //Felmeddelande om fältet för rasattribut innehåller annat än siffror.
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Fältet " + lblRasAttributRubrik.getText().toLowerCase() + " får enbart innehålla siffror", "Felaktigt värde", JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        //Felmeddelande om rasattributfältet är tomt    
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett " + lblRasAttributRubrik.getText().toLowerCase(), "Felaktigt värde", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    //Om inget rasattribut krävs (för worms)    
                                                    } else {
                                                        String nyttRasAttribut = "0";
                                                        //Försöker lägga till en alien i databasen
                                                            if(Alien.uppdateraAlien(nyttNamn, nyttTfn, nyPlats, nyttLosenord, ras, nyRas, nyttRasAttribut, nyAnsvarigAgent, valdAlien)) {
                                                            //Visar ett meddelande om att en alien har lagts till
                                                            JOptionPane.showMessageDialog(null, "Alien har uppdaterats");
                                                            //Går tillbaka till fönstret för att visa mer och stänger redigeringsfönstret
                                                            gaTillbaka();
                                                        //Felmeddelande om någonting gick fel när data skulle läggas till i databasen
                                                        } else {
                                                        JOptionPane.showMessageDialog(null, "Någonting gick fel när alien skulle uppdateras. Försök igen.", "Ett fel har uppstått!", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                    //Felmeddelande om ingen plats är vald
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Du har inte valt någon plats", "Ingen plats vald", JOptionPane.ERROR_MESSAGE);
                                                }
                                        //Felmeddelande om ingen ras är vald        
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Du har inte valt någon ras", "Ingen ras vald", JOptionPane.ERROR_MESSAGE);
                                        }
                                    //Felmeddelande om lösenordet är längre än 6 tecken
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Lösenordet du har valt är för långt", "Lösenord", JOptionPane.ERROR_MESSAGE);
                                    }
                                //Felmeddelande om lösenordsfältet är tomt
                                } else {
                                    JOptionPane.showMessageDialog(null, "Du har inte angett något lösenord", "Inget lösenord angett", JOptionPane.ERROR_MESSAGE);
                                }
                            //Felmeddelande om telefonnumret är i fel format
                            } else {
                                JOptionPane.showMessageDialog(null, "Telefonnummer måste anges i rätt format, exempelvis \"123-456789\".", "Telefonnummer", JOptionPane.ERROR_MESSAGE);
                            }
                        //Felmeddelande om telefonnumret är för långt
                        } else {
                            JOptionPane.showMessageDialog(null, "Telefonnumret du har angett är för långt", "Telefonnummer", JOptionPane.ERROR_MESSAGE);
                        }
                    //Felmeddelande om telefonnummerfältet är tomt
                    } else {
                        JOptionPane.showMessageDialog(null, "Du har inte angett något telefonnummer", "Inget telefonnummer angett", JOptionPane.ERROR_MESSAGE);
                    }
                //Felmeddelande om namnet är för långt
                } else {
                    JOptionPane.showMessageDialog(null, "Namnet du har angett är för långt", "Namn", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Det finns redan en användare med det namnet du har angett", "Namn", JOptionPane.ERROR_MESSAGE);
            }
        //Felmeddelande om namnfältet är tomt
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angett något namn", "Inget namn angett", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void cbRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRasActionPerformed
        //Kontrollerar vilken ras som är vald i comboboxen och uppdaterar label till rätt rasattribut ("antal armar"/"antal boogies") om det är en boglodite eller squid
        if(cbRas.getSelectedItem().toString().equals("Boglodite") || cbRas.getSelectedItem().toString().equals("Squid")) {
                   String rasAttribut = Alien.getRasAttribut(cbRas.getSelectedItem().toString());
                   lblRasAttributRubrik.setText(rasAttribut + ":");
                   txtRasAttribut.setEnabled(true);
                   txtRasAttribut.setVisible(true);
                   
                  //Om det är någon annan ras än boglodite eller squid så får labeln ett tomt värde (blir dold) och textfältet döljs och inaktiveras.
                } else {
                    lblRasAttributRubrik.setText("");
                    txtRasAttribut.setVisible(false);
                    txtRasAttribut.setEnabled(false);
                }
    }//GEN-LAST:event_cbRasActionPerformed

    private void btnNySokningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNySokningActionPerformed
        gaTillbaka();
    }//GEN-LAST:event_btnNySokningActionPerformed

    private void btnTaBortAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortAlienActionPerformed
        //Kollar om agenten är administratör (utifallat knappen av någon mystisk anledning inte har inaktiverats?)
        if(Agent.getAdminStatusById(id)) {
            //Försöker ta bort alien
            if(Alien.taBort(valdAlien)) {
                //Visar successmeddelande och går tillbaka till sökmenyn
                JOptionPane.showMessageDialog(null, "En alien har tagits bort.", "Alien borttagen", JOptionPane.INFORMATION_MESSAGE);
                gaTillbaka();
            }
        } else {
            //Om användaren försöker ta bort utan att vara admin så visas ett felmeddelande
            JOptionPane.showMessageDialog(null, "Du behöver vara administratör för att kunna ta bort en alien.", "Behörighet saknas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTaBortAlienActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNySokning;
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnTaBortAlien;
    private javax.swing.JComboBox<String> cbAnsvarigAgent;
    private javax.swing.JComboBox<String> cbPlats;
    private javax.swing.JComboBox<String> cbRas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAnsvarigAgentRubrik;
    private javax.swing.JLabel lblLosenordRubrik;
    private javax.swing.JLabel lblNamnRubrik;
    private javax.swing.JLabel lblOmradeRubrik;
    private javax.swing.JLabel lblRasAttributRubrik;
    private javax.swing.JLabel lblRasRubrik;
    private javax.swing.JLabel lblTelefonnummerRubrik;
    private javax.swing.JPasswordField pwLosenord;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtRasAttribut;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
