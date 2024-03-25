package business_logic.warranty_management;

import enities.InventoryProduct;
import enities.Sale;

public interface WarrantyRule {
	
	boolean activeWarranty (Sale ticket);

}
