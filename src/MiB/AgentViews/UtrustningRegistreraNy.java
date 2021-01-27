package MiB.AgentViews;

import MiB.Fordon;
import MiB.Kommunikation;
import MiB.Teknik;
import MiB.Validering;
import MiB.Vapen;
import javax.swing.JOptionPane;

public class UtrustningRegistreraNy extends javax.swing.JFrame {
    private static int id;
    
    public UtrustningRegistreraNy(int id) {
        initComponents();
        this.id = id;
        
        
        //Döljer alla labels och fält per default
        lblBenamningRubrik.setVisible(false);
        txtBenamning.setVisible(false);
        lblAttributRubrik.setVisible(false);
        txtAttribut.setVisible(false);
        lblFordonIdRubrik.setVisible(false);
        txtFordonId.setVisible(false);
        lblFordonArsmodellRubrik.setVisible(false);
        txtFordonArsmodell.setVisible(false);
        lblFordonBeskrivningRubrik.setVisible(false);
        txtFordonBeskrivning.setVisible(false);
        lblFordonsRegDatumRubrik.setVisible(false);
        txtFordonRegDatum.setVisible(false);
        
    }
    
    private void genereraFormular() {
        String kategori = cbKategori.getSelectedItem().toString();
        
        //Visar labels och fält beroende på vald kategori i combobox
        if(kategori.equals("Fordon")) {
            lblBenamningRubrik.setVisible(false);
            txtBenamning.setVisible(false);
            lblAttributRubrik.setVisible(false);
            txtAttribut.setVisible(false);
            lblFordonIdRubrik.setVisible(true);
            txtFordonId.setVisible(true);
            lblFordonArsmodellRubrik.setVisible(true);
            txtFordonArsmodell.setVisible(true);
            lblFordonBeskrivningRubrik.setVisible(true);
            txtFordonBeskrivning.setVisible(true);
            lblFordonsRegDatumRubrik.setVisible(true);
            txtFordonRegDatum.setVisible(true);
        } else if(kategori.equals("Kommunikation")) {
            lblAttributRubrik.setText("Överföringsteknik:");
            txtAttribut.setText("--- Ange överföringsteknik ---");
            lblBenamningRubrik.setVisible(true);
            txtBenamning.setVisible(true);
            lblAttributRubrik.setVisible(true);
            txtAttribut.setVisible(true);
            lblFordonIdRubrik.setVisible(false);
            txtFordonId.setVisible(false);
            lblFordonArsmodellRubrik.setVisible(false);
            txtFordonArsmodell.setVisible(false);
            lblFordonBeskrivningRubrik.setVisible(false);
            txtFordonBeskrivning.setVisible(false);
            lblFordonsRegDatumRubrik.setVisible(false);
            txtFordonRegDatum.setVisible(false);
        } else if(kategori.equals("Teknik")) {
            lblAttributRubrik.setText("Kraftkälla:");
            txtAttribut.setText("--- Ange kraftkälla ---");
            lblBenamningRubrik.setVisible(true);
            txtBenamning.setVisible(true);
            lblAttributRubrik.setVisible(true);
            txtAttribut.setVisible(true);
            lblFordonIdRubrik.setVisible(false);    
            txtFordonId.setVisible(false);
            lblFordonArsmodellRubrik.setVisible(false);
            txtFordonArsmodell.setVisible(false);
            lblFordonBeskrivningRubrik.setVisible(false);
            txtFordonBeskrivning.setVisible(false);
            lblFordonsRegDatumRubrik.setVisible(false);
            txtFordonRegDatum.setVisible(false);
        } else if(kategori.equals("Vapen")) {
            lblAttributRubrik.setText("Kaliber:");
            txtAttribut.setText("--- Ange kaliber ---");
            lblBenamningRubrik.setVisible(true);
            txtBenamning.setVisible(true);
            lblAttributRubrik.setVisible(true);
            txtAttribut.setVisible(true);
            lblFordonIdRubrik.setVisible(false);
            txtFordonId.setVisible(false);
            lblFordonArsmodellRubrik.setVisible(false);
            txtFordonArsmodell.setVisible(false);
            lblFordonBeskrivningRubrik.setVisible(false);
            txtFordonBeskrivning.setVisible(false);
            lblFordonsRegDatumRubrik.setVisible(false);
            txtFordonRegDatum.setVisible(false);
        }
    
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        lblBenamningRubrik = new javax.swing.JLabel();
        txtBenamning = new javax.swing.JTextField();
        lblAttributRubrik = new javax.swing.JLabel();
        txtAttribut = new javax.swing.JTextField();
        btnLaggTill = new javax.swing.JButton();
        lblFordonBeskrivningRubrik = new javax.swing.JLabel();
        txtFordonBeskrivning = new javax.swing.JTextField();
        lblFordonsRegDatumRubrik = new javax.swing.JLabel();
        txtFordonRegDatum = new javax.swing.JTextField();
        lblFordonArsmodellRubrik = new javax.swing.JLabel();
        txtFordonArsmodell = new javax.swing.JTextField();
        cbKategori = new javax.swing.JComboBox<>();
        lblFordonIdRubrik = new javax.swing.JLabel();
        txtFordonId = new javax.swing.JTextField();

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

        lblBenamningRubrik.setText("Benämning: (Max 20 tecken)");

        txtBenamning.setText("--- Ange benämning ---");
        txtBenamning.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBenamningFocusGained(evt);
            }
        });

        lblAttributRubrik.setText("$attribut:");

        txtAttribut.setText("--- Ange $attribut ---");
        txtAttribut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAttributFocusGained(evt);
            }
        });

        btnLaggTill.setText("Lägg till");
        btnLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillActionPerformed(evt);
            }
        });

        lblFordonBeskrivningRubrik.setText("Beskrivning:");

        txtFordonBeskrivning.setText("--- Ange fordonsbeskrivning ---");
        txtFordonBeskrivning.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFordonBeskrivningFocusGained(evt);
            }
        });

        lblFordonsRegDatumRubrik.setText("Registreringsdatum:");

        txtFordonRegDatum.setText("--- Ange registreringsdatum ---");
        txtFordonRegDatum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFordonRegDatumFocusGained(evt);
            }
        });

        lblFordonArsmodellRubrik.setText("Årsmodell:");

        txtFordonArsmodell.setText("--- Ange årsmodell ---");
        txtFordonArsmodell.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFordonArsmodellFocusGained(evt);
            }
        });

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Välj en kategori ---", "Fordon", "Vapen", "Kommunikation", "Teknik" }));
        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });

        lblFordonIdRubrik.setText("Fordons-ID:");

        txtFordonId.setText("--- Ange fordons-ID ---");
        txtFordonId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFordonIdFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBenamning)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBenamningRubrik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAttribut)
                    .addComponent(btnLaggTill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFordonId)
                    .addComponent(txtFordonBeskrivning)
                    .addComponent(txtFordonRegDatum)
                    .addComponent(txtFordonArsmodell)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAttributRubrik)
                            .addComponent(lblFordonIdRubrik)
                            .addComponent(lblFordonBeskrivningRubrik)
                            .addComponent(lblFordonsRegDatumRubrik)
                            .addComponent(lblFordonArsmodellRubrik))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addGap(12, 12, 12)
                .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBenamningRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBenamning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAttributRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFordonIdRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFordonId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFordonBeskrivningRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFordonBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFordonsRegDatumRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFordonRegDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFordonArsmodellRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFordonArsmodell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnLaggTill, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyUtrustning(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriActionPerformed
        genereraFormular();
    }//GEN-LAST:event_cbKategoriActionPerformed

    private void btnLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillActionPerformed
        String kategori = cbKategori.getSelectedItem().toString();
        
        if(kategori.equals("Fordon")) {
            //Kontrollera att fordonsID är ifyllt
            if(Validering.txtFaltHarVarde(txtFordonId) && !txtFordonId.getText().equals("--- Ange fordons-ID ---")) {
                //Kontrollera att fordonsID är mellan 1 och 6 tecken långt
                if(Validering.valideraLangd(txtFordonId.getText(), 1, 6)) {
                    //Kontrollera att beskrivning är ifyllt
                    if(Validering.txtFaltHarVarde(txtFordonBeskrivning) && !txtFordonBeskrivning.getText().equals("--- Ange fordonsbeskrivning ---")){
                        //Kontrollera längd på beskrivning
                        if(Validering.valideraLangd(txtFordonBeskrivning.getText(), 1, 100)) {
                            //Kontrollera att regdatum är ifyllt
                            if(Validering.txtFaltHarVarde(txtFordonRegDatum) && !txtFordonRegDatum.getText().equals("--- Ange registreringsdatum ---")) {
                                //Kontrollera format på datum
                                if(Validering.valideraDatum(txtFordonRegDatum.getText())) {
                                    //Kontrollera att årsmodell är ifyllt
                                    if(Validering.txtFaltHarVarde(txtFordonArsmodell) && !txtFordonArsmodell.getText().equals("--- Ange årsmodell ---")) {
                                        //Kontrollera att årsmodell enbart innehåller siffror
                                        if(Validering.enbartSiffror(txtFordonArsmodell.getText())) {
                                            if(Validering.valideraLangd(txtFordonArsmodell.getText(), 4, 4)) {
                                                if(Fordon.ledigtId(txtFordonId.getText())) {
                                                    if(Fordon.laggTill(txtFordonId.getText(), txtFordonBeskrivning.getText(), txtFordonRegDatum.getText(), Integer.parseInt(txtFordonArsmodell.getText()))) {
                                                        JOptionPane.showMessageDialog(null, "Fordonet har lagts till", "Fordon tillagt", JOptionPane.INFORMATION_MESSAGE);
                                                        new MenyUtrustning(id).setVisible(true);
                                                        dispose();
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Det fordons-ID du har angivit är upptaget. Försök med ett annat.", "Fordons-ID", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Årsmodell är angivet i fel format. Ange årtal, exempelvis \"2000\"", "Årsmodell", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Årsmodell får bara innehålla siffror. Ange årtal, exempelvis \"2000\"", "Årsmodell", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ingen årsmodell angiven. Ange årtal, exempelvis \"2000\"", "Årsmodell", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Registreringsdatum är angivet i fel format. Ange YYYY-MM-DD.", "Registreringsdatum", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Inget registreringsdatum angivet. Ange YYYY-MM-DD.", "Registreringsdatum", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Fordonsbeskrivningen du har angett är för lång. Max 100 tecken.", "Fordonsbeskrivning", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingen fordonsbeskrivning angiven. Max 100 tecken.", "Fordonsbeskrivning", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fordons-ID är för långt. Max 6 tecken.", "Fordons-ID", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inget fordons-ID angivet. Max 6 tecken.", "Fordons-ID", JOptionPane.ERROR_MESSAGE);
            }
            
            
        } else if(kategori.equals("Kommunikation")) {
            if(Validering.txtFaltHarVarde(txtBenamning) && !txtBenamning.getText().equals("--- Ange benämning ---")) {
                if(Validering.valideraLangd(txtBenamning.getText(), 1, 20)) {
                    if(Validering.txtFaltHarVarde(txtAttribut) && !txtAttribut.getText().equals("--- Ange överföringsteknik ---")) {
                        if(Validering.valideraLangd(txtAttribut.getText(), 1, 20)) {
                            if(Kommunikation.laggTill(txtBenamning.getText(), txtAttribut.getText())) {
                                JOptionPane.showMessageDialog(null, "Utrustningen har lagts till", "Utrustning tillagd", JOptionPane.INFORMATION_MESSAGE);
                                new MenyUtrustning(id).setVisible(true);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Någonting gick fel när utrustningen skulle läggas till. Försök igen.", "Ett fel uppstod", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                        JOptionPane.showMessageDialog(null, "Angivet värde i fältet Överföringsteknik är för långt. Max 20 tecken.", "Överföringsteknik", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingen överföringsteknik angiven. Max 20 tecken.", "Överföringsteknik", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Benämningen är för lång. Max 20 tecken.", "Benämning", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingen benämning angiven. Max 20 tecken.", "Benämning", JOptionPane.ERROR_MESSAGE);
            }
        } else if(kategori.equals("Teknik")) {
            if(Validering.txtFaltHarVarde(txtBenamning) && !txtBenamning.getText().equals("--- Ange benämning ---")) {
                if(Validering.valideraLangd(txtBenamning.getText(), 1, 20)) {
                    if(Validering.txtFaltHarVarde(txtAttribut) && !txtAttribut.getText().equals("--- Ange kraftkälla ---")) {
                        if(Validering.valideraLangd(txtAttribut.getText(), 1, 20)) {
                            if(Teknik.laggTill(txtBenamning.getText(), txtAttribut.getText())) {
                                JOptionPane.showMessageDialog(null, "Utrustningen har lagts till", "Utrustning tillagd", JOptionPane.INFORMATION_MESSAGE);
                                new MenyUtrustning(id).setVisible(true);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Någonting gick fel när utrustningen skulle läggas till. Försök igen.", "Ett fel uppstod", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                        JOptionPane.showMessageDialog(null, "Angivet värde i fältet Kraftkälla är för lång. Max 20 tecken.", "Kraftkälla", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingen kraftkälla angiven. Max 20 tecken.", "Kraftkälla", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Benämningen är för lång. Max 20 tecken.", "Benämning", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingen benämning angiven. Max 20 tecken.", "Benämning", JOptionPane.ERROR_MESSAGE);
            }
        } else if(kategori.equals("Vapen")) {
            if(Validering.txtFaltHarVarde(txtBenamning) && !txtBenamning.getText().equals("--- Ange benämning ---")) {
                if(Validering.valideraLangd(txtBenamning.getText(), 1, 20)) {
                    if(Validering.txtFaltHarVarde(txtAttribut) && !txtAttribut.getText().equals("--- Ange kaliber ---")) {
                        if(Validering.valideraLangd(txtAttribut.getText(), 1, 10)) {
                            if(Validering.enbartSiffror(txtAttribut.getText())) {
                                if(Vapen.laggTill(txtBenamning.getText(), Integer.parseInt(txtAttribut.getText()))) {
                                    JOptionPane.showMessageDialog(null, "Utrustningen har lagts till", "Utrustning tillagd", JOptionPane.INFORMATION_MESSAGE);
                                    new MenyUtrustning(id).setVisible(true);
                                    dispose();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Någonting gick fel när utrustningen skulle läggas till. Försök igen.", "Ett fel uppstod", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Kaliber måste anges i siffror.", "Kaliber", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                        JOptionPane.showMessageDialog(null, "Angivet värde i fältet Kaliber är för långt. Max 10 tecken.", "Kaliber", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingen kaliber angiven. Max 10 tecken.", "Kaliber", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Benämningen är för lång. Max 20 tecken.", "Benämning", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingen benämning angiven. Max 20 tecken.", "Benämning", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Välj en kategori", "Ingen kategori vald", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLaggTillActionPerformed

    private void txtBenamningFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBenamningFocusGained
        txtBenamning.setText("");
    }//GEN-LAST:event_txtBenamningFocusGained

    private void txtAttributFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAttributFocusGained
        txtAttribut.setText("");
    }//GEN-LAST:event_txtAttributFocusGained

    private void txtFordonIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFordonIdFocusGained
        txtFordonId.setText("");
    }//GEN-LAST:event_txtFordonIdFocusGained

    private void txtFordonBeskrivningFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFordonBeskrivningFocusGained
        txtFordonBeskrivning.setText("");
    }//GEN-LAST:event_txtFordonBeskrivningFocusGained

    private void txtFordonRegDatumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFordonRegDatumFocusGained
        txtFordonRegDatum.setText("");
    }//GEN-LAST:event_txtFordonRegDatumFocusGained

    private void txtFordonArsmodellFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFordonArsmodellFocusGained
        txtFordonArsmodell.setText("");
    }//GEN-LAST:event_txtFordonArsmodellFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnLaggTill;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JLabel lblAttributRubrik;
    private javax.swing.JLabel lblBenamningRubrik;
    private javax.swing.JLabel lblFordonArsmodellRubrik;
    private javax.swing.JLabel lblFordonBeskrivningRubrik;
    private javax.swing.JLabel lblFordonIdRubrik;
    private javax.swing.JLabel lblFordonsRegDatumRubrik;
    private javax.swing.JTextField txtAttribut;
    private javax.swing.JTextField txtBenamning;
    private javax.swing.JTextField txtFordonArsmodell;
    private javax.swing.JTextField txtFordonBeskrivning;
    private javax.swing.JTextField txtFordonId;
    private javax.swing.JTextField txtFordonRegDatum;
    // End of variables declaration//GEN-END:variables
}
