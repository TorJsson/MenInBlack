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
        //D�ljer labeln och textf�ltet f�r rasattribut per default
        lblRasAttributRubrik.setVisible(false);
        txtRasAttribut.setVisible(false);
        txtRasAttribut.setText("");
        //Anropar hamtaPlatser() f�r att h�mta alla platsben�mningar 
        hamtaPlatser();
    }
    
    //Metod f�r att h�mta alla platsben�mningar, iterera igenom dom och fylla p� combobox-listan med platsben�mningar
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

        btnGoBack.setText("G� tillbaka");
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

        lblLosenord.setText("L�senord (Max 6 tecken)");

        pwLosenord.setText("------ Ange l�senord ------");
        pwLosenord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwLosenordFocusGained(evt);
            }
        });

        cbRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------ V�lj ras ------", "Boglodite", "Squid", "Worm" }));
        cbRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRasActionPerformed(evt);
            }
        });

        cbPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------ V�lj plats ------" }));

        btnLaggTill.setText("L�gg till");
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

    //Metod som k�rs n�r man klickar p� G� tillbaka. �ppnar nytt f�nster och st�nger det nuvarande
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyAliens(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som k�rs n�r namnf�ltet f�r fokus. T�mmer f�ltet.
    private void txtNamnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamnFocusGained
        txtNamn.setText("");
    }//GEN-LAST:event_txtNamnFocusGained

    //Metod som k�rs n�r telefonf�ltet f�r fokus. T�mmer f�ltet.
    private void txtTelefonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonFocusGained
        txtTelefon.setText("");
    }//GEN-LAST:event_txtTelefonFocusGained

    //Metod som k�rs n�r l�senordsf�ltet f�r fokus. T�mmer f�ltet.
    private void pwLosenordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwLosenordFocusGained
        pwLosenord.setText("");
    }//GEN-LAST:event_pwLosenordFocusGained

    private void btnLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillActionPerformed
        //Instansierar en int-variabel med namnet ansvarigAgent som f�r v�rdet av konstruktorns inparameter id.
        int ansvarigAgent = id;
        //Kontrollerar att namnf�ltet �r ifyllt
        if(Validering.txtFaltHarVarde(txtNamn)  && !txtNamn.getText().equals("------ Ange namn ------")) {
            //Kontrollerar att det angivna namnet �r ledigt genom klassen Validerings metod getLedigtNamn()
            if(Alien.getLedigtNamn(txtNamn.getText())){
                //Kontrollerar att namnet �r mellan 1 och 20 tecken l�ngt.
                if(Validering.valideraLangd(txtNamn.getText(), 1, 20)) {
                    String namnStrang = txtNamn.getText();
                    //Kontrollerar att telefonnummerf�ltet �r ifyllt
                    if(Validering.txtFaltHarVarde(txtTelefon) && !txtTelefon.getText().equals("------ Ange telefonnummer ------")) {
                        //Kontrollerar att telefonnumret �r mellan 1 och 30 tecken l�ngt.
                        if(Validering.valideraLangd(txtTelefon.getText(), 1, 30)) {
                            String telefonnummerStrang = txtTelefon.getText();
                            //Kontrollerar att telefonnumret �r i r�tt format
                            if(Validering.valideraTelefonnummer(txtTelefon.getText())) {
                                //Kontrollerar att l�senordsf�ltet �r ifyllt
                                if(Validering.pwdFaltHarVarde(pwLosenord) && !new String(pwLosenord.getPassword()).equals("------ Ange l�senord ------")) {
                                    //Kontrollerar att l�senordet �r mellan 1 och 6 tecken l�ngt
                                    if(Validering.valideraLangd(new String(pwLosenord.getPassword()), 1, 6)) {
                                        String losenordsStrang = new String(pwLosenord.getPassword());
                                        //Kontrollerar att en ras �r vald
                                        if(!cbRas.getSelectedItem().toString().isEmpty() && !cbRas.getSelectedItem().toString().equals("------ V�lj ras ------")) {
                                            String rasStrang = cbRas.getSelectedItem().toString();
                                                //Kontrollerar att en plats �r vald
                                                if(!cbPlats.getSelectedItem().toString().isEmpty() && !cbPlats.getSelectedItem().toString().equals("------ V�lj plats ------")) {
                                                    String platsStrang = cbPlats.getSelectedItem().toString();
                                                    //Kontrollerar om rasen �r Boglodite eller Squid
                                                    if(cbRas.getSelectedItem().equals("Boglodite") || cbRas.getSelectedItem().equals("Squid")) {
                                                        //Kontrollerar att f�ltet f�r rasattribut (antal armar/antal boogies) �r ifyllt
                                                        if(Validering.txtFaltHarVarde(txtRasAttribut)) {
                                                            //Kontrollerar att f�ltet f�r rasattribut enbart inneh�ller siffror
                                                            if(Validering.enbartSiffror(txtRasAttribut.getText())) {
                                                                //Kontrollerar att f�ltet rasattribut har mellan 1 och 10 tecken.
                                                                if(Validering.valideraLangd(txtRasAttribut.getText(), 1, 10)) {
                                                                    int rasAttribut = Integer.parseInt(txtRasAttribut.getText());
                                                                    //F�rs�ker l�gga till en alien
                                                                    if(Alien.laggTill(losenordsStrang, namnStrang, telefonnummerStrang, platsStrang, ansvarigAgent, rasStrang, rasAttribut)) {
                                                                        //Visar ett meddelande om att en alien �r tillagd
                                                                        JOptionPane.showMessageDialog(null, "En alien har lagts till i databasen");
                                                                        //G�r tillbaka till alienmenyn
                                                                        new MenyAliens(id).setVisible(true);
                                                                        //St�nger f�nstret
                                                                        dispose();
                                                                    //Visar ett felmeddelande om n�gonting gick fel n�r data skulle l�ggas till i databasen
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien skulle l�ggas till. F�rs�k igen.", "Ett fel har uppst�tt!", JOptionPane.ERROR_MESSAGE);
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
                                                        //F�rs�ker l�gga till en alien i databasen
                                                        if(Alien.laggTill(losenordsStrang, namnStrang, telefonnummerStrang, platsStrang, ansvarigAgent, rasStrang, 0)) {
                                                            //Visar ett meddelande om att en alien har lagts till
                                                            JOptionPane.showMessageDialog(null, "En alien har lagts till i databasen");
                                                            //G�r tillbaka till alienmenyn
                                                            new MenyAliens(id).setVisible(true);
                                                            //St�nger f�nstret
                                                            dispose();
                                                        //Felmeddelande om n�gonting gick fel n�r data skulle l�ggas till i databasen
                                                        } else {
                                                        JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien skulle l�ggas till. F�rs�k igen.", "Ett fel har uppst�tt!", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Namnet du vill anv�nda �r upptaget", "Det finns redan en anv�ndare med det namnet", JOptionPane.ERROR_MESSAGE);
            }
        //Felmeddelande om namnf�ltet �r tomt
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angett n�got namn", "Inget namn angett", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLaggTillActionPerformed

    private void cbRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRasActionPerformed
        //Kollar om Boglodite eller Squid �r valda i Raslistan
        if(cbRas.getSelectedItem().equals("Boglodite") || cbRas.getSelectedItem().equals("Squid")) {
            //H�mtar r�tt typ av rasattribut ("antal boogies"/"antal armar")
            String rasAttribut =  Alien.getRasAttribut(cbRas.getSelectedItem().toString());
            //Visar rubriken f�r rasattribut
            lblRasAttributRubrik.setVisible(true);
            //S�tter labeln f�r rasattribut till det som st�mmer f�r den valda rasen
            lblRasAttributRubrik.setText(rasAttribut);
            //Visar textf�ltet f�r rasattribut
            txtRasAttribut.setVisible(true);
            //T�mmer textf�ltet
            txtRasAttribut.setText("");
        //Om rasen �r annan �n Boglodite och Squid (exv Worms)
        } else {
            //D�ljer labeln rasattribut
            lblRasAttributRubrik.setVisible(false);
            //D�ljer textf�ltet f�r rasattribut
            txtRasAttribut.setVisible(false);
            //T�mmer textf�ltet p� inneh�ll
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
