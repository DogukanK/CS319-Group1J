package group1j.ReviewTool.DAO;
import group1j.ReviewTool.BusinessLogic.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAOPeerReview {
	private String connectionUrl, user, passw;
	private static DAOPeerReview instance;
	static {
		try {
			instance = new DAOPeerReview();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOPeerReview() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOPeerReview getInstance() {
		return instance;
	}
	
	public boolean createPeerReview(int toStudent, int giverID, String description, double grade, String date) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOPeerReview :createPeerReview()");
			selectSQL = "SELECT COUNT(1) FROM [PeerReview] WHERE (toStudent = " + String.valueOf(toStudent) + ") AND (giverID = " + String.valueOf(giverID) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) <= 0) {
					updateSQL = "INSERT INTO [PeerReview] VALUES(" + String.valueOf(toStudent) + ", " + String.valueOf(giverID) + ",\'" + description + "\'," + String.valueOf(grade) + ",\'" + date + "\');";
					
				}else {
					throw new Exception("Peer Review with toStudent = " + String.valueOf(toStudent) + " AND giverID = " + String.valueOf(giverID) + " already exists!");
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
	
	public PeerReview getPeerReview(int toStudent, int giverID) {
		PeerReview pr = null;
		String selectSQL = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOPeerReview :getPeerReview()");
			selectSQL = "SELECT * FROM [PeerReview] WHERE (toStudent = " + String.valueOf(toStudent) + ") AND (giverID = " + String.valueOf(giverID) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				
				if(res.next()) {
					pr = new PeerReview(res.getInt("giverID"), res.getString("description"), res.getFloat("grade"), format.parse(res.getString("date")) );
					
				}else {
					throw new Exception("Peer Review with toStudent = " + String.valueOf(toStudent) + " AND giverID = " + String.valueOf(giverID) + " is NOT found!");
				}
			} catch (Exception e) {
				throw e;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pr;
	}
	
	
	public ArrayList<PeerReview> getAllPeerReviewsByToStudent(int toStudent){
		ArrayList<PeerReview> prList = new ArrayList<PeerReview>();
		String selectSQL= null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOPeerReview :getAllPeerReviewsByToStudent()");
			selectSQL = "SELECT * FROM [PeerReview] WHERE (toStudent = " + String.valueOf(toStudent) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				
				while(res.next()) {
					prList.add(new PeerReview(res.getInt("giverID"), res.getString("description"), res.getFloat("grade"), format.parse(res.getString("date")) ) );	
				}
			} catch (Exception e) {
				throw e;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prList;
	}
	
	public ArrayList<PeerReview> getAllPeerReviewsByGiverID(int giverID){
		ArrayList<PeerReview> prList = new ArrayList<PeerReview>();
		String selectSQL= null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOPeerReview :getAllPeerReviewsByGiverID()");
			selectSQL = "SELECT * FROM [PeerReview] WHERE (giverID = " + String.valueOf(giverID) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				
				while(res.next()) {
					prList.add(new PeerReview(res.getInt("giverID"), res.getString("description"), res.getFloat("grade"), format.parse(res.getString("date")) ) );	
				}
			} catch (Exception e) {
				throw e;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prList;
	}
	
	public boolean changeGrade(int toStudent, int giverID, double newGrade, String date) {
		int affectedRows = -1;
		String selectSQL= null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOPeerReview :changeGrade()");
			selectSQL = "SELECT COUNT(1) FROM [PeerReview] WHERE (giverID = " + String.valueOf(giverID) + ") AND (toStudent = " + String.valueOf(toStudent) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) > 0) {
					updateSQL = "UPDATE [PeerReview] SET grade = " + String.valueOf(newGrade) + " WHERE (giverID = " + String.valueOf(giverID) + ") AND (toStudent = " + String.valueOf(toStudent) + ");";
				}else {
					throw new Exception("PeerReview with toStudent = " + String.valueOf(toStudent) + " AND giverID = " + String.valueOf(giverID) + " doesn't exist.");
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
	
	public boolean changeDescription(int toStudent, int giverID, String description, String date) {
		int affectedRows = -1;
		String selectSQL= null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOPeerReview :changeDescription()");
			selectSQL = "SELECT COUNT(1) FROM [PeerReview] WHERE (giverID = " + String.valueOf(giverID) + ") AND (toStudent = " + String.valueOf(toStudent) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) > 0) {
					updateSQL = "UPDATE [PeerReview] SET description = \'" + description + "\' WHERE (giverID = " + String.valueOf(giverID) + ") AND (toStudent = " + String.valueOf(toStudent) + ");";
				}else {
					throw new Exception("PeerReview with toStudent = " + String.valueOf(toStudent) + " AND giverID = " + String.valueOf(giverID) + " doesn't exist.");
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
	
	public boolean deletePeerReview(int toStudent, int giverID) {
		int affectedRows = -1;
		String selectSQL= null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOPeerReview :deletePeerReview()");
			selectSQL = "SELECT COUNT(1) FROM [PeerReview] WHERE (giverID = " + String.valueOf(giverID) + ") AND (toStudent = " + String.valueOf(toStudent) + ");";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) > 0) {
					updateSQL = "DELETE FROM [PeerReview] WHERE (giverID = " + String.valueOf(giverID) + ") AND (toStudent = " + String.valueOf(toStudent) + ");";
				}else {
					throw new Exception("PeerReview with toStudent = " + String.valueOf(toStudent) + " AND giverID = " + String.valueOf(giverID) + " doesn't exist.");
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
}
