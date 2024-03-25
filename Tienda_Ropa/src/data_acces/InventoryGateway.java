package data_acces;
import java.sql.*;
import java.util.*;
import enities.InventoryProduct;


public class InventoryGateway {
	
	private static InventoryGateway instance;
	private Connection conn;
	
	public static InventoryGateway getInstance () {
		if (instance == null) 
			instance = new InventoryGateway();
		
		return instance;
		}
		
	public List <InventoryProduct>getAll() throws SQLException {
		
		List<InventoryProduct> products = new ArrayList<>();
		final String querySQL = "SELECT * FROM Inventario";
		
		try {
		   ConnectDB myConnectDB = new ConnectDB();
		   conn = myConnectDB.openConnection();
		   
		   Statement myStmt = conn.createStatement();
		   ResultSet myRs = myStmt.executeQuery(querySQL);
		   
		   while(myRs.next()) {
			   
			   InventoryProduct temp = new InventoryProduct(Long.valueOf(myRs.getLong("EAN")), myRs.getString("Marca") , myRs.getString("Tipo") ,
					   myRs.getString("Descripcion"), myRs.getInt("Cantidad") ,
						myRs.getFloat("Precio"), myRs.getFloat("Margen"), myRs.getString("Estado"), myRs.getDate("Fecha de incorporacion").toLocalDate(), myRs.getDate("Fecha de modificacion").toLocalDate());
			   products.add(temp);
			   
		   }
		   
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		return products;
	}
	
	public InventoryProduct getProduct(Long ean) throws SQLException {

		final String querySQL = "SELECT * FROM Inventario where EAN = ? ";
		InventoryProduct product = null;
		long eanlong = Long.valueOf(ean);
		try {
		   ConnectDB myConnectDB = new ConnectDB();
		   conn = myConnectDB.openConnection();
		   
		   PreparedStatement myStmt = conn.prepareStatement(querySQL);
		   myStmt.setLong(1,eanlong);
		   
		   ResultSet myRs = myStmt.executeQuery();
		   
		   myRs.next();
		   product = new InventoryProduct(Long.valueOf(myRs.getLong("EAN")), myRs.getString("Marca") , myRs.getString("Tipo") ,
		   myRs.getString("Descripcion"), myRs.getInt("Cantidad") ,
		   myRs.getFloat("Precio"), myRs.getFloat("Margen"),myRs.getString("Estado"), myRs.getDate("Fecha de incorporacion").toLocalDate(), myRs.getDate("Fecha de modificacion").toLocalDate());
			
		   
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		return product;
	}

}
