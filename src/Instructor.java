/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group1JProject;

/**
 *
 * @author anilt
 */
public class Instructor extends User{
    
    public Instructor(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
    // Add new assignment to all groups' assignment list
    public void createAssignment(String name,String desc){        
        for(Group traverse : Model.getGlobalGroupList()){
            Assignment newAssn = new Assignment(name,desc);
            traverse.getAssignments().add(newAssn);
        }
    }
    
    // Gets which assignment to remove from the UI
    public void removeAssignment(Assignment targetAssignment){
        for(Group traverse : Model.getGlobalGroupList()){
            traverse.getAssignments().remove(targetAssignment);
        }
    }
    
    // Create empty group
    public void createGroup(String groupName){
        Group newGroup = new Group(groupName);
        Model.getGlobalGroupList().add(newGroup);
    }
    
    // Gets targetUser and targetGroup from UI, which are provided from the mainLogicClass
    public void addMember(User targetUser,Group targetGroup){
        targetGroup.getMembers().add(targetUser);
    }
    // Gets targetUser and targetGroup from UI, which are provided from the mainLogicClass
    public void removeMember(User targetUser,Group targetGroup){
        targetGroup.getMembers().remove(targetUser);
    }
    
}
