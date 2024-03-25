package business_logic.warranty_management;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.TimeZone;

import enities.Sale;

public class WarrantyRuleShoes implements WarrantyRule {

	@Override
	public boolean activeWarranty(Sale ticket) {
		// Si son zapatos la garantía es de 6 meses
	
		LocalDate now = LocalDate.now ();
		LocalDate date = ticket.getStamp().atZone(TimeZone.getDefault().toZoneId()).toLocalDate();
		long numberOfDays = DAYS.between(date, now);
		
		if( numberOfDays < 180)
		return true;
		
		else
		return false;
	}

}
