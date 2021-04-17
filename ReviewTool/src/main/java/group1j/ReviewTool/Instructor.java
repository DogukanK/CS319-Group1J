package group1j.ReviewTool;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author anilt
 * This is the instructor class, which holds implementation for:
 * Assignment creation/deletion
 * Group creation
 * Member addition/deletion
 */
public class Instructor extends User{
    
    public Instructor(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
    
    // Add new assignment to all groups' assignment list
    public void createAssignment(String name,String desc){        
        for(Group traverse : LogicManagement.getGlobalGroupList()){
            Assignment newAssn = new Assignment(name,desc);
            traverse.getAssignments().add(newAssn);
        }
    }
    
    /*
    ** Creates new group and adds it to globalGroupList in LogicManagement
    ** selectedIDs: IDs of members selected in the UI
    ** groupName: Entered by the user
    */
    public void createGroup(ArrayList<Integer> selectedIDs,String groupName){
        Group newGroup = new Group(groupName);
        ArrayList<User> userList = LogicManagement.getFreeUserList();
        Iterator<User> iter = userList.iterator();
        while(iter.hasNext()){
            User u = iter.next();
            for(int id: selectedIDs){
                if(u.getId() == id){
                    newGroup.getMembers().add(new Student(u.getId(),u.getEmail(),u.getName()));
                    iter.remove();
                }
            }
        }
        if(LogicManagement.getGlobalGroupList().isEmpty() == false){
            Group dummyGroup = LogicManagement.getGlobalGroupList().get(0);
            for(Assignment A : dummyGroup.getAssignments()){                 // Copy assignments from an existing group
                newGroup.getAssignments().add(new Assignment(A.getName(),A.getDescription()));
            }
        }
        LogicManagement.getGlobalGroupList().add(newGroup);
    }
    
    // NEEDS IMPLEMENTATION
    public void addMembers(ArrayList<Integer> selectedIDs,String groupName){
        
    }
    
    // NEEDS IMPLEMENTATION
    public void removeMember(int id, String groupName){
    }
    
     // NEEDS IMPLEMENTATION
    public void removeAssignment(String aName){
        
    }
}
