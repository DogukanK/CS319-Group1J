
package group1j.ReviewTool.factories;

import javax.swing.JPanel;

/**
 *
 * @author anilt
 */
public class PanelFactory {
    
    public static UIPanel createPanel(String type){
        if(type.equalsIgnoreCase("group")){
            return new GroupPanel();
        }
        else if(type.equalsIgnoreCase("assignment")){
            return new AssignmentPanel();
        }
        else if(type.equalsIgnoreCase("member")){
            return new MemberPanel();
        }
        
        return null;
    }
}
