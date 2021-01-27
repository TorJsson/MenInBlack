package MiB.CommonViews;

import MiB.Agent;
import MiB.AgentViews.AgentStart;
import MiB.Alien;
import MiB.AlienViews.AlienStart;
import MiB.Validering;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
private static int id;

    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRubrik = new javax.swing.JLabel();
        lblAnvandarnamn = new javax.swing.JLabel();
        tfAnvandarnamn = new javax.swing.JTextField();
        lblLosenord = new javax.swing.JLabel();
        tfLosenord = new javax.swing.JPasswordField();
        btnLoggaIn = new javax.swing.JButton();
        lblUnderRubrik = new javax.swing.JLabel();
        lblFelmeddelande = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Autentisering krävs");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setIconImages(null);
        setLocation(new java.awt.Point(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName("mibLoginRequired"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        lblRubrik.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        lblRubrik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRubrik.setText("Autentisering krävs.");
        lblRubrik.setToolTipText("");

        lblAnvandarnamn.setText("Användarnamn:");

        tfAnvandarnamn.setColumns(30);
        tfAnvandarnamn.setText("Ange ditt användarnamn");
        tfAnvandarnamn.setToolTipText("");
        tfAnvandarnamn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAnvandarnamnFocusGained(evt);
            }
        });

        lblLosenord.setText("Lösenord:");

        tfLosenord.setColumns(30);
        tfLosenord.setText("Ange ditt lösenord");
        tfLosenord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfLosenordFocusGained(evt);
            }
        });

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLoggaIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoggaIn.setOpaque(false);
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        lblUnderRubrik.setText("Ange ditt namn och lösenord nedan. Uppgifterna är skitflägeskänsliga.");

        lblFelmeddelande.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFelmeddelande.setForeground(new java.awt.Color(255, 0, 51));
        lblFelmeddelande.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRubrik)
                    .addComponent(lblUnderRubrik)
                    .addComponent(lblAnvandarnamn)
                    .addComponent(lblLosenord)
                    .addComponent(lblFelmeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoggaIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfLosenord)
                            .addComponent(tfAnvandarnamn, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblRubrik)
                .addGap(6, 6, 6)
                .addComponent(lblUnderRubrik)
                .addGap(18, 18, 18)
                .addComponent(lblAnvandarnamn)
                .addGap(6, 6, 6)
                .addComponent(tfAnvandarnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblLosenord)
                .addGap(6, 6, 6)
                .addComponent(tfLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addComponent(lblFelmeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoggaIn, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        id = 0;
        //Kontrollera att användarnamn är ifyllt
        if(Validering.txtFaltHarVarde(tfAnvandarnamn)) {
            String anvandarNamn = tfAnvandarnamn.getText();
            if(Validering.pwdFaltHarVarde(tfLosenord)) {
                String losenOrd = new String(tfLosenord.getPassword());
                //Kontrollera om användaren är en agent eller en alien
                if(Validering.arAgent(anvandarNamn)) {
                    if(Agent.getIdByNamn(anvandarNamn) != null){
                        //Om användaren är en agent hämtar vi användarens ID från Agent-tabellen i databasen
                        id = Integer.parseInt(Agent.getIdByNamn(anvandarNamn));
                            //Kontrollera att lösenordet stämmer med det som har sparats i databasen
                            if(Validering.valideraLosenord(id, losenOrd, true)) {
                                //Öppna agentmenyn.
                                new AgentStart(id).setVisible(true);
                                //Stäng loginfönstret
                                dispose();
                            //Om lösenordet inte stämmer
                            } else {
                                JOptionPane.showMessageDialog(null, "Du har angett fel lösenord. Försök igen.", "Fel kontouppgifter", JOptionPane.ERROR_MESSAGE);
                            } 
                    } else {
                        JOptionPane.showMessageDialog(null, "Det finns ingen agent med det namnet.", "Fel kontouppgifter", JOptionPane.ERROR_MESSAGE);
                    }
                //Om användaren är en alien
                } else {
                    if(Alien.getIdByNamn(anvandarNamn) != null) {
                        //Om användaren är en alien hämtar vi användarens ID från Alien-tabellen i databasen
                        id = Integer.parseInt(Alien.getIdByNamn(anvandarNamn));
                        //Kontrollera om lösenordet stämmer med det som sparats i databasen
                        if(Validering.valideraLosenord(id, losenOrd, false)) {
                            //Öppna alienmenyn
                            new AlienStart(id).setVisible(true);
                            //Stäng loginfönstret
                            setVisible(false);
                        //Om lösenordet inte stämmer
                        } else {
                            JOptionPane.showMessageDialog(null, "Du har angett fel lösenord", "Fel kontouppgifter", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Det finns ingen alien med det namnet.", "Fel kontouppgifter", JOptionPane.ERROR_MESSAGE);
                    }
                }
            //Om inget lösenord är ifyllt
            } else {
                JOptionPane.showMessageDialog(null, "Du har inte angett något lösenord. Försök igen.", "Fel kontouppgifter", JOptionPane.ERROR_MESSAGE);
            }
        //Om inget användarnamn är ifyllt
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angett något användarnamn.", "Fel kontouppgifter", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void tfAnvandarnamnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAnvandarnamnFocusGained
       tfAnvandarnamn.setText("");
       lblFelmeddelande.setText("");
    }//GEN-LAST:event_tfAnvandarnamnFocusGained

    private void tfLosenordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLosenordFocusGained
       tfLosenord.setText("");
       lblFelmeddelande.setText("");
    }//GEN-LAST:event_tfLosenordFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JLabel lblAnvandarnamn;
    private javax.swing.JLabel lblFelmeddelande;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblUnderRubrik;
    private javax.swing.JTextField tfAnvandarnamn;
    private javax.swing.JPasswordField tfLosenord;
    // End of variables declaration//GEN-END:variables
}
