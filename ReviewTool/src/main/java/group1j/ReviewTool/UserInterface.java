/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool;

import java.util.ArrayList;

/**
 * @author anilt
 * This is the UserInterface class, which is the main class
 * for the top layer. Handles data connection between individual
 * UI classes and the LogicManagement class.
 */
public class UserInterface {
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    
    // NEEDS IMPLEMENTATION
    public static boolean login(String email,char[] password){
        if(LogicManagement.signIn(email,password) == true){
            if(LogicManagement.getCurrentUser().getClass() == Instructor.class){
                new InstructorScreen().setVisible(true);
            }
            else if(LogicManagement.getCurrentUser().getClass() == TA.class){
                new TAScreen().setVisible(true);
            }
            else if(LogicManagement.getCurrentUser().getClass() == Student.class){
                new StudentScreen().setVisible(true);
            }
            
            return true;
        }
        
        return false;
        
    }
    
    
    public static void createGroup(ArrayList<Integer> selectedIDs,String groupName){
        LogicManagement.createGroup(selectedIDs,groupName);
    }
    
    public static void showSignupScreen(){
        
    }
    
    public static void createAssignment(String name,String desc){
        
    }
    
    public static void setSelectedGroup(String groupName){
        LogicManagement.setSelectedGroup(groupName);
    }
    
    public static ArrayList<User> getFreeUserList(){
        return LogicManagement.getFreeUserList();
    }
    
    public static ArrayList<Group> getGlobalGroupList(){
        return LogicManagement.getGlobalGroupList();
    }
    
    
    public static void addMembers(ArrayList<Integer> selectedIDs,String groupName){
        LogicManagement.addMembers(selectedIDs,groupName);
    }
    
    public static void removeMember(int id,String groupName){}
}
