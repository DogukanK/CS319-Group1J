package group1j.ReviewTool.BusinessLogic;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author anilt
 * This is the Group class, which holds:
 * group name
 * group members
 * group assignments
 * user (peer) reviews
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
        this.UReviews = new HashMap<User,UReview>();
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
