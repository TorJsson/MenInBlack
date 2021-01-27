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
        
        //H�mtar data och genererar listor
        hamtaPlatser();
        hamtaAgenter();
        
        //H�mtar data och fyller i textf�lt
        fyllIFalt();
        
        //Aktiverar/inaktiverar ta bort-knappen beroende p� om anv�ndaren �r administrat�r eller inte.
        if(Agent.getAdminStatusById(id)) {
            btnTaBortAlien.setEnabled(true);
        } else {
            btnTaBortAlien.setEnabled(false);
        }
    }
    
    //Metod som h�mtar alla platsnamn
    private void hamtaPlatser(){
        ArrayList<String> allaPlatser = Plats.getAllaPlatsNamn();
        //Itererar igenom resultaten och l�gger till varje platsnamn i comboboxen f�r plats
        for(String plats : allaPlatser) {
            cbPlats.addItem(plats);
        }
    }
    
    //Metod som h�mtar alla agenter
    private void hamtaAgenter(){
        ArrayList<String> allaAgenter = Agent.getAllaAgentNamn();
        //Itererar igenom resultaten och l�gger till varje agentnamn i comboboxen f�r agenter
        for(String agent : allaAgenter) {
            cbAnsvarigAgent.addItem(agent);
        }
    }
    
    //Metod som h�mtar aliendata och fyller i f�lten med den sparade datan
    private void fyllIFalt() {
        ArrayList<HashMap<String, String>> allData = Alien.getAllaById(valdAlien);
        //Itererar igenom resultaten
        for(HashMap<String, String> rad : allData) {
            String alienNamn = rad.get("NAMN");
            String agentNamn = Agent.getNamnById(Integer.parseInt(rad.get("ANSVARIG_AGENT")));//FetchRow returnerar bara ett f�lt med kolumnnamnet "NAMN" 
                                                                                              //(vilket g�r att agent- "sl�r ut" alien-namn) 
                                                                                              //- �r det h�r en ok l�sning? Samma g�ller f�r "BEN�MNING" p� plats resp. omr�de.
            String alienId = rad.get("ALIEN_ID");
            String plats = rad.get("BENAMNING");
            String telefonnummer = rad.get("TELEFON");
            String losenord = rad.get("LOSENORD");
            String ras = Alien.getRas(Integer.parseInt(rad.get("ALIEN_ID")));
            
            //Fyll i f�lt
            txtNamn.setText(alienNamn);
            txtTelefon.setText(telefonnummer);
            pwLosenord.setText(losenord);
            cbRas.setSelectedItem(Alien.getRas(Integer.parseInt(alienId)));
            cbAnsvarigAgent.setSelectedItem(agentNamn);
            cbPlats.setSelectedItem(plats);


            //Fyll bara f�lten lblRasInfoRubrik och lblRasInfo om alien �r boglodite eller squid.
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
    
    //Metod som k�rs n�r man klickar p� G� tillbaka. Beroende p� vilket v�rde typAvSokning har f�tt s� tas man tillbaka till r�tt s�kmeny
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

        btnNySokning.setText("Ny s�kning");
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
        lblLosenordRubrik.setText("L�senord:");

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
        //H�mtar nuvarande rasen (f�r att kunna ta bort alien fr�n respektive tabell)
        String ras = Alien.getRas(valdAlien);
        //H�mtar str�ngv�rde fr�n Ansvarig agent-rullistan (finns alltid ett val)
        String nyAnsvarigAgent = cbAnsvarigAgent.getSelectedItem().toString();
        
        if(Validering.txtFaltHarVarde(txtNamn)) {
            //Kontrollerar genom klassen Validerings metod getLedigtNamn() att det angivna namnet �r ledigt
            if(Alien.getLedigtNamn(txtNamn.getText()) || txtNamn.getText().equals(Alien.getNamnById(valdAlien))) {
                //Kontrollerar att namnet �r mellan 1 och 20 tecken l�ngt.
                if(Validering.valideraLangd(txtNamn.getText(), 1, 20)) {
                    String nyttNamn = txtNamn.getText();
                    //Kontrollerar att telefonnummerf�ltet �r ifyllt
                    if(Validering.txtFaltHarVarde(txtTelefon)) {
                        //Kontrollerar att telefonnumret �r mellan 1 och 30 tecken l�ngt.
                        if(Validering.valideraLangd(txtTelefon.getText(), 1, 30)) {
                            String nyttTfn = txtTelefon.getText();
                            //Kontrollerar att telefonnumret �r i r�tt format
                            if(Validering.valideraTelefonnummer(txtTelefon.getText())) {
                                //Kontrollerar att l�senordsf�ltet �r ifyllt
                                if(Validering.pwdFaltHarVarde(pwLosenord)) {
                                    //Kontrollerar att l�senordet �r mellan 1 och 6 tecken l�ngt
                                    if(Validering.valideraLangd(new String(pwLosenord.getPassword()), 1, 6)) {
                                        String nyttLosenord = new String(pwLosenord.getPassword());
                                        //Kontrollerar att en ras �r vald
                                        if(!cbRas.getSelectedItem().toString().isEmpty()) {
                                            String nyRas = cbRas.getSelectedItem().toString();
                                                //Kontrollerar att en plats �r vald
                                                if(!cbPlats.getSelectedItem().toString().isEmpty()) {
                                                    String nyPlats = cbPlats.getSelectedItem().toString();
                                                    //Kontrollerar om rasen �r Boglodite eller Squid
                                                    if(cbRas.getSelectedItem().equals("Boglodite") || cbRas.getSelectedItem().equals("Squid")) {
                                                        //Kontrollerar att f�ltet f�r rasattribut (antal armar/antal boogies) �r ifyllt
                                                        if(Validering.txtFaltHarVarde(txtRasAttribut)) {
                                                            //Kontrollerar att f�ltet f�r rasattribut enbart inneh�ller siffror
                                                            if(Validering.enbartSiffror(txtRasAttribut.getText())) {
                                                                //Kontrollerar att f�ltet rasattribut har mellan 1 och 10 tecken.
                                                                if(Validering.valideraLangd(txtRasAttribut.getText(), 1, 10)) {
                                                                    //F�rs�ker uppdatera en alien
                                                                    String nyttRasAttribut = "0";
                                                                    if(nyRas.equals("Boglodite") || nyRas.equals("Squid")) {
                                                                        nyttRasAttribut = txtRasAttribut.getText();
                                                                    }
                                                                    if(Alien.uppdateraAlien(nyttNamn, nyttTfn, nyPlats, nyttLosenord, ras, nyRas, nyttRasAttribut, nyAnsvarigAgent, valdAlien)) {
                                                                        //Visar ett meddelande om att en alien �r tillagd
                                                                        JOptionPane.showMessageDialog(null, "Alien har uppdaterats");
                                                                        //G�r tillbaka till f�reg�ende f�nster och st�nger det nuvarande
                                                                        gaTillbaka();
                                                                    //Visar ett felmeddelande om n�gonting gick fel n�r data skulle l�ggas till i databasen
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien skulle uppdateras. F�rs�k igen.", "Ett fel har uppst�tt!", JOptionPane.ERROR_MESSAGE);
                                                                    }
                                                                //Felmeddelande om f�ltet f�r rasattribut �r l�ngre �n 10 tecken.
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Du har angett ett f�r h�gt v�rde i f�ltet " + lblRasAttributRubrik.getText() + ". Max 10 siffror l�ngt.", "Felaktigt v�rde", JOptionPane.ERROR_MESSAGE);
                                                                }
                                                            //Felmeddelande om f�ltet f�r rasattribut inneh�ller annat �n siffror.
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "F�ltet " + lblRasAttributRubrik.getText().toLowerCase() + " f�r enbart inneh�lla siffror", "Felaktigt v�rde", JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        //Felmeddelande om rasattributf�ltet �r tomt    
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett " + lblRasAttributRubrik.getText().toLowerCase(), "Felaktigt v�rde", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    //Om inget rasattribut kr�vs (f�r worms)    
                                                    } else {
                                                        String nyttRasAttribut = "0";
                                                        //F�rs�ker l�gga till en alien i databasen
                                                            if(Alien.uppdateraAlien(nyttNamn, nyttTfn, nyPlats, nyttLosenord, ras, nyRas, nyttRasAttribut, nyAnsvarigAgent, valdAlien)) {
                                                            //Visar ett meddelande om att en alien har lagts till
                                                            JOptionPane.showMessageDialog(null, "Alien har uppdaterats");
                                                            //G�r tillbaka till f�nstret f�r att visa mer och st�nger redigeringsf�nstret
                                                            gaTillbaka();
                                                        //Felmeddelande om n�gonting gick fel n�r data skulle l�ggas till i databasen
                                                        } else {
                                                        JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien skulle uppdateras. F�rs�k igen.", "Ett fel har uppst�tt!", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                    //Felmeddelande om ingen plats �r vald
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Du har inte valt n�gon plats", "Ingen plats vald", JOptionPane.ERROR_MESSAGE);
                                                }
                                        //Felmeddelande om ingen ras �r vald        
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Du har inte valt n�gon ras", "Ingen ras vald", JOptionPane.ERROR_MESSAGE);
                                        }
                                    //Felmeddelande om l�senordet �r l�ngre �n 6 tecken
                                    } else {
                                        JOptionPane.showMessageDialog(null, "L�senordet du har valt �r f�r l�ngt", "L�senord", JOptionPane.ERROR_MESSAGE);
                                    }
                                //Felmeddelande om l�senordsf�ltet �r tomt
                                } else {
                                    JOptionPane.showMessageDialog(null, "Du har inte angett n�got l�senord", "Inget l�senord angett", JOptionPane.ERROR_MESSAGE);
                                }
                            //Felmeddelande om telefonnumret �r i fel format
                            } else {
                                JOptionPane.showMessageDialog(null, "Telefonnummer m�ste anges i r�tt format, exempelvis \"123-456789\".", "Telefonnummer", JOptionPane.ERROR_MESSAGE);
                            }
                        //Felmeddelande om telefonnumret �r f�r l�ngt
                        } else {
                            JOptionPane.showMessageDialog(null, "Telefonnumret du har angett �r f�r l�ngt", "Telefonnummer", JOptionPane.ERROR_MESSAGE);
                        }
                    //Felmeddelande om telefonnummerf�ltet �r tomt
                    } else {
                        JOptionPane.showMessageDialog(null, "Du har inte angett n�got telefonnummer", "Inget telefonnummer angett", JOptionPane.ERROR_MESSAGE);
                    }
                //Felmeddelande om namnet �r f�r l�ngt
                } else {
                    JOptionPane.showMessageDialog(null, "Namnet du har angett �r f�r l�ngt", "Namn", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Det finns redan en anv�ndare med det namnet du har angett", "Namn", JOptionPane.ERROR_MESSAGE);
            }
        //Felmeddelande om namnf�ltet �r tomt
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angett n�got namn", "Inget namn angett", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void cbRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRasActionPerformed
        //Kontrollerar vilken ras som �r vald i comboboxen och uppdaterar label till r�tt rasattribut ("antal armar"/"antal boogies") om det �r en boglodite eller squid
        if(cbRas.getSelectedItem().toString().equals("Boglodite") || cbRas.getSelectedItem().toString().equals("Squid")) {
                   String rasAttribut = Alien.getRasAttribut(cbRas.getSelectedItem().toString());
                   lblRasAttributRubrik.setText(rasAttribut + ":");
                   txtRasAttribut.setEnabled(true);
                   txtRasAttribut.setVisible(true);
                   
                  //Om det �r n�gon annan ras �n boglodite eller squid s� f�r labeln ett tomt v�rde (blir dold) och textf�ltet d�ljs och inaktiveras.
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
        //Kollar om agenten �r administrat�r (utifallat knappen av n�gon mystisk anledning inte har inaktiverats?)
        if(Agent.getAdminStatusById(id)) {
            //F�rs�ker ta bort alien
            if(Alien.taBort(valdAlien)) {
                //Visar successmeddelande och g�r tillbaka till s�kmenyn
                JOptionPane.showMessageDialog(null, "En alien har tagits bort.", "Alien borttagen", JOptionPane.INFORMATION_MESSAGE);
                gaTillbaka();
            }
        } else {
            //Om anv�ndaren f�rs�ker ta bort utan att vara admin s� visas ett felmeddelande
            JOptionPane.showMessageDialog(null, "Du beh�ver vara administrat�r f�r att kunna ta bort en alien.", "Beh�righet saknas", JOptionPane.ERROR_MESSAGE);
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
