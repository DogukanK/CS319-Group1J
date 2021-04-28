/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.BusinessLogic;

import java.util.ArrayList;

/**
 *
 * @author anilt
 */
public class Student extends User{
    
    private ArrayList<UReview> reviews;
    public Student(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.reviews = new ArrayList<UReview>();
    }
     
    public void uploadFile(Assignment targetAssignment,String fileName){
        
    }
    
    public void removeFile(Assignment targetAssignmentre,String fileName){
        
    }
    
    // NEEDS IMPLEMENTATION
    public void addPeerReview(String uName,String gName,String reviewer,int point,String review){
    }
    
    // NEEDS IMPLEMENTATION
    public void removePeerReview(String uName,String gName,String reviewer){
    }
    
    public ArrayList<UReview> getReviews(){
        return reviews;
    }
}
