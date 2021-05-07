package group1j.ReviewTool.BusinessLogic;

import java.util.Date;

public class PeerReview {
	//properties
	private int giverID;
	private String description;
	private double grade;
	private Date date;
	
	//constructors
	public PeerReview() {
		giverID = 0;
		description = "";
		grade = -1;
		date = new Date(0);
	}
	
	public PeerReview(int giverID, String description, double grade, Date date) {
		this.giverID = giverID;
		this.description = description;
		this.grade = grade;
		
		//iki instance da memoryde ayni objeye point ediyor. Birinde yapilan degisiklik digerini de etkiler
		//date verildikten sonra parametreye verilen date uzerinde manuel degisiklik yapilmamali
		this.date = date;
	}
	
	//methods
	public int getGiverID() {return giverID;}
	public String getDescription() {return description;}
	public double getGrade() {return grade;}
	public Date getDate() {return date;}
	
	public void setGiverID(int giverID) {
		this.giverID = giverID;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	//iki instance da memoryde ayni objeye point ediyor. Birinde yapilan degisiklik digerini de etkiler
	//date verildikten sonra parametreye verilen date uzerinde manuel degisiklik yapilmamali
	public void setDate(Date date) {
		this.date = date;
	}
}
