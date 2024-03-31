package data_acces;

import java.sql.*;
import java.time.Instant;
import java.util.*;

import enities.Sale;

public class SalesGateway {

	private static SalesGateway instance;
	private Connection conn;
	
	public static SalesGateway getInstance() {
		if (instance==null)
			instance = new SalesGateway();
		    
		return instance;
	}
	
	public List<Sale> getAll() throws SQLException {
		
		List<Sale> all = new ArrayList<Sale>();
		
		try {
		ConnectDB conDB = new ConnectDB();
		conn = conDB.openConnection();
		
		String SQLQuery = "SELECT * FROM Ventas";
		Statement myStmt = conn.createStatement();
		
		ResultSet myRs = myStmt.executeQuery(SQLQuery);
		ArrayList<Integer> ticketList = new ArrayList <Integer>();
		
	
		while(myRs.next()) {
			
			if( ticketList.contains(Integer.valueOf(myRs.getInt("Numero de ticket")))) {
				
				Sale sale = all.get(myRs.getInt("Numero de ticket")-1);
				sale.addProduct(Long.valueOf(myRs.getLong("Producto")));
				
			}
			else if ( !ticketList.contains(Integer.valueOf(myRs.getInt("Numero de ticket")))) {
				
				ticketList.add(Integer.valueOf(myRs.getInt("Numero de ticket")));
				List<Long> temp = new ArrayList<Long>();
				temp.add(Long.valueOf(myRs.getLong("Producto")));
				Sale sale = new Sale(myRs.getInt("Numero de ticket"), myRs.getInt("Vendedor"), temp ,myRs.getTimestamp("Fecha").toInstant());	
				all.add(myRs.getInt("Numero de ticket")-1,sale);
				
			}
			
			
		}
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		return all;
	}
	
	
	public Sale getSale(int ticket) throws SQLException {
		
		Sale sale =null;
		
		try {
			ConnectDB conDB = new ConnectDB();
			conn = conDB.openConnection();
			
			String SQLQuery = "SELECT * FROM Ventas WHERE \"Numero de ticket\" = ?";
			PreparedStatement myStmt = conn.prepareStatement(SQLQuery);
			
			myStmt.setInt(1, ticket);
			
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			
			List<Long> products = new ArrayList <Long>();
			int vendor = myRs.getInt("Vendedor");
			Instant stamp = myRs.getTimestamp("Fecha").toInstant();
			 
			products.add(myRs.getLong("Producto"));	
			
			while (myRs.next()) {
			
			products.add(myRs.getLong("Producto"));	
			
			}
			
			sale = new Sale(ticket,vendor,products,stamp);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		return sale;
	}
	
	
	
	public void addSale(Sale added) throws SQLException {
		try {
			
			Integer ticketNumber = getLastTicket()+1;
			
			ConnectDB conDB = new ConnectDB();
			conn = conDB.openConnection();
			
			String SQLInsert = "INSERT into Ventas (\"Numero de ticket\",Vendedor, Producto, Fecha) VALUES (?,?,?,?)";
			PreparedStatement myStmt = conn.prepareStatement(SQLInsert);
			
			myStmt.setInt(1, ticketNumber);
			myStmt.setInt(2, added.getVendor());
			myStmt.setTimestamp(4, Timestamp.from(added.getStamp()));
			
			List <Long> productos = added.getProducts();
			
			for(Long producto:  productos) {
			
			myStmt.setLong(3, producto);
			
			
			myStmt.executeUpdate();
			
			}
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		conn.close();
		
		}
	
	 public Integer getLastTicket() throws SQLException{
		Integer LastTicket = 0;
		
		try {
			
			List <Sale> sales = getAll();
			
			for(Sale temp: sales) {
				if (temp.getTicketNumber()>LastTicket.intValue()) {
					LastTicket = Integer.valueOf(temp.getTicketNumber());
				}
			}
		}
		
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return LastTicket;
		}
	}

