/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface;

import group1j.ReviewTool.BusinessLogic.BMController;
import group1j.ReviewTool.BusinessLogic.Group;
import group1j.ReviewTool.BusinessLogic.Student;
import group1j.ReviewTool.BusinessLogic.TA;
import group1j.ReviewTool.BusinessLogic.User;
import group1j.ReviewTool.BusinessLogic.Instructor;
import group1j.ReviewTool.UserInterface.screens.*;
import java.util.ArrayList;

/**
 * @author anilt
 This is the UIController class, which is the main class
 for the top layer. Handles data connection between individual
 UI classes and the BMController class.
 */
public class UIController {
    
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    
    public static void refreshUI(){
        
    }
    
    public static void changeScreen(String type){
        if(type.equalsIgnoreCase("signup")){
            new SignupScreen().setVisible(true);
        }
        
        else if(type.equalsIgnoreCase("login")){
            new LoginScreen().setVisible(true);
        }
    }
    
    // NEEDS IMPLEMENTATION
    public static boolean login(String email,char[] password){
        if(BMController.signIn(email,password) == true){
            if(BMController.getCurrentUser().getClass() == Instructor.class){
                new InstructorScreen().setVisible(true);
            }
            else if(BMController.getCurrentUser().getClass() == TA.class){
                new TAScreen().setVisible(true);
            }
            else if(BMController.getCurrentUser().getClass() == Student.class){
                new StudentScreen().setVisible(true);
            }
            
            return true;
        }
        return false;
    }
    
    public static boolean signup(String name,String email,char[] password,String courseCode){
        return true;
    }
    
    public static void createGroup(ArrayList<Integer> selectedIDs,String groupName){
        BMController.createGroup(selectedIDs,groupName);
    }
    
  
    public static void addMembers(ArrayList<Integer> selectedIDs,String groupName){
        BMController.addMembers(selectedIDs,groupName);
    }
    
    public static void removeMember(int id){
        
    }
    
    public static void createAssignment(String name,String desc){
        
    }
    
    public static void removeAssignment(){
        
    }
    
    public static void addArtifactReview(){
        
    }
    
    public static void removeArtifactReview(){
        
    }
    
    public static void uploadFile(){
        
    }
    
    public static void removeFile(){
        
    }
    
    public static void addPeerReview(){
        
    }
    
    public static void removePeerReview(){
        
    }
    
    public static ArrayList<User> getFreeUserList(){
        return BMController.getFreeUserList();
    }
    
    public static ArrayList<Group> getGlobalGroupList(){
        return BMController.getGlobalGroupList();
    }
    
    public static User getCurrentUser(){
        return BMController.getCurrentUser();
    }
}
    