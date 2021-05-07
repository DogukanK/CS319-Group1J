package group1j.ReviewTool.BusinessLogic;


public class User {
	//properties
	private String email, name, surname, password, userType;
	private int userID;
	
	//constructors
	public User() {
		email = "";
		name = "";
		surname = "";
		password = "";
		userID = 0;
	}
	
	public User(String email, String name, String surname, String password, int userID, String userType) {
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.userID = userID;
		this.userType = userType;
	}
	
	//methods
	public String getEmail(){return email;}
	public String getName(){return name;}
	public String getSurname(){return surname;}
	public String getPassword(){return password;}
	public int getUserID(){return userID;}
	public String getUserType() {return userType;}
	
	public void setEmail(String email){this.email = email;}
	public void setName(String name){this.name = name;}
	public void setSurname(String surname) {this.surname = surname;}
	public void setPassword(String password) {this.password = password;}
	public void setUserID(int userID) {this.userID = userID;}
}
