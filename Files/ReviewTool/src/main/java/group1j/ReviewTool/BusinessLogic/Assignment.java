package group1j.ReviewTool.BusinessLogic;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.util.Date;

public class Assignment {
	//properties
	private int assignmentID, groupID;
	private HashMap<String,File> artifacts;
	private HashMap<String,ArrayList<ArtifactReview>> artifactReviews;
	private String description, title;
	private double grade;
	private Date dueDate, startDate;
	
	//constructor
	public Assignment(int assignmentID, String title, int groupID, String description, Date startDate, Date dueDate){
		this.assignmentID = assignmentID;
		this.title = title;
		this.description = description;
		artifacts = new HashMap<String,File>();
		artifactReviews = new HashMap<String,ArrayList<ArtifactReview>>();
		
		//grade is negative until give grade method is called
		grade = -1;
		this.groupID = groupID;
		//iki instance da memoryde ayni objeye point ediyor. Birinde yapilan degisiklik digerini de etkiler
		//date verildikten sonra parametreye verilen date uzerinde manuel degisiklik yapilmamali
		this.dueDate = dueDate;
		this.startDate = startDate;
	}
	
	//methods
	public int getAssignmentID() {return assignmentID;}
	public String getDescription() {return description;}
	public HashMap<String,File> getArtifacts(){return artifacts;}
	public HashMap<String,ArrayList<ArtifactReview>> getArtifactReviews() {return artifactReviews;}
	public double getGrade() {return grade;}
	public Date getDueDate() {return dueDate;}
	public String getTitle() {return title;}
	public Date getStartDate() {return startDate;}
	public String getName() {return title;}
	
	public File getArtifactByID(String id) {
		return artifacts.get(id);
	}
	
	//yeni eklendi
	public ArrayList<ArtifactReview> getArtifactReviews(String id){
		if(artifactReviews.get(id) == null) {
			return new ArrayList<ArtifactReview>();
		}else {
			return artifactReviews.get(id);
		}
	}
	
	//parametreye reviewID eklendi
	public ArtifactReview getArtifactReviewByID(String id, int reviewID) {
		return artifactReviews.get(id).get(reviewID);
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	//parametrete key eklendi
	//return void
	public void uploadArtifact(String key, File artifact) {
		artifacts.put(key, artifact);
		artifactReviews.put(key, new ArrayList<ArtifactReview>());
	}
	
	public boolean uploadReview(int artifactReviewID, String artifactID, int writerID, String writer, String text, Date date) {
		if( !artifactReviews.containsKey(artifactID)) {
			return false;
		}else {
			ArtifactReview uploadReview = new ArtifactReview(writerID,text,date,artifactReviewID,writer);
			artifactReviews.get(artifactID).add(uploadReview);
			return true;
		}
	}
	
	public boolean editReview(String artifactID, int reviewID, String text, Date date, int writerID) {
		if(artifactReviews.get(artifactID)==null) {
			return false;
		}else {
			for(int i = 0; i < artifactReviews.get(artifactID).size(); i++) {
				if(artifactReviews.get(artifactID).get(i).getReviewID() == reviewID 
						&& artifactReviews.get(artifactID).get(i).getWriterID() == writerID) {
					artifactReviews.get(artifactID).get(i).setDate(date);
					artifactReviews.get(artifactID).get(i).setText(text);
				}
			}
			return false;
		}
	}
	
	public boolean deleteReview(String artifactID, int reviewID, int writerID) {
		if(artifactReviews.get(artifactID)==null) {
			return false;
		}else {
			for(int i = 0; i < artifactReviews.get(artifactID).size(); i++) {
				if(artifactReviews.get(artifactID).get(i).getReviewID() == reviewID 
						&& artifactReviews.get(artifactID).get(i).getWriterID() == writerID) {
					artifactReviews.get(artifactID).remove(i);
				}
			}
			return false;
		}
	}
	
	public void giveGrade(double grade) {
		this.grade = grade;
	}
	
	public void editGrade(double grade) {
		this.grade = grade;
	}
	
	public boolean deleteArtifact(String artifactID) {
		if(artifacts.get(artifactID)==null) {
			return false;
		}else {
			artifacts.remove(artifactID);
			return true;
		}
	}
	
	//iki instance da memoryde ayni objeye point ediyor. Birinde yapilan degisiklik digerini de etkiler
	//date verildikten sonra parametreye verilen date uzerinde manuel degisiklik yapilmamali
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
