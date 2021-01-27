package MiB.AlienViews;

import MiB.Agent;
import MiB.Alien;
import MiB.Omrade;
import MiB.Plats;

public class OmradeListaAliensVisaMer extends javax.swing.JFrame {
    private static int id;
    private static int valdAlienId;
    private static int ansvarigAgentId;
    private static String ansvarigAgent;
    private static String alienNamn;
    private static String alienTelefon;
    private static int alienPlatsId;
    private static String alienPlats;
    private static String alienOmrade;
    
    public OmradeListaAliensVisaMer(int id, int valdAlienId) {
        initComponents();
        this.id = id;
        this.valdAlienId = valdAlienId;
        uppdateraSida();
    }
    
    private void uppdateraSida() {
        //Hämta från databasen
        String namn = Alien.getNamnById(valdAlienId);
        String omradeId = Plats.getBenamningById(valdAlienId);
        String omradeNamn = Omrade.getBenamningById(Plats.getFinnsIById(valdAlienId));
        String registreringsdatum = Alien.getRegistreringsdatumById(valdAlienId);
        String telefonnummer = Alien.getTelefonnummerById(valdAlienId);
        String ras = Alien.getRas(valdAlienId);
        
        //Fyll i fält
        lblNamn.setText(namn);
        lblId.setText(Integer.toString(valdAlienId));
        lblOmrade.setText(omradeId + ", " + omradeNamn);
        lblRegistreringsdatum.setText(registreringsdatum);
        lblTelefonnummer.setText(telefonnummer);
        lblRas.setText(ras);
        //Fyll bara fälten lblRasInfoRubrik och lblRasInfo om alien är boglodite eller squid.
        if(ras == "Boglodite" || ras == "Squid") {
            String rasAttribut = Alien.getRasAttribut(ras);
            int rasAttributData = Alien.getRasAttributData(ras, valdAlienId);
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

        jPanel1 = new javax.swing.JPanel();
        lblNamnRubrik = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblIdRubrik = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTelefonnummerRubrik = new javax.swing.JLabel();
        lblTelefonnummer = new javax.swing.JLabel();
        lblOmradeRubrik = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblRegistreringsdatumRubrik = new javax.swing.JLabel();
        lblRegistreringsdatum = new javax.swing.JLabel();
        lblRasRubrik = new javax.swing.JLabel();
        lblRas = new javax.swing.JLabel();
        lblRasInfoRubrik = new javax.swing.JLabel();
        lblRasInfo = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Visa information om alien");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblNamnRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNamnRubrik.setText("Namn:");

        lblNamn.setText("$alienNamn");

        lblIdRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdRubrik.setText("ID:");

        lblId.setForeground(new java.awt.Color(51, 51, 51));
        lblId.setText("$id");

        lblTelefonnummerRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefonnummerRubrik.setText("Telefonnummer:");

        lblTelefonnummer.setForeground(new java.awt.Color(51, 51, 51));
        lblTelefonnummer.setText("$telefonnummer");

        lblOmradeRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeRubrik.setText("Plats:");

        lblOmrade.setForeground(new java.awt.Color(51, 51, 51));
        lblOmrade.setText("$plats, $område");

        lblRegistreringsdatumRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistreringsdatumRubrik.setText("Registreringsdatum:");

        lblRegistreringsdatum.setForeground(new java.awt.Color(51, 51, 51));
        lblRegistreringsdatum.setText("$regdatum");

        lblRasRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasRubrik.setText("Ras:");

        lblRas.setForeground(new java.awt.Color(51, 51, 51));
        lblRas.setText("$ras");

        lblRasInfoRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRasInfoRubrik.setText("$rasInfo");

        lblRasInfo.setText("$rasInfo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegistreringsdatumRubrik)
                            .addComponent(lblRasRubrik)
                            .addComponent(lblRasInfoRubrik))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRasInfo)
                            .addComponent(lblRas)
                            .addComponent(lblRegistreringsdatum)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdRubrik)
                            .addComponent(lblTelefonnummerRubrik)
                            .addComponent(lblOmradeRubrik)
                            .addComponent(lblNamnRubrik))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamn)
                            .addComponent(lblOmrade)
                            .addComponent(lblTelefonnummer)
                            .addComponent(lblId))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamnRubrik)
                    .addComponent(lblNamn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdRubrik)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonnummerRubrik)
                    .addComponent(lblTelefonnummer))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradeRubrik)
                    .addComponent(lblOmrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistreringsdatumRubrik)
                    .addComponent(lblRegistreringsdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRasRubrik)
                    .addComponent(lblRas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRasInfoRubrik)
                    .addComponent(lblRasInfo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addGap(0, 459, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new OmradeListaAliens(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JPanel jPanel1;
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
    // End of variables declaration//GEN-END:variables
}
