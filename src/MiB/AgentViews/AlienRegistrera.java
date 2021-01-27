package MiB.AgentViews;

import MiB.Alien;
import MiB.Plats;
import MiB.Validering;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AlienRegistrera extends javax.swing.JFrame {
    private static int id;

    public AlienRegistrera(int id) {
        initComponents();
        this.id = id;
        //Döljer labeln och textfältet för rasattribut per default
        lblRasAttributRubrik.setVisible(false);
        txtRasAttribut.setVisible(false);
        txtRasAttribut.setText("");
        //Anropar hamtaPlatser() för att hämta alla platsbenämningar 
        hamtaPlatser();
    }
    
    //Metod för att hämta alla platsbenämningar, iterera igenom dom och fylla på combobox-listan med platsbenämningar
    private void hamtaPlatser() {
        ArrayList<String> allaPlatser = Plats.getAllaPlatsNamn();
        
        for(String plats : allaPlatser) {
            cbPlats.addItem(plats);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        txtNamn = new javax.swing.JTextField();
        lblNamn = new javax.swing.JLabel();
        lblTelefonnummerRubrik = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        lblLosenord = new javax.swing.JLabel();
        pwLosenord = new javax.swing.JPasswordField();
        cbRas = new javax.swing.JComboBox<>();
        cbPlats = new javax.swing.JComboBox<>();
        btnLaggTill = new javax.swing.JButton();
        lblRasRubrik = new javax.swing.JLabel();
        lblPlatsRubrik = new javax.swing.JLabel();
        lblRasAttributRubrik = new javax.swing.JLabel();
        txtRasAttribut = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Registrera ny alien");
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

        txtNamn.setText("------ Ange namn ------");
        txtNamn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamnFocusGained(evt);
            }
        });

        lblNamn.setText("Namn (Max 20 tecken)");

        lblTelefonnummerRubrik.setText("Telefonnummer (Max 30 tecken. Anges i formatet \"123-456789....\")");
        lblTelefonnummerRubrik.setToolTipText("");

        txtTelefon.setText("------ Ange telefonnummer ------");
        txtTelefon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonFocusGained(evt);
            }
        });

        lblLosenord.setText("Lösenord (Max 6 tecken)");

        pwLosenord.setText("------ Ange lösenord ------");
        pwLosenord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwLosenordFocusGained(evt);
            }
        });

        cbRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------ Välj ras ------", "Boglodite", "Squid", "Worm" }));
        cbRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRasActionPerformed(evt);
            }
        });

        cbPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------ Välj plats ------" }));

        btnLaggTill.setText("Lägg till");
        btnLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillActionPerformed(evt);
            }
        });

        lblRasRubrik.setText("Ras");

        lblPlatsRubrik.setText("Plats");

        lblRasAttributRubrik.setText("RasAttribut");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamn)
                    .addComponent(txtTelefon)
                    .addComponent(pwLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(cbRas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRasAttribut)
                    .addComponent(cbPlats, 0, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamn)
                            .addComponent(lblTelefonnummerRubrik)
                            .addComponent(lblLosenord)
                            .addComponent(lblRasRubrik)
                            .addComponent(lblRasAttributRubrik)
                            .addComponent(lblPlatsRubrik))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGoBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLaggTill, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNamn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefonnummerRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRasRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRasAttributRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRasAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlatsRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLaggTill)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som körs när man klickar på Gå tillbaka. Öppnar nytt fönster och stänger det nuvarande
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyAliens(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som körs när namnfältet får fokus. Tömmer fältet.
    private void txtNamnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamnFocusGained
        txtNamn.setText("");
    }//GEN-LAST:event_txtNamnFocusGained

    //Metod som körs när telefonfältet får fokus. Tömmer fältet.
    private void txtTelefonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonFocusGained
        txtTelefon.setText("");
    }//GEN-LAST:event_txtTelefonFocusGained

    //Metod som körs när lösenordsfältet får fokus. Tömmer fältet.
    private void pwLosenordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwLosenordFocusGained
        pwLosenord.setText("");
    }//GEN-LAST:event_pwLosenordFocusGained

    private void btnLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillActionPerformed
        //Instansierar en int-variabel med namnet ansvarigAgent som får värdet av konstruktorns inparameter id.
        int ansvarigAgent = id;
        //Kontrollerar att namnfältet är ifyllt
        if(Validering.txtFaltHarVarde(txtNamn)  && !txtNamn.getText().equals("------ Ange namn ------")) {
            //Kontrollerar att det angivna namnet är ledigt genom klassen Validerings metod getLedigtNamn()
            if(Alien.getLedigtNamn(txtNamn.getText())){
                //Kontrollerar att namnet är mellan 1 och 20 tecken långt.
                if(Validering.valideraLangd(txtNamn.getText(), 1, 20)) {
                    String namnStrang = txtNamn.getText();
                    //Kontrollerar att telefonnummerfältet är ifyllt
                    if(Validering.txtFaltHarVarde(txtTelefon) && !txtTelefon.getText().equals("------ Ange telefonnummer ------")) {
                        //Kontrollerar att telefonnumret är mellan 1 och 30 tecken långt.
                        if(Validering.valideraLangd(txtTelefon.getText(), 1, 30)) {
                            String telefonnummerStrang = txtTelefon.getText();
                            //Kontrollerar att telefonnumret är i rätt format
                            if(Validering.valideraTelefonnummer(txtTelefon.getText())) {
                                //Kontrollerar att lösenordsfältet är ifyllt
                                if(Validering.pwdFaltHarVarde(pwLosenord) && !new String(pwLosenord.getPassword()).equals("------ Ange lösenord ------")) {
                                    //Kontrollerar att lösenordet är mellan 1 och 6 tecken långt
                                    if(Validering.valideraLangd(new String(pwLosenord.getPassword()), 1, 6)) {
                                        String losenordsStrang = new String(pwLosenord.getPassword());
                                        //Kontrollerar att en ras är vald
                                        if(!cbRas.getSelectedItem().toString().isEmpty() && !cbRas.getSelectedItem().toString().equals("------ Välj ras ------")) {
                                            String rasStrang = cbRas.getSelectedItem().toString();
                                                //Kontrollerar att en plats är vald
                                                if(!cbPlats.getSelectedItem().toString().isEmpty() && !cbPlats.getSelectedItem().toString().equals("------ Välj plats ------")) {
                                                    String platsStrang = cbPlats.getSelectedItem().toString();
                                                    //Kontrollerar om rasen är Boglodite eller Squid
                                                    if(cbRas.getSelectedItem().equals("Boglodite") || cbRas.getSelectedItem().equals("Squid")) {
                                                        //Kontrollerar att fältet för rasattribut (antal armar/antal boogies) är ifyllt
                                                        if(Validering.txtFaltHarVarde(txtRasAttribut)) {
                                                            //Kontrollerar att fältet för rasattribut enbart innehåller siffror
                                                            if(Validering.enbartSiffror(txtRasAttribut.getText())) {
                                                                //Kontrollerar att fältet rasattribut har mellan 1 och 10 tecken.
                                                                if(Validering.valideraLangd(txtRasAttribut.getText(), 1, 10)) {
                                                                    int rasAttribut = Integer.parseInt(txtRasAttribut.getText());
                                                                    //Försöker lägga till en alien
                                                                    if(Alien.laggTill(losenordsStrang, namnStrang, telefonnummerStrang, platsStrang, ansvarigAgent, rasStrang, rasAttribut)) {
                                                                        //Visar ett meddelande om att en alien är tillagd
                                                                        JOptionPane.showMessageDialog(null, "En alien har lagts till i databasen");
                                                                        //Går tillbaka till alienmenyn
                                                                        new MenyAliens(id).setVisible(true);
                                                                        //Stänger fönstret
                                                                        dispose();
                                                                    //Visar ett felmeddelande om någonting gick fel när data skulle läggas till i databasen
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Någonting gick fel när alien skulle läggas till. Försök igen.", "Ett fel har uppstått!", JOptionPane.ERROR_MESSAGE);
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
                                                        //Försöker lägga till en alien i databasen
                                                        if(Alien.laggTill(losenordsStrang, namnStrang, telefonnummerStrang, platsStrang, ansvarigAgent, rasStrang, 0)) {
                                                            //Visar ett meddelande om att en alien har lagts till
                                                            JOptionPane.showMessageDialog(null, "En alien har lagts till i databasen");
                                                            //Går tillbaka till alienmenyn
                                                            new MenyAliens(id).setVisible(true);
                                                            //Stänger fönstret
                                                            dispose();
                                                        //Felmeddelande om någonting gick fel när data skulle läggas till i databasen
                                                        } else {
                                                        JOptionPane.showMessageDialog(null, "Någonting gick fel när alien skulle läggas till. Försök igen.", "Ett fel har uppstått!", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Namnet du vill använda är upptaget", "Det finns redan en användare med det namnet", JOptionPane.ERROR_MESSAGE);
            }
        //Felmeddelande om namnfältet är tomt
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angett något namn", "Inget namn angett", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLaggTillActionPerformed

    private void cbRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRasActionPerformed
        //Kollar om Boglodite eller Squid är valda i Raslistan
        if(cbRas.getSelectedItem().equals("Boglodite") || cbRas.getSelectedItem().equals("Squid")) {
            //Hämtar rätt typ av rasattribut ("antal boogies"/"antal armar")
            String rasAttribut =  Alien.getRasAttribut(cbRas.getSelectedItem().toString());
            //Visar rubriken för rasattribut
            lblRasAttributRubrik.setVisible(true);
            //Sätter labeln för rasattribut till det som stämmer för den valda rasen
            lblRasAttributRubrik.setText(rasAttribut);
            //Visar textfältet för rasattribut
            txtRasAttribut.setVisible(true);
            //Tömmer textfältet
            txtRasAttribut.setText("");
        //Om rasen är annan än Boglodite och Squid (exv Worms)
        } else {
            //Döljer labeln rasattribut
            lblRasAttributRubrik.setVisible(false);
            //Döljer textfältet för rasattribut
            txtRasAttribut.setVisible(false);
            //Tömmer textfältet på innehåll
            txtRasAttribut.setText("");
        }
    }//GEN-LAST:event_cbRasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnLaggTill;
    private javax.swing.JComboBox<String> cbPlats;
    private javax.swing.JComboBox<String> cbRas;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPlatsRubrik;
    private javax.swing.JLabel lblRasAttributRubrik;
    private javax.swing.JLabel lblRasRubrik;
    private javax.swing.JLabel lblTelefonnummerRubrik;
    private javax.swing.JPasswordField pwLosenord;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtRasAttribut;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
