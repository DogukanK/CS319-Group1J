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
public class Controller {
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    public static boolean login(String email,char[] password){
        if(Model.signIn(email,password) == true){
            if(Model.getCurrentUser().getClass() == Instructor.class){
                new InstructorScreen().setVisible(true);
            }
            else if(Model.getCurrentUser().getClass() == TA.class){
                new TAScreen().setVisible(true);
            }
            else if(Model.getCurrentUser().getClass() == Student.class){
                new StudentScreen().setVisible(true);
            }
            
            return true;
        }
        
        return false;
        
    }
    
    public static void showSignupScreen(){
        
    }
}
