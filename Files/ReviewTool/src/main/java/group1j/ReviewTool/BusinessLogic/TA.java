package group1j.ReviewTool.BusinessLogic;

import java.util.ArrayList;

public class TA extends User{
	//properties
	private int taID;
	private ArrayList<Integer> studentList, sectionList, groupList, assignmentList;
	
	//constructors
	public TA() {
		super();
		studentList = new ArrayList<Integer>();
		sectionList = new ArrayList<Integer>();
		groupList = new ArrayList<Integer>();
		assignmentList = new ArrayList<Integer>();
	}
	
	public TA(String email, String name, String surname, String password, int userID,
			ArrayList<Integer> studentList, ArrayList<Integer> sectionList, ArrayList<Integer> groupList, ArrayList<Integer> assignmentList) {
		super(email, name, surname, password, userID, "ta");
		
		//this.assignmentList uzerinde yapilan degisiklikler parametre
		//olarak verileni ArrayListi de degistirir bu arrayler parametre
		//olarak verildikten sonra kullanilmamali bunun yerine yapilacak 
		//degisiklikler metodlar uzerinden yapilmali
		this.studentList = studentList;
		this.sectionList = sectionList;
		this.groupList = groupList;
		this.assignmentList = assignmentList;
	}
	
	//methods
	public int getTAID() {return taID;}
	public ArrayList<Integer> getStudentList(){return studentList;}
	public ArrayList<Integer> getSectionList(){return sectionList;}
	public ArrayList<Integer> getGroupList(){return groupList;}
	public ArrayList<Integer> getAssignmentList(){return assignmentList;}
	
	public void addStudent(int studentID) {
		studentList.add(studentID);
	}
	
	public void addSection(int sectionID) {
		sectionList.add(sectionID);
	}
	
	public void addGroup(int groupID) {
		groupList.add(groupID);
	}
	
	public void removeStudent(int studentID){
		studentList.remove(studentID);
	}
	
	public void addAssignment(int assignmentID) {
		assignmentList.add(assignmentID);
	}
}
