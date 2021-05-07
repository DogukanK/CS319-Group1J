/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.factories;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

/**
 *
 * @author anilt
 */
public class ArtReviewPanel extends UIPanel {

    private JTextPane commentField;
    private JLabel rnLabel;
    private JLabel avatarIcon2;
    private JSeparator jSeparator1;
    
    public ArtReviewPanel(){  
        commentField = new JTextPane();
        rnLabel = new JLabel();
        avatarIcon2 = new JLabel();
        jSeparator1 = new JSeparator();
        this.setBackground(new java.awt.Color(255, 255, 255));

        commentField.setEditable(false);
        commentField.setBackground(new java.awt.Color(0, 102, 0));
        commentField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        commentField.setForeground(new java.awt.Color(0, 0, 0));
        commentField.setText("Aenean lectus tortor, tincidunt non sapien eget, lobortis interdum elit. Etiam vitae velit a arcu laoreet bibendum. Donec accumsan neque eros, eget tincidunt enim fermentum in. Sed volutpat enim eu augue hendrerit condimentum. Quisque tincidunt non lectus sit amet sollicitudin. Praesent nisl arcu, \n");
        commentField.setMargin(new java.awt.Insets(20, 20, 20, 20));

        rnLabel.setForeground(new java.awt.Color(0, 0, 0));
        rnLabel.setText("Reviewer Name");

        javax.swing.GroupLayout arPLayout = new javax.swing.GroupLayout(this);
        this.setLayout(arPLayout);
        arPLayout.setHorizontalGroup(
            arPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(arPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commentField, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(arPLayout.createSequentialGroup()
                        .addGroup(arPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        arPLayout.setVerticalGroup(
            arPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, arPLayout.createSequentialGroup()
                .addComponent(rnLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(arPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(avatarIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(commentField, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        avatarIcon2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\group1j\\ReviewTool\\UserInterface\\img\\user.png"));
    }
    @Override
    public void setLabel(String label) {
        rnLabel.setText(label);
    }

    @Override
    public void setLabel2(String label) {
        commentField.setText(label);
    }
    
    public void setColor(Color clr){
        commentField.setBackground(clr);
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
        return null;
    }

    @Override
    public JToggleButton getToggleButton() {
        return null;
    }
    
}
