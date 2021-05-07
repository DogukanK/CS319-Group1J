package group1j.ReviewTool.DAO;
import group1j.ReviewTool.BusinessLogic.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOInstructor {
	private String connectionUrl, user, passw;
	private static DAOInstructor instance;
	static {
		try {
			instance = new DAOInstructor();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOInstructor() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOInstructor getInstance() {
		return instance;
	}
	
	public Instructor getInstructorData(int userID) {
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		User initialData = DAOUser.getInstance().getUserData(userID);
		Instructor inst = null;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
			statement = connection.createStatement();
			//student list query
			selectSQL = "SELECT studentID FROM [Student];";
			resultSet = statement.executeQuery(selectSQL);
			ArrayList<Integer> studentList = new ArrayList<Integer>();
			while(resultSet.next()) {
				studentList.add(resultSet.getInt(1));
			}
			
			//TA list query
			selectSQL = "SELECT userID FROM [USER] WHERE userType = \'ta\';";
			resultSet = statement.executeQuery(selectSQL);
			ArrayList<Integer> taList = new ArrayList<Integer>();
			while(resultSet.next()) {
				taList.add(resultSet.getInt(1));
			}
			
			//section list query
			selectSQL = "SELECT DISTINCT section FROM [Student];";
			resultSet = statement.executeQuery(selectSQL);
			ArrayList<Integer> sectionList = new ArrayList<Integer>();
			while(resultSet.next()) {
				sectionList.add(resultSet.getInt(1));
			}
			
			//group list query
			selectSQL = "SELECT DISTINCT groupID FROM [Student];";
			resultSet = statement.executeQuery(selectSQL);
			ArrayList<Integer> groupList = new ArrayList<Integer>();
			while(resultSet.next()) {
				groupList.add(resultSet.getInt(1));
			}
			
			//assignment list query
			selectSQL = "SELECT DISTINCT assignmentID FROM [Assignment];";
			resultSet = statement.executeQuery(selectSQL);
			ArrayList<Integer> assignmentList = new ArrayList<Integer>();
			while(resultSet.next()) {
				assignmentList.add(resultSet.getInt(1));
			}
			
			inst = new Instructor(initialData.getEmail(), initialData.getName(), initialData.getSurname(), initialData.getPassword(), initialData.getUserID(), studentList, taList, sectionList, groupList, assignmentList);
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
		return inst;
	}
}
