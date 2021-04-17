/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool;

import java.util.ArrayList;
import java.util.Iterator;

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
        for(Group traverse : LogicManagement.getGlobalGroupList()){
            Assignment newAssn = new Assignment(name,desc);
            traverse.getAssignments().add(newAssn);
        }
    }
    
    // Gets which assignment to remove from the UI
    public void removeAssignment(String aName){
        
    }
    
    // Create new group
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
    
    // Gets targetUser and targetGroup from UI, which are provided from the mainLogicClass
    public void addMember(User targetUser,Group targetGroup){
        targetGroup.getMembers().add(targetUser);
    }
    // Gets targetUser and targetGroup from UI, which are provided from the mainLogicClass
    public void removeMember(User targetUser,Group targetGroup){
        targetGroup.getMembers().remove(targetUser);
    }
    
}
