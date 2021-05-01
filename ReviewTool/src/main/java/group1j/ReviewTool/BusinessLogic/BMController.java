package group1j.ReviewTool.BusinessLogic;
import java.util.ArrayList;
/**
 * @author anilt
 This is the BMController class, which is the main class
 for the middle layer. Essentially a connector class,
 which receives data from and sends data to
 the UI and DB main classes.
 */
public class BMController {
    private static ArrayList<Group> globalGroupList = new ArrayList<Group>();
    private static ArrayList<User> freeUserList = new ArrayList<User>();
    private static User currentUser;
    
    // NEEDS IMPLEMENTATION
    public static boolean signUp(String email,String name,String password){
        return false;
    }
    
    // NEEDS IMPLEMENTATION
    public static boolean signIn(String email,char[] password){
        
        currentUser = new Instructor(1,"e-mail","Instructor-Name");
        
        Student st1 = new Student(001,"st1@reviewtool.com"," Alice A.");
        
        freeUserList.add(new Student(1,"e1","Name1"));
        freeUserList.add(new Student(2,"e1","Name2"));
        freeUserList.add(new Student(3,"e1","Name3"));
        freeUserList.add(new Student(4,"e1","Name4"));
        freeUserList.add(new Student(5,"e1","Name5"));
        freeUserList.add(new Student(6,"e1","Name6"));
        freeUserList.add(new Student(7,"e1","Name7"));
        
        
        Student st2 = new Student(002,"st2@reviewtool.com"," Bob B.");
        Student st3 = new Student(003,"st3@reviewtool.com"," Charlie C.");
        Student st4 = new Student(004,"st4@reviewtool.com"," David D.");
        Student st5 = new Student(005,"st5@reviewtool.com"," Eve E.");
        
        UReview u1 = new UReview(10,"Lorem ipsum dolor sit amet, "
                + "consectetur adipiscing elit. Quisque semper "
                + "ante nibh, vitae posuere nisi sagittis ut. "
                + "Nullam elit mi, vehicula vel consectetur id, laoreet "
                + "ac dui. Ut id quam eu mauris maximus pulvinar pharetra at lectus. "
                + "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vestibulum commodo tincidunt dui a tempor. "
                + "Vivamus facilisis mi et molestie venenatis. Nunc maximus nulla orci. Curabitur augue dolor, semper eget volutpat in, rhoncus ut risus. Ut faucibus "
                + "tempus velit sed euismod. Cras quis eros in lectus sollicitudin convallis. Maecenas dolor purus, consequat ut nulla sed, convallis cursus leo. Donec varius leo leo, "
                + "eu ultricies odio sagittis vel. Cras nulla metus, maximus at suscipit quis, luctus eget nisl. Quisque non odio felis. Duis at lacus blandit, congue tellus eu, porttitor diam. "
                + "Fusce dapibus tortor eget egestas volutpat.\n", st2);
        
        UReview u2 = new UReview(7,"I am Charlie reviewing Alice", st3);
        
        UReview u3 = new UReview(2,"I am David reviewing Alice", st4);
        
        ((Instructor) currentUser).createGroup(new ArrayList<Integer>(),"Group1A");
        ((Instructor) currentUser).createGroup(new ArrayList<Integer>(),"Group1B");
        ((Instructor) currentUser).createGroup(new ArrayList<Integer>(),"Group1C");
        ((Instructor) currentUser).createGroup(new ArrayList<Integer>(),"Group1D");
        ((Instructor) currentUser).createGroup(new ArrayList<Integer>(),"Group1E");
        
        
        ((Instructor) currentUser).createAssignment("Assignment 1", "this is a1");
        ((Instructor) currentUser).createAssignment("Assignment 2", "this is a2");
        ((Instructor) currentUser).createAssignment("Assignment 3", "this is a3");
        ((Instructor) currentUser).createAssignment("Assignment 4", "this is a4");
        ((Instructor) currentUser).createAssignment("Assignment 5", "this is a5");
        
        globalGroupList.get(0).getMembers().add(currentUser);
        globalGroupList.get(0).getMembers().add(st1);
        globalGroupList.get(0).getMembers().add(st2);
        globalGroupList.get(0).getMembers().add(st3);
        globalGroupList.get(0).getMembers().add(st4);
        globalGroupList.get(0).getMembers().add(st5);
        
        ((Student) globalGroupList.get(0).getMembers().get(1)).getReviews().add(u1);
        ((Student) globalGroupList.get(0).getMembers().get(1)).getReviews().add(u2);
        ((Student) globalGroupList.get(0).getMembers().get(1)).getReviews().add(u3);
        
        
        currentUser = st1;
        return true;
    }
    
    public static void addMembers(ArrayList<Integer> selectedIDs,String groupName){}

    public static ArrayList<Group> getGlobalGroupList() {
        return globalGroupList;
    }
    
    public static User getCurrentUser(){
        return currentUser;
    }
    
    public static ArrayList<User> getFreeUserList(){
        return freeUserList;
    }
    
    public static void createGroup(ArrayList<Integer> selectedIDs,String groupName){
        ((Instructor) currentUser).createGroup(selectedIDs,groupName);
    }
    
}
