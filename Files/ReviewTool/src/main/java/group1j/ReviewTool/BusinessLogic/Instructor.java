package group1j.ReviewTool.BusinessLogic;

import java.util.ArrayList;

public class Instructor extends User{
	//properties
	private ArrayList<Integer> studentList, TAList, sectionList, groupList, assignmentList;
	
	//constructors
	public Instructor() {
		super();
		studentList = new ArrayList<Integer>();
		TAList = new ArrayList<Integer>();
		sectionList = new ArrayList<Integer>();
		groupList = new ArrayList<Integer>();
		assignmentList = new ArrayList<Integer>();
	}
	
	//this.assignmentList uzerinde yapilan degisiklikler parametre
	//olarak verileni ArrayListi de degistirir bu arrayler parametre
	//olarak verildikten sonra kullanilmamali bunun yerine yapilacak 
	//degisiklikler metodlar uzerinden yapilmali
	public Instructor(String email, String name, String surname, String password, int userID,
			ArrayList<Integer> studentList, ArrayList<Integer> TAList, ArrayList<Integer> sectionList,
			ArrayList<Integer> groupList, ArrayList<Integer> assignmentList) {
		super(email, name, surname, password, userID, "instructor");
		this.studentList = studentList;
		this.TAList = TAList;
		this.sectionList = sectionList;
		this.groupList = groupList;
		this.assignmentList = assignmentList;
	}
	
	//methods
	public void addStudent(int studentID) {
		studentList.add(studentID);
	}
	
	public void addTA(int taID) {
		TAList.add(taID);
	}
	
	public void addSection(int sectionID) {
		sectionList.add(sectionID);
	}
	
	public ArrayList<Integer> getStudentList(){return studentList;}
	public ArrayList<Integer> getTAList(){return TAList;}
	public ArrayList<Integer> getSectionList(){return sectionList;}
	public ArrayList<Integer> getGroupList(){return groupList;}
	public ArrayList<Integer> getAssignmentList(){return assignmentList;}
	
	public void removeStudent(int studentID) {
		studentList.remove(new Integer(studentID));
	}
	
	public void removeTA(int taID) {
		TAList.remove(new Integer(taID));
	}
	
	public void removeSection(int sectionID) {
		sectionList.remove(new Integer(sectionID));
	}
	
	//return void
	public void createGroup() {
		groupList.add(groupList.size()+1);
	}
	
	//parametreler silindi
	//return void
	public void createAssignment() {
		assignmentList.add(assignmentList.size()+1);
	}
}
