package group1j.ReviewTool.DAO;
import group1j.ReviewTool.BusinessLogic.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOStudent {
	private String connectionUrl, user, passw;
	private static DAOStudent instance;
	static {
		try {
			instance = new DAOStudent();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOStudent() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOStudent getInstance() {
		return instance;
	}
	
	public boolean addStudent(Student aStudent) {
		int affectedRows = 0;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String selectSQL = null;
		String updateSQL;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOUser: addUser()");
            selectSQL = "SELECT COUNT(1) FROM [Student] WHERE studentID = " + String.valueOf(aStudent.getStudentID()) + ";";
            resultSet = statement.executeQuery(selectSQL);
            resultSet.next();
        	if(resultSet.getInt(1) == 1) {
        		throw new Exception("Student with studentID = " + String.valueOf(aStudent.getUserID()) + " already exists!");
        	}
            updateSQL = "INSERT INTO [Student] VALUES (" +  String.valueOf(aStudent.getUserID()) + "," + String.valueOf(aStudent.getGroupID()) + "," + String.valueOf(aStudent.getSection()) + ");";
            affectedRows = statement.executeUpdate(updateSQL);
			
		}catch(Exception e) {
			e.printStackTrace();
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
		
		return affectedRows > 0;
	}
	
	public boolean addStudent(int studentID, int groupID, int sectionID) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
            Statement statement = connection.createStatement();){
			selectSQL = "SELECT COUNT(1) FROM [Student] WHERE studentID = " + String.valueOf(studentID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) > 0) {
					throw new Exception("Student with studentID = " + String.valueOf(studentID) + " already exists in Student table!!");
				}else {
					updateSQL = "INSERT INTO [Student] VALUES (" + String.valueOf(studentID) + "," + String.valueOf(groupID) + "," + String.valueOf(sectionID) + ");";
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
	
	public Student getStudentData(int studentID) {
		Student temp = null;
		DAOUser userDAO = DAOUser.getInstance();
		User initialData = userDAO.getUserData(studentID);
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOStudent: getStudentData(studentID)");
            selectSQL = "SELECT groupID, section FROM [Student] WHERE studentID=" + String.valueOf(studentID) + ";";
            resultSet = statement.executeQuery(selectSQL);
            if(resultSet.next()) {
            	temp = new Student(initialData.getEmail(), initialData.getName(), initialData.getSurname(), initialData.getPassword(), initialData.getUserID(), initialData.getUserID(), resultSet.getInt(1), resultSet.getInt(2));
            	ArrayList<PeerReview> peerReviews = DAOPeerReview.getInstance().getAllPeerReviewsByToStudent(studentID);
            	for(PeerReview p : peerReviews) {
            		temp.addReview(p);
            	}
            	System.out.println(String.valueOf(temp.getReviews().size()) + ":" + String.valueOf(studentID) +  ":DAOStudent:getStudentData()");
            	
            }else {
            	System.out.println("Data not found in Student table for studentID = " + String.valueOf(studentID) + " DAOStudent:getStudentData()");
            }
		}catch(Exception e) {
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
		return temp;
	}
	
	public int getStudentGroup(int studentID) {
		int studentGroup = -1;
		String selectSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOStudent:getStudentGroup()");
			selectSQL = "SELECT COUNT(1) FROM [Student] WHERE studentID = " + String.valueOf(studentID) + ";";
			try(ResultSet res = statement.executeQuery(selectSQL);) {
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("Student with studentID = " + String.valueOf(studentID) + " is not found on Student Table.");
				}else if(res.getInt(1) > 1) {
					throw new Exception("Multiple records found for Student with studentID = " + String.valueOf(studentID) + " on Student Table.");
				}else {
					selectSQL = "SELECT groupID FROM [Student] WHERE studentID = " + String.valueOf(studentID) + ";";
				}
			} catch (Exception e) {
				throw e;
			}
			ResultSet res = statement.executeQuery(selectSQL);
			res.next();
			studentGroup = res.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return studentGroup;
	}
	
	public int getStudentSection(int studentID) {
		int sectionID = -1;
		String selectSQL = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOStudent:getStudentSection()");
			selectSQL = "SELECT COUNT(1) FROM [Student] WHERE studentID = " + String.valueOf(studentID) + ";";
			try(ResultSet res = statement.executeQuery(selectSQL);) {
				res.next();
				if(res.getInt(1) == 0) {
					throw new Exception("Student with studentID = " + String.valueOf(studentID) + " is not found on Student Table.");
				}else if(res.getInt(1) > 1) {
					throw new Exception("Multiple records found for Student with studentID = " + String.valueOf(studentID) + " on Student Table.");
				}else {
					selectSQL = "SELECT section FROM [Student] WHERE studentID = " + String.valueOf(studentID) + ";";
				}
			} catch (Exception e) {
				throw e;
			}
			ResultSet res = statement.executeQuery(selectSQL);
			res.next();
			sectionID = res.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return sectionID;
	}
	
	public boolean changeGroup(int studentID, int newGroupID) {
		int affectedRows = -1;
		String updateSQL = null;
		try(Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOStudent:changeGroup()");
			updateSQL = "UPDATE [Student] SET groupID = " + String.valueOf(newGroupID) + " WHERE studentID = " + String.valueOf(studentID) + ";";
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows > 0;
	}
	
	
	public boolean changeSection(int studentID, int newSectionID) {
		int affectedRows = -1;
		String updateSQL = null;
		try(Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOStudent:changeSection()");
			updateSQL = "UPDATE [Student] SET section = " + String.valueOf(newSectionID) + " WHERE studentID = " + String.valueOf(studentID) + ";";
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows > 0;
	}
	
	
	public boolean deleteStudent(int studentID) {
		int affectedRows = -1;
		String updateSQL = null;
		try(Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOStudent:deleteStudent()");
			updateSQL = "DELETE FROM [Student] WHERE studentID = " + String.valueOf(studentID) + ";";
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows > 0;
	}
	
}
