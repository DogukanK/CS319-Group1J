package group1j.ReviewTool.DAO;
import group1j.ReviewTool.BusinessLogic.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAOArtifactReview {
	private String connectionUrl, user, passw;
	private static DAOArtifactReview instance;
	static {
		try {
			instance = new DAOArtifactReview();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOArtifactReview() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOArtifactReview getInstance() {
		return instance;
	}
	
	public boolean createArtifactReview(int assignmentID, String artifactTitle, int writerID, String writer, String text, String date) {
		int affectedRows = -1;
		String updateSQL = null;
		String selectSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();) {
			selectSQL = "SELECT COUNT(1) FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\') AND (writerID = " + String.valueOf(writerID) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) > 0) {
					throw new Exception("Artifact Review Already Exists! :DAOArtifactReview:createArtifactReview()");
				}
			} catch (Exception e) {
				throw e;
			}
			int lastID = getLastArtifactReviewID() + 1;
			updateSQL = "INSERT INTO [ArtifactReview] VALUES (" + String.valueOf(lastID) + "," + String.valueOf(assignmentID) + ",\'" + artifactTitle + "\'," + String.valueOf(writerID) + ",\'" + writer + "\',\'" + text + "\',\'" + date + "\');";
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return affectedRows > 0;
	}
	
	public int getLastArtifactReviewID() {
		int lastID = 0;
		String selectSQL = "";
		int rowCount;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
				System.out.println("Connection established in :DAOArtifactReview:getLastArtifactReviewID()");
				selectSQL = "SELECT COUNT(1) FROM [ArtifactReview]";
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					rowCount = res.getInt(1);
					if(rowCount == 0) {
						lastID = 0;
						return lastID;
					}else {
						selectSQL = "SELECT MAX(artifactReviewID) FROM [ArtifactReview]";
					}
				} catch (Exception e) {
					throw e;
				}
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					lastID = res.getInt(1);
				} catch (Exception e) {
					throw e;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		return lastID;
	}
	
	public ArtifactReview getArtifactReview(int assignmentID, String artifactTitle, int writerID) {
		ArtifactReview ar = null;
		String selectSQL = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOArtifactReview:getArtifactReview");
			selectSQL = "SELECT * FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\') AND (writerID = " + String.valueOf(writerID) +");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				if(res.next()) {
					ar = new ArtifactReview(res.getInt("writerID"), res.getString("text"), format.parse(res.getString("date")), res.getInt("artifactReviewID"),  res.getString("writer"));
				}else {
					throw new Exception("No artifactReview found for assignmentID = " + String.valueOf(assignmentID) + ": artifactTitle = " + artifactTitle + ": writerID = " + String.valueOf(writerID) + " in :DAOArtifactReview:getArtifactReview(int assignmentID, String artifactTitle, int writerID)");
				}
				
				
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ar;
	}
	
	public ArrayList<ArtifactReview> getAllArtifactReviews(int assignmentID, String artifactTitle) {
		ArrayList<ArtifactReview> ar = new ArrayList<ArtifactReview>();
		String selectSQL = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOArtifactReview:getArtifactReview");
			selectSQL = "SELECT * FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\')" + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				while(res.next()) {
					ar.add(new ArtifactReview(res.getInt("writerID"), res.getString("text"), format.parse(res.getString("date")), res.getInt("artifactReviewID"),  res.getString("writer")));
				}
				
				
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ar;
	}
	
	public ArtifactReview getArtifactReview(int reviewID) {
		ArtifactReview ar = null;
		String selectSQL = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOArtifactReview:getArtifactReview(reviewID)");
			selectSQL = "SELECT * FROM [ArtifactReview] WHERE artifactReviewID = " + String.valueOf(reviewID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				if(res.next()) {
					ar = new ArtifactReview(res.getInt("writerID"), res.getString("text"), format.parse(res.getString("date")), res.getInt("artifactReviewID"),  res.getString("writer"));
				}else {
					throw new Exception("No artifactReview found for artifactReviewID = " + String.valueOf(reviewID) + " in :DAOArtifactReview:getArtifactReview(int assignmentID, String artifactTitle, int writerID)");
				}
				
				
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ar;
	}
	
	
	public boolean updateArtifactReview(int assignmentID, String artifactTitle, int writerID, String newText, String newDate) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOArtifactReview:updateArtifactReview(int assignmentID, String artifactTitle, int writerID, String newText, String newDate)");
			selectSQL = "SELECT COUNT(1) FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\') AND (writerID = " + String.valueOf(writerID) +");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				if(res.next()) {
					updateSQL = "UPDATE [ArtifactReview] SET text = \'" + newText + "\', date = \'" + newDate + "\' WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\') AND (writerID = " + String.valueOf(writerID) +");";
				}else {
					throw new Exception("No artifactReview found for assignmentID = " + String.valueOf(assignmentID) + ": artifactTitle = " + artifactTitle + ": writerID = " + String.valueOf(writerID) + " in :DAOArtifactReview:updateArtifactReview(int assignmentID, String artifactTitle, int writerID, String newText, String newDate)");
				}
				
				
			} catch (Exception e) {
				throw e;
			}
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return affectedRows > 0;
	}
	
	
	public boolean updateArtifactReview(int reviewID, int writerID, String newText, String newDate) {
		int affectedRows = -1;
		
		String selectSQL = null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOArtifactReview:updateArtifactReview(int reviewID, int writerID, String newText, String newDate)");
			selectSQL = "SELECT writerID FROM [ArtifactReview] WHERE artifactReviewID = " + String.valueOf(reviewID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				if(res.next()) {
					if(res.getInt(1) != writerID) {
						throw new Exception("Artifact Review with artifactReviewID = " + String.valueOf(reviewID) + " can't be edited by User with userID = " + String.valueOf(writerID));
					}
					updateSQL = "UPDATE [ArtifactReview] SET text = \'" + newText + "\', date = \'" + newDate + "\' WHERE artifactReviewID = " + String.valueOf(reviewID) + ";";
				}else {
					throw new Exception("No artifactReview found for artifactReviewID = " + String.valueOf(reviewID) + " in :DAOArtifactReview:updateArtifactReview(int reviewID, int writerID, String newText, String newDate)");
				}
				
				
			} catch (Exception e) {
				throw e;
			}
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return affectedRows > 0;
	}
	
	
	public boolean deleteArtifactReview(int assignmentID, String artifactTitle, int writerID) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOArtifactReview:deleteArtifactReview()");
			selectSQL = "SELECT writerID FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\') AND (writerID = " + String.valueOf(writerID) +");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				if(res.next()) {
					if(res.getInt(1) != writerID) {
						throw new Exception("Artifact Review with assignmentID = " + String.valueOf(assignmentID) + " AND artifactTitle = " + artifactTitle + " can't be edited by User with userID = " + String.valueOf(writerID));
					}
					updateSQL = "DELETE FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\') AND (writerID = " + String.valueOf(writerID) +");";;
				}else {
					throw new Exception("No artifactReview found for assignmentID = " + String.valueOf(assignmentID) + ": artifactTitle = " + artifactTitle + ": writerID = " + String.valueOf(writerID) + " in :DAOArtifactReview:deleteArtifact()");
				}
				
				
			} catch (Exception e) {
				throw e;
			}
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows > 0;
	}
	
	public boolean deleteArtifactReview(int assignmentID, String artifactTitle) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOArtifactReview:deleteArtifactReview(assignmentID,artifactTitle)");
			selectSQL = "SELECT COUNT(1) FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\');";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("Artifact Review with assignmentID = " + String.valueOf(assignmentID) + " AND artifactTitle = " + artifactTitle + " is not found on ArtifactReview Table.");
				}
				updateSQL = "DELETE FROM [ArtifactReview] WHERE (assignmentID = " + String.valueOf(assignmentID) + ") AND (artifactTitle = \'" + artifactTitle + "\');";
				
				
			} catch (Exception e) {
				throw e;
			}
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows > 0;
	}
}
