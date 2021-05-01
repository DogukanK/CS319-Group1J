/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.factories;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author anilt
 */
public class AssignmentPanel extends UIPanel{
    
    private JLabel label; 
    private JButton viewButton;
    
    public AssignmentPanel(){
            label = new javax.swing.JLabel();
            viewButton = new javax.swing.JButton();
            
            label.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
            label.setForeground(new java.awt.Color(0, 0, 0));
        
            viewButton.setBackground(new java.awt.Color(255, 255, 255));
            viewButton.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img/view.png"));
            viewButton.setBorder(null);
        
            this.setBackground(new java.awt.Color(255, 255, 255));
            this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            javax.swing.GroupLayout newButtonPanelLayout = new javax.swing.GroupLayout(this);
            this.setLayout(newButtonPanelLayout);
            newButtonPanelLayout.setHorizontalGroup(newButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newButtonPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 642, Short.MAX_VALUE)
                .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            );
            newButtonPanelLayout.setVerticalGroup(newButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(viewButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
    }
    
    
    public void setLabel(String label){
        this.label.setText(label);
    }
    
    public JButton getViewButton(){
        return viewButton;
    }
    
    public JButton getRemoveButton(){
        return null;
    }
    
    public JButton getReviewButton(){
        return null;
    }
    
    public JToggleButton getToggleButton(){
        return null;
    }
}
