/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.factories;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author anilt
 */
public abstract class UIPanel extends JPanel{
    
    private JLabel label; 
    private JButton viewButton;
    private JButton removeButton;
    private JButton reviewButton;
    
    
    public abstract void setLabel(String label);
    
    public abstract JButton getViewButton();
    
    public abstract JButton getRemoveButton();
    
    public abstract JButton getReviewButton();
}
