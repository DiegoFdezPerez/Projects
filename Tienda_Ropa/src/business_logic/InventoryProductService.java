package business_logic;
import java.sql.SQLException;
import java.util.*;
import data_acces.InventoryGateway;
import enities.InventoryProduct;

public class InventoryProductService {
	
	private InventoryGateway gateway;
	
	public InventoryProductService () {
		gateway = InventoryGateway.getInstance();
	}
	
	public List<InventoryProduct> getAllProducts() throws SQLException {
		
		List <InventoryProduct> products = null;
		
		try {
		 products = gateway.getAll(); }
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return products;
	}

	public InventoryProduct getProduct(Long ean) throws SQLException {
		
		InventoryProduct prod = null;
		
		try {
		prod = gateway.getProduct(ean);}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return prod;
		
	}
	
}
