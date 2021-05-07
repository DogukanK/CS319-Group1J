package group1j.ReviewTool.DAO;
import group1j.ReviewTool.BusinessLogic.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class DAOAssignment {
	private String connectionUrl, user, passw;
	private static DAOAssignment instance;
	static {
		try {
			instance = new DAOAssignment();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOAssignment() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOAssignment getInstance() {
		return instance;
	}
	
	public boolean createAssignment(int assignmentID, String title, int groupID, String description, String startDate, String dueDate) {
		int affectedRows = 0;
		String selectSQL;
		String updateSQL;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
			System.out.println("Connection Established in :DAOAssignment:createAssignment()");
			selectSQL = "SELECT COUNT(*) FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) == 1) {
					throw new Exception("Assignment with assignmentID = " + String.valueOf(assignmentID) + " already exists! :DAOAssignment:createAssignment()");
				}else {
					updateSQL = "INSERT INTO [Assignment] VALUES (" + String.valueOf(assignmentID) + ",\'" + title + "\'," + String.valueOf(groupID) + ",\'\',\'" + description + "\'," + "-1" + ",\'" + startDate + "\',\'" + dueDate + "\');"; 
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
	
	public Integer findAssignmentID(String title, int groupID) {
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		Integer assignmentID = null;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
			statement = connection.createStatement();
			System.out.println("Connection Established in DAOAssignment:findAssignmentID()");
			selectSQL = "SELECT assignmentID FROM [Assignment] WHERE ( (title = \'" + title + "\') AND (groupID = " + String.valueOf(groupID) + ") );";
			resultSet = statement.executeQuery(selectSQL);
			if(resultSet.next()) {
				assignmentID = resultSet.getInt(1);
				
			}else {
				System.out.println("No Assignment Data Found For title = " + title + " AND groupID = " + String.valueOf(groupID) + " :DAOAssignment:findAssignmentID()");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return assignmentID;
	}
	
	public Assignment getAssignment(int assignmentID) {
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		Assignment as = null;
		ArrayList<ArtifactReview> ar = new ArrayList<ArtifactReview>();
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
			statement = connection.createStatement();
			System.out.println("Connection Established in: DAOAssignment:getAssignment()");
			selectSQL = "SELECT * FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			resultSet = statement.executeQuery(selectSQL);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			if(resultSet.next()) {
				
				as = new Assignment(resultSet.getInt("assignmentID"), resultSet.getString("title"), resultSet.getInt("groupID"), resultSet.getString("description"), format.parse(resultSet.getString("startDate")), format.parse(resultSet.getString("dueDate")) );
				float grade = resultSet.getFloat("grade");
				if(grade != -1) {
					as.editGrade(grade);
				}
				String artifactsAsString = resultSet.getString("artifacts");
				String artifactList[] = artifactsAsString.split(",");
				if(!artifactList[0].equals("")) {
					for(int i = 0; i < artifactList.length; i++) {
						as.uploadArtifact(artifactList[i], new File("C:/Users/cagir/Desktop/cs319_proje/Final_Report.pdf"));
						ar = DAOArtifactReview.getInstance().getAllArtifactReviews(assignmentID, artifactList[i]);
						System.out.println("Artifact Title = " + artifactList[i] + " :DAOAssignment :getAssignment()");
						for(int j = 0; j < ar.size(); j++) {
							System.out.println("Artifact Review = " + artifactList[i] + ":" + ar.get(j).getText() + " :DAOAssignment :getAssignment()");
							as.uploadReview(ar.get(j).getReviewID(), artifactList[i], ar.get(j).getWriterID(), ar.get(j).getWriter(), ar.get(j).getText(), ar.get(j).getDate());
						}
					}
				}
			}else {
				System.out.println("No Assignment Data Found For assignmentID = " + String.valueOf(assignmentID) + " :getAssignment()");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return as;
	}
	
	public int getLastAssignmentID() {
		int lastAssignment = 0;
		String selectSQL = "";
		int rowCount;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
				System.out.println("Connection established in :DAOAssignment:editDescription()");
				selectSQL = "SELECT COUNT(1) FROM [Assignment]";
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					rowCount = res.getInt(1);
					if(rowCount == 0) {
						lastAssignment = 0;
						return lastAssignment;
					}else {
						selectSQL = "SELECT MAX(assignmentID) FROM [Assignment]";
					}
				} catch (Exception e) {
					throw e;
				}
				
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					lastAssignment = res.getInt(1);
				} catch (Exception e) {
					throw e;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		return lastAssignment;
	}
	public boolean editDescription(String title, String newDescription) {
		int rowsAffected = -2;
		int rowCount = -1;
		String selectSQL;
		String updateSQL;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
			Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOAssignment:editDescription()");
			selectSQL = "SELECT COUNT(*) FROM [Assignment] WHERE title = \'" + title + "\';";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				rowCount = res.getInt(1);
				if(rowCount == 0) {
					throw new Exception("No Assignment found with title = " + title + " in Assignment table. DAOAssignment:editDescription()");
				}else {
					updateSQL = "UPDATE [Assignment] SET description = \'" + newDescription + "\' WHERE title = \'" + title + "\';";
				}
			} catch (Exception e) {
				throw e;
			}
			
			rowsAffected = statement.executeUpdate(updateSQL);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return rowCount == rowsAffected;
	}
	
	public boolean addArtifact(int assignmentID, String artifactTitle) {
		int affectedRows = -1;
		String selectSQL = "";
		String updateSQL = "";
		String artifactString = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
				System.out.println("Connection established in :DAOAssignment:editDescription()");
				selectSQL = "SELECT COUNT(1) FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					if(res.getInt(1) == 0) {
						throw new Exception("No Assignment found with assignmentID = " + String.valueOf(assignmentID) + " in Assignment table. DAOAssignment:addArtifact()");
					}else {
						selectSQL = "SELECT artifacts FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
					}
				} catch (Exception e) {
					throw e;
				}
				
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					artifactString = res.getString(1);
				} catch (Exception e) {
					throw e;
				}
				
				String artifactsAsArr[] = artifactString.split(",");
				if(!artifactsAsArr[0].equals("")) {
					ArrayList<String> artifacts = new ArrayList<String>();
					artifacts.addAll(Arrays.asList(artifactsAsArr));
					if(!artifacts.contains(artifactTitle)) {
						artifactString = "";
						artifacts.add(artifactTitle);
						for(int i = 0; i < artifacts.size(); i++) {
							if( i == (artifacts.size() - 1)) {
								artifactString = artifactString + artifacts.get(i);
							}else {
								artifactString = artifactString + artifacts.get(i) + ",";
							}
						}
					}else {
						throw new Exception("Artifact with title = " + artifactTitle + " is already found in artifacts of Assignment with assignmentID = " + String.valueOf(assignmentID) + "!");
					}
				}else {
					artifactString = artifactTitle;
				}
				
				updateSQL = "UPDATE [Assignment] SET artifacts = \'" + artifactString + "\' WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
				
				affectedRows = statement.executeUpdate(updateSQL);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return affectedRows > 0;
	}
	
	public boolean removeArtifact(int assignmentID, String artifactTitle) {
		int affectedRows = -1;
		String selectSQL = "";
		String updateSQL = "";
		String artifactString = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = connection.createStatement();){
				System.out.println("Connection established in :DAOAssignment:editDescription()");
				selectSQL = "SELECT COUNT(1) FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					if(res.getInt(1) == 0) {
						throw new Exception("No Assignment found with assignmentID = " + String.valueOf(assignmentID) + " in Assignment table. DAOAssignment:addArtifact()");
					}else {
						selectSQL = "SELECT artifacts FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
					}
				} catch (Exception e) {
					throw e;
				}
				
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					artifactString = res.getString(1);
					String artifactsAsArr[] = artifactString.split(",");
					if(!artifactsAsArr[0].equals("")) {
						ArrayList<String> artifacts = new ArrayList<String>();
						artifacts.addAll(Arrays.asList(artifactsAsArr));
						if(artifacts.contains(artifactTitle)) {
							artifactString = "";
							artifacts.remove(artifactTitle);
							for(int i = 0; i < artifacts.size(); i++) {
								if( i == (artifacts.size() - 1)) {
									artifactString = artifactString + artifacts.get(i);
								}else {
									artifactString = artifactString + artifacts.get(i) + ",";
								}
							}
						}else {
							throw new Exception("Artifact with title = " + artifactTitle + " is not found in artifacts of Assignment with assignmentID = " + String.valueOf(assignmentID) + "!");
						}
					}else {
						throw new Exception("Artifact with title = " + artifactTitle + " is not found in artifacts of Assignment with assignmentID = " + String.valueOf(assignmentID) + "!");
					}
				} catch (Exception e) {
					throw e;
				}
				updateSQL = "UPDATE [Assignment] SET artifacts = \'" + artifactString + "\' WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
				
				affectedRows = statement.executeUpdate(updateSQL);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return affectedRows > 0;
	}
	
	
	public boolean gradeAssignment(int assignmentID, double grade) {
		int affectedRows = -1;
		String selectSQL = "";
		String updateSQL = "";
		try (Connection con = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = con.createStatement()){
			System.out.println("Connection established in :DAOAssignment :gradeAssignment()");
			selectSQL = "SELECT COUNT(1) FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("No assignment in Assignment table found with assignmentID = " + String.valueOf(assignmentID) + "!");
				}else if(res.getInt(1) > 1) {
					throw new Exception("Multiple assignments with assignmentID = " + String.valueOf(assignmentID) + " found in Assignment Table!");
				}else {
					updateSQL = "UPDATE [Assignment] SET grade = " + String.valueOf(grade) + " WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
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
	
	//TODO: Add check for startDate < dueDate
	public boolean changeDueDate(String title, String newDueDate) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection con = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = con.createStatement()){
			System.out.println("Connection established in :DAOAssignment :gradeAssignment()");
			selectSQL = "SELECT COUNT(1) FROM [Assignment] WHERE title = \'" + title + "\';";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("No assignment in Assignment table found with title = \'" + title + "\'!");
				}else {
					updateSQL = "UPDATE [Assignment] SET dueDate = \'" + newDueDate + "\' WHERE title = \'" + title + "\';";
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
	
	public boolean deleteAssignment(String title) {
		int affectedRows = -1;
		String selectSQL;
		String updateSQL;
		try (Connection con = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = con.createStatement()){
			System.out.println("Connection established in :DAOAssignment :gradeAssignment()");
			selectSQL = "SELECT COUNT(1) FROM [Assignment] WHERE title = \'" + title + "\';";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("No assignment in Assignment table found with title = \'" + title + "\'!");
				}else {
					updateSQL = "DELETE FROM [Assignment] WHERE title = \'" + title + "\';";
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
	
	public boolean deleteAssignmentByID(int assignmentID) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection con = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = con.createStatement()){
			System.out.println("Connection established in :DAOAssignment :gradeAssignment()");
			selectSQL = "SELECT COUNT(1) FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("No assignment in Assignment table found with assignmentID = " + String.valueOf(assignmentID) + "!");
				}else {
					updateSQL = "DELETE FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
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
	
	public boolean deleteAssignmentByGroup(int groupID) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection con = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = con.createStatement()){
			System.out.println("Connection established in :DAOAssignment :gradeAssignment()");
			selectSQL = "SELECT COUNT(1) FROM [Assignment] WHERE groupID = " + String.valueOf(groupID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("No assignment in Assignment table found with groupID = " + String.valueOf(groupID) + "!");
				}else {
					updateSQL = "DELETE FROM [Assignment] WHERE groupID = " + String.valueOf(groupID) + ";";
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
	
	public ArrayList<ArrayList<String>> getAllCurrentAssignments(){
		ArrayList<ArrayList<String>> cur = new ArrayList<ArrayList<String>>();
		String selectSQL = null;
		ArrayList<String> param = null;
		try (Connection con = DriverManager.getConnection(connectionUrl, user, passw);
				Statement statement = con.createStatement()){
			System.out.println("Connection established in :DAOAssignment :getAllCurrentAssignments()");
			selectSQL = "SELECT DISTINCT title, description, startDate, dueDate FROM [Assignment];";
			try (ResultSet res = statement.executeQuery(selectSQL)){
				while(res.next()) {
					param = new ArrayList<String>();
					param.add(res.getString(1));
					param.add(res.getString(2));
					param.add(res.getString(3));
					param.add(res.getString(4));
					cur.add(param);
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cur;
	}
}













































