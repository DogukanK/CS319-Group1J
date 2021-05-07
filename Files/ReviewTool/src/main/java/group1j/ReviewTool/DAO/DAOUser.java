package group1j.ReviewTool.DAO;
import group1j.ReviewTool.BusinessLogic.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class DAOUser {
	private String connectionUrl, user, passw;
	private static DAOUser instance;
	static {
		try {
			instance = new DAOUser();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOUser() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOUser getInstance() {
		return instance;
	}
	
	public boolean addUser(User aUser, String userType) {
		int affectedRows = 0;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		ResultSet resultSet = null;
		String updateSQL = null;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOUser: addUser()");
            switch(userType) {
            case "student":{
            	selectSQL = "SELECT Count(1) FROM [User] WHERE userID = " + String.valueOf(aUser.getUserID()) + ";";

            	resultSet = statement.executeQuery(selectSQL);
            	resultSet.next();
            	if(resultSet.getInt(1) == 1) {
            		throw new Exception("Student with studentID = " + String.valueOf(aUser.getUserID()) + " already exists!");
            	}else {
            		updateSQL = "INSERT INTO [User] VALUES (" +  String.valueOf(aUser.getUserID()) + ",\'" + aUser.getName() + "\',\'" + aUser.getSurname() + "\',\'" + userType + "\',\'" + aUser.getEmail() + "\',\'" + aUser.getPassword() + "\');";
            	}
            	//updateSQL = "INSERT INTO [User] VALUES (" +  String.valueOf(aUser.getUserID()) + ",\'" + aUser.getName() + "\',\'" + aUser.getSurname() + "\',\'" + userType + "\',\'" + aUser.getEmail() + "\',\'" + aUser.getPassword() + "\');";
            	break;
            }
            
            case "ta":{
            	selectSQL = "SELECT COUNT(1) FROM [User] WHERE email=\'" + aUser.getEmail() + "\';";
            	resultSet = statement.executeQuery(selectSQL);
            	resultSet.next();
            	if(resultSet.getInt(1) == 1) {
            		throw new Exception("TA with email = " + aUser.getEmail() + " already exists!");
            	}
            	selectSQL = "SELECT MAX(userID) FROM [User] WHERE userType = \'ta\';";
            	resultSet = statement.executeQuery(selectSQL);
                resultSet.next();
                updateSQL = "INSERT INTO [User] VALUES (" +  String.valueOf((resultSet.getInt(1) + 11)) + ",\'" + aUser.getName() + "\',\'" + aUser.getSurname() + "\',\'" + userType + "\',\'" + aUser.getEmail() + "\',\'" + aUser.getPassword() + "\');";
            	break;
            	
            }
            default:{
            	throw new Exception("Can't add new user of userType = " + userType + " :DAOUser:addUser()");
            }
            	
            }
            affectedRows = statement.executeUpdate(updateSQL);
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
		
		
		return affectedRows > 0;
	}
	
	
	public boolean loginUser(String email, String password) {
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		boolean r = false;
		try{
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
			System.out.println("Connection Established in: DAO: loginUser");
			String selectSQL = "SELECT passw FROM [dbo].[User] WHERE email=\'" + email + "\';";
			resultSet = statement.executeQuery(selectSQL);
			if(resultSet.next()) {
				String passwFromDatabase = resultSet.getString(1);
				
				
				if(password.equals(passwFromDatabase)) {
					
					selectSQL = "SELECT userID, userType FROM [User] WHERE email=\'" + email + "\';";
					resultSet = statement.executeQuery(selectSQL);
					if(resultSet.next()) {
						r = true;
					}else {
						System.out.println("Something went wrong with retrieving user data from database: DAO: loginUser");
					}
				}
			}else {
				System.out.println("Email Not Found: DAO: loginUser");
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
		return r;
	}
	
	public User getUserData(String email) {
		User temp = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOUser: getUserData(email)");
            selectSQL = "SELECT * FROM [User] WHERE email=\'" + email + "\';";
            resultSet = statement.executeQuery(selectSQL);
            if(resultSet.next()) {
            	temp = new User(resultSet.getString(5), resultSet.getString(2), resultSet.getString(3), resultSet.getString(6), resultSet.getInt(1), resultSet.getString(4));
            }else {
            	System.out.println("Data not found in User table for email = " + email + " :DAOUser:getUserData(email)");
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
	
	public User getUserData(int userID) {
		User temp = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOUser: getUserData(userID)");
            selectSQL = "SELECT * FROM [User] WHERE userID=" + userID + ";";
            resultSet = statement.executeQuery(selectSQL);
            if(resultSet.next()) {
            	temp = new User(resultSet.getString(5), resultSet.getString(2), resultSet.getString(3), resultSet.getString(6), resultSet.getInt(1), resultSet.getString(4));
            }else {
            	System.out.println("Data not found in User table for userID = " + userID + " :DAOUser:getUserData(userID)");
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
	
	
	public int getUserID(String email) {
		int userID = -1;
		String selectSQL = null;
		
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOUser:getUserID()");
			selectSQL = "SELECT userID FROM [User] WHERE email = \'" + email + "\';";
			try(ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				userID = res.getInt(1);
			}catch(Exception e){
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return userID;
	}
	
	public boolean changePassword(int userID, String oldPassword, String newPassword) {
		int affectedRows = -1;
		String selectSQL = "";
		String updateSQL = "";
		try(Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOUser:changePassword()");
			selectSQL = "SELECT passw FROM [User] WHERE userID = " + String.valueOf(userID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(!res.getString(1).equals(oldPassword)) {
					throw new Exception("oldPassword doesn't match with password in the database");
				}else {
					updateSQL = "UPDATE [User] SET passw = \'" + newPassword + "\' WHERE userID = " + String.valueOf(userID) + ";";
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
	
	public boolean changeEmail(int userID, String newMail) {
		int affectedRows = -1;
		String selectSQL = "";
		String updateSQL = "";
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOUser :changeEmail()");
			selectSQL = "SELECT COUNT(1) FROM [User] WHERE userID = " + String.valueOf(userID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) <= 0) {
					throw new Exception("User with userID = " + String.valueOf(userID) + " doesn't exist!");
				}else {
					updateSQL = "UPDATE [User] SET email = \'" + newMail + "\' WHERE userID = " + String.valueOf(userID) + ";";
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
	
	public boolean deleteUser(int userID) {
		int affectedRows = -1;
		String selectSQL = "";
		String updateSQL = "";
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOUser :deleteUser()");
			selectSQL = "SELECT COUNT(1) FROM [User] WHERE userID = " + String.valueOf(userID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				if(res.getInt(1) <= 0) {
					throw new Exception("User with userID = " + String.valueOf(userID) + " doesn't exist!");
				}else {
					updateSQL = "DELETE FROM [User] WHERE userID= " + String.valueOf(userID) + ";";
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
