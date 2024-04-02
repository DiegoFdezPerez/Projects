package business_logic;
import java.sql.SQLException;
import java.time.LocalDate;
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
	
	public void insert(Long ean, String brand, String productType, String description, int numberOfUnities,
			float price, float revenueMargin, String saleState, LocalDate arrivalDate, LocalDate modificationDate) throws SQLException {
		
		InventoryProduct product = new InventoryProduct(ean, brand, productType, description, numberOfUnities, price, revenueMargin, saleState, arrivalDate, modificationDate);
		
		try {
		gateway.insert(product);
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
;		
	}
	
	public void delete(Long ean) throws SQLException {
		
		try {
			gateway.delete(ean);
			} 
			catch(Exception ex) {
				ex.printStackTrace();
			}
		
	}
	
	public void update(Long ean, String brand, String productType, String description, int numberOfUnities,
			float price, float revenueMargin, String saleState, LocalDate arrivalDate, LocalDate modificationDate) throws SQLException {
	
		InventoryProduct product = new InventoryProduct(ean, brand, productType, description, numberOfUnities, price, revenueMargin, saleState, arrivalDate, modificationDate);
		
		try {
			gateway.update(product);
			} 
			catch(Exception ex) {
				ex.printStackTrace();
			}
		
	}
}
