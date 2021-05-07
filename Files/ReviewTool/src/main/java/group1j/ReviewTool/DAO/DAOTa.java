package group1j.ReviewTool.DAO;
import group1j.ReviewTool.BusinessLogic.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOTa {
	private String connectionUrl, user, passw;
	private static DAOTa instance;
	static {
		try {
			instance = new DAOTa();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOTa() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOTa getInstance() {
		return instance;
	}
	
	public TA getTAData(int userID) {
		TA ta = null;
		String selectSQL = null;
		User initialData = DAOUser.getInstance().getUserData(userID);
		ResultSet resultSet = null;
		if(initialData != null) {
			try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
					Statement statement = connection.createStatement();){
				selectSQL = "SELECT userType FROM [User] WHERE userID = " + String.valueOf(userID) + ";";
				try (ResultSet res = statement.executeQuery(selectSQL);){
					res.next();
					if(res.getString(1).equals("ta")) {
						selectSQL = "SELECT studentID FROM [Student];";
						resultSet = statement.executeQuery(selectSQL);
						ArrayList<Integer> studentList = new ArrayList<Integer>();
						while(resultSet.next()) {
							studentList.add(resultSet.getInt(1));
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
						
						ta = new TA(initialData.getEmail(), initialData.getName(), initialData.getSurname(), initialData.getPassword(), userID, studentList, sectionList, groupList, assignmentList);
					}else {
						throw new Exception("User with userID = " + String.valueOf(userID) + " is not a TA.");
					}
				} catch (Exception e) {
					throw e;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ta;
	}
}
