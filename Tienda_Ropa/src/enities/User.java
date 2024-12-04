package enities;

public class User {
	
	private int id;
	private String name = "Pepe";
	private String userType;
	
	//Constructor//
	
	public User(int id, String name, String userType) {
		
		this.id = id;
		this.name = name;
		this.userType = userType;
	}
	
	
	//Constructor antes que la BD le asigne número//
	
	public User(String name, String userType) {
		
		this.name = name;
		this.userType = userType;
	}
	
	//getters and setters//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
