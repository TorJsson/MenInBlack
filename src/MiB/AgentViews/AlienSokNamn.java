package MiB.AgentViews;

import MiB.Validering;
import javax.swing.JOptionPane;

public class AlienSokNamn extends javax.swing.JFrame {
    private static int id;

    public AlienSokNamn(int id) {
        initComponents();
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        txtNamn = new javax.swing.JTextField();
        btnHamta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - S�k efter namn");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("G� tillbaka");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        txtNamn.setText("------ Ange ett namn ------");
        txtNamn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamnFocusGained(evt);
            }
        });

        btnHamta.setText("H�mta");
        btnHamta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaActionPerformed(evt);
            }
        });

        jLabel1.setText("Ange det namn du vill s�ka efter.");

        jLabel2.setText("Anv�nd % som wildcard f�r flera tecken");

        jLabel3.setText("eller _ som wildcard f�r ett tecken.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamn, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnHamta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGoBack)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(btnHamta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Metod som k�rs n�r namnf�ltet f�r fokus
    private void txtNamnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamnFocusGained
        //T�mmer textf�ltet
        txtNamn.setText("");
    }//GEN-LAST:event_txtNamnFocusGained

    //Metod som k�rs n�r man klickar p� G� tillbaka
    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        //�ppnar alienmenyn
        new MenyAliens(id).setVisible(true);
        //St�nger nuvarande f�nstret
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    //Metod som k�rs n�r man klickar p� H�mta
    private void btnHamtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaActionPerformed
        //Kontrollerar att textf�ltet �r ifyllt
        if(!Validering.txtFaltHarVarde(txtNamn) || txtNamn.getText().equals("------ Ange ett namn ------")){
            //Visar felmeddelande om inget namn �r angett
            JOptionPane.showMessageDialog(null, "Du har inte angett n�got namn att s�ka efter", "Inget namn angett", JOptionPane.ERROR_MESSAGE);
        
        } else {
            //H�mta textf�ltets v�rde
            String namnAttSokaEfter = txtNamn.getText();
            //�ppna resultatf�nstret
            new AlienSokNamnResultat(id, namnAttSokaEfter).setVisible(true);
            //St�ng det nuvarande f�nstret
            dispose();
        }
        
    }//GEN-LAST:event_btnHamtaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHamta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNamn;
    // End of variables declaration//GEN-END:variables
}
