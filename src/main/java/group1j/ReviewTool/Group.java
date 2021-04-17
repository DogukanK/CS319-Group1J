package group1j.ReviewTool;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author anilt
 */
public class Group {
    
    private String name;
    private ArrayList<User> members;
    private ArrayList<Assignment> assignments;
    private HashMap<User,UReview> UReviews;

    public Group(String name) {
        this.name = name;
        this.assignments = new ArrayList<Assignment>();
        this.members = new ArrayList<User>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public HashMap<User, UReview> getUReviews() {
        return UReviews;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
