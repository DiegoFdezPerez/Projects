package data_acces;
import java.sql.*;

public class ConnectDB {
	
	private Connection conn;
	
	public Connection openConnection() throws SQLException {
		
		conn=null;
		
		try {
			conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/TiendaRopa","postgres","@dminPG25");
			//System.out.println("Conexion exitosa");	
		}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return conn;
	}

	
	public void closeConnection() throws SQLException
	{
	try {
		if (conn!=null)
			conn.close();
	}
	
	catch (Exception ex) {
		ex.printStackTrace();
	}
		}

}
