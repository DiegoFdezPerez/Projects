
package business_logic.warranty_management;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.TimeZone;

import enities.InventoryProduct;
import enities.Sale;

public class WarrantyRulePants implements WarrantyRule {

	@Override
	public boolean activeWarranty(Sale ticket) {
		// si son pantalones la garantía es de 2 años
		
		LocalDate now = LocalDate.now ();
		LocalDate date = ticket.getStamp().atZone(TimeZone.getDefault().toZoneId()).toLocalDate();
		long numberOfDays = DAYS.between(date, now);
		
		if( numberOfDays < 730)
		return true;
		
		else
		return false;
		
	}

}
