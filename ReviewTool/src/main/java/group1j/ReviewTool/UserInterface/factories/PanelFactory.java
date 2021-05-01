
package group1j.ReviewTool.UserInterface.factories;

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
        
        else if(type.equalsIgnoreCase("smallmember")){
            return new SmallMemberPanel();
        }
        
        else if(type.equalsIgnoreCase("stMember")){
            return new stMemberPanel();
        }
        
        return null;
    }
}
