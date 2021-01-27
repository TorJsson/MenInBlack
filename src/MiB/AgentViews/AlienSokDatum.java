package MiB.AgentViews;

import MiB.Validering;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class AlienSokDatum extends javax.swing.JFrame {
private static int id;

    public AlienSokDatum(int id) {
        initComponents();
        this.id = id;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        txtSlutdatum.setText(LocalDate.now().format(format));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        txtStartdatum = new javax.swing.JTextField();
        lblStartdatum = new javax.swing.JLabel();
        lblSlutdatum = new javax.swing.JLabel();
        txtSlutdatum = new javax.swing.JTextField();
        btnHamta = new javax.swing.JButton();
        lblDatumSok = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - S�k efter datum");
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

        txtStartdatum.setText("------ Ange startdatum ------");
        txtStartdatum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStartdatumFocusGained(evt);
            }
        });

        lblStartdatum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblStartdatum.setText("Startdatum:");

        lblSlutdatum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSlutdatum.setText("Slutdatum:");

        txtSlutdatum.setText("------ Ange slutdatum ------");
        txtSlutdatum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSlutdatumFocusGained(evt);
            }
        });

        btnHamta.setText("H�mta");
        btnHamta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaActionPerformed(evt);
            }
        });

        lblDatumSok.setText("Ange start- respektive slutdatum i formatet YYYY-MM-DD.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(403, 403, 403))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHamta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblSlutdatum)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDatumSok)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtStartdatum, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSlutdatum, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(lblDatumSok))
                .addGap(18, 18, 18)
                .addComponent(lblStartdatum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSlutdatum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSlutdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addComponent(btnHamta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Metod som k�rs n�r man klickar p� G� tillbaka. �ppnar alienmenyn och st�nger det nuvarande f�nstret
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyAliens(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som k�rs n�r man klickar p� H�mta
    private void btnHamtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaActionPerformed
        //Kontrollerar att f�lten har fyllts i
        if(!Validering.txtFaltHarVarde(txtStartdatum) || !txtStartdatum.getText().equals("------ Ange startdatum ------")) {
            String startDatum = txtStartdatum.getText();
            if(!Validering.txtFaltHarVarde(txtSlutdatum) || !txtSlutdatum.getText().equals("------ Ange slutdatum ------")) {
                String slutDatum = txtSlutdatum.getText();
                //Kontrollerar att datumen �r i r�tt format
                if(Validering.valideraDatum(startDatum)) {
                    if(Validering.valideraDatum(slutDatum)) {
                        //�ppna resultatf�nster och st�ng s�kf�nstret
                        new AlienSokDatumResultat(id, startDatum, slutDatum).setVisible(true);
                        dispose();
                        
                //Annars visas felmeddelanden
                    } else {
                        JOptionPane.showMessageDialog(null, "Slutdatumet du har angett �r i fel format. Ange datum i formatet YYYY-MM-DD.", "Ett fel uppstod", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Startdatumet du har angett �r i fel format. Ange datum i formatet YYYY-MM-DD.", "Ett fel uppstod", JOptionPane.ERROR_MESSAGE);
                }
            } else { 
                JOptionPane.showMessageDialog(null, "Du har inte angett n�got slutdatum. Ange datum i formatet YYYY-MM-DD.", "Ett fel uppstod", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angett n�got startdatum. Ange datum i formatet YYYY-MM-DD.", "Ett fel uppstod", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHamtaActionPerformed

    //Metod som k�rs n�r slutdatumf�ltet f�r fokus. T�mmer textf�ltet.
    private void txtSlutdatumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSlutdatumFocusGained
        txtSlutdatum.setText("");
    }//GEN-LAST:event_txtSlutdatumFocusGained

    //Metod som k�rs n�r startdatumf�ltet f�r fokus. T�mmer textf�ltet.
    private void txtStartdatumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStartdatumFocusGained
        txtStartdatum.setText("");
    }//GEN-LAST:event_txtStartdatumFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHamta;
    private javax.swing.JLabel lblDatumSok;
    private javax.swing.JLabel lblSlutdatum;
    private javax.swing.JLabel lblStartdatum;
    private javax.swing.JTextField txtSlutdatum;
    private javax.swing.JTextField txtStartdatum;
    // End of variables declaration//GEN-END:variables
}
