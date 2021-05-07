/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.factories;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author anilt
 */
public class STMemberPanel extends UIPanel{

    private JLabel avatarIcon;
    private JLabel memberName;
    private JLabel rankLabel;
    private JButton reviewButton;
    
    public STMemberPanel(){
        avatarIcon = new JLabel();
        memberName = new JLabel();
        rankLabel = new JLabel();
        reviewButton = new JButton();
        
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setPreferredSize(new java.awt.Dimension(1140, 120));

        memberName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        memberName.setText("jLabel2");

        rankLabel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        rankLabel.setText("jLabel1");

        reviewButton.setFocusPainted(false);

        reviewButton.setBackground(new java.awt.Color(255, 255, 255));
        reviewButton.setForeground(new java.awt.Color(255, 255, 255));
        reviewButton.setBorder(null);

        javax.swing.GroupLayout empLayout = new javax.swing.GroupLayout(this);
        this.setLayout(empLayout);
        empLayout.setHorizontalGroup(
            empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(avatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(empLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 647, Short.MAX_VALUE)
                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        empLayout.setVerticalGroup(
            empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(empLayout.createSequentialGroup()
                        .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(avatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, empLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        
        avatarIcon.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\user.png"));
        reviewButton.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\page.png"));
    }
    
    @Override
    public void setLabel(String label) {
        memberName.setText(label);
    }
    
    public void setLabel2(String label){
        rankLabel.setText(label);
    }
    public void setColor(Color clr){
        
    }

    @Override
    public JButton getViewButton() {
        return null;
    }

    @Override
    public JButton getRemoveButton() {
        return null;
    }

    @Override
    public JButton getReviewButton() {
        return reviewButton;
    }

    @Override
    public JToggleButton getToggleButton() {
        return null;
    }
    
}
