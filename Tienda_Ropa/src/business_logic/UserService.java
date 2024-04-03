package business_logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_acces.UserGateway;
import enities.User;

public class UserService {

	private UserGateway gateway;
	
	public UserService () {
		gateway = UserGateway.getInstance();
	}
	
	
	public List<User> getAll () throws SQLException {
		
		List <User> users = new ArrayList <>();
		
		try {
			users = gateway.getAll();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return users;
	}
	
	public User  getById (int ID) throws SQLException {
		
		User user = null;
		
		try {
			user = gateway.getById(ID);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return user;
	}
	
	public void insert (String name, String userType) throws SQLException {
		
		try {
			gateway.insert(name, userType);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void delete (int ID) throws SQLException {
		
	try {
			gateway.delete(ID);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void update (int id, String name, String userType) throws SQLException{
		
	try {
			gateway.update(id, name, userType);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
