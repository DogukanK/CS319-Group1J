package group1j.ReviewTool.BusinessLogic;

import java.util.ArrayList;

import group1j.ReviewTool.DAO.DAOGroup;

public class GroupController {
	//properties
	private DAOGroup daoGroup;
	
	//constructor
	public GroupController() {
		daoGroup = DAOGroup.getInstance();
	}
	
	//methods
	public boolean createGroup(Group group) {
		return daoGroup.createGroup(group);
	}
	
	public Group getGroupData(int groupID) {
		return daoGroup.getGroupData(groupID);
	}
	
	public ArrayList<Integer> getAllGroupID(){
		return daoGroup.getAllGroupID();
	}
	
	public boolean addStudentToGroup(int groupID, int studentID) {
		return daoGroup.addGroupMember(groupID, studentID);
	}
	
	public boolean removeStudentFromGroup(int groupID, int studentID) {
		return daoGroup.removeMemberFromGroup(groupID,studentID);
	}
	
	public boolean addAssignment(int groupID, int assignmentID) {
		return daoGroup.addAssignmentToGroup(assignmentID, groupID);
	}
	
	public ArrayList<Integer> getAssignments(int groupID){
		return daoGroup.getGroupData(groupID).getAssignments();
	}
	
	public ArrayList<Integer> getMembers(int groupID){
		return daoGroup.getGroupData(groupID).getMembers();
	}
	
	public boolean removeAssignment(int groupID, int assignmentID) {
		return daoGroup.removeAssignmentFromGroup(groupID, assignmentID);
	}
	
	public boolean deleteGroup(int groupID) {
		return daoGroup.deleteGroup(groupID);
	}
}
