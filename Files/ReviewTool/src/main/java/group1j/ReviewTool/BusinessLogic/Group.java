package group1j.ReviewTool.BusinessLogic;

import java.util.ArrayList;

public class Group {
	//properties
	private ArrayList<Integer> assignments, members;
	private int groupID;
	
	//constructors
	public Group() {
		assignments = new ArrayList<Integer>();
		members = new ArrayList<Integer>();
		groupID = 0;
	}
	
	//this.assignmentList uzerinde yapilan degisiklikler parametre
	//olarak verileni ArrayListi de degistirir bu arrayler parametre
	//olarak verildikten sonra kullanilmamali bunun yerine yapilacak 
	//degisiklikler metodlar uzerinden yapilmali
	public Group(ArrayList<Integer> assignments, ArrayList<Integer> members, int groupID) {
		this.assignments = assignments;
		this.members = members;
		this.groupID = groupID;
	}
	
	public Group(int groupID) {
		this.groupID = groupID;
		members = new ArrayList<Integer>();
		assignments = new ArrayList<Integer>();
	}
	
	//methods
	public ArrayList<Integer> getMembers(){return members;}
	public ArrayList<Integer> getAssignments(){return assignments;}
	public int getGroupID() {return groupID;}
	
	public void addMember(int studentID) {
		members.add(studentID);
	}
	
	public void addAssignment(int assignmentID) {
		assignments.add(assignmentID);
	}
	
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	
	public void removeMember(int studentID) {
		members.remove(new Integer(studentID));
	}
	
	//yeni eklendi
	public void removeAssignment(int assignmentID) {
		assignments.remove(new Integer(assignmentID));
	}
}
