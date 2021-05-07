package group1j.ReviewTool.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import group1j.ReviewTool.BusinessLogic.*;

public class DAOGroup {
	private String connectionUrl, user, passw;
	private static DAOGroup instance;
	static {
		try {
			instance = new DAOGroup();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOGroup() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "cs319Login";
        passw = "1234CS319Project";
	}
	
	public static DAOGroup getInstance() {
		return instance;
	}
	
	public boolean createGroup(Group group) {
		int affectedRows = 0;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		ResultSet resultSet = null;
		String updateSQL = null;
		
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOGroup: createGroup()");
            selectSQL = "SELECT COUNT(1) FROM [Group] WHERE groupID = " + String.valueOf(group.getGroupID()) + ";";
            resultSet = statement.executeQuery(selectSQL);
            resultSet.next();
            if(resultSet.getInt(1) == 1) {
            	throw new Exception("Group with groupID = " + String.valueOf(group.getGroupID()) + " already exists!");
            }
            
            updateSQL = "INSERT INTO [Group] VALUES (" + String.valueOf(group.getGroupID()) + ",\'";
            ArrayList<Integer> memberList = group.getMembers();
            ArrayList<Integer> assignmentList = group.getAssignments();
            if(memberList.size() != 0) {
            	for(int i = 0; i < memberList.size(); i++)
                {
                	if(i == (memberList.size() - 1)) {
                		updateSQL = updateSQL + String.valueOf(memberList.get(i)) + "\', \'";
                	}else {
                		updateSQL = updateSQL + String.valueOf(memberList.get(i)) + ",";
                	}
                }
            }else {
            	updateSQL = updateSQL + "\',\'";
            }
            
            if(assignmentList.size() != 0) {
            	for(int i = 0; i < assignmentList.size(); i++) {
                	if(i == (assignmentList.size() - 1)) {
                		updateSQL = updateSQL + String.valueOf(assignmentList.get(i)) + "\');";
                	}else {
                		updateSQL = updateSQL + String.valueOf(assignmentList.get(i)) + ",";
                	}
                }
            }else {
            	updateSQL = updateSQL + "\');";
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
	
	public Group getGroupData(int groupID) {
		Group gr = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOGroup: getGroupData()");
            selectSQL = "SELECT members, assignments FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
            resultSet = statement.executeQuery(selectSQL);
            if(resultSet.next()) {
            	String memberList[] = resultSet.getString(1).split(",");
            	ArrayList<Integer> members = new ArrayList<Integer>();
            	if(!memberList[0].equals("")) {
            		for(int i = 0; i < memberList.length; i++) {
                		members.add(Integer.parseInt(memberList[i]));
                	}
            	}
            	
            	
            	String assignmentList[] = resultSet.getString(2).split(",");
            	ArrayList<Integer> assignments = new ArrayList<Integer>();
            	if(!assignmentList[0].equals("")) {
	            	for(int i = 0; i < assignmentList.length; i++) {
	            		System.out.println("Input Integer String =" + assignmentList[i] + " :DAOGroup:getGroupData()");
	            		assignments.add(Integer.parseInt(assignmentList[i]));
	            	}
            	}
            	
            	gr = new Group(assignments, members, groupID);
            }else {
            	System.out.println("No data found for Group in Table Group for groupID = " + String.valueOf(groupID) + " :DAOGroup:getGroupData()");
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
		
		
		return gr;
	}
	
	public boolean addGroupMember(int groupID, int studentID) {
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		ResultSet resultSet = null;
		String updateSQL = null;
		int affectedRows = 0;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOGroup: addGroupMember()");
            selectSQL = "SELECT COUNT(1) FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
            resultSet = statement.executeQuery(selectSQL);
            resultSet.next();
            if(resultSet.getInt(1) == 1) {
            	selectSQL = "SELECT members FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
            	resultSet = statement.executeQuery(selectSQL);
            	resultSet.next();
            	String membersAsString = resultSet.getString(1);
            	String membersAsStringList[] = membersAsString.split(",");
            	ArrayList<Integer> members = new ArrayList<Integer>();
            	if(!membersAsStringList[0].equals("")) {
	            	for(int i = 0; i < membersAsStringList.length; i++) {
	            		members.add(Integer.parseInt(membersAsStringList[i]));
	            	}
	            	if(members.contains(studentID)) {
	            		throw new Exception("Student with studentID = " + String.valueOf(studentID) + " already in Group with groupID = " + String.valueOf(groupID) + "!");
	            	}
	            	membersAsString = membersAsString + ",";
            	}
            	
            	
            	membersAsString = membersAsString + String.valueOf(studentID);
            	
            	updateSQL = "UPDATE [Group] SET members = \'" + membersAsString + "\' WHERE groupID = " + String.valueOf(groupID) + ";";
            	affectedRows = statement.executeUpdate(updateSQL);
            }else {
            	throw new Exception("Group with groupID = " + String.valueOf(groupID) + " doesn't exist!");
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
		
		return affectedRows > 0;
	}
	
	
	
	public boolean addAssignmentToGroup(int assignmentID, int groupID) {
		int affectedRows = 0;
		Connection connection = null;
		Statement statement = null;
		String selectSQL;
		ResultSet resultSet = null;
		String updateSQL = null;
		try {
			connection = DriverManager.getConnection(connectionUrl, user, passw);
            statement = connection.createStatement();
            System.out.println("Connection established in DAOGroup: addAssignmentToGroup()");
            selectSQL = "SELECT assignments FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
            resultSet = statement.executeQuery(selectSQL);
            resultSet.next();
            String assignmentString = resultSet.getString(1);
            String assignmentStringList[] = assignmentString.split(",");
            ArrayList<Integer> currentAssignments = new ArrayList<Integer>();
            if(!assignmentStringList[0].equals("")) {
	            for(int i = 0; i < assignmentStringList.length; i++) {
	            	currentAssignments.add(Integer.parseInt(assignmentStringList[i]));
	            }
	            if(currentAssignments.contains(assignmentID)) {
	            	throw new Exception("Assignment with assignmentID = " + String.valueOf(assignmentID) + " already exists for Group with groupID = " + String.valueOf(groupID) + " :DAOGroup:addAssignmentToGroup()");
	            }
	            assignmentString = assignmentString + "," + String.valueOf(assignmentID);
            }else {
            	assignmentString = String.valueOf(assignmentID);
            }
            
            
            
            updateSQL = "UPDATE [Group] SET assignments = \'" + assignmentString + "\' WHERE groupID = " + String.valueOf(groupID) + ";";
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
	
	public ArrayList<Integer> getAllGroupID(){
		ArrayList<Integer> idList = new ArrayList<Integer>();
		String selectSQL = null;
		try(Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
	            Statement statement = connection.createStatement();) {
			System.out.println("Connection established in :DAOGroup:getAllGroupID()");
			selectSQL = "SELECT groupID FROM [Group];";
			try (ResultSet res = statement.executeQuery(selectSQL)){
				while(res.next()) {
					idList.add(res.getInt(1));
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return idList;
	}
	
	public boolean removeMemberFromGroup(int groupID, int studentID) {
		int affectedRows = 0;
		String selectSQL = null;
		String updateSQL = null;
		String membersAsString;
		try (Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :DAOGroup:removeMemberFromGroup()");
			selectSQL = "SELECT members FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				membersAsString = res.getString(1);
            	String membersAsStringList[] = membersAsString.split(",");
            	ArrayList<Integer> members = new ArrayList<Integer>();
            	for(int i = 0; i < membersAsStringList.length; i++) {
            		members.add(Integer.parseInt(membersAsStringList[i]));
            	}
            	if(members.contains(studentID)) {
            		membersAsString = "";
            		members.remove((Integer) studentID);
            		for(int i = 0; i < members.size(); i++) {
            			if(i != (members.size() - 1)) {
            				membersAsString = membersAsString + String.valueOf(members.get(i)) + ",";
            			}else {
            				membersAsString = membersAsString + String.valueOf(members.get(i));
            			}
            		}
            	}else {
            		throw new Exception("Student with studentID = " + String.valueOf(studentID) + " is not in Group with groupID = " + String.valueOf(groupID) + "!");
            	}
			}catch(Exception e) {
				throw e;
			}
			updateSQL = "UPDATE [Group] SET members = \'" + membersAsString + "\' WHERE groupID = " + String.valueOf(groupID) + ";";
			affectedRows = statement.executeUpdate(updateSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return affectedRows > 0;
	}
	
	public boolean removeAssignmentFromGroup(int groupID, int assignmentID) {
		int affectedRows = 0;
		String selectSQL = null;
		String updateSQL = null;
		String assignmentsAsString;
		try(Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :removeAssignmentFromGroup()");
			selectSQL = "SELECT assignments FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
			try(ResultSet res = statement.executeQuery(selectSQL);){
				res.next();
				assignmentsAsString = res.getString(1);
				String assignmentsAsStringList[] = assignmentsAsString.split(",");
				ArrayList<Integer> assignments = new ArrayList<Integer>();
				if(!assignmentsAsStringList[0].equals("")) {
					for(int i = 0; i < assignmentsAsStringList.length; i++) {
						assignments.add(Integer.parseInt(assignmentsAsStringList[i]));
					}
				}
				
				if(assignments.contains(assignmentID)) {
					assignmentsAsString = "";
					assignments.remove((Integer) assignmentID);
					for(int i = 0; i < assignments.size(); i++) {
						if(i != (assignments.size() - 1) ) {
							assignmentsAsString = assignmentsAsString + String.valueOf(assignments.get(i)) + ",";
						}else {
							assignmentsAsString = assignmentsAsString + String.valueOf(assignments.get(i));
						}
					}
				}else {
					throw new Exception("Assignment with assignmentID = " + String.valueOf(assignmentID) + " is not in Group with groupID = " + String.valueOf(groupID) + "!");
				}
			}catch (Exception e){
				throw e;
			}
			updateSQL = "UPDATE [Group] SET assignments = \'" + assignmentsAsString + "\' WHERE groupID = " + String.valueOf(groupID) + ";";
			affectedRows = statement.executeUpdate(updateSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return affectedRows > 0;
	}
	
	public boolean deleteGroup(int groupID) {
		int affectedRows = 0;
		String selectSQL = null;
		String updateSQL = "";
		try(Connection connection = DriverManager.getConnection(connectionUrl, user, passw);
            Statement statement = connection.createStatement();){
			System.out.println("Connection established in :deleteGroup()");
			selectSQL = "SELECT COUNT(1) FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
			try(ResultSet res = statement.executeQuery(selectSQL)){
				res.next();
				if(res.getInt(1) == 1) {
					updateSQL = "DELETE FROM [Group] WHERE groupID = " + String.valueOf(groupID) + ";";
				}else {
					throw new Exception("Group with groupID = " + String.valueOf(groupID) + " not found!");
				}
			}catch(Exception e) {
				throw e;
			}
			
			affectedRows = statement.executeUpdate(updateSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return affectedRows > 0;
	}
}
