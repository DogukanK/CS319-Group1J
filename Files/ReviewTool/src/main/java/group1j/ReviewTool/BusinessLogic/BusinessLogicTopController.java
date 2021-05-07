package group1j.ReviewTool.BusinessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import group1j.ReviewTool.DAO.DAOArtifactReview;
import group1j.ReviewTool.DAO.DAOInstructor;
import group1j.ReviewTool.DAO.DAOStudent;
import group1j.ReviewTool.DAO.DAOUser;

import java.io.File;
import java.text.DateFormat;  
import java.text.SimpleDateFormat; 
import java.util.Calendar;  

public class BusinessLogicTopController {
	//properties
	private AuthenticationController authControl;
	private AssignmentController assignmentControl;
	private PeerReviewController peerReviewControl;
	private GroupController groupControl;
	
	//constructor
	public BusinessLogicTopController() {
		authControl = new AuthenticationController();
		assignmentControl = new AssignmentController();
		peerReviewControl = new PeerReviewController();
		groupControl = new GroupController();
	}
	
	//methods
	
	//parametre id yerine email
	public boolean loginUser(String email, String password) {
		return authControl.loginUser(email,password);
	}
	
	//parametre surname eklendi
	public boolean signUpUser(String email, String name, String surname, int id,
			String password, String userType) {
		return authControl.signUpUser(email, name, surname, id, password, userType);
	}
	
	public ArrayList<Student> getStudentByGroup(int groupID){
		ArrayList<Integer> studentList = groupControl.getMembers(groupID);
		ArrayList<Student> finalArray = new ArrayList<Student>();
		for(int i = 0; i < studentList.size(); i++) {
			finalArray.add(authControl.getStudent(studentList.get(i)));
		}
		return finalArray;
	}
	
	public ArrayList<Student> getStudentBySection(int sectionID){
		ArrayList<Integer> studentList = authControl.getStudentList();
		ArrayList<Student> finalArray = new ArrayList<Student>();
		for(int i = 0; i < studentList.size(); i++) {
			if(authControl.getStudent(studentList.get(i)).getSection() == sectionID) {
				finalArray.add(authControl.getStudent(studentList.get(i)));
			}
		}
		return finalArray;
	}
	
	public ArrayList<Integer> getSectionList(){
		return authControl.getSectionList();
	}
	
	public ArrayList<Integer> getGroupList(){
		return groupControl.getAllGroupID();
	}
	
	public ArrayList<TA> getTAList(){
		ArrayList<Integer> taList = authControl.getTAList();
		ArrayList<TA> finalList = new ArrayList<TA>();
		for(int i = 0; i < taList.size(); i++) {
			finalList.add(authControl.getTA(taList.get(i)));
		}
		return finalList;
	}
	
	public ArrayList<Student> getAllStudents(){
		ArrayList<Integer> studentList = authControl.getStudentList();
		ArrayList<Student> finalArray = new ArrayList<Student>();
		for(int i = 0; i < studentList.size(); i++) {
			finalArray.add(authControl.getStudent(studentList.get(i)));
		}
		return finalArray;
	}
	
	//parametreler degisti
	public boolean createAssignment( String title, String desc,Date startDate, Date dueDate){ 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String startDate2 = dateFormat.format(startDate);
		String dueDate2 = dateFormat.format(dueDate);
		ArrayList<Integer> groupList = groupControl.getAllGroupID();
		if(groupList.size() == 0) {
			return false;
		}
		
		for(int i = 0; i < groupList.size();i++) {
			assignmentControl.createAssignment( title,groupList.get(i) , desc, startDate2, dueDate2);
			groupControl.addAssignment(groupList.get(i), assignmentControl.getLastAssignmentID());
			
		}
		return true;
	}
	
	//parametre title silindi
	public Assignment getAssignment(int assignmentID){
		return assignmentControl.getAssignment(assignmentID);
	}
	
	public ArrayList<Assignment> getAllAssignments(){
		int id = authControl.getCurrentUser().getUserID();		
		ArrayList<Integer> assignmentList = assignmentControl.getAssignmentList(id);
		ArrayList<Assignment> finalList = new ArrayList<Assignment>();
		for(int i = 0; i < assignmentList.size();i++) {
			finalList.add(assignmentControl.getAssignment(assignmentList.get(i)));
		}
		return finalList;
	}
	
