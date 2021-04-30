/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.factories;

import javax.swing.*;
/**
 *
 * @author anilt
 */
public class SmallMemberPanel extends UIPanel{
    
    private JToggleButton button;
    
    public SmallMemberPanel(){
        
        button = new JToggleButton();
        
        this.setBackground(new java.awt.Color(23, 35, 51));
        this.setPreferredSize(new java.awt.Dimension(250, 100));

        this.setBackground(new java.awt.Color(23, 35, 51));
        this.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setBackground(new java.awt.Color(23, 35, 51));
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setSelected(true);
        button.setText("MemberName");
        button.setBorder(null);
        button.setFocusPainted(false);

        javax.swing.GroupLayout peerMemberPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(peerMemberPanelLayout);
        peerMemberPanelLayout.setHorizontalGroup(
            peerMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(peerMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        peerMemberPanelLayout.setVerticalGroup(
            peerMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(peerMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
    }
    
    public JToggleButton getToggleButton(){
        return button;
    }
    
    public void setLabel2(String label){}
    
    public void setLabel(String label){
        
    }
    
    public JButton getViewButton(){
        return null;
    }
    
    public JButton getRemoveButton(){
        return null;
    }
    
    public JButton getReviewButton(){
        return null;
    }
}
