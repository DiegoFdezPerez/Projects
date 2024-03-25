package enities;
import java.time.*;
import java.util.*;

public class Sale {

	private int ticketNumber;
	private int vendor;
	private List<Long> products;
	private Instant stamp;
	
	//Constructor//
	
	public Sale(int ticketNumber, int vendor, List<Long> products, Instant stamp) {

		this.ticketNumber = ticketNumber;
		this.vendor = vendor;
		this.products = products;
		this.stamp = stamp;
	}
	
	//Constructor para añadir a la BD
	
	public Sale( int vendor, List<Long> products, Instant stamp) {

		this.vendor = vendor;
		this.products = products;
		this.stamp = stamp;
	}
	
	//getters and setters//
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public int getVendor() {
		return vendor;
	}
	public void setVendor(int vendor) {
		this.vendor = vendor;
	}
	public List <Long> getProducts() {
		return products;
	}
	public void setProducts(List <Long> products) {
		this.products = products;
	}
	
	public void addProduct(Long product) {
		this.products.add(product);
	}
	
	public Instant getStamp() {
		return stamp;
	}
	

	
	
	
}
