/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.screens;

import group1j.ReviewTool.UserInterface.UIController;

/**
 *
 * @author anilt
 */
public class SignupScreen extends javax.swing.JFrame implements Refreshable{

    /**
     * Creates new form SignupScreen
     */
    
    public void refreshUI(){
        this.revalidate();
    }
    
    public SignupScreen() {
        initComponents();
        whiteBgLabel.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\whiteBackground.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blueBgPanel = new javax.swing.JPanel();
        whiteBgPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        signupButton = new javax.swing.JButton();
        signupButton.setFocusPainted(false);
        backButton = new javax.swing.JButton();
        backButton.setFocusPainted(false);
        pwField = new javax.swing.JPasswordField();
        errorLabel = new javax.swing.JLabel();
        errorLabel.setVisible(false);
        nameLabel = new javax.swing.JLabel();
        pwLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        mailField = new javax.swing.JTextField();
        codeLabel = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        whiteBgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        blueBgPanel.setBackground(new java.awt.Color(71, 120, 197));
        blueBgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteBgPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        whiteBgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameField.setActionCommand("<Not Set>");
        nameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        whiteBgPanel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, -1));

        signupButton.setText("Signup");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        whiteBgPanel.add(signupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        whiteBgPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        pwField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pwField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwFieldActionPerformed(evt);
            }
        });
        whiteBgPanel.add(pwField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 170, 20));

        errorLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setText("This user already exists");
        whiteBgPanel.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 230, 40));

        nameLabel.setText("   Name-Surname:");
        whiteBgPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 120, 110, 40));

        pwLabel.setText(" Password:");
        whiteBgPanel.add(pwLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 210, 70, 40));

        mailLabel.setText("E-Mail Address:");
        whiteBgPanel.add(mailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 20));

        mailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailFieldActionPerformed(evt);
            }
        });
        whiteBgPanel.add(mailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 170, -1));

        codeLabel.setText("    Course Code:");
        whiteBgPanel.add(codeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 190, 100, -1));

        codeField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        whiteBgPanel.add(codeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 170, -1));
        whiteBgPanel.add(whiteBgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, -1));

        blueBgPanel.add(whiteBgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 310, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(blueBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(blueBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
       
        errorLabel.setVisible(false);
        if(UIController.signup(nameField.getText(),mailField.getText(),pwField.getPassword(),codeField.getText()) == false){
            errorLabel.setVisible(true);
        }

        else{
            this.setVisible(false);
        }
    }//GEN-LAST:event_signupButtonActionPerformed

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        this.setVisible(false);
        UIController.changeScreen("login");
    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void pwFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwFieldActionPerformed

    private void mailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel blueBgPanel;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField mailField;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField pwField;
    private javax.swing.JLabel pwLabel;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel whiteBgLabel;
    private javax.swing.JPanel whiteBgPanel;
    // End of variables declaration//GEN-END:variables
}
