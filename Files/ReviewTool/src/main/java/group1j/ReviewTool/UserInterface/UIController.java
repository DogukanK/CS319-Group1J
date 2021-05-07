/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface;

import group1j.ReviewTool.BusinessLogic.Instructor;
import group1j.ReviewTool.BusinessLogic.PeerReview;
import group1j.ReviewTool.BusinessLogic.BusinessLogicTopController;
import group1j.ReviewTool.BusinessLogic.Student;
import group1j.ReviewTool.BusinessLogic.Assignment;
import group1j.ReviewTool.BusinessLogic.TA;
import group1j.ReviewTool.BusinessLogic.User;
import group1j.ReviewTool.BusinessLogic.*;
import group1j.ReviewTool.UserInterface.screens.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author anilt
 This is the UIController class, which is the main class
 for the top layer. Handles data connection between individual
 UI classes and the BMController class.
 */
public class UIController {
    
    private static ScreenInterface currentScreen;
    private static BusinessLogicTopController bc = new BusinessLogicTopController();
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentScreen = new LoginScreen();
                ((LoginScreen) currentScreen).setVisible(true);
            }
        });
    }
    
    public static void refreshUI(){
        currentScreen.refreshUI();
    }
    
    public static void changeScreen(String type){
        if(type.equalsIgnoreCase("signup")){
            currentScreen = new SignupScreen();
            ((SignupScreen) currentScreen).setVisible(true);
        }
        
        else if(type.equalsIgnoreCase("login")){
            currentScreen = new LoginScreen();
            ((LoginScreen) currentScreen).setVisible(true);
        }
    }
    
    
    public static boolean login(String email,char[] password){
        boolean loginCheck = bc.loginUser(email,String.valueOf(password));
        if(loginCheck== true){
            if(bc.getCurrentUser().getClass() == Instructor.class){
                currentScreen = new InstructorScreen();
                ((InstructorScreen) currentScreen).setVisible(true);
            }
            else if(bc.getCurrentUser().getClass() == TA.class){
                currentScreen = new TAScreen();
                ((TAScreen) currentScreen).setVisible(true);
            }
            else if(bc.getCurrentUser().getClass() == Student.class){
                currentScreen = new StudentScreen();
                ((StudentScreen) currentScreen).setVisible(true);
            }
            
            return true;
        }
        return false;
    }
    
    public static boolean signup(String name,String email,char[] password,int studentID){
    	boolean re = false;
        if(studentID == - 1)
            re = bc.signUpUser(email, name, "", studentID, String.valueOf(password),"ta");
        else
            re = bc.signUpUser(email, name, "", studentID, String.valueOf(password),"student");
        changeScreen("login");
        return re;
    }
    
    public static void createGroup(ArrayList<Integer> selectedIDs,String groupName){
        int groupCount = bc.getAllGroupID().size() + 1;
        bc.createGroup(groupCount);
        for(Integer id: selectedIDs) {
        	bc.addStudentToGroup(id, groupCount);
        }
        refreshUI();
    }
  
    public static void addMembers(ArrayList<Integer> selectedIDs,int groupID){
        for(int iter:selectedIDs){
            bc.addStudentToGroup(iter, groupID);
        }
        refreshUI();
    }
    
    public static void removeMember(int id){
        bc.removeStudentFromGroup(id, bc.getStudentData(id).getGroupID());
        refreshUI();
    }
    
    public static void createAssignment(String name,String desc,Date dueDate){
        Date today = new Date();
        bc.createAssignment(name, desc, today, dueDate);
        refreshUI();
    }
    
    public static void removeAssignment(String name){
        bc.deleteAssignment(name);
        refreshUI();
    }
    
    public static void editAssignment(String name,String desc,Date startDate,Date dueDate){
        //TODO
    	bc.editAssignment(name, dueDate, desc);
    }
    
    public static void addArtifactReview(int writerID,String writerName,String comment,String artName,String assnName,int groupID){
        Group gr = bc.getGroupData(groupID);
        int assnID = -1;
        for(int iter: gr.getAssignments()){
            Assignment iter2 = bc.getAssignment(iter);
            if(assnName.equals(iter2.getTitle())){
                assnID = iter;
                break;
            }
        }
        bc.uploadArtifactReview(assnID, artName, writerID, comment, writerName);
        refreshUI();
    }
    
    public static void removeArtifactReview(int writerID,String artName,int groupID){
        refreshUI();
    }
    
    public static void uploadFile(File selectedFile,String artName,int groupID,String assnName){
        Group gr = bc.getGroupData(groupID);
        int assnID = -1;
        for(int iter: gr.getAssignments()){
            Assignment iter2 = bc.getAssignment(iter);
            if(assnName.equals(iter2.getTitle())){
                assnID = iter;
                break;
            }
        }
        bc.uploadArtifact(assnID, artName);
        refreshUI();
    }
    
    public static void removeArtifact(String artName,int groupID,String assnName){
    	Group gr = bc.getGroupData(groupID);
        int assnID = -1;
        for(int iter: gr.getAssignments()){
            Assignment iter2 = bc.getAssignment(iter);
            if(assnName.equals(iter2.getTitle())){
                assnID = iter;
                break;
            }
        }
        bc.deleteArtifact(groupID, assnID, artName);
        refreshUI();
    }
    
    //
    public static void downloadArtifact(String artName,int groupID,String assnName){
        refreshUI();
    }
    
    public static void updatePeerReview(int giverID,int recieverID,String comment,int point){
        ArrayList<PeerReview> reviews = bc.getAllPeerReviews(recieverID);
        for(PeerReview iter:reviews){
            if(iter.getGiverID() == giverID){
                bc.editPeerReview(recieverID, comment, point);
                refreshUI();
                return;
            }
        }
        bc.givePeerReview(recieverID, comment, point);
        refreshUI();
    }
    
    public static void setPeerReviewsEnabled(boolean set){
        refreshUI();
    }
    
    public static boolean isPeerReviewsEnabled(){
        return true;
    }
    
    public static ArrayList<User> getFreeUserList(){
        ArrayList<User> freeUserList = new ArrayList<>();
        for(User u:bc.getAllStudents()){
            if(u.getClass().getSimpleName().equalsIgnoreCase("Student")){
                if(((Student) u).getGroupID() == -1){
                    freeUserList.add(u);
                }
            }
        }
        
        return freeUserList;
    }
    
    public static ArrayList<Group> getGlobalGroupList(){
//        if(bc.getCurrentUser().getClass().getSimpleName().equalsIgnoreCase("Student")){
//            ArrayList<Group> stGroup = new ArrayList<>();
//            stGroup.add(bc.getGroupData(bc.getGroupList().get(0)));
//            return stGroup;
//        }
        
    	if(bc.getCurrentUser().getClass().getSimpleName().equalsIgnoreCase("Student")){
          ArrayList<Group> stGroup = new ArrayList<>();
          stGroup.add(bc.getCurrentUserGroupData());
          return stGroup;
    	}
        ArrayList<Group> grList = new ArrayList<>();
        for(int iter: bc.getGroupList()){
        	
            grList.add(bc.getGroupData(iter));
        }
        
        return grList;
    }
    
    public static User getCurrentUser(){
        return bc.getCurrentUser();
    }
    
//    public static ArrayList<Assignment> getAssignments(Group gr){
//        ArrayList<Assignment> allAssignments = bc.getAllAssignments();
//        ArrayList<Assignment> groupAssignments = null;
//        for(int iter:gr.getAssignments()){
//            groupAssignments.add(bc.getAssignment(iter));
//        }
//        return groupAssignments;
//    }
    
    public static User getSTUser(int id){
        return bc.getStudentData(id);
    }
    
    public static ArrayList<Assignment> getAllAssignments(){
        return bc.getAllAssignments();
    }
    
    public static ArrayList<Assignment> getAllAssignments(int groupID){
    	return bc.getAllAssignments(groupID);
    }
    
    public static User getUserData(int userID) {
    	return bc.getUserData(userID);
    }
    
    public static ArrayList<PeerReview> getAllPeerReviews(int userID){
        return bc.getAllPeerReviews(userID);
    }
    
    public static void  editArtifactReview(int assnID,String artTitle,int writerID,String text,String writer){
        bc.editArtifactReview(assnID, artTitle, writerID, text);
    }
    
    public static int getCurrentUserGroupID() {
    	return bc.getCurrentUserGroupData().getGroupID();
    }
    
}
    