package data_acces;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
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
	
	public void insert (InventoryProduct product) throws SQLException {
		
		try {
			 
			final String insertSQL = "INSERT INTO inventario ('ean','marca','tipo','descripcion','cantidad','precio','margen','estado',\"Fecha de incorporacion\",\"Fecha de modificacion\")"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			ConnectDB myConnectDB = new ConnectDB();
			 conn = myConnectDB.openConnection();
			
			PreparedStatement myStmt = conn.prepareStatement(insertSQL);
			myStmt.setLong(1,product.getEan());
			myStmt.setString(2, product.getBrand());
			myStmt.setString(3, product.getProductType());
			myStmt.setString(4, product.getDescription());
			myStmt.setInt(5, product.getNumberrOfUnities());
			myStmt.setFloat(6, product.getPrice());
			myStmt.setFloat(7, product.getRevenueMargin());
			myStmt.setString(8, product.getSaleState());
			myStmt.setDate(9, Date.valueOf(product.getArrivalDate()));
			myStmt.setDate(10, Date.valueOf(product.getModificationDate()));
			
			myStmt.executeUpdate();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
	  }
		
		public void delete(Long ean) throws SQLException {
			
			try {
				
				final String deleteSQL = "DELETE FROM inventario WHERE (ean) = (?)";
				
				ConnectDB myConnectDB = new ConnectDB();
				conn = myConnectDB.openConnection();
				 
				 PreparedStatement myStmt = conn.prepareStatement(deleteSQL);
				 myStmt.setLong(1, ean);
				 
				 myStmt.executeUpdate();
			}
			
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
			conn.close();
		}
		
		public void update (InventoryProduct product) throws SQLException {
			
			try {
				
				final String updateSQL = "UPDATE inventario SET ('marca','tipo','descripcion','cantidad','precio','margen','estado',\"Fecha de incorporacion\",\"Fecha de modificacion\")"
						+ "= (?,?,?,?,?,?,?,?,?) WHERE 'ean' = ?";
				
				ConnectDB myConnectDB = new ConnectDB();
				conn = myConnectDB.openConnection();
				
				PreparedStatement myStmt = conn.prepareStatement(updateSQL);
				
				myStmt.setString(1, product.getBrand());
				myStmt.setString(2, product.getProductType());
				myStmt.setString(3, product.getDescription());
				myStmt.setInt(4, product.getNumberrOfUnities());
				myStmt.setFloat(5, product.getPrice());
				myStmt.setFloat(6, product.getRevenueMargin());
				myStmt.setString(7, product.getSaleState());
				myStmt.setDate(8, Date.valueOf(product.getArrivalDate()));
				myStmt.setDate(9, Date.valueOf(product.getModificationDate()));
				myStmt.setLong(10,product.getEan());
				
				myStmt.executeUpdate();
			}
			
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
			conn.close();
		}
		
		}


