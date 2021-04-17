/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool;

/**
 *
 * @author anilt
 */
public class Student extends User{
    
    public Student(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
     
    public void uploadFile(Assignment targetAssignment,String fileName){
        
    }
    
    public void removeFile(Assignment targetAssignmentre,String fileName){
        
    }
    
    // Get review target and information from the UI
    public void addPeerReview(User targetUser,Group targetGroup,int point,String review){
        UReview newReview = new UReview(point,review,this);
        targetGroup.getUReviews().put(targetUser,newReview);
    }
    
    // Get review target and information from the UI
    public void removePeerReview(User targetUser,Group targetGroup,UReview targetReview){
        targetGroup.getUReviews().remove(targetUser,targetReview);
    }
}
