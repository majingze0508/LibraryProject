/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;

/**
 *
 * @author cstuser
 */
public class UserProfile extends javax.swing.JFrame {

    /**
     * Creates new form UserProfile
     */
    User loginedUser = new User();
    userEditUI userUpdateUI;
    public UserProfile(User currentUser) {
        loginedUser = currentUser;
        initComponents();
        UserNameTF.setText(loginedUser.getUserName());
        FirstNameTF.setText(loginedUser.getFname());
        LastNameTF.setText(loginedUser.getLname());
        RoleTF.setText(loginedUser.getMyRole());
        EmailTF.setText(loginedUser.getEmail());
        MobileTF.setText(loginedUser.getPhone());
        AddressTF.setText(loginedUser.getAddress() + ", " + loginedUser.getCity()
                          + ", " + loginedUser.getProvince() + ", " + loginedUser.getCountry());
        ZipTF.setText(loginedUser.getZip());
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameL = new javax.swing.JLabel();
        UserNameTF = new javax.swing.JTextField();
        firstNameL = new javax.swing.JLabel();
        FirstNameTF = new javax.swing.JTextField();
        lastNameL1 = new javax.swing.JLabel();
        LastNameTF = new javax.swing.JTextField();
        roleL = new javax.swing.JLabel();
        RoleTF = new javax.swing.JTextField();
        emailL = new javax.swing.JLabel();
        EmailTF = new javax.swing.JTextField();
        phoneL = new javax.swing.JLabel();
        MobileTF = new javax.swing.JTextField();
        addressL = new javax.swing.JLabel();
        AddressTF = new javax.swing.JTextField();
        UpdateB = new javax.swing.JButton();
        CancelB = new javax.swing.JButton();
        zipL = new javax.swing.JLabel();
        ZipTF = new javax.swing.JTextField();

        setName("UsrProfileFrm"); // NOI18N

        usernameL.setText("User Name:");

        UserNameTF.setEditable(false);

        firstNameL.setText("First Name:");

        FirstNameTF.setEditable(false);

        lastNameL1.setText("Last Name:");

        LastNameTF.setEditable(false);

        roleL.setText("Role:");

        RoleTF.setEditable(false);

        emailL.setText("Email:");

        EmailTF.setEditable(false);

        phoneL.setText("Mobile:");

        MobileTF.setEditable(false);

        addressL.setText("Address:");

        AddressTF.setEditable(false);

        UpdateB.setText("Update");
        UpdateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBActionPerformed(evt);
            }
        });

        CancelB.setText("Cancel");
        CancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBActionPerformed(evt);
            }
        });

        zipL.setText("Zip:");

        ZipTF.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FirstNameTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UserNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roleL)
                            .addComponent(lastNameL1)
                            .addComponent(emailL)
                            .addComponent(phoneL)
                            .addComponent(addressL)
                            .addComponent(zipL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastNameTF)
                            .addComponent(RoleTF)
                            .addComponent(EmailTF)
                            .addComponent(MobileTF)
                            .addComponent(AddressTF)
                            .addComponent(ZipTF)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UpdateB)
                        .addGap(59, 59, 59)
                        .addComponent(CancelB)
                        .addGap(75, 75, 75)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameL)
                    .addComponent(UserNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameL)
                    .addComponent(FirstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameL1)
                    .addComponent(LastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleL)
                    .addComponent(RoleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailL)
                    .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneL)
                    .addComponent(MobileTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressL)
                    .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipL)
                    .addComponent(ZipTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateB)
                    .addComponent(CancelB))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBActionPerformed
        userUpdateUI = new userEditUI(loginedUser, "update");
    }//GEN-LAST:event_UpdateBActionPerformed

    private void CancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_CancelBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressTF;
    private javax.swing.JButton CancelB;
    private javax.swing.JTextField EmailTF;
    private javax.swing.JTextField FirstNameTF;
    private javax.swing.JTextField LastNameTF;
    private javax.swing.JTextField MobileTF;
    private javax.swing.JTextField RoleTF;
    private javax.swing.JButton UpdateB;
    private javax.swing.JTextField UserNameTF;
    private javax.swing.JTextField ZipTF;
    private javax.swing.JLabel addressL;
    private javax.swing.JLabel emailL;
    private javax.swing.JLabel firstNameL;
    private javax.swing.JLabel lastNameL1;
    private javax.swing.JLabel phoneL;
    private javax.swing.JLabel roleL;
    private javax.swing.JLabel usernameL;
    private javax.swing.JLabel zipL;
    // End of variables declaration//GEN-END:variables
}
