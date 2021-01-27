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
        
        //Göm kontorsbeteckningsfält och label per default
        lblKontorsbeteckningRubrik.setVisible(false);
        txtKontorsbeteckning.setVisible(false);
        
        //Hämta platser och populera comboboxen
        hamtaPlatser();
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

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblNamnRubrik.setText("Namn:");

        lblTelefonRubrik.setText("Telefonnummer:");

        lblLosenordRubrik.setText("Lösenord:");

        lblAgenttypRubrik.setText("Agenttyp:");

        lblKontorsbeteckningRubrik.setText("Kontorsbeteckning:");

        chbAdmin.setText("Administratör");

        lblOmradeRubrik.setText("Område:");

        cbOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj område ---" }));

        btnSpara.setText("Spara");
        btnSpara.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        jLabel1.setText("Agent");

        chbFaltagent.setText("Fältagent");

        chbOmradeschef.setText("Områdeschef");

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
       //Instansierar ett antal booleska variabler med värdet som returneras från checkboxarnas isSelected()-metod
       boolean nyAgentKontorschef = chbKontorschef.isSelected();
       boolean nyAgentOmradeschef = chbOmradeschef.isSelected();
       boolean nyAgentFaltagent = chbFaltagent.isSelected();
       
       //Kontrollerar genom klassen Validerings metod txtFaltHarVarde att fältet txtNamn är ifyllt
        if(Validering.txtFaltHarVarde(txtNamn)) {
            //Kontrollerar om namnet som är ifyllt i fältet txtNamn inte är taget av någon annan användare
            if(Agent.getLedigtNamn("Agent " + txtNamn.getText())) {
                //Kontrollerar att längden på strängen som returneras från fältet txtNamn genom metoden getText() inte överstiger 15 tecken
                if(Validering.valideraLangd(txtNamn.getText(), 1, 15)) {
                    //Skapar en ny strängvariabel med namnet nyAgentNamn och ger den värdet "Agent " följt av det ifyllda namnet från textfältet txtNamn genom metoden getText()
                    String nyAgentNamn = "Agent " + txtNamn.getText().toUpperCase();
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
                                        //Kontrollerar att minst en av checkboxarna för agenttyp är markerad (och därmed true)
                                        if(nyAgentFaltagent || nyAgentOmradeschef || nyAgentKontorschef) {
                                            //Instansierar en ny strängvariabel med namnet nyAgentKontorsbeteckning
                                            String nyAgentKontorsbeteckning = "";
                                            //Om checkboxen chbKontorschef är markerad
                                            if(nyAgentKontorschef) {
                                                //Kontrollerar om fältet txtKontorsbeteckning 
                                                if(Validering.txtFaltHarVarde(txtKontorsbeteckning)) {
                                                    if(Validering.valideraLangd(txtKontorsbeteckning.getText(), 1, 25)) {
                                                        nyAgentKontorsbeteckning = txtKontorsbeteckning.getText();
                                                        
                                                        String nyAgentOmrade = "";
                                                        if(cbOmrade.getSelectedItem().toString().isEmpty() || cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
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
                                                        if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett vilket område som agenten är områdeschef för", "Område saknas", JOptionPane.ERROR_MESSAGE);
                                                        } else {
                                                            if(Agent.laggTill(nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentFaltagent, nyAgentOmradeschef, nyAgentKontorschef, nyAgentKontorsbeteckning, nyAgentAdmin)) {
                                                                JOptionPane.showMessageDialog(null, "Agenten har lagts till i databasen", "Agent tillagd", JOptionPane.INFORMATION_MESSAGE);
                                                                new MenyAgent(id).setVisible(true);
                                                                dispose();
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Ett fel uppstod när agenten skulle läggas till. Försök igen.", "Agenten kunde inte läggas till", JOptionPane.ERROR_MESSAGE);
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
                                                
                                                //Kontrollerar om något område är valt
                                                String nyAgentOmrade = "";
                                                if(cbOmrade.getSelectedItem().toString().isEmpty() || cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
                                                    nyAgentOmrade = null;
                                                } else {
                                                    //Hämtar värdet från comboboxen cbOmrade, omvandlar det till en sträng och instansierar variabeln nyAgentOmrade.
                                                    nyAgentOmrade = cbOmrade.getSelectedItem().toString();
                                                }    
                                                
                                                //Sätter variabeln nyAgentAdmin till true respektive false beroende på om checkboxen chbAdmin är markerad eller inte
                                                boolean nyAgentAdmin = false;
                                                if(chbAdmin.isSelected()) {
                                                    nyAgentAdmin = true;
                                                } else {
                                                    nyAgentAdmin = false;
                                                }
                                                if(nyAgentOmradeschef && cbOmrade.getSelectedItem().toString().equals("--- Välj område ---")) {
                                                            JOptionPane.showMessageDialog(null, "Du har inte angett vilket område som agenten är områdeschef för", "Område saknas", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    //Försöker lägga till agent med användning av klassen Agent och metoden laggTill(). Inparameter från formuläret.
                                                    if(Agent.laggTill(nyAgentLosenord, nyAgentNamn, nyAgentTelefon, nyAgentOmrade, nyAgentFaltagent, nyAgentOmradeschef, nyAgentKontorschef, nyAgentKontorsbeteckning, nyAgentAdmin)) {
                                                        JOptionPane.showMessageDialog(null, "Agenten har lagts till i databasen", "Agent tillagd", JOptionPane.INFORMATION_MESSAGE);
                                                        new MenyAgent(id).setVisible(true);
                                                        dispose();
                                                    } else {
                                                        //Felmeddelande som visas när agent inte kunde läggas till
                                                        JOptionPane.showMessageDialog(null, "Ett fel uppstod när agenten skulle läggas till. Försök igen.", "Agenten kunde inte läggas till", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                            }
                                        } else {
                                            //Felmeddelande som visas när ingen av checkboxarna för agenttyp är markerade
                                            JOptionPane.showMessageDialog(null, "Du har inte valt vilken typ av agent du vill lägga till", "Agenttyp saknas", JOptionPane.ERROR_MESSAGE);
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

    //Metod som körs när knappen Gå tillbaka klickas på
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //Instansierar ett nytt objekt av klassen MenyAgent och visar fönstret
        new MenyAgent(id).setVisible(true);
        //Slänger och stänger det nuvarande fönstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som körs när chbKontorschef (checkbox) klickas i/ur.
    private void chbKontorschefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbKontorschefActionPerformed
       //Om checkboxen är markerad...
        if(chbKontorschef.isSelected()) {
           //Visa label och textfält
           lblKontorsbeteckningRubrik.setVisible(true);
           txtKontorsbeteckning.setVisible(true);
           //Forcerar en uppdatering på JForm för att label och textfält visas när checkboxen är ifylld
           this.repaint();
           this.revalidate();
       } else {
            //Om checkboxen inte är markerad så döljs både label och textfält
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
