package group1j.ReviewTool.LogicManagement;
import java.util.ArrayList;
/**
 * @author anilt
 * This is the LogicManagement class, which is the main class
 * for the middle layer. Essentially a connector class,
 * which receives data from and sends data to
 * the UI and DB main classes.
 */
public class LogicManagement {
    private static ArrayList<Group> globalGroupList = new ArrayList<Group>();
    private static ArrayList<User> globalUserList;
    private static ArrayList<User> freeUserList = new ArrayList<User>();
    private static User currentUser;
    private static Group selectedGroup = new Group("");
    
    
    // NEEDS IMPLEMENTATION
    public static boolean signUp(String email,String name,String password){
        return false;
    }
    
    // NEEDS IMPLEMENTATION
    public static boolean signIn(String email,char[] password){
        
        currentUser = new Instructor(1,"e-mail","Instructor-Name");
       
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
        
        freeUserList.add(new Student(1,"e1","Name1"));
        freeUserList.add(new Student(2,"e1","Name2"));
        freeUserList.add(new Student(3,"e1","Name3"));
        freeUserList.add(new Student(4,"e1","Name4"));
        freeUserList.add(new Student(5,"e1","Name5"));
        freeUserList.add(new Student(6,"e1","Name6"));
        freeUserList.add(new Student(7,"e1","Name7"));
        return true;
    }
    
    // NEEDS IMPLEMENTATION
    public static void update(){}
    
    public static void addMembers(ArrayList<Integer> selectedIDs,String groupName){}

    public static ArrayList<Group> getGlobalGroupList() {
        return globalGroupList;
    }

    public static Group getSelectedGroup() {
        return selectedGroup;
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
    
    /*
    ** Sets the selectedGroup variable
    ** based on the group an instructor selects
    ** in the UI.
    */
    public static void setSelectedGroup(String groupName){
        for(Group g : globalGroupList){
            if(g.getName().equals(groupName)){
                selectedGroup = g;
                return;
            }
        }
    }
    
   
}
