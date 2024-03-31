package business_logic;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

import business_logic.warranty_management.WarrantyRule;
import business_logic.warranty_management.WarrantyRuleFactory;
import data_acces.SalesGateway;
import enities.InventoryProduct;
import enities.Sale;

public class SaleService {

	private SalesGateway gateway;
	
	
	public SaleService() {
		gateway = SalesGateway.getInstance();
	}
	
	
	public List<Sale> getAllSales() throws SQLException{
		
		List <Sale> sales = null;
		
		try{
			sales = gateway.getAll();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return sales;
	}
	
	public Sale getSale (int ticket) throws SQLException {
		
		Sale sale = null;
		
		try {
			
			sale = gateway.getSale(ticket);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return sale;
	}

	public void addSale( int vendor, List <Long> products) throws SQLException {
		
		try {
		Instant stamp = Instant.now();
		
		Sale added = new Sale ( vendor, products, stamp);
		
	     gateway.addSale(added);}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean activeWarranty (InventoryProduct product, Sale ticket) {
		
		WarrantyRule rule = WarrantyRuleFactory.getInstance().getRule(product.getProductType());
		
		return rule.activeWarranty(ticket);
	}
	
}
