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
public abstract class User {
    protected int id;
    protected String email;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // Gets targetAssignment from the UI
    public void addAssignmentReview(String review,Assignment targetAssignment){
        targetAssignment.getAReviews().put(this,review);
    }
    
    public void removeAssignmentReview(String review,Assignment targetAssignment){
        targetAssignment.getAReviews().remove(this,review);
    }
}
