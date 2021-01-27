package MiB.AgentViews;

import MiB.Agent;
import MiB.Omrade;
import MiB.Validering;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgentRegistrera extends javax.swing.JFrame {
    private static int id;
    
    public AgentRegistrera(int id) {
        initComponents();
        this.id = id;
        
        //G�m kontorsbeteckningsf�lt och label per default
        lblKontorsbeteckningRubrik.setVisible(false);
        txtKontorsbeteckning.setVisible(false);
        
        //H�mta platser och populera comboboxen
        hamtaPlatser();
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        lblNamnRubrik = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        lblTelefonRubrik = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        lblLosenordRubrik = new javax.swing.JLabel();
        pwLosenord = new javax.swing.JPasswordField();
        lblAgenttypRubrik = new javax.swing.JLabel();
        lblKontorsbeteckningRubrik = new javax.swing.JLabel();
        txtKontorsbeteckning = new javax.swing.JTextField();
        chbAdmin = new javax.swing.JCheckBox();
        lblOmradeRubrik = new javax.swing.JLabel();
        cbOmrade = new javax.swing.JComboBox<>();
        btnSpara = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        chbFaltagent = new javax.swing.JCheckBox();
        chbOmradeschef = new javax.swing.JCheckBox();
        chbKontorschef = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("G� tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblNamnRubrik.setText("Namn:");

        lblTelefonRubrik.setText("Telefonnummer:");

        lblLosenordRubrik.setText("L�senord:");

        lblAgenttypRubrik.setText("Agenttyp:");

        lblKontorsbeteckningRubrik.setText("Kontorsbeteckning:");

        chbAdmin.setText("Administrat�r");

        lblOmradeRubrik.setText("Omr�de:");

        cbOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj omr�de ---" }));

        btnSpara.setText("Spara");
        btnSpara.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        jLabel1.setText("Agent");

        chbFaltagent.setText("F�ltagent");

        chbOmradeschef.setText("Omr�deschef");

        chbKontorschef.setText("Kontorschef");
        chbKontorschef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbKontorschefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefon)
                    .addComponent(pwLosenord)
                    .addComponent(txtKontorsbeteckning)
                    .addComponent(cbOmrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSpara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamnRubrik)
                            .addComponent(lblTelefonRubrik)
                            .addComponent(lblLosenordRubrik)
                            .addComponent(lblAgenttypRubrik)
                            .addComponent(lblKontorsbeteckningRubrik)
                            .addComponent(chbAdmin)
                            .addComponent(lblOmradeRubrik)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chbFaltagent)
                                .addGap(18, 18, 18)
                                .addComponent(chbOmradeschef)
                                .addGap(18, 18, 18)
                                .addComponent(chbKontorschef)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNamnRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefonRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(12, 12, 12)
                .addComponent(lblKontorsbeteckningRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKontorsbeteckning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOmradeRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnSpara, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
       //Instansierar ett antal booleska variabler med v�rdet som returneras fr�n checkboxarnas isSelected()-metod
       boolean nyAgentKontorschef = chbKontorschef.isSelected();
       boolean nyAgentOmradeschef = chbOmradeschef.isSelected();
       boolean nyAgentFaltagent = chbFaltagent.isSelected();
       
       //Kontrollerar genom klassen Validerings metod txtFaltHarVarde att f�ltet txtNamn �r ifyllt
        if(Validering.txtFaltHarVarde(txtNamn)) {
            //Kontrollerar om namnet som �r ifyllt i f�ltet txtNamn inte �r taget av n�gon annan anv�ndare
            if(Agent.getLedigtNamn("Agent " + txtNamn.getText())) {
                //Kontrollerar att l�ngden p� str�ngen som returneras fr�n f�ltet txtNamn genom metoden getText() inte �verstiger 15 tecken
                if(Validering.valideraLangd(txtNamn.getText(), 1, 15)) {
                    //Skapar en ny str�ngvariabel med namnet nyAgentNamn och ger den v�rdet "Agent " f�ljt av det ifyllda namnet fr�n textf�ltet txtNamn genom metoden getText()
                    String nyAgentNamn = "Agent " + txtNamn.getText().toUpperCase();
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
                                        //Kontrollerar att minst en av checkboxarna f�r agenttyp �r markerad (och d�rmed true)
                                        if(nyAgentFaltagent || nyAgentOmradeschef || nyAgentKontorschef) {
                                            //Instansierar en ny str�ngvariabel med namnet nyAgentKontorsbeteckning
                                            String nyAgentKontorsbeteckning = "";
                                            //Om checkboxen chbKontorschef �r markerad
                                            if(nyAgentKontorschef) {
                                                //Kontrollerar om f�ltet txtKontorsbeteckning 
                                                if(Validering.txtFaltHarVarde(txtKontorsbeteckning)) {
                                                    if(Validering.valideraLangd(txtKontorsbeteckning.getText(), 1, 25)) {
                                                        nyAgentKontorsbeteckning = txtKontorsbeteckning.getText();
                                                        
                                                        String nyAgentOmrade = "";
                                                        if(cbOmrade.getSelectedItem().toString().isEmpty() || cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                            nyAgentOmrade = null;
                                                        } else {
                                                            nyAgentOmrade = cbOmrade.getSelectedItem().toString();
                                                        }
                                                        
                                                        boolean nyAgentAdmin = false;
                                                        if(chbAdmin.isSelected()) {
                                                            nyAgentAdmin = true;
                                                        } else {
                                                            nyAgentAdmin = false;
                                                        }
                                                        if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett vilket omr�de som agenten �r omr�deschef f�r", "Omr�de saknas", JOptionPane.ERROR_MESSAGE);
                                                        } else {
                                                            if(Agent.laggTill(nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentFaltagent, nyAgentOmradeschef, nyAgentKontorschef, nyAgentKontorsbeteckning, nyAgentAdmin)) {
                                                                JOptionPane.showMessageDialog(null, "Agenten har lagts till i databasen", "Agent tillagd", JOptionPane.INFORMATION_MESSAGE);
                                                                new MenyAgent(id).setVisible(true);
                                                                dispose();
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Ett fel uppstod n�r agenten skulle l�ggas till. F�rs�k igen.", "Agenten kunde inte l�ggas till", JOptionPane.ERROR_MESSAGE);
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
                                                
                                                //Kontrollerar om n�got omr�de �r valt
                                                String nyAgentOmrade = "";
                                                if(cbOmrade.getSelectedItem().toString().isEmpty() || cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                    nyAgentOmrade = null;
                                                } else {
                                                    //H�mtar v�rdet fr�n comboboxen cbOmrade, omvandlar det till en str�ng och instansierar variabeln nyAgentOmrade.
                                                    nyAgentOmrade = cbOmrade.getSelectedItem().toString();
                                                }    
                                                
                                                //S�tter variabeln nyAgentAdmin till true respektive false beroende p� om checkboxen chbAdmin �r markerad eller inte
                                                boolean nyAgentAdmin = false;
                                                if(chbAdmin.isSelected()) {
                                                    nyAgentAdmin = true;
                                                } else {
                                                    nyAgentAdmin = false;
                                                }
                                                if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- V�lj omr�de ---")) {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett vilket omr�de som agenten �r omr�deschef f�r", "Omr�de saknas", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    //F�rs�ker l�gga till agent med anv�ndning av klassen Agent och metoden laggTill(). Inparameter fr�n formul�ret.
                                                    if(Agent.laggTill(nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentFaltagent, nyAgentOmradeschef, nyAgentKontorschef, nyAgentKontorsbeteckning, nyAgentAdmin)) {
                                                        JOptionPane.showMessageDialog(null, "Agenten har lagts till i databasen", "Agent tillagd", JOptionPane.INFORMATION_MESSAGE);
                                                        new MenyAgent(id).setVisible(true);
                                                        dispose();
                                                    } else {
                                                        //Felmeddelande som visas n�r agent inte kunde l�ggas till
                                                        JOptionPane.showMessageDialog(null, "Ett fel uppstod n�r agenten skulle l�ggas till. F�rs�k igen.", "Agenten kunde inte l�ggas till", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                            }
                                        } else {
                                            //Felmeddelande som visas n�r ingen av checkboxarna f�r agenttyp �r markerade
                                            JOptionPane.showMessageDialog(null, "Du har inte valt vilken typ av agent du vill l�gga till", "Agenttyp saknas", JOptionPane.ERROR_MESSAGE);
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

    //Metod som k�rs n�r knappen G� tillbaka klickas p�
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Instansierar ett nytt objekt av klassen MenyAgent och visar f�nstret
        new MenyAgent(id).setVisible(true);
        //Sl�nger och st�nger det nuvarande f�nstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som k�rs n�r chbKontorschef (checkbox) klickas i/ur.
    private void chbKontorschefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbKontorschefActionPerformed
       //Om checkboxen �r markerad...
        if(chbKontorschef.isSelected()) {
           //Visa label och textf�lt
           lblKontorsbeteckningRubrik.setVisible(true);
           txtKontorsbeteckning.setVisible(true);
           //Forcerar en uppdatering p� JForm f�r att label och textf�lt visas n�r checkboxen �r ifylld
           this.repaint();
           this.revalidate();
       } else {
            //Om checkboxen inte �r markerad s� d�ljs b�de label och textf�lt
           lblKontorsbeteckningRubrik.setVisible(false);
           txtKontorsbeteckning.setVisible(false);
       }
        
    }//GEN-LAST:event_chbKontorschefActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox<String> cbOmrade;
    private javax.swing.JCheckBox chbAdmin;
    private javax.swing.JCheckBox chbFaltagent;
    private javax.swing.JCheckBox chbKontorschef;
    private javax.swing.JCheckBox chbOmradeschef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAgenttypRubrik;
    private javax.swing.JLabel lblKontorsbeteckningRubrik;
    private javax.swing.JLabel lblLosenordRubrik;
    private javax.swing.JLabel lblNamnRubrik;
    private javax.swing.JLabel lblOmradeRubrik;
    private javax.swing.JLabel lblTelefonRubrik;
    private javax.swing.JPasswordField pwLosenord;
    private javax.swing.JTextField txtKontorsbeteckning;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
