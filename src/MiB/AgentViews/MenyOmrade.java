package MiB.AgentViews;

import MiB.Agent;
import MiB.Omrade;
import java.util.ArrayList;

public class MenyOmrade extends javax.swing.JFrame {
    private static int id;
    
    public MenyOmrade(int id) {
        initComponents();
        this.id = id;
        
        //D�ljer alla labels per default
        lblAntalAliens.setVisible(false);
        lblAntalAliensRubrik.setVisible(false);
        lblOmradeschef.setVisible(false);
        lblOmradeschefRubrik.setVisible(false);

        hamtaOmraden();
    }
    
    //H�mtar omr�desben�mningar, itererar igenom resultaten och fyller p� comboboxen
    private void hamtaOmraden() {
        ArrayList<String> allaOmraden = Omrade.getAllaOmradesBenamningar();
        
        for(String benamning : allaOmraden) {
            cbOmrade.addItem(benamning);
        }
    }
    
    //H�mtar data f�r omr�det och �ndrar texten p� labels
    private void genereraSida(int id) {
        String antalAliens = Integer.toString(Omrade.getAntalAliens(id));
        int omradesChefId = Omrade.getOmradesChefById(id);
        String omradesChefNamn = Agent.getNamnById(omradesChefId);
        lblAntalAliens.setText(antalAliens);
        lblOmradeschef.setText(omradesChefNamn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        cbOmrade = new javax.swing.JComboBox<>();
        lblOmradeschefRubrik = new javax.swing.JLabel();
        lblOmradeschef = new javax.swing.JLabel();
        lblAntalAliensRubrik = new javax.swing.JLabel();
        lblAntalAliens = new javax.swing.JLabel();

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

        cbOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- V�lj omr�de ---" }));
        cbOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOmradeActionPerformed(evt);
            }
        });

        lblOmradeschefRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOmradeschefRubrik.setText("Omr�deschef:");

        lblOmradeschef.setText("$agentNamn");

        lblAntalAliensRubrik.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAntalAliensRubrik.setText("Antal aliens i omr�det:");

        lblAntalAliens.setText("$antalAliens");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 360, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbOmrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOmradeschefRubrik)
                            .addComponent(lblAntalAliensRubrik))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAntalAliens)
                            .addComponent(lblOmradeschef))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addGap(18, 18, 18)
                .addComponent(cbOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmradeschefRubrik)
                    .addComponent(lblOmradeschef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAntalAliensRubrik)
                    .addComponent(lblAntalAliens))
                .addContainerGap(370, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOmradeActionPerformed
        //Kollar vilket omr�de som �r valt
        String valtOmrade = cbOmrade.getSelectedItem().toString();
        
        if(valtOmrade.equals("--- V�lj omr�de ---")) {
            //Om inget omr�de �r valt d�ljs alla labels
            lblAntalAliens.setVisible(false);
            lblAntalAliensRubrik.setVisible(false);
            lblOmradeschef.setVisible(false);
            lblOmradeschefRubrik.setVisible(false);
        } else {
            //Visar labels om ett omr�de �r valt
            lblAntalAliens.setVisible(true);
            lblAntalAliensRubrik.setVisible(true);
            lblOmradeschef.setVisible(true);
            lblOmradeschefRubrik.setVisible(true);
            //Anropar genereraSida() f�r �ndra text p� labels
            int omradesId = Integer.parseInt(Omrade.getIdByBenamning(valtOmrade));
            genereraSida(omradesId);  
            
        }
                
        
    }//GEN-LAST:event_cbOmradeActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new AgentStart(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JComboBox<String> cbOmrade;
    private javax.swing.JLabel lblAntalAliens;
    private javax.swing.JLabel lblAntalAliensRubrik;
    private javax.swing.JLabel lblOmradeschef;
    private javax.swing.JLabel lblOmradeschefRubrik;
    // End of variables declaration//GEN-END:variables
}
