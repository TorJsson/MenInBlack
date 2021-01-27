package MiB.AgentViews;

import MiB.Agent;
import MiB.Alien;
import MiB.CommonViews.Login;
import MiB.Omrade;
import MiB.Validering;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class AgentRedigera extends javax.swing.JFrame {
    private static int id;
    private static int valdAgent;

    public AgentRedigera(int id, int valdAgent) {
        initComponents();
        this.id = id;
        this.valdAgent = valdAgent;
        //Döljer label och textfält för kontorsbeteckning per default
        lblKontorsbeteckningRubrik.setEnabled(false);
        txtKontorsbeteckning.setEnabled(false);
        
        //Döljer label och textfält för ny områdeschef per default
        lblNyOmradesChefRubrik.setEnabled(false);
        cbNyOmradesChef.setEnabled(false);
        
        //Anropar metoden hamtaPlatser()
        hamtaPlatser();
        
        //Anropar metoden hamtaAgentData()
        hamtaAgentData();
        
        //Anropar metoden hamtaMojligaOmradeschefer()
        hamtaMojligaOmradeschefer();
    }
    
    //Metod som hämtar alla områdesnamn från databasen och lägger till dom på nya rader i comboboxen cbOmrade
    private void hamtaPlatser() {
        //Instansierar arrayList med namnet allaOmraden som får värdet som returneras genom klassen Omrades metod getAllaOmradesBenamningar()
        ArrayList<String> allaOmraden = Omrade.getAllaOmradesBenamningar();
        
        //Itererar igenom resultatsetet allaOmraden och lägger till varje returnerat värde som ett item i comboboxen cbOmrade genom metoden addItem().
        for(String omrade : allaOmraden) {
            cbOmrade.addItem(omrade);
        }
    }
    
    //Hämtar en lista över agenters namn som i nuläget inte är områdeschefer
    private void hamtaMojligaOmradeschefer() {
        ArrayList<String> agenter = Agent.listaAgenterUtanOmradesAnsvar();
        
        //Om arrayListen över agenter inte är tom...
        if(agenter != null) {
            //så itererar vi igenom resultaten
            for(String agent: agenter) {
                //... och lägger till namnen i comboboxen
                cbNyOmradesChef.addItem(agent);
            }
        //Om arrayListen är tom...
        } else {
            //.. så tar removeAllItems() tar bort default-valet "--- Välj agent ---"
            cbNyOmradesChef.removeAllItems();
            //lägger till "--- Inga tillgängliga ---"
            cbNyOmradesChef.addItem("--- Inga tillgängliga ---");
        }
        
    }
    
    //Metod för att hämta agentdata för den valda agenten
    private void hamtaAgentData() {
        HashMap<String, String> agentData = Agent.getAgentDataById(valdAgent);
        //Sparar resultaten som strängar
            String agentNamn = agentData.get("NAMN");
            String agentAnstallningsdatum = agentData.get("ANSTALLNINGSDATUM");
            String agentTelefonnummer = agentData.get("TELEFON");
            String agentLosenord = agentData.get("LOSENORD");
            String agentOmradeNamn = agentData.get("BENAMNING");
            String agentAdminStatus = agentData.get("ADMINISTRATOR");
            
            //Kontrollerar om agenten är administratör och instansierar agentArAdmin som en boolesk variabel med true/false.
            boolean agentArAdmin = false;
            if(agentAdminStatus.equals("J")) {
                agentArAdmin = true;
            } else {
                agentArAdmin = false;
            }
            
            //Instansierar booleska variabler som representerar huruvida en agent är fältagent/områdeschef/kontorschef.
            boolean agentArFaltagent = Agent.getIsFaltAgent(valdAgent);
            boolean agentArOmradeschef = Agent.getIsOmradesChef(valdAgent);
            boolean agentArKontorschef = Agent.getIsKontorsChef(valdAgent);
            
            //Kontrollerar om agenten är kontorschef
            String agentKontorsbeteckning = "";
            if(agentArKontorschef) {
                //Visar txtKontorsbeteckning och lblKontorsbeteckningRubrik
                txtKontorsbeteckning.setEnabled(true);
                lblKontorsbeteckningRubrik.setEnabled(true);
                //Lagrar kontorsbeteckningen som en sträng
                agentKontorsbeteckning = Agent.getKontorsbeteckningById(valdAgent);
            }
            
            //Fyller i sidans fält
            //Vi vill bara fylla i textfältet med det som kommer efter "Agent " i namnet som sparats i databasen. Använder split() och hämtar ut det som finns på den 1a positionen i arrayen
            txtNamn.setText(agentNamn.split("Agent ")[1]); 
            txtAnstallningsdatum.setText(agentAnstallningsdatum);
            txtTelefon.setText(agentTelefonnummer);
            pwLosenord.setText(agentLosenord);
            chbAdmin.setSelected(agentArAdmin);
            chbFaltagent.setSelected(agentArFaltagent);
            chbOmradeschef.setSelected(agentArOmradeschef);
            chbKontorschef.setSelected(agentArKontorschef);
            cbOmrade.setSelectedItem(agentOmradeNamn);
            txtKontorsbeteckning.setText(agentKontorsbeteckning);

    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLosenordRubrik = new javax.swing.JLabel();
        chbOmradeschef = new javax.swing.JCheckBox();
        pwLosenord = new javax.swing.JPasswordField();
        chbKontorschef = new javax.swing.JCheckBox();
        lblAgenttypRubrik = new javax.swing.JLabel();
        lblKontorsbeteckningRubrik = new javax.swing.JLabel();
        txtKontorsbeteckning = new javax.swing.JTextField();
        chbAdmin = new javax.swing.JCheckBox();
        btnNySokning = new javax.swing.JButton();
        lblOmradeRubrik = new javax.swing.JLabel();
        lblNamnRubrik = new javax.swing.JLabel();
        cbOmrade = new javax.swing.JComboBox<>();
        txtNamn = new javax.swing.JTextField();
        btnSpara = new javax.swing.JButton();
        lblTelefonRubrik = new javax.swing.JLabel();
        lblAgentRubrik = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        chbFaltagent = new javax.swing.JCheckBox();
        lblAnstallningsdatumRubrik = new javax.swing.JLabel();
        txtAnstallningsdatum = new javax.swing.JTextField();
        lblNyOmradesChefRubrik = new javax.swing.JLabel();
        cbNyOmradesChef = new javax.swing.JComboBox<>();
        btnTaBort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblLosenordRubrik.setText("Lösenord:");

        chbOmradeschef.setText("Områdeschef");
        chbOmradeschef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbOmradeschefActionPerformed(evt);
            }
        });

        chbKontorschef.setText("Kontorschef");
        chbKontorschef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbKontorschefActionPerformed(evt);
            }
        });

        lblAgenttypRubrik.setText("Agenttyp:");

        lblKontorsbeteckningRubrik.setText("Kontorsbeteckning:");

        chbAdmin.setText("Administratör");

        btnNySokning.setText("Ny sökning");
        btnNySokning.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNySokning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNySokningActionPerformed(evt);
            }
        });

        lblOmradeRubrik.setText("Område:");

        lblNamnRubrik.setText("Namn:");

        cbOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj område ---" }));

        btnSpara.setText("Spara");
        btnSpara.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        lblTelefonRubrik.setText("Telefonnummer:");

        lblAgentRubrik.setText("Agent");

        chbFaltagent.setText("Fältagent");

        lblAnstallningsdatumRubrik.setText("Anställningsdatum:");

        txtAnstallningsdatum.setEnabled(false);

        lblNyOmradesChefRubrik.setText("Välj ny områdeschef:");

        cbNyOmradesChef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj agent ---" }));

        btnTaBort.setText("Ta bort agent");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnstallningsdatum)
                    .addComponent(btnSpara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNySokning, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTelefon)
                    .addComponent(pwLosenord)
                    .addComponent(cbNyOmradesChef, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKontorsbeteckning)
                    .addComponent(cbOmrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamnRubrik)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAgentRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAnstallningsdatumRubrik)
                            .addComponent(lblTelefonRubrik)
                            .addComponent(lblLosenordRubrik)
                            .addComponent(lblAgenttypRubrik)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chbFaltagent)
                                .addGap(18, 18, 18)
                                .addComponent(chbOmradeschef)
                                .addGap(18, 18, 18)
                                .addComponent(chbKontorschef))
                            .addComponent(lblNyOmradesChefRubrik)
                            .addComponent(lblKontorsbeteckningRubrik)
                            .addComponent(chbAdmin)
                            .addComponent(lblOmradeRubrik)
                            .addComponent(btnTaBort))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNySokning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNamnRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgentRubrik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnstallningsdatumRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefonRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLosenordRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgenttypRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbFaltagent)
                    .addComponent(chbOmradeschef)
                    .addComponent(chbKontorschef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNyOmradesChefRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNyOmradesChef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKontorsbeteckningRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKontorsbeteckning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOmradeRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnTaBort)
                .addGap(18, 18, 18)
                .addComponent(btnSpara, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chbKontorschefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbKontorschefActionPerformed
        //Om checkboxen är markerad...
        if(chbKontorschef.isSelected()) {
            //Visa label och textfält
            lblKontorsbeteckningRubrik.setEnabled(true);
            txtKontorsbeteckning.setEnabled(true);
            //Forcerar en uppdatering på JForm för att label och textfält ska visas när checkboxen är markerad
            this.repaint();
            this.revalidate();
        } else {
            //Om checkboxen inte är markerad så döljs både label och textfält
            lblKontorsbeteckningRubrik.setEnabled(false);
            txtKontorsbeteckning.setEnabled(false);
        }

    }//GEN-LAST:event_chbKontorschefActionPerformed

    private void btnNySokningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNySokningActionPerformed
        //Instansierar ett nytt objekt av klassen MenyAgent och visar fönstret
        new MenyAgent(id).setVisible(true);
        //Slänger och stänger det nuvarande fönstret
        dispose();
    }//GEN-LAST:event_btnNySokningActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        //Instansierar ett antal booleska variabler med värdet som returneras från checkboxarnas isSelected()-metod
        boolean nyAgentKontorschef = chbKontorschef.isSelected();
        boolean nyAgentOmradeschef = chbOmradeschef.isSelected();
        boolean nyAgentFaltagent = chbFaltagent.isSelected();

        //Validerar att fält är ifylla
        
        //Kontrollerar genom klassen Validerings metod txtFaltHarVarde att fältet txtNamn är ifyllt
        if(Validering.txtFaltHarVarde(txtNamn)) {
            //Skapar en ny strängvariabel med namnet nyAgentNamn och ger den värdet "Agent " följt av det ifyllda namnet från textfältet txtNamn genom metoden getText()
            String nyAgentNamn = "Agent " + txtNamn.getText().toUpperCase();
            //Kontrollerar om namnet som är ifyllt i fältet txtNamn inte är taget av någon annan användare
            if(Agent.getLedigtNamn(nyAgentNamn) || nyAgentNamn.equals(Agent.getNamnById(valdAgent))) {
                //Kontrollerar att längden på strängen som returneras från fältet txtNamn genom metoden getText() inte överstiger 15 tecken
                if(Validering.valideraLangd(txtNamn.getText(), 1, 15)) {
                    
                    //Kontrollerar genom klassen Validerings metod txtFaltHarVarde att fältet txtTelefon är ifyllt
                    if(Validering.txtFaltHarVarde(txtTelefon)) {
                        //Kontrollerar genom klassen Validerings metod valideraLangd att värdet från fältet txtTelefon (genom metoden getText()) är mellan 1 och 30 tecken långt
                        if(Validering.valideraLangd(txtTelefon.getText(), 1, 30)) {
                            //Kontrollerar med klassen Validerings metod valideraTelefonnummer() att telefonnumret är i rätt format (NNN-NNNNN.....)
                            if(Validering.valideraTelefonnummer(txtTelefon.getText())) {
                                //Instansierar en ny strängvariabel nyAgentTelefon med värdet från textfältet txtTelefon genom metoden getText().
                                String nyAgentTelefon = txtTelefon.getText();
                                //Kontrollerar genom klassen Validerings metod pwdFaltHarVarde() att lösenordsfältet pwLosenord är ifyllt
                                if(Validering.pwdFaltHarVarde(pwLosenord)) {
                                    //Instansierar en ny strängvariabel med genom att hämta arrayen från fältet pwLosenord genom metoden getPassword() och skapa en sträng av den arrayen.
                                    String nyAgentLosenord = new String(pwLosenord.getPassword());
                                    //Använder klassen Validerings metod valideraLangd() för att kontrollera att lösenordet är mellan 1 och 6 tecken långt
                                    if(Validering.valideraLangd(nyAgentLosenord, 1, 6)) {                                        
                                            //Instansierar en ny strängvariabel med namnet nyAgentKontorsbeteckning
                                            String nyAgentKontorsbeteckning = "";
                                            
                                            //Kontrollerar om något område är valt
                                            String nyAgentOmrade = "";
                                            if(cbOmrade.getSelectedItem().toString().isEmpty() || cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
                                                nyAgentOmrade = null;
                                            } else {
                                                //Hämtar värdet från comboboxen cbOmrade, omvandlar det till en sträng och instansierar variabeln nyAgentOmrade.
                                                nyAgentOmrade = cbOmrade.getSelectedItem().toString();
                                            }
                                            
                                            boolean nyAgentAdmin = false;
                                            if(chbAdmin.isSelected()) {
                                                nyAgentAdmin = true;
                                            } else {
                                                nyAgentAdmin = false;
                                            }
                                            //Kontrollerar om checkboxen chbKontorschef är markerad
                                            if(nyAgentKontorschef) {
                                                //Kontrollerar om fältet txtKontorsbeteckning är ifyllt
                                                if(Validering.txtFaltHarVarde(txtKontorsbeteckning)) {
                                                    if(Validering.valideraLangd(txtKontorsbeteckning.getText(), 1, 25)) {
                                                        nyAgentKontorsbeteckning = txtKontorsbeteckning.getText();
                                                        if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett vilket område som agenten är områdeschef för", "Område saknas", JOptionPane.ERROR_MESSAGE);
                                                        } else {
                                                               //Kontrollerar om agenten i nuläget är områdeschef men inte längre ska vara det. Gör isåfall en ändring i områdeschefstabellen.
                                                            if(Agent.getIsOmradesChef(valdAgent) && !chbOmradeschef.isSelected()){
                                                                if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Välj agent ---")) {
                                                                    System.out.println("Du har inte valt en agent som ersätter den du redigerar som områdeschef");
                                                                } else {
                                                                    if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
                                                                        JOptionPane.showMessageDialog(null, "Det finns inga agenter som är tillgängliga för att överta områdeschefsansvaret. Agenten kommer fortsatt vara områdeschef.");
                                                                    } else {
                                                                        String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                        if(Agent.andraOmradesChef(valdAgent, nyOmradesChef)) {
                                                                            //Områdeschef har ändrats
                                                                        }
                                                                    }
                                                                }
                                                            } else if(!Agent.getIsOmradesChef(valdAgent) && chbOmradeschef.isSelected()){
                                                                if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Välj agent ---")) {
                                                                    System.out.println("Du har inte valt vilket område agenten ska vara områdeschef för");
                                                                } else {
                                                                    String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                    if(Agent.gorTillOmradesChef(valdAgent, nyAgentOmrade)) {
                                                                        //Agenten har gjorts till områdeschef
                                                                    }
                                                                }
                                                            }

                                                            if(Agent.getIsFaltAgent(valdAgent) && !chbFaltagent.isSelected()) {
                                                                //Agenten är fältagent men ska inte längre vara det
                                                                if(Agent.taBortFaltAgent(valdAgent)) {
                                                                    //Agenten är borttagen som fältagent
                                                                }
                                                            } else if(!Agent.getIsFaltAgent(valdAgent) && chbFaltagent.isSelected()) {
                                                                //Agenten är inte fältagent men ska vara det
                                                                if(Agent.gorTillFaltAgent(valdAgent)) {
                                                                    //Agenten är gjord till fältagent
                                                                }
                                                            }

                                                            if(Agent.getIsKontorsChef(valdAgent) && !chbKontorschef.isSelected()) {
                                                                //Agenten är kontorschef men ska inte längre vara det
                                                                if(Agent.taBortKontorsChef(valdAgent)) {
                                                                    //Agenten är borttagen som kontorschef
                                                                }
                                                            } else if(!Agent.getIsKontorsChef(valdAgent) && chbKontorschef.isSelected()){
                                                                //Agenten är inte kontorschef men ska vara det
                                                                if(Agent.gorTillKontorsChef(valdAgent, nyAgentKontorsbeteckning)) {
                                                                    //Agenten är gjord till kontorschef
                                                                }
                                                            }
                                                            
                                                            //Försöker genomföra uppdateringen
                                                            if(Agent.uppdateraAgent(valdAgent, nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentAdmin)) {
                                                                //Om uppdateringen lyckas så visas ett meddelande. Återgår till agentmenyn och stänger redigeringsfönstret
                                                                JOptionPane.showMessageDialog(null, "Agenten har uppdaterats", "Uppdatering genomförd", JOptionPane.INFORMATION_MESSAGE);
                                                                new MenyAgent(id).setVisible(true);
                                                                dispose();
                                                            }
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Kontorsbeteckningen du har angivit är för lång. Max 25 tecken.", "Kontorsbeteckningen är för lång", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                } else {
                                                    //Ingen kontorsbeteckning
                                                    JOptionPane.showMessageDialog(null, "Du har inte angivit någon kontorsbeteckning för kontorschefen", "Kontorsbeteckning saknas", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } else {
                                                nyAgentKontorsbeteckning = "";
                                                if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
                                                        JOptionPane.showMessageDialog(null, "Du har inte angett vilket område som agenten är områdeschef för", "Område saknas", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    //Kontrollerar om agenten i nuläget är områdeschef men inte längre ska vara det. Gör isåfall en ändring i områdeschefstabellen.
                                                    if(Agent.getIsOmradesChef(valdAgent) && !chbOmradeschef.isSelected()){
                                                        if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Välj agent ---")) {
                                                            System.out.println("Du har inte valt en agent som ersätter den du redigerar som områdeschef");
                                                        } else {
                                                            if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
                                                                 JOptionPane.showMessageDialog(null, "Det finns inga agenter som är tillgängliga för att överta områdeschefsansvaret. Agenten kommer fortsatt vara områdeschef.");
                                                            } else {
                                                                String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                if(Agent.andraOmradesChef(valdAgent, nyOmradesChef)) {
                                                                    //Områdeschef har ändrats
                                                                }
                                                            }
                                                        }
                                                    } else if(!Agent.getIsOmradesChef(valdAgent) && chbOmradeschef.isSelected()){
                                                        if(cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
                                                            System.out.println("Du har inte valt vilket område agenten ska vara områdeschef för");
                                                        } else {
                                                            if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Inga tillgängliga ---")) {
                                                                JOptionPane.showMessageDialog(null, "Det finns inga agenter som är tillgängliga för att överta områdeschefsansvaret. Agenten kommer fortsatt vara områdeschef.");
                                                            } else {
                                                                String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                if(Agent.andraOmradesChef(valdAgent, nyOmradesChef)) {
                                                                    //Områdeschef har ändrats
                                                                }
                                                            }
                                                        }
                                                    }
                                                    
                                                    if(Agent.getIsFaltAgent(valdAgent) && !chbFaltagent.isSelected()) {
                                                        //Agenten är fältagent men ska inte längre vara det
                                                        if(Agent.taBortFaltAgent(valdAgent)) {
                                                            //Agenten är borttagen som fältagent
                                                        }
                                                    } else if(!Agent.getIsFaltAgent(valdAgent) && chbFaltagent.isSelected()) {
                                                        //Agenten är inte fältagent men ska vara det
                                                        if(Agent.gorTillFaltAgent(valdAgent)) {
                                                            //Agenten är gjord till fältagent
                                                        }
                                                    }
                                                    
                                                    if(Agent.getIsKontorsChef(valdAgent) && !chbKontorschef.isSelected()) {
                                                        //Agenten är kontorschef men ska inte längre vara det
                                                        if(Agent.taBortKontorsChef(valdAgent)) {
                                                            //Agenten är borttagen som kontorschef
                                                        }
                                                    } else if(!Agent.getIsKontorsChef(valdAgent) && chbKontorschef.isSelected()){
                                                        //Agenten är inte kontorschef men ska vara det
                                                        if(Agent.gorTillKontorsChef(valdAgent, nyAgentKontorsbeteckning)) {
                                                            //Agenten är gjord till kontorschef
                                                        }
                                                    }
                                                    if(Agent.uppdateraAgent(valdAgent, nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentAdmin)) {
                                                        JOptionPane.showMessageDialog(null, "Agenten har uppdaterats", "Uppdatering genomförd", JOptionPane.INFORMATION_MESSAGE);
                                                        new MenyAgent(id).setVisible(true);
                                                        dispose();
                                                    }
                                                }
                                            }

                                    } else {
                                        //Felmeddelande som visas när lösenordet som angivits är längre än 6 tecken
                                        JOptionPane.showMessageDialog(null, "Lösenordet du har angett är för långt. Max 6 tecken.", "Lösenordet är för långt", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    //Felmeddelande som visas när inget lösenord är angivet
                                    JOptionPane.showMessageDialog(null, "Du har inte angett något lösenord", "Lösenord saknas", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                //Felmeddelande som visas när telefonnumret är angivet i fel format
                                JOptionPane.showMessageDialog(null, "Telefonnumret är angivet i fel format. Telefonnummer måste anges i formatet \"012-3456.....\"", "Telefonnumret är felaktigt", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            //Felmeddelande som visas om telefonnumret är för långt
                            JOptionPane.showMessageDialog(null, "Telefonnumret du har angivit är för långt. Max 30 tecken.", "Telefonnumret är för långt", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        //Felmeddelande om telefonnummer inte är ifyllt
                        JOptionPane.showMessageDialog(null, "Du har inte angett något telefonnummer till agenten. Max 30 tecken långt.", "Telefonnummer saknas", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //Felmeddelande när namnet är för långt
                    JOptionPane.showMessageDialog(null, "Namnet du har angett är för långt. Max 15 tecken (exklusive \"Agent\")", "Namnet är för långt", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                //Felmeddelande om namnet som är angivet redan finns registrerat
                JOptionPane.showMessageDialog(null, "Det finns redan en användare med det namnet du har angett", "Namnet upptaget", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Felmeddelande som visas när inget namn är angivet
            JOptionPane.showMessageDialog(null, "Du har inte angett något namn. Max 15 tecken (exklusive \"Agent\")", "Namn saknas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void chbOmradeschefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbOmradeschefActionPerformed
        if(Agent.getIsOmradesChef(valdAgent) && !chbOmradeschef.isSelected()) {
            lblNyOmradesChefRubrik.setEnabled(true);
            cbNyOmradesChef.setEnabled(true);
        } else if(Agent.getIsOmradesChef(valdAgent) && chbOmradeschef.isSelected()) {
            lblNyOmradesChefRubrik.setEnabled(false);
            cbNyOmradesChef.setEnabled(false);
        }
        
    }//GEN-LAST:event_chbOmradeschefActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        
        if(Agent.isAnsvarigAgent(valdAgent)) {
            Alien.andraAnsvarigAgent(valdAgent, Agent.getForstaBastaAgentId());
            if(!Agent.getIsKontorsChef(valdAgent)) {
                if(!Agent.getIsOmradesChef(valdAgent)) {
                    if(Agent.taBort(valdAgent)) {
                        JOptionPane.showMessageDialog(null, "Agenten är borttagen");
                        //Om agenten som tas bort är densamma som är inloggad
                        if(valdAgent == id) {
                            //Öppna loginsidan igen
                            new Login().setVisible(true);
                            //Stäng det nuvarande fönstret
                            dispose();
                        //annars..
                        } else {
                            //Öppna agentermenyn
                            new MenyAgent(id).setVisible(true);
                            //Stäng det nuvarande fönstret
                            dispose();
                        } 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som är områdeschef. Redigera agenten och ange en ny områdeschef först.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som är kontorschef. Redigera agenten och ange en ny kontorschef först.");
            }
        } else {
            Alien.andraAnsvarigAgent(valdAgent, Agent.getForstaBastaAgentId());
            if(!Agent.getIsKontorsChef(valdAgent)) {
                if(!Agent.getIsOmradesChef(valdAgent)) {
                    if(Agent.taBort(valdAgent)) {
                        JOptionPane.showMessageDialog(null, "Agenten är borttagen");
                        //Om agenten som tas bort är densamma som är inloggad
                        if(valdAgent == id) {
                            //Öppna loginsidan igen
                            new Login().setVisible(true);
                            //Stäng det nuvarande fönstret
                            dispose();
                        //annars..
                        } else {
                            //Öppna agentermenyn
                            new MenyAgent(id).setVisible(true);
                            //Stäng det nuvarande fönstret
                            dispose();
                        } 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som är områdeschef. Redigera agenten och ange en ny områdeschef först.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som är kontorschef. Redigera agenten och ange en ny kontorschef först.");
            } 
        }
    }//GEN-LAST:event_btnTaBortActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNySokning;
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JComboBox<String> cbNyOmradesChef;
    private javax.swing.JComboBox<String> cbOmrade;
    private javax.swing.JCheckBox chbAdmin;
    private javax.swing.JCheckBox chbFaltagent;
    private javax.swing.JCheckBox chbKontorschef;
    private javax.swing.JCheckBox chbOmradeschef;
    private javax.swing.JLabel lblAgentRubrik;
    private javax.swing.JLabel lblAgenttypRubrik;
    private javax.swing.JLabel lblAnstallningsdatumRubrik;
    private javax.swing.JLabel lblKontorsbeteckningRubrik;
    private javax.swing.JLabel lblLosenordRubrik;
    private javax.swing.JLabel lblNamnRubrik;
    private javax.swing.JLabel lblNyOmradesChefRubrik;
    private javax.swing.JLabel lblOmradeRubrik;
    private javax.swing.JLabel lblTelefonRubrik;
    private javax.swing.JPasswordField pwLosenord;
    private javax.swing.JTextField txtAnstallningsdatum;
    private javax.swing.JTextField txtKontorsbeteckning;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
