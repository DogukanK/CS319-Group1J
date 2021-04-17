
package group1j.ReviewTool;

/**
 * @author anilt
 * This is an abstract class
 * providing a template for Instructor,Student and
 * TA classes.
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
    
    // NEEDS IMPLEMENTATION
    public void addAssignmentReview(String review,String reviewer,String targetGroup){
    }
    
    // NEEDS IMPLEMENTATION
    public void removeAssignmentReview(String review,String reviewer,String targetGroup,String assignmentName){
    }
}
