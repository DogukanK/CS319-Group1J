package group1j.ReviewTool.BusinessLogic;

import java.util.Date;

public class ArtifactReview {
	//properties
	private int writerID, reviewID;
	private String text, writer;
	private Date date;
	
	//constructors
	public ArtifactReview() {
		writerID = 0;
		text = "";
		date = new Date();
		reviewID = 0;
		writer = "";
	}
	
	public ArtifactReview(int writerID, String text, Date date, int reviewID, String writer) {
		this.writerID = writerID;
		this.text = text;
		
		//iki instance da ayni objeye point ediyor bu yuzden parametre 
		//olarak verilen obje uzerinde degisiklik yapilmamali
		this.date = date;
		this.reviewID = reviewID;
		this.writer = writer;
	}
	
	//methods
	public String getText() {return text;}
	public String getWriter() {return writer;}
	public Date getDate() {return date;}
	public int getReviewID() {return reviewID;}
	public int getWriterID() {return writerID;}
	
	//iki instance da memoryde ayni objeye point ediyor. Birinde yapilan degisiklik digerini de etkiler
	//date verildikten sonra parametreye verilen date uzerinde manuel degisiklik yapilmamali
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setWriterID(int writerID) {
		this.writerID = writerID;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
}
