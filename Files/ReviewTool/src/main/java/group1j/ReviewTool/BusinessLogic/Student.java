package group1j.ReviewTool.BusinessLogic;

import java.util.ArrayList;

public class Student extends User {
	//properties
	private int studentID, groupID, section;
	private ArrayList<PeerReview> reviews;
	
	//constructors
	public Student() {
		super();
		studentID = 0;
		groupID = 0;
		section = 0;
		reviews = new ArrayList<PeerReview>();
	}
	
	public Student(String email, String name, String surname, String password, int userID,
			int studentID, int groupID, int section) {
		super(email, name, surname, password, userID, "student");
		this.studentID = studentID;
		this.groupID = groupID;
		this.section = section;
		
		//Reviews ArrayList is initiated empty reviews should be added manually with method "addReview"
		this.reviews = new ArrayList<PeerReview>();
	}
	
	//methods
	public int getStudentID() {return studentID;}
	public int getGroupID() {return groupID;}
	public int getSection() {return section;}
	public ArrayList<PeerReview> getReviews(){return reviews;}
	
	public void setStudentID(int studentID) {this.studentID = studentID;}
	public void assignToGroup(int groupID) {this.groupID = groupID;}
	public void setSection(int section) {this.section = section;}
	
	public void addReview(PeerReview review) {
		reviews.add(review);
	}
}
