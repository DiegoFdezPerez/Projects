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
	
	public WarrantyRule getRule(String productType) {
		
		WarrantyRule rule = null;
		
		if(productType.equalsIgnoreCase("Pantalones")) {
			rule = new WarrantyRulePants ();
		}
		else if (productType.equalsIgnoreCase("Zapatillas")) {
			rule = new WarrantyRuleShoes ();
		}
		else {
			rule = new WarrantyRuleDefault ();
		}
		
		return rule;
			
	}

}
