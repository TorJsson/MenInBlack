package MiB.AlienViews;

import MiB.Alien;
import MiB.Validering;
import javax.swing.JOptionPane;

public class KontoBytLosenord extends javax.swing.JFrame {
    private static int id;

    public KontoBytLosenord(int id) {
        initComponents();
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        lblCurrentPassword = new javax.swing.JLabel();
        pwdCurrent = new javax.swing.JPasswordField();
        lblNewPassword = new javax.swing.JLabel();
        pwdNew = new javax.swing.JPasswordField();
        lblNewPasswordConfirm = new javax.swing.JLabel();
        pwdNewConfirm = new javax.swing.JPasswordField();
        btnChangePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiB - Byt lösenord");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        btnGoBack.setText("Gå tillbaka");
        btnGoBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblCurrentPassword.setText("Befintligt lösenord:");

        pwdCurrent.setText("jPasswordField1");
        pwdCurrent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdCurrentFocusGained(evt);
            }
        });

        lblNewPassword.setText("Nytt lösenord:");

        pwdNew.setText("jPasswordField2");
        pwdNew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdNewFocusGained(evt);
            }
        });

        lblNewPasswordConfirm.setText("Bekräfta nytt lösenord:");

        pwdNewConfirm.setText("jPasswordField3");
        pwdNewConfirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdNewConfirmFocusGained(evt);
            }
        });

        btnChangePassword.setText("Byt lösenord");
        btnChangePassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnChangePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCurrentPassword)
                    .addComponent(lblNewPassword)
                    .addComponent(pwdNew, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(lblNewPasswordConfirm)
                    .addComponent(pwdNewConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwdCurrent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addGap(22, 22, 22)
                .addComponent(lblCurrentPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNewPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdNew, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNewPasswordConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdNewConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenyKonto(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        //Kontrollera att det nuvarande lösenordet är ifyllt
        if(Validering.pwdFaltHarVarde(pwdCurrent)) {
            String nuvarandeLosenord = new String(pwdCurrent.getPassword());
            //Kontrollera att ett nytt lösenord är ifyllt
            if(Validering.pwdFaltHarVarde(pwdNew)) {
                String nyttLosenord = new String(pwdNew.getPassword());
                //Kontrollera att det nya lösenordet har bekräftats
                if(Validering.pwdFaltHarVarde(pwdNewConfirm)) {
                    String nyttBekraftatLosenord = new String(pwdNewConfirm.getPassword());
                    //Kontrollerar att det nuvarande lösenordet stämmer med det som är sparat i databasen.
                    if(Validering.valideraLosenord(id, nuvarandeLosenord, false)) {
                        //Kontrollerar att det nya lösenordet stämmer med det bekräftade nya
                        if(nyttLosenord.equals(nyttBekraftatLosenord)) {
                            //Kontrollerar att längden på det nya lösenordet inte överstiger 6 tecken.
                            if(Validering.valideraLangd(nyttLosenord, 1, 6)) {
                                //Gör ett försök att ändra lösenordet för användaren
                                if(Alien.setPassword(id, nyttLosenord)) {
                                    //Visar ett meddelande om att lösenordet är bytt
                                    JOptionPane.showMessageDialog(null, "Ditt lösenord är uppdaterat.", "Bytt lösenord", JOptionPane.INFORMATION_MESSAGE);
                                    //Öppnar konto-menyn igen.
                                    new MenyKonto(id).setVisible(true);
                                    //Stänger Byt lösenord-fönstret
                                    dispose();
                                //Om någonting gick fel när lösenordet skulle bytas
                                } else {
                                    JOptionPane.showMessageDialog(null, "Någonting gick fel när lösenordet skulle bytas. Försök igen.");
                                }
                            //Om det nya lösenordet är för långt    
                            } else {
                                JOptionPane.showMessageDialog(null, "Lösenordet du vill byta till är för långt. Lösenordet får vara max 6 tecken. Försök igen.");
                            }    
                        //Om det nya lösenordet inte stämmer överrens med det bekräftade nya
                        } else {
                            JOptionPane.showMessageDialog(null, "Det nya lösenordet stämmer inte överrens med det som står i fältet \"Bekräfta nytt lösenord\". Försök igen.");
                        }
                    //Om det angivna nuvarande lösenordet inte stämmer
                    } else {
                        JOptionPane.showMessageDialog(null, "Du har angett fel nuvarande lösenord. Försök igen.");
                    }
                //Om fältet Bekräftat nytt lösenord inte stämmer med fältet Nytt lösenord
                } else {
                 JOptionPane.showMessageDialog(null, "Du har inte bekräftat det nya lösenordet. Försök igen.");
                }
            //Om inget nytt lösenord är angett
            } else {
             JOptionPane.showMessageDialog(null, "Du har inte angett något nytt lösenord. Försök igen.");
            }
        //Om det nuvarande lösenordet inte är angett
        } else {
         JOptionPane.showMessageDialog(null, "Du har inte angett ditt nuvarande lösenord. Försök igen.");
        }
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void pwdCurrentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdCurrentFocusGained
        pwdCurrent.setText("");
    }//GEN-LAST:event_pwdCurrentFocusGained

    private void pwdNewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNewFocusGained
        pwdNew.setText("");
    }//GEN-LAST:event_pwdNewFocusGained

    private void pwdNewConfirmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNewConfirmFocusGained
        pwdNewConfirm.setText("");
    }//GEN-LAST:event_pwdNewConfirmFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel lblCurrentPassword;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNewPasswordConfirm;
    private javax.swing.JPasswordField pwdCurrent;
    private javax.swing.JPasswordField pwdNew;
    private javax.swing.JPasswordField pwdNewConfirm;
    // End of variables declaration//GEN-END:variables
}
