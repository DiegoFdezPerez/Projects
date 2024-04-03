package data_acces;

import java.sql.*;
import java.util.*;

import enities.InventoryProduct;
import enities.User;


public class UserGateway {

	private static UserGateway instance;
	private Connection conn;
	

	public static UserGateway getInstance () {
		
		if ( instance == null) 
			instance = new UserGateway();
			
			return instance;	
	}
	
	public List<User> getAll() throws SQLException {
		
		List <User> users = new ArrayList <> ();
		
		try {
			
			final String querySQL = "SELECT * FROM usuarios";
			
			 ConnectDB myConnectDB = new ConnectDB();
			 conn = myConnectDB.openConnection();
			
			 Statement myStmt = conn.createStatement();
			 ResultSet myRs = myStmt.executeQuery(querySQL);
			   
			   while(myRs.next()) {
				   
				   User temp = new User(myRs.getInt("id"),myRs.getString("nombre"),myRs.getString("tipo"));
				   users.add(temp);
				   
			   }
			   
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		return users;
	}
	
	public User getById(int ID) throws SQLException {
		
		User user = null;
		
		try {
			
			final String querySQL = "SELECT * FROM usuarios WHERE id = ?";
			
			 ConnectDB myConnectDB = new ConnectDB();
			 conn = myConnectDB.openConnection();
			 
			 PreparedStatement myStmt = conn.prepareStatement(querySQL);
			 myStmt.setInt(1, ID);
			 
			 ResultSet myRs = myStmt.executeQuery();
			
			while(myRs.next())
			 user = new User(myRs.getInt("id"),myRs.getString("nombre"),myRs.getString("tipo"));
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		return user;
	}
	
	public void insert(String name, String userType) throws SQLException{
		
		try {
			
			final String insertSQL = "INSERT INTO usuarios (nombre,tipo) VALUES (?,?)";
			
			 ConnectDB myConnectDB = new ConnectDB();
			 conn = myConnectDB.openConnection();
			 
			 PreparedStatement myStmt = conn.prepareStatement(insertSQL);
			 myStmt.setString(1, name);
			 myStmt.setString(2, userType);
			 
			 myStmt.executeUpdate();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
	}
	
	public void delete(int ID) throws SQLException{
		
		try {
			
			final String deleteSQL = "DELETE FROM usuarios WHERE (id) = " + ID ;
			
			 ConnectDB myConnectDB = new ConnectDB();
			 conn = myConnectDB.openConnection();
			 
			 Statement myStmt = conn.createStatement();
			 myStmt.execute(deleteSQL);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		
	}
	
	public void update(int id, String name, String userType) throws SQLException{
		
		try {
			
			final String updateSQL = "UPDATE usuarios SET (nombre,tipo) = (?,?) WHERE id = ?";
			
			 ConnectDB myConnectDB = new ConnectDB();
			 conn = myConnectDB.openConnection();
			 
			 PreparedStatement myStmt = conn.prepareStatement(updateSQL);
			 myStmt.setString(1, name);
			 myStmt.setString(2, userType);
			 myStmt.setInt(3, id);
			 
			 myStmt.executeUpdate();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		
	}
}
