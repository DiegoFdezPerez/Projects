package business_logic.warranty_management;

import enities.InventoryProduct;
import enities.Sale;

public class WarrantyRuleFactory {

	private static WarrantyRuleFactory instance;
	
	private WarrantyRuleFactory () {
		
	}
	
	public static WarrantyRuleFactory getInstance () {
		
		if(instance == null)
			instance = new WarrantyRuleFactory();
		
		return instance;
	}
	
	public WarrantyRule getRule(InventoryProduct product, Sale ticket) {
		
		WarrantyRule rule = null;
		
		if(product.getProductType().equalsIgnoreCase("Pantalones")) {
			rule = new WarrantyRulePants ();
		}
		else if (product.getProductType().equalsIgnoreCase("Zapatillas")) {
			rule = new WarrantyRuleShoes ();
		}
		else {
			rule = new WarrantyRuleDefault ();
		}
		
		return rule;
			
	}

}
