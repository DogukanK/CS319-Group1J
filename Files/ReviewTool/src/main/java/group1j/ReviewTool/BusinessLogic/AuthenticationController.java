package group1j.ReviewTool.BusinessLogic;
import group1j.ReviewTool.DAO.*;
import java.util.ArrayList;

public class AuthenticationController {
	//properties
	private User currentUser;
	private DAOUser daoUser;
	private DAOStudent daoStudent;
	private DAOInstructor daoInstructor;
	private DAOTa daoTa;
	
	//constructors
	public AuthenticationController() {
		currentUser = new User();
		daoUser = DAOUser.getInstance();
		daoStudent = DAOStudent.getInstance();
		daoInstructor = DAOInstructor.getInstance();
		daoTa = DAOTa.getInstance();
	}
	
	//methods
	public boolean loginUser(String email, String password){
		if(daoUser.loginUser(email, password)) {
			User temp = daoUser.getUserData(email);
			switch(temp.getUserType()) {
			case("student"):{
				currentUser = daoStudent.getStudentData(temp.getUserID());
				break;
			}
			case("instructor"):{
				currentUser = daoInstructor.getInstructorData(temp.getUserID());
				break;
			}
			case("ta"):{
				currentUser = daoTa.getTAData(temp.getUserID());
				break;
			}
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean signUpUser(String email, String name, String surname,  int id, String password,
			String userType) {
		User newUser = new User(email, name, surname, password, id, userType);
		if(userType.equals("student")) {
			daoStudent.addStudent(id, -1, 1);
		}
		
		return daoUser.addUser(newUser, userType);
	}

	public User getCurrentUser() {
		return currentUser;
	}
	
	public User getUserData(int userID) {
		return daoUser.getUserData(userID);
	}
	
	public User getUserData(String email) {
		return daoUser.getUserData(email);
	}
	
	public boolean setUserName(int id, String name) {
		if(daoUser.getUserData(id) == null) {
			return false;
		}else {
			daoUser.getUserData(id).setName(name);
			return true;
		}
	}
	
	public boolean setUserSurname(int id, String surname) {
		if(daoUser.getUserData(id) == null) {
			return false;
		}else {
			daoUser.getUserData(id).setSurname(surname);
			return true;
		}
	}
	
	public boolean setUserEmail(int id, String email) {
		if(daoUser.getUserData(id) == null) {
			return false;
		}else {
			daoUser.getUserData(id).setEmail(email);
			return true;
		}
	}
	
	public boolean setUserPassword(int id, String password) {
		if(daoUser.getUserData(id) == null) {
			return false;
		}else {
			daoUser.getUserData(id).setPassword(password);
			return true;
		}
	}
	
	public boolean setStudentSection(int id, int section) {
		if(daoStudent.getStudentData(id) == null) {
			return false;
		}else {
			daoStudent.getStudentData(id).setSection(section); 
			return true;
		}
	}
	
	public boolean setStudentGroup(int id, int groupID) {
		return daoStudent.changeGroup(id, groupID);
	}
	
	public TA getTA(int id) {
		return daoTa.getTAData(id);
	}
	
	public Instructor getInstructor() {
		return daoInstructor.getInstructorData(currentUser.getUserID());
	}
	
	public Student getStudent(int studentID) {
		return daoStudent.getStudentData(studentID);
	}

	public ArrayList<Integer> getStudentList(){
		return daoInstructor.getInstructorData(currentUser.getUserID()).getStudentList();
	}

	public ArrayList<Integer> getTAList(){
		return daoInstructor.getInstructorData(currentUser.getUserID()).getTAList();
	}
	
	public ArrayList<Integer> getSectionList(){
		return daoInstructor.getInstructorData(currentUser.getUserID()).getSectionList();
	}
	
//	public ArrayList<Integer> getGroupList(){
//		return daoInstructor.getInstructorData(currentUser.getUserID()).getGroupList();
//	}
}
