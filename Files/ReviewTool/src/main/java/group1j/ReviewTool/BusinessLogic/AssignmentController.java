package group1j.ReviewTool.BusinessLogic;
import group1j.ReviewTool.DAO.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.io.File;
import java.text.SimpleDateFormat;

public class AssignmentController {
	//properties
	ArrayList<Integer> currentAssignments;
	DAOAssignment daoAssignment;
	DAOInstructor daoInstructor;
	//TODO FIX
	//DAOArtifact daoArtifact;
	DAOArtifactReview daoArtifactReview;
	
	//constructor
	public AssignmentController() {
		currentAssignments = new ArrayList<Integer>();
		daoAssignment = DAOAssignment.getInstance();
		daoInstructor = DAOInstructor.getInstance();
		//TODO FIX
		//daoArtifact = DAOArtifact.getInstance();
		daoArtifactReview = DAOArtifactReview.getInstance();
	}
	
	//methods
	public boolean createAssignment( String title,int groupID, String desc,String startDate, String dueDate) {
		return daoAssignment.createAssignment((daoAssignment.getLastAssignmentID()+1), title, groupID, desc, startDate, dueDate);
	}
	
	public Assignment getAssignment(int assignmentID) {
		Assignment as;
		as = daoAssignment.getAssignment(assignmentID);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Artifact Review = " + as.getTitle() + ":" + String.valueOf(as.getArtifactReviews().size()));
		HashMap<String, ArrayList<ArtifactReview>> temp = as.getArtifactReviews();
		for(String s : temp.keySet()) {
			System.out.println("----------------------------------------------------");
			System.out.println("Artifact Review Size = " + temp.get(s).size() + " :AssignmentController :getAssignment()");
		}
		for(int i = 0; i < as.getArtifactReviews().size(); i++) {
			
		}
		
		//as.uploadArtifact(null, null);
		return as;
	}
	
	public ArrayList<Integer> getAssignmentList(int id){
		int groupID = DAOStudent.getInstance().getStudentGroup(id);
		return DAOGroup.getInstance().getGroupData(groupID).getAssignments();
	}

	public boolean uploadArtifact(int assignmentID, String name) {
		//TODO FIX
		return daoAssignment.addArtifact(assignmentID, name);
		//return daoArtifact.uploadArtifact(assignmentID, name, uploadDate, file);
	}

	public Artifact getArtifact(int assignmentID, String artifactName) {
		//TODO FIX
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(5);
		temp.add(4);
		return new Artifact("artifactName", assignmentID, new Date(), new File("C:/Users/cagir/Desktop/cs319_proje/Final_Report.pdf"), temp);
		//return daoArtifact.getArtifact(assignmentID, artifactName);
	}
	
	public boolean gradeAssignment(int assignmentID, double grade) {
		return daoAssignment.gradeAssignment(assignmentID, grade);
	}
	
	public boolean setAssignmentDescription(int assignmentID, String desc) {
		return daoAssignment.editDescription(daoAssignment.getAssignment(assignmentID).getTitle(), desc);
	}
	
	public boolean setAssignmentTitle(int assignmentID, String title) {
		if(daoAssignment.getAssignment(assignmentID) == null) {
			return false;
		}else {
			daoAssignment.getAssignment(assignmentID).setTitle(title);
			return true;
		}
	}
	
	public boolean uploadArtifactReview(int assignmentID, String artifactTitle, int writerID, String text, String date, String writer) {
		return daoArtifactReview.createArtifactReview(assignmentID, artifactTitle, writerID, writer, text, date);
	}
	
	public boolean editReview( int assignmentID, String artifactTitle, int writerID, String text) {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return daoArtifactReview.updateArtifactReview(assignmentID, artifactTitle, writerID, text, df.format(d));
	}
	
	public boolean setNewDueDate(String assignmentTitle, String dueDate) {
		return daoAssignment.changeDueDate(assignmentTitle, dueDate);
	}
	
	public boolean editDescription(String title, String newDescription) {
		return daoAssignment.editDescription(title, newDescription);
	}
	
	public boolean deleteReview(int assignmentID, String artifactTitle, int writerID) {
		return daoArtifactReview.deleteArtifactReview(assignmentID, artifactTitle, writerID);
	}
	
	public boolean deleteArtifactReview(int assignmentID, String artifactTitle) {
		return daoArtifactReview.deleteArtifactReview(assignmentID, artifactTitle);
	}
	
	public ArrayList<File> getAllArtifacts(int assignmentID){
		Collection<File> col = daoAssignment.getAssignment(assignmentID).getArtifacts().values();
		ArrayList<File> finalList = new ArrayList<File>(col);
		return finalList;
	}
	
	public ArrayList<String> getAllArtifactTitles(int assignmentID){
		ArrayList<String> finalList = new ArrayList<String>(daoAssignment.getAssignment(assignmentID).getArtifacts().keySet());
		return finalList;
	}
	
	public ArrayList<ArtifactReview> getArtifactReview(int assignmentID, String artifactTitle) {
		return daoArtifactReview.getAllArtifactReviews(assignmentID, artifactTitle);
	}
	
	public ArtifactReview getArtifactReview(int reviewID) {
		return daoArtifactReview.getArtifactReview(reviewID);
	}
	
	public boolean removeArtifact(int assignmentID, String artifactTitle) {
		return daoAssignment.removeArtifact(assignmentID, artifactTitle);
	}
	
	public boolean deleteAssignment(String title) {
		
		return daoAssignment.deleteAssignment(title);
	}
	
	public int findAssignmentID(String title, int groupID) {
		return daoAssignment.findAssignmentID(title,groupID);
	}
	
	public int getLastAssignmentID() {
		return daoAssignment.getLastAssignmentID();
	}
	
	public ArrayList<ArrayList<String>> getAllCurrentAssignments(){
		return daoAssignment.getAllCurrentAssignments();
	}
	
}
