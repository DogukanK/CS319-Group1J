package group1j.ReviewTool.BusinessLogic;
import group1j.ReviewTool.DAO.*;
import java.util.Date;
import java.util.ArrayList;

public class PeerReviewController {
	//properties
	private DAOPeerReview daoPeerReview;
	
	//constructor
	public PeerReviewController() {
		daoPeerReview = DAOPeerReview.getInstance();
	}
	
	//methods
	public boolean createPeerReview(int giverID, String desc, double grade,
			String date, int toStudentID){
		return daoPeerReview.createPeerReview(toStudentID, giverID, desc, grade, date);
	}
	
	public boolean changeGrade(int giverID, double grade, String date, int toStudentID) {
		return daoPeerReview.changeGrade(toStudentID, giverID, grade, date);
	}
	
	public boolean changeDescription(int giverID, String desc, String date, int toStudentID) {
		return daoPeerReview.changeDescription(toStudentID, giverID, desc, date);
	}
	
	public PeerReview getPeerReview(int toStudent, int giverID) {
		return daoPeerReview.getPeerReview(toStudent, giverID);
	}
	
	public ArrayList<PeerReview> getAllPeerReviewsByToStudent(int toStudent){
		return daoPeerReview.getAllPeerReviewsByToStudent(toStudent);
	}
	
	public ArrayList<PeerReview> getAllPeerReviewsByGiverID(int giverID){
		return daoPeerReview.getAllPeerReviewsByGiverID(giverID);
	}
	
	public boolean deletePeerReview(int toStudentID, int giverID) {
		return daoPeerReview.deletePeerReview(toStudentID, giverID);
	}
}
