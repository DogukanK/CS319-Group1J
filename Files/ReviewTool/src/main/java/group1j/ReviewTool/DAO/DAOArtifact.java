package group1j.ReviewTool.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOArtifact {
	private String connectionUrl, user, passw;
	private static DAOArtifact instance;
	static {
		try {
			instance = new DAOArtifact();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DAOArtifact() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connectionUrl = "jdbc:sqlserver://localhost;" + "database=CS319ProjectSQL";
		user = "sa";
        passw = "684259Ank!";
	}
	
	public static DAOArtifact getInstance() {
		return instance;
	}
	
	public boolean createArtifact(int assignmentID, String artifactTitle) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		String artifactsAsString;
		//XXX
		try(Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement();) {
			System.out.println("Connection Established in :DAOArtifact :createArtifact()");
			selectSQL = "SELECT artifacts FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL)){
				res.next();
				artifactsAsString = res.getString(1);
				String artifactsAsList[] = artifactsAsString.split(",");
				ArrayList<String> ar = new ArrayList<String>();
				if(!artifactsAsList[0].equals("")) {
					for(String s: artifactsAsList) {
						ar.add(s);
					}
					if(ar.contains(artifactTitle)) {
						throw new Exception("Artifact With artifactTitle = " + artifactTitle + " already exists for assignmentID = " + String.valueOf(assignmentID) + ":DAOArtifact :createArtifact()");
					}else {
						artifactsAsString = artifactsAsString + "," + artifactTitle;
					}
				}else {
					artifactsAsString = artifactTitle;
				}
			} catch (Exception e) {
				throw e;
			}
			
			updateSQL = "UPDATE [Assignment] SET artifacts = \'" + artifactsAsString + "\' WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows > 0;
	}
	
	public boolean deleteArtifact(int assignmentID, String artifactTitle) {
		int affectedRows = -1;
		String selectSQL = null;
		String updateSQL = null;
		String artifactsAsString;
		//XXX
		try(Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement();) {
			System.out.println("Connection Established in :DAOArtifact :deleteArtifact()");
			selectSQL = "SELECT artifacts FROM [Assignment] WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			try (ResultSet res = statement.executeQuery(selectSQL)){
				res.next();
				artifactsAsString = res.getString(1);
				String artifactsAsList[] = artifactsAsString.split(",");
				ArrayList<String> ar = new ArrayList<String>();
				if(!artifactsAsList[0].equals("")) {
					for(String s: artifactsAsList) {
						ar.add(s);
					}
					if(ar.contains(artifactTitle)) {
						ar.remove(artifactTitle);
						artifactsAsString = "";
						for(int i = 0; i < ar.size(); i++) {
							if(i == (ar.size() - 1)) {
								artifactsAsString = artifactsAsString + ar.get(i);
							}else {
								artifactsAsString = artifactsAsString + ar.get(i) + ",";
							}
						}
					}else {
						throw new Exception("Artifact With artifactTitle = " + artifactTitle + " already exists for assignmentID = " + String.valueOf(assignmentID) + ":DAOArtifact :deleteArtifact()");
					}
				}else {
					throw new Exception("Artifact With artifactTitle = " + artifactTitle + " doesn't exist for assignmentID = " + String.valueOf(assignmentID) + ":DAOArtifact :deleteArtifact()");
				}
			} catch (Exception e) {
				throw e;
			}
			
			updateSQL = "UPDATE [Assignment] SET artifacts = \'" + artifactsAsString + "\' WHERE assignmentID = " + String.valueOf(assignmentID) + ";";
			affectedRows = statement.executeUpdate(updateSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows > 0;
	}
}