	public ArrayList<Assignment> getAllAssignments(int groupID){
		ArrayList<Assignment> as = new ArrayList<Assignment>();
		ArrayList<Integer> assignmentsList = groupControl.getAssignments(groupID);
		for(int i = 0; i < assignmentsList.size(); i++) {
			
			as.add(assignmentControl.getAssignment(assignmentsList.get(i)));
			System.out.println("Assignment ID = " + String.valueOf(assignmentsList.get(i)) + " :BusinessLogicTopController:getAllAssignments()");
			System.out.println("Assignment Title = " + as.get(i).getTitle() + " :BusinessLogicTopController:getAllAssignments()");
		}
		
		
		return as;
	}
	
	public boolean updateAssignment(int assignmentID, String desc,
			Date dueDate, String title){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(dueDate);
		boolean first = assignmentControl.setNewDueDate(title, date);
		boolean second = assignmentControl.setAssignmentDescription(assignmentID, desc);
		if(first && second) {
			return true;
		}else {
			return false;
		}
	}
	
	public HashMap<String,File> getArtifacts(int assignmentID, int groupID){
		ArrayList<Integer> assignmentList = groupControl.getAssignments(groupID);
		return assignmentControl.getAssignment(assignmentList.get(assignmentID)).getArtifacts();
	}

	//parametreden groupID silindi
	public ArrayList<ArtifactReview> getArtifactReviews(int assignmentID, String artifactName){
		Assignment assignment = assignmentControl.getAssignment(assignmentID);
		return assignment.getArtifactReviews(artifactName);
	}	
	
	//parametreden groupID silindi
	public boolean uploadArtifact(int assignmentID, String artifactTitle) {
		return assignmentControl.uploadArtifact(assignmentID, artifactTitle);
	}
	
	public HashMap<String,File> getCurrentUserArtifacts(){
		HashMap<String, File> finalMap = new HashMap<String,File>();
		int id = authControl.getCurrentUser().getUserID();
		Student student = authControl.getStudent(id);
		if(student != null) {
			Group group = groupControl.getGroupData(student.getGroupID());
			ArrayList<Integer> assignmentList = group.getAssignments();
			for(int i = 0; i < assignmentList.size();i++) {
				finalMap.putAll(assignmentControl.getAssignment(assignmentList.get(i)).getArtifacts());
			}
		}
		return finalMap;
	}
	
	public HashMap<String, ArrayList<ArtifactReview>> getCurrentUserArtifactReviews() {
		HashMap<String, ArrayList<ArtifactReview>> finalMap = new HashMap<String,ArrayList<ArtifactReview>>();
		int id = authControl.getCurrentUser().getUserID();
		Student student = authControl.getStudent(id);
		if(student != null) {
			Group group = groupControl.getGroupData(student.getGroupID());
			ArrayList<Integer> assignmentList = group.getAssignments();
			for(int i = 0; i < assignmentList.size();i++) {
				finalMap.putAll(assignmentControl.getAssignment(assignmentList.get(i)).getArtifactReviews());
			}
		}
		return finalMap;
	}
	
	public Group getCurrentUserGroupData() {
		Student student = authControl.getStudent(authControl.getCurrentUser().getUserID());
		return groupControl.getGroupData(student.getGroupID());
	}
	
	public ArrayList<PeerReview> getCurrentUserPeerReviews(){
		Student student = authControl.getStudent(authControl.getCurrentUser().getUserID());
		return student.getReviews();
	}
	
	public Student getStudentData(int studentID) {
		return authControl.getStudent(studentID);
	}
	
	public TA getTAData(int taID) {
		return authControl.getTA(taID);
	}
	
	public Instructor getInstructorData() {
		return authControl.getInstructor();
	}
	
	public Group getGroupData(int groupID) {
		return groupControl.getGroupData(groupID);
	}
	
	public boolean deleteArtifact(int groupID, int assignmentID, String artifactTitle) {
		DAOArtifactReview.getInstance().deleteArtifactReview(assignmentID, artifactTitle);
		return assignmentControl.removeArtifact(assignmentID, artifactTitle);
	}
	
	public boolean givePeerReview(int toStudentID, String desc, double grade) {
		Date date = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String uploadDate = dateFormat.format(date);
		return peerReviewControl.createPeerReview(authControl.getCurrentUser().getUserID(), desc,
				grade, uploadDate, toStudentID);
	}
	
