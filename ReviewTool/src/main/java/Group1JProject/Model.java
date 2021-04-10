package Group1JProject;
import java.util.ArrayList;
/**
 *
 * @author anilt
 */
public class Model {
    private static ArrayList<Group> globalGroupList;
    private static ArrayList<User> globalUserList;
    private static ArrayList<User> freeUserList;
    private static User currentUser;
    private static Group selectedGroup;
    
    
    public static boolean signUp(int id,String email,String name,String password){
        
        
        return false;
    }
    
    // TODO: If query succeeds, instantiate grouplists, userlists and currentuser before this function terminates!
    public static boolean signIn(String email,char[] password){
        
        return false;
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
}
