/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface;

import group1j.ReviewTool.LogicManagement.Group;
import group1j.ReviewTool.LogicManagement.Instructor;
import group1j.ReviewTool.LogicManagement.LMController;
import group1j.ReviewTool.LogicManagement.Student;
import group1j.ReviewTool.LogicManagement.TA;
import group1j.ReviewTool.LogicManagement.User;
import java.util.ArrayList;

/**
 * @author anilt
 This is the UIController class, which is the main class
 for the top layer. Handles data connection between individual
 UI classes and the LMController class.
 */
public class UIController {
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    
    // NEEDS IMPLEMENTATION
    public static boolean login(String email,char[] password){
        if(LMController.signIn(email,password) == true){
            if(LMController.getCurrentUser().getClass() == Instructor.class){
                new InstructorScreen().setVisible(true);
            }
            else if(LMController.getCurrentUser().getClass() == TA.class){
                new TAScreen().setVisible(true);
            }
            else if(LMController.getCurrentUser().getClass() == Student.class){
                new StudentScreen().setVisible(true);
            }
            
            return true;
        }
        
        return false;
        
    }
    
    
    public static void createGroup(ArrayList<Integer> selectedIDs,String groupName){
        LMController.createGroup(selectedIDs,groupName);
    }
    
    public static void showSignupScreen(){
        
    }
    
    public static void createAssignment(String name,String desc){
        
    }
    
    public static void setSelectedGroup(String groupName){
        LMController.setSelectedGroup(groupName);
    }
    
    public static ArrayList<User> getFreeUserList(){
        return LMController.getFreeUserList();
    }
    
    public static ArrayList<Group> getGlobalGroupList(){
        return LMController.getGlobalGroupList();
    }
    
    
    public static void addMembers(ArrayList<Integer> selectedIDs,String groupName){
        LMController.addMembers(selectedIDs,groupName);
    }
    
    public static void removeMember(int id,String groupName){}
}