	public boolean editPeerReview(int toStudentID, String desc, double grade) {
		Date date = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String uploadDate = dateFormat.format(date);
		
		boolean first = peerReviewControl.changeDescription(authControl.getCurrentUser().getUserID(), desc, uploadDate, toStudentID);
		boolean second = peerReviewControl.changeGrade(authControl.getCurrentUser().getUserID(), grade, uploadDate, toStudentID);
		
		if(first && second) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deletePeerReview(int toStudentID, int giverID) {
		return peerReviewControl.deletePeerReview(toStudentID, giverID);
	}
	
	public ArrayList<PeerReview> getAllPeerReviews(int studentID){
		return peerReviewControl.getAllPeerReviewsByToStudent(studentID);
	}
	
	public boolean createGroup(int groupID) {
		try {
			Group newGroup = new Group(groupID);
			ArrayList<ArrayList<String>> cur = assignmentControl.getAllCurrentAssignments();
			groupControl.createGroup(newGroup);
			for(ArrayList<String> param : cur) {
				assignmentControl.createAssignment(param.get(0), groupID, param.get(1), param.get(2), param.get(3));
				groupControl.addAssignment(groupID, assignmentControl.findAssignmentID(param.get(0), groupID));
			}
			
			
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean addStudentToGroup(int studentID, int groupID) {
		boolean fixedStudentTable = authControl.setStudentGroup(studentID, groupID);
		boolean fixedGroupTable = groupControl.addStudentToGroup(groupID, studentID);
		return fixedStudentTable && fixedGroupTable;
	}
	
	public boolean removeStudentFromGroup(int studentID, int groupID) {
		boolean studentTableGroupCorrect = authControl.setStudentGroup(studentID, -1);
		boolean removedFromGroupMember = groupControl.removeStudentFromGroup(groupID, studentID);
		return studentTableGroupCorrect && removedFromGroupMember;
	}
	
	public boolean deleteAssignment(String title) {
		ArrayList<Integer> groupList = groupControl.getAllGroupID();
		boolean first = true;
		boolean second = true;
		boolean third = true;
		
		for(int i = 0; i < groupList.size(); i++) {
			int assignmentID = assignmentControl.findAssignmentID(title,groupList.get(i));
			ArrayList<String> ar = assignmentControl.getAllArtifactTitles(assignmentID);
			for(String s : ar) {
				third = assignmentControl.deleteArtifactReview(assignmentID, s);
			}
			first = groupControl.removeAssignment(groupList.get(i), assignmentID);	
		}
		second = assignmentControl.deleteAssignment(title);
		if(first == false || second == false || third == false) {
			return false;
		}
		return true;
	}
	
	public boolean uploadArtifactReview(int assignmentID, String artifactTitle, int writerID, String text, String writer) {
		Date date = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date1 = dateFormat.format(date);
		
		return assignmentControl.uploadArtifactReview(assignmentID, artifactTitle, writerID, text, date1, writer);
	}
	
	public boolean editAssignment(String title, Date dueDate, String newDesc) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String newDueDate = dateFormat.format(dueDate);
		boolean first = assignmentControl.editDescription(title, newDesc);
		boolean second = assignmentControl.setNewDueDate(title, newDueDate);
		
		return (first && second);
	}
        
	public User getCurrentUser(){
		return authControl.getCurrentUser();
	}
	
	public User getUserData(int userID)  {
		User initialData = DAOUser.getInstance().getUserData(userID);
		switch(initialData.getUserType()) {
		case("student"):{
			return authControl.getStudent(userID);
		}
		case("ta"):{
			return authControl.getTA(userID);
		}
		case("instructor"):{
			return authControl.getInstructor();
		}
		default:{
			System.out.println("USER NOT FOUND WITH userID = " + String.valueOf(userID) + " :BusinessLogicTopController :getUserData(int userID)");
			return initialData;
		}
		}
	}
	
	public ArrayList<Integer> getAllGroupID(){
		return groupControl.getAllGroupID();
	}
	
	
	public boolean editArtifactReview(int assignmentID, String artifactTitle, int writerID, String text) {
		return assignmentControl.editReview(assignmentID, artifactTitle, writerID, text);
	}
}
