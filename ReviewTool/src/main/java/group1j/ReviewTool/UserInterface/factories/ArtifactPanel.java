/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.factories;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author anilt
 */
public class ArtifactPanel extends UIPanel{

    private JLabel artLabel1;
    private JLabel artLabel2;
    private JButton removeButton;
    private JButton reviewButton;
    
    public ArtifactPanel(){
        artLabel1 = new JLabel();
        artLabel2 = new JLabel();
        removeButton = new JButton();
        reviewButton = new JButton();
        
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setPreferredSize(new java.awt.Dimension(1140, 120));

        artLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        artLabel1.setText("Artifact 1");

        artLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        artLabel2.setText("Status: Pending for Review");

        removeButton.setBackground(new java.awt.Color(255, 255, 255));
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setBorder(null);
        removeButton.setBorderPainted(false);
        removeButton.setFocusPainted(false);
        removeButton.setFocusable(false);

        reviewButton.setBackground(new java.awt.Color(255, 255, 255));
        reviewButton.setForeground(new java.awt.Color(255, 255, 255));
        reviewButton.setBorder(null);
        reviewButton.setBorderPainted(false);
        reviewButton.setFocusPainted(false);

        javax.swing.GroupLayout empLayout = new javax.swing.GroupLayout(this);
        this.setLayout(empLayout);
        empLayout.setHorizontalGroup(
            empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(artLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(artLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        empLayout.setVerticalGroup(
            empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(artLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(artLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(empLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        
        removeButton.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\remove.png"));
        reviewButton.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\page.png"));
    }
    @Override
    public void setLabel(String label) {
        artLabel1.setText(label);
    }

    @Override
    public void setLabel2(String label) {
        artLabel2.setText(label);
    }

    @Override
    public JButton getViewButton() {
        return null;
    }

    @Override
    public JButton getRemoveButton() {
        return removeButton;
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
