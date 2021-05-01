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
public abstract class UIPanel extends JPanel{
    public abstract void setLabel(String label);
    
    public abstract JButton getViewButton();
    
    public abstract JButton getRemoveButton();
    
    public abstract JButton getReviewButton();
    
    public abstract JToggleButton getToggleButton();
}
