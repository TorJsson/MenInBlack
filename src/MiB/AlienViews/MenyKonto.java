package MiB.AlienViews;

import MiB.Alien;
import MiB.Omrade;
import MiB.Plats;

/**
 *
 * @author Mikael Boggian
 */
public class MenyKonto extends javax.swing.JFrame {
    private static int id;
   
    public MenyKonto(int id) {
        initComponents();
        this.id = id;
        uppdateraSida();
    }
    
    private void uppdateraSida() {
        String namn = Alien.getNamnById(id);
        String omradeId = Plats.getBenamningById(id);
        String omradeNamn = Omrade.getBenamningById(Plats.getFinnsIById(id));
        String registreringsdatum = Alien.getRegistreringsdatumById(id);
        String telefonnummer = Alien.getTelefonnummerById(id);
        String ras = Alien.getRas(id);
        
        lblNamn.setText(namn);
        lblId.setText(Integer.toString(id));
        lblOmrade.setText(omradeId + ", " + omradeNamn);
        lblRegistreringsdatum.setText(registreringsdatum);
        lblTelefonnummer.setText(telefonnummer);
        lblRas.setText(ras);
        //Fyll bara fälten lblRasInfoRubrik och lblRasInfo om alien är boglodite eller squid.
        if(ras == "Boglodite" || ras == "Squid") {
            String rasAttribut = Alien.getRasAttribut(ras);
            int rasAttributData = Alien.getRasAttributData(ras, id);
            lblRasInfoRubrik.setText(rasAttribut + ":");
            lblRasInfo.setText(Integer.toString(rasAttributData));
        } else {
            lblRasInfoRubrik.setText("");
            lblRasInfo.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlData = new javax.swing.JPanel();
        lblNamnRubrik = new javax.swing.JLabel();
        lblTelefonnummerRubrik = new javax.swing.JLabel();
        lblOmradeRubrik = new javax.swing.JLabel();
        lblRegistreringsdatumRubrik = new javax.swing.JLabel();
        lblIdRubrik = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTelefonnummer = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblRegistreringsdatum = new javax.swing.JLabel();
        lblRasRubrik = new javax.swing.JLabel();
        lblRas = new javax.swing.JLabel();
        lblRasInfoRubrik = new javax.swing.JLabel();
        lblRasInfo = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        btnOpenBytLosenord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Kontoinformation");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setName("kontoViewAlien"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblNamnRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNamnRubrik.setLabelFor(lblNamn);
        lblNamnRubrik.setText("Namn:");

        lblTelefonnummerRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefonnummerRubrik.setLabelFor(lblTelefonnummer);
        lblTelefonnummerRubrik.setText("Telefonnummer:");

        lblOmradeRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeRubrik.setLabelFor(lblOmrade);
        lblOmradeRubrik.setText("Plats:");

        lblRegistreringsdatumRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistreringsdatumRubrik.setLabelFor(lblRegistreringsdatum);
        lblRegistreringsdatumRubrik.setText("Registreringsdatum:");

        lblIdRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdRubrik.setLabelFor(lblId);
        lblIdRubrik.setText("ID:");

        lblNamn.setForeground(new java.awt.Color(51, 51, 51));
        lblNamn.setText("$namn");

        lblId.setForeground(new java.awt.Color(51, 51, 51));
        lblId.setText("$id");

        lblTelefonnummer.setForeground(new java.awt.Color(51, 51, 51));
        lblTelefonnummer.setText("$telefonnummer");

        lblOmrade.setForeground(new java.awt.Color(51, 51, 51));
        lblOmrade.setText("$plats, $område");

        lblRegistreringsdatum.setForeground(new java.awt.Color(51, 51, 51));
        lblRegistreringsdatum.setText("$regdatum");

        lblRasRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasRubrik.setLabelFor(lblRas);
        lblRasRubrik.setText("Ras:");

        lblRas.setForeground(new java.awt.Color(51, 51, 51));
        lblRas.setText("$ras");

        lblRasInfoRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasInfoRubrik.setText("$rasInfo");

        lblRasInfo.setText("$rasInfo");

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamnRubrik)
                            .addComponent(lblIdRubrik)
                            .addComponent(lblTelefonnummerRubrik)
                            .addComponent(lblOmradeRubrik))
                        .addGap(42, 42, 42)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOmrade)
                            .addComponent(lblTelefonnummer)
                            .addComponent(lblId)
                            .addComponent(lblNamn)))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegistreringsdatumRubrik)
                            .addComponent(lblRasRubrik)
                            .addComponent(lblRasInfoRubrik))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRasInfo)
                            .addComponent(lblRas)
                            .addComponent(lblRegistreringsdatum))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamnRubrik)
                    .addComponent(lblNamn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdRubrik)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonnummerRubrik)
                    .addComponent(lblTelefonnummer))
                .addGap(7, 7, 7)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradeRubrik)
                    .addComponent(lblOmrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistreringsdatumRubrik)
                    .addComponent(lblRegistreringsdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRasRubrik)
                    .addComponent(lblRas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRasInfoRubrik)
                    .addComponent(lblRasInfo))
                .addContainerGap(257, Short.MAX_VALUE))
        );

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnOpenBytLosenord.setText("Byt lösenord");
        btnOpenBytLosenord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnOpenBytLosenord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpenBytLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenBytLosenordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpenBytLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpenBytLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new AlienStart(id).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnOpenBytLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenBytLosenordActionPerformed
        new KontoBytLosenord(id).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnOpenBytLosenordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnOpenBytLosenord;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdRubrik;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblNamnRubrik;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblOmradeRubrik;
    private javax.swing.JLabel lblRas;
    private javax.swing.JLabel lblRasInfo;
    private javax.swing.JLabel lblRasInfoRubrik;
    private javax.swing.JLabel lblRasRubrik;
    private javax.swing.JLabel lblRegistreringsdatum;
    private javax.swing.JLabel lblRegistreringsdatumRubrik;
    private javax.swing.JLabel lblTelefonnummer;
    private javax.swing.JLabel lblTelefonnummerRubrik;
    private javax.swing.JPanel pnlData;
    // End of variables declaration//GEN-END:variables
}
