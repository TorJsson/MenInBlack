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
        //D�ljer label och textf�lt f�r kontorsbeteckning per default
        lblKontorsbeteckningRubrik.setEnabled(false);
        txtKontorsbeteckning.setEnabled(false);
        
        //D�ljer label och textf�lt f�r ny omr�deschef per default
        lblNyOmradesChefRubrik.setEnabled(false);
        cbNyOmradesChef.setEnabled(false);
        
        //Anropar metoden hamtaPlatser()
        hamtaPlatser();
        
        //Anropar metoden hamtaAgentData()
        hamtaAgentData();
        
        //Anropar metoden hamtaMojligaOmradeschefer()
        hamtaMojligaOmradeschefer();
    }
    
    //Metod som h�mtar alla omr�desnamn fr�n databasen och l�gger till dom p� nya rader i comboboxen cbOmrade
    private void hamtaPlatser() {
        //Instansierar arrayList med namnet allaOmraden som f�r v�rdet som returneras genom klassen Omrades metod getAllaOmradesBenamningar()
        ArrayList<String> allaOmraden = Omrade.getAllaOmradesBenamningar();
        
        //Itererar igenom resultatsetet allaOmraden och l�gger till varje returnerat v�rde som ett item i comboboxen cbOmrade genom metoden addItem().
        for(String omrade : allaOmraden) {
            cbOmrade.addItem(omrade);
        }
    }
    
    //H�mtar en lista �ver agenters namn som i nul�get inte �r omr�deschefer
    private void hamtaMojligaOmradeschefer() {
        ArrayList<String> agenter = Agent.listaAgenterUtanOmradesAnsvar();
        
        //Om arrayListen �ver agenter inte �r tom...
        if(agenter != null) {
            //s� itererar vi igenom resultaten
            for(String agent: agenter) {
                //... och l�gger till namnen i comboboxen
                cbNyOmradesChef.addItem(agent);
            }
        //Om arrayListen �r tom...
        } else {
            //.. s� tar removeAllItems() tar bort default-valet "--- V�lj agent ---"
            cbNyOmradesChef.removeAllItems();
            //l�gger till "--- Inga tillg�ngliga ---"
            cbNyOmradesChef.addItem("--- Inga tillg�ngliga ---");
        }
        
    }
    
    //Metod f�r att h�mta agentdata f�r den valda agenten
    private void hamtaAgentData() {
        HashMap<String, String> agentData = Agent.getAgentDataById(valdAgent);
        //Sparar resultaten som str�ngar
            String agentNamn = agentData.get("NAMN");
            String agentAnstallningsdatum = agentData.get("ANSTALLNINGSDATUM");
            String agentTelefonnummer = agentData.get("TELEFON");
            String agentLosenord = agentData.get("LOSENORD");
            String agentOmradeNamn = agentData.get("BENAMNING");
            String agentAdminStatus = agentData.get("ADMINISTRATOR");
            
            //Kontrollerar om agenten �r administrat�r och instansierar agentArAdmin som en boolesk variabel med true/false.
            boolean agentArAdmin = false;
            if(agentAdminStatus.equals("J")) {
                agentArAdmin = true;
            } else {
                agentArAdmin = false;
            }
            
            //Instansierar booleska variabler som representerar huruvida en agent �r f�ltagent/omr�deschef/kontorschef.
            boolean agentArFaltagent = Agent.getIsFaltAgent(valdAgent);
            boolean agentArOmradeschef = Agent.getIsOmradesChef(valdAgent);
            boolean agentArKontorschef = Agent.getIsKontorsChef(valdAgent);
            
            //Kontrollerar om agenten �r kontorschef
            String agentKontorsbeteckning = "";
            if(agentArKontorschef) {
                //Visar txtKontorsbeteckning och lblKontorsbeteckningRubrik
                txtKontorsbeteckning.setEnabled(true);
                lblKontorsbeteckningRubrik.setEnabled(true);
                //Lagrar kontorsbeteckningen som en str�ng
                agentKontorsbeteckning = Agent.getKontorsbeteckningById(valdAgent);
            }
            
            //Fyller i sidans f�lt
            //Vi vill bara fylla i textf�ltet med det som kommer efter "Agent " i namnet som sparats i databasen. Anv�nder split() och h�mtar ut det som finns p� den 1a positionen i arrayen
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

        lblLosenordRubrik.setText("L�senord:");

        chbOmradeschef.setText("Omr�deschef");
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

        chbAdmin.setText("Administrat�r");

        btnNySokning.setText("Ny s�kning");
        btnNySokning.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNySokning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNySokningActionPerformed(evt);
            }
        });

        lblOmradeRubrik.setText("Omr�de:");

        lblNamnRubrik.setText("Namn:");

        cbOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj omr�de ---" }));

        btnSpara.setText("Spara");
        btnSpara.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        lblTelefonRubrik.setText("Telefonnummer:");

        lblAgentRubrik.setText("Agent");

        chbFaltagent.setText("F�ltagent");

        lblAnstallningsdatumRubrik.setText("Anst�llningsdatum:");

        txtAnstallningsdatum.setEnabled(false);

        lblNyOmradesChefRubrik.setText("V�lj ny omr�deschef:");

        cbNyOmradesChef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj agent ---" }));

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
        //Om checkboxen �r markerad...
        if(chbKontorschef.isSelected()) {
            //Visa label och textf�lt
            lblKontorsbeteckningRubrik.setEnabled(true);
            txtKontorsbeteckning.setEnabled(true);
            //Forcerar en uppdatering p� JForm f�r att label och textf�lt ska visas n�r checkboxen �r markerad
            this.repaint();
            this.revalidate();
        } else {
            //Om checkboxen inte �r markerad s� d�ljs b�de label och textf�lt
            lblKontorsbeteckningRubrik.setEnabled(false);
            txtKontorsbeteckning.setEnabled(false);
        }

    }//GEN-LAST:event_chbKontorschefActionPerformed

    private void btnNySokningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNySokningActionPerformed
        //Instansierar ett nytt objekt av klassen MenyAgent och visar f�nstret
        new MenyAgent(id).setVisible(true);
        //Sl�nger och st�nger det nuvarande f�nstret
        dispose();
    }//GEN-LAST:event_btnNySokningActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        //Instansierar ett antal booleska variabler med v�rdet som returneras fr�n checkboxarnas isSelected()-metod
        boolean nyAgentKontorschef = chbKontorschef.isSelected();
        boolean nyAgentOmradeschef = chbOmradeschef.isSelected();
        boolean nyAgentFaltagent = chbFaltagent.isSelected();

        //Validerar att f�lt �r ifylla
        
        //Kontrollerar genom klassen Validerings metod txtFaltHarVarde att f�ltet txtNamn �r ifyllt
        if(Validering.txtFaltHarVarde(txtNamn)) {
            //Skapar en ny str�ngvariabel med namnet nyAgentNamn och ger den v�rdet "Agent " f�ljt av det ifyllda namnet fr�n textf�ltet txtNamn genom metoden getText()
            String nyAgentNamn = "Agent " + txtNamn.getText().toUpperCase();
            //Kontrollerar om namnet som �r ifyllt i f�ltet txtNamn inte �r taget av n�gon annan anv�ndare
            if(Agent.getLedigtNamn(nyAgentNamn) || nyAgentNamn.equals(Agent.getNamnById(valdAgent))) {
                //Kontrollerar att l�ngden p� str�ngen som returneras fr�n f�ltet txtNamn genom metoden getText() inte �verstiger 15 tecken
                if(Validering.valideraLangd(txtNamn.getText(), 1, 15)) {
                    
                    //Kontrollerar genom klassen Validerings metod txtFaltHarVarde att f�ltet txtTelefon �r ifyllt
                    if(Validering.txtFaltHarVarde(txtTelefon)) {
                        //Kontrollerar genom klassen Validerings metod valideraLangd att v�rdet fr�n f�ltet txtTelefon (genom metoden getText()) �r mellan 1 och 30 tecken l�ngt
                        if(Validering.valideraLangd(txtTelefon.getText(), 1, 30)) {
                            //Kontrollerar med klassen Validerings metod valideraTelefonnummer() att telefonnumret �r i r�tt format (NNN-NNNNN.....)
                            if(Validering.valideraTelefonnummer(txtTelefon.getText())) {
                                //Instansierar en ny str�ngvariabel nyAgentTelefon med v�rdet fr�n textf�ltet txtTelefon genom metoden getText().
                                String nyAgentTelefon = txtTelefon.getText();
                                //Kontrollerar genom klassen Validerings metod pwdFaltHarVarde() att l�senordsf�ltet pwLosenord �r ifyllt
                                if(Validering.pwdFaltHarVarde(pwLosenord)) {
                                    //Instansierar en ny str�ngvariabel med genom att h�mta arrayen fr�n f�ltet pwLosenord genom metoden getPassword() och skapa en str�ng av den arrayen.
                                    String nyAgentLosenord = new String(pwLosenord.getPassword());
                                    //Anv�nder klassen Validerings metod valideraLangd() f�r att kontrollera att l�senordet �r mellan 1 och 6 tecken l�ngt
                                    if(Validering.valideraLangd(nyAgentLosenord, 1, 6)) {                                        
                                            //Instansierar en ny str�ngvariabel med namnet nyAgentKontorsbeteckning
                                            String nyAgentKontorsbeteckning = "";
                                            
                                            //Kontrollerar om n�got omr�de �r valt
                                            String nyAgentOmrade = "";
                                            if(cbOmrade.getSelectedItem().toString().isEmpty() || cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                nyAgentOmrade = null;
                                            } else {
                                                //H�mtar v�rdet fr�n comboboxen cbOmrade, omvandlar det till en str�ng och instansierar variabeln nyAgentOmrade.
                                                nyAgentOmrade = cbOmrade.getSelectedItem().toString();
                                            }
                                            
                                            boolean nyAgentAdmin = false;
                                            if(chbAdmin.isSelected()) {
                                                nyAgentAdmin = true;
                                            } else {
                                                nyAgentAdmin = false;
                                            }
                                            //Kontrollerar om checkboxen chbKontorschef �r markerad
                                            if(nyAgentKontorschef) {
                                                //Kontrollerar om f�ltet txtKontorsbeteckning �r ifyllt
                                                if(Validering.txtFaltHarVarde(txtKontorsbeteckning)) {
                                                    if(Validering.valideraLangd(txtKontorsbeteckning.getText(), 1, 25)) {
                                                        nyAgentKontorsbeteckning = txtKontorsbeteckning.getText();
                                                        if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett vilket omr�de som agenten �r omr�deschef f�r", "Omr�de saknas", JOptionPane.ERROR_MESSAGE);
                                                        } else {
                                                               //Kontrollerar om agenten i nul�get �r omr�deschef men inte l�ngre ska vara det. G�r is�fall en �ndring i omr�deschefstabellen.
                                                            if(Agent.getIsOmradesChef(valdAgent) && !chbOmradeschef.isSelected()){
                                                                if(cbNyOmradesChef.getSelectedItem().toString().equals("--- V�lj agent ---")) {
                                                                    System.out.println("Du har inte valt en agent som ers�tter den du redigerar som omr�deschef");
                                                                } else {
                                                                    if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
                                                                        JOptionPane.showMessageDialog(null, "Det finns inga agenter som �r tillg�ngliga f�r att �verta omr�deschefsansvaret. Agenten kommer fortsatt vara omr�deschef.");
                                                                    } else {
                                                                        String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                        if(Agent.andraOmradesChef(valdAgent, nyOmradesChef)) {
                                                                            //Omr�deschef har �ndrats
                                                                        }
                                                                    }
                                                                }
                                                            } else if(!Agent.getIsOmradesChef(valdAgent) && chbOmradeschef.isSelected()){
                                                                if(cbNyOmradesChef.getSelectedItem().toString().equals("--- V�lj agent ---")) {
                                                                    System.out.println("Du har inte valt vilket omr�de agenten ska vara omr�deschef f�r");
                                                                } else {
                                                                    String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                    if(Agent.gorTillOmradesChef(valdAgent, nyAgentOmrade)) {
                                                                        //Agenten har gjorts till omr�deschef
                                                                    }
                                                                }
                                                            }

                                                            if(Agent.getIsFaltAgent(valdAgent) && !chbFaltagent.isSelected()) {
                                                                //Agenten �r f�ltagent men ska inte l�ngre vara det
                                                                if(Agent.taBortFaltAgent(valdAgent)) {
                                                                    //Agenten �r borttagen som f�ltagent
                                                                }
                                                            } else if(!Agent.getIsFaltAgent(valdAgent) && chbFaltagent.isSelected()) {
                                                                //Agenten �r inte f�ltagent men ska vara det
                                                                if(Agent.gorTillFaltAgent(valdAgent)) {
                                                                    //Agenten �r gjord till f�ltagent
                                                                }
                                                            }

                                                            if(Agent.getIsKontorsChef(valdAgent) && !chbKontorschef.isSelected()) {
                                                                //Agenten �r kontorschef men ska inte l�ngre vara det
                                                                if(Agent.taBortKontorsChef(valdAgent)) {
                                                                    //Agenten �r borttagen som kontorschef
                                                                }
                                                            } else if(!Agent.getIsKontorsChef(valdAgent) && chbKontorschef.isSelected()){
                                                                //Agenten �r inte kontorschef men ska vara det
                                                                if(Agent.gorTillKontorsChef(valdAgent, nyAgentKontorsbeteckning)) {
                                                                    //Agenten �r gjord till kontorschef
                                                                }
                                                            }
                                                            
                                                            //F�rs�ker genomf�ra uppdateringen
                                                            if(Agent.uppdateraAgent(valdAgent, nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentAdmin)) {
                                                                //Om uppdateringen lyckas s� visas ett meddelande. �terg�r till agentmenyn och st�nger redigeringsf�nstret
                                                                JOptionPane.showMessageDialog(null, "Agenten har uppdaterats", "Uppdatering genomf�rd", JOptionPane.INFORMATION_MESSAGE);
                                                                new MenyAgent(id).setVisible(true);
                                                                dispose();
                                                            }
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Kontorsbeteckningen du har angivit �r f�r l�ng. Max 25 tecken.", "Kontorsbeteckningen �r f�r l�ng", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                } else {
                                                    //Ingen kontorsbeteckning
                                                    JOptionPane.showMessageDialog(null, "Du har inte angivit n�gon kontorsbeteckning f�r kontorschefen", "Kontorsbeteckning saknas", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } else {
                                                nyAgentKontorsbeteckning = "";
                                                if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                        JOptionPane.showMessageDialog(null, "Du har inte angett vilket omr�de som agenten �r omr�deschef f�r", "Omr�de saknas", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    //Kontrollerar om agenten i nul�get �r omr�deschef men inte l�ngre ska vara det. G�r is�fall en �ndring i omr�deschefstabellen.
                                                    if(Agent.getIsOmradesChef(valdAgent) && !chbOmradeschef.isSelected()){
                                                        if(cbNyOmradesChef.getSelectedItem().toString().equals("--- V�lj agent ---")) {
                                                            System.out.println("Du har inte valt en agent som ers�tter den du redigerar som omr�deschef");
                                                        } else {
                                                            if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
                                                                 JOptionPane.showMessageDialog(null, "Det finns inga agenter som �r tillg�ngliga f�r att �verta omr�deschefsansvaret. Agenten kommer fortsatt vara omr�deschef.");
                                                            } else {
                                                                String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                if(Agent.andraOmradesChef(valdAgent, nyOmradesChef)) {
                                                                    //Omr�deschef har �ndrats
                                                                }
                                                            }
                                                        }
                                                    } else if(!Agent.getIsOmradesChef(valdAgent) && chbOmradeschef.isSelected()){
                                                        if(cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                            System.out.println("Du har inte valt vilket omr�de agenten ska vara omr�deschef f�r");
                                                        } else {
                                                            if(cbNyOmradesChef.getSelectedItem().toString().equals("--- Inga tillg�ngliga ---")) {
                                                                JOptionPane.showMessageDialog(null, "Det finns inga agenter som �r tillg�ngliga f�r att �verta omr�deschefsansvaret. Agenten kommer fortsatt vara omr�deschef.");
                                                            } else {
                                                                String nyOmradesChef = cbNyOmradesChef.getSelectedItem().toString();
                                                                if(Agent.andraOmradesChef(valdAgent, nyOmradesChef)) {
                                                                    //Omr�deschef har �ndrats
                                                                }
                                                            }
                                                        }
                                                    }
                                                    
                                                    if(Agent.getIsFaltAgent(valdAgent) && !chbFaltagent.isSelected()) {
                                                        //Agenten �r f�ltagent men ska inte l�ngre vara det
                                                        if(Agent.taBortFaltAgent(valdAgent)) {
                                                            //Agenten �r borttagen som f�ltagent
                                                        }
                                                    } else if(!Agent.getIsFaltAgent(valdAgent) && chbFaltagent.isSelected()) {
                                                        //Agenten �r inte f�ltagent men ska vara det
                                                        if(Agent.gorTillFaltAgent(valdAgent)) {
                                                            //Agenten �r gjord till f�ltagent
                                                        }
                                                    }
                                                    
                                                    if(Agent.getIsKontorsChef(valdAgent) && !chbKontorschef.isSelected()) {
                                                        //Agenten �r kontorschef men ska inte l�ngre vara det
                                                        if(Agent.taBortKontorsChef(valdAgent)) {
                                                            //Agenten �r borttagen som kontorschef
                                                        }
                                                    } else if(!Agent.getIsKontorsChef(valdAgent) && chbKontorschef.isSelected()){
                                                        //Agenten �r inte kontorschef men ska vara det
                                                        if(Agent.gorTillKontorsChef(valdAgent, nyAgentKontorsbeteckning)) {
                                                            //Agenten �r gjord till kontorschef
                                                        }
                                                    }
                                                    if(Agent.uppdateraAgent(valdAgent, nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentAdmin)) {
                                                        JOptionPane.showMessageDialog(null, "Agenten har uppdaterats", "Uppdatering genomf�rd", JOptionPane.INFORMATION_MESSAGE);
                                                        new MenyAgent(id).setVisible(true);
                                                        dispose();
                                                    }
                                                }
                                            }

                                    } else {
                                        //Felmeddelande som visas n�r l�senordet som angivits �r l�ngre �n 6 tecken
                                        JOptionPane.showMessageDialog(null, "L�senordet du har angett �r f�r l�ngt. Max 6 tecken.", "L�senordet �r f�r l�ngt", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    //Felmeddelande som visas n�r inget l�senord �r angivet
                                    JOptionPane.showMessageDialog(null, "Du har inte angett n�got l�senord", "L�senord saknas", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                //Felmeddelande som visas n�r telefonnumret �r angivet i fel format
                                JOptionPane.showMessageDialog(null, "Telefonnumret �r angivet i fel format. Telefonnummer m�ste anges i formatet \"012-3456.....\"", "Telefonnumret �r felaktigt", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            //Felmeddelande som visas om telefonnumret �r f�r l�ngt
                            JOptionPane.showMessageDialog(null, "Telefonnumret du har angivit �r f�r l�ngt. Max 30 tecken.", "Telefonnumret �r f�r l�ngt", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        //Felmeddelande om telefonnummer inte �r ifyllt
                        JOptionPane.showMessageDialog(null, "Du har inte angett n�got telefonnummer till agenten. Max 30 tecken l�ngt.", "Telefonnummer saknas", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //Felmeddelande n�r namnet �r f�r l�ngt
                    JOptionPane.showMessageDialog(null, "Namnet du har angett �r f�r l�ngt. Max 15 tecken (exklusive \"Agent\")", "Namnet �r f�r l�ngt", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                //Felmeddelande om namnet som �r angivet redan finns registrerat
                JOptionPane.showMessageDialog(null, "Det finns redan en anv�ndare med det namnet du har angett", "Namnet upptaget", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Felmeddelande som visas n�r inget namn �r angivet
            JOptionPane.showMessageDialog(null, "Du har inte angett n�got namn. Max 15 tecken (exklusive \"Agent\")", "Namn saknas", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(null, "Agenten �r borttagen");
                        //Om agenten som tas bort �r densamma som �r inloggad
                        if(valdAgent == id) {
                            //�ppna loginsidan igen
                            new Login().setVisible(true);
                            //St�ng det nuvarande f�nstret
                            dispose();
                        //annars..
                        } else {
                            //�ppna agentermenyn
                            new MenyAgent(id).setVisible(true);
                            //St�ng det nuvarande f�nstret
                            dispose();
                        } 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som �r omr�deschef. Redigera agenten och ange en ny omr�deschef f�rst.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som �r kontorschef. Redigera agenten och ange en ny kontorschef f�rst.");
            }
        } else {
            Alien.andraAnsvarigAgent(valdAgent, Agent.getForstaBastaAgentId());
            if(!Agent.getIsKontorsChef(valdAgent)) {
                if(!Agent.getIsOmradesChef(valdAgent)) {
                    if(Agent.taBort(valdAgent)) {
                        JOptionPane.showMessageDialog(null, "Agenten �r borttagen");
                        //Om agenten som tas bort �r densamma som �r inloggad
                        if(valdAgent == id) {
                            //�ppna loginsidan igen
                            new Login().setVisible(true);
                            //St�ng det nuvarande f�nstret
                            dispose();
                        //annars..
                        } else {
                            //�ppna agentermenyn
                            new MenyAgent(id).setVisible(true);
                            //St�ng det nuvarande f�nstret
                            dispose();
                        } 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som �r omr�deschef. Redigera agenten och ange en ny omr�deschef f�rst.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du kan inte ta bort en agent som �r kontorschef. Redigera agenten och ange en ny kontorschef f�rst.");
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
