package group1j.ReviewTool;
import java.util.ArrayList;
/**
 *
 * @author anilt
 */
public class LogicManagement {
    private static ArrayList<Group> globalGroupList = new ArrayList<Group>();
    private static ArrayList<User> globalUserList;
    private static ArrayList<User> freeUserList = new ArrayList<User>();
    private static User currentUser;
    private static Group selectedGroup = new Group("");
    
    
    public static boolean signUp(int id,String email,String name,String password){
        
        
        return false;
    }
    
    // TODO: If query succeeds, instantiate grouplists, userlists and currentuser before this function terminates!
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
    
    public static void setSelectedGroup(String groupName){
        for(Group g : globalGroupList){
            if(g.getName().equals(groupName)){
                selectedGroup = g;
                return;
            }
        }
    }
}
