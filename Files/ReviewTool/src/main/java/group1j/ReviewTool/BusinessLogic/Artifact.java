package group1j.ReviewTool.BusinessLogic;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Artifact {
	private int assignmentID;
	private String artifactTitle;
	private Date uploadDate;
	private File file;
	private ArrayList<Integer> reviewList;

	public Artifact() {
		assignmentID = -1;
		artifactTitle = "";
		uploadDate = null;
		file = null;
		reviewList = null;
	}

	public Artifact(String artifactTitle, int assignmentID, Date uploadDate, File file, ArrayList<Integer> reviewList) {
		this.artifactTitle = artifactTitle;
		this.assignmentID = assignmentID;
		this.uploadDate = uploadDate;
		this.file = file;
		this.reviewList = reviewList;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public String getArtifactTitle() {
		return artifactTitle;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public File getFile() {
		return file;
	}

	public ArrayList<Integer> getReviewList() {
		return reviewList;
	}

	public boolean addReview(Integer reviewTitle) throws Exception {
		if(!reviewList.contains(reviewTitle)) {
			reviewList.add(reviewTitle);
			return true;
		}else {
			throw new Exception("reviewTitle already exist for this artifact.");
		}

	}
}