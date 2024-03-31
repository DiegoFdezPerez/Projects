package business_logic.warranty_management;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.TimeZone;

import enities.InventoryProduct;
import enities.Sale;

public class WarrantyRuleDefault implements WarrantyRule {

	@Override
	public boolean activeWarranty(Sale ticket) {
	
		// para el resto de las prendas la garantía es de 1 año
		
				LocalDate now = LocalDate.now ();
				LocalDate date = ticket.getStamp().atZone(TimeZone.getDefault().toZoneId()).toLocalDate();
				long numberOfDays = DAYS.between(date, now);
				
				if( numberOfDays < 365)
				return true;
				
				else
				return false;
				
		
	}

}
