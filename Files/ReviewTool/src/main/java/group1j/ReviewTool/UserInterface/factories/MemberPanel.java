/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.factories;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author anilt
 */
public class MemberPanel extends UIPanel{
    
    JLabel label;
    JButton removeButton;
    JButton reviewButton;
    
    public MemberPanel(){
        
        label = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        reviewButton = new javax.swing.JButton();

        label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(0, 0, 0));
        
        this.setBackground(new java.awt.Color(255, 255, 255));
        removeButton.setBorder(null);
        reviewButton.setBorder(null);
        
        removeButton.setBackground(new java.awt.Color(255, 255, 255));
        reviewButton.setBackground(new java.awt.Color(255, 255, 255));
        
        removeButton.setFocusPainted(false);
        reviewButton.setFocusPainted(false);
        
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        removeButton.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\remove.png"));
        reviewButton.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\page.png"));

        
        javax.swing.GroupLayout newMemberPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(newMemberPanelLayout);
        newMemberPanelLayout.setHorizontalGroup(newMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newMemberPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 500, Short.MAX_VALUE)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        newMemberPanelLayout.setVerticalGroup(newMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newMemberPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newMemberPanelLayout.createSequentialGroup()
                        .addGroup(newMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reviewButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(removeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
    }
    
    
    public void setLabel(String label){
        this.label.setText(label);
    }
    
    public void setLabel2(String label){}
    public void setColor(Color clr){
        
    }
    
    public JButton getViewButton(){
        return null;
    }
    
    public JButton getRemoveButton(){
        return removeButton;
    }
    
    public JButton getReviewButton(){
        return reviewButton;
    }
    
    public JToggleButton getToggleButton(){
        return null;
    }
}
