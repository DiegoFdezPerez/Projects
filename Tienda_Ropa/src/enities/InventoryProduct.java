package enities;

import java.time.*;

public class InventoryProduct {
 
	private Long ean;
	private String brand;
	private String productType;
	private String description;
	private int numberOfUnities;
	private float price;
	private float revenueMargin;
	private String saleState;
	private LocalDate arrivalDate;
	private LocalDate modificationDate;
	
	//Constructor//
	
	public InventoryProduct(Long ean, String brand, String productType, String description, int numberOfUnities,
			float price, float revenueMargin, LocalDate arrivalDate) {
		
		this.ean = ean;
		this.brand = brand;
		this.productType = productType;
		this.description = description;
		this.numberOfUnities = numberOfUnities;
		this.price = price;
		this.revenueMargin = revenueMargin;
		this.saleState = "Nuevo";
		this.arrivalDate = arrivalDate;
		this.modificationDate = arrivalDate;
	}
	
	public InventoryProduct(Long ean, String brand, String productType, String description, int numberOfUnities,
			float price, float revenueMargin, String saleState, LocalDate arrivalDate, LocalDate modificationDate) {
		
		this.ean = ean;
		this.brand = brand;
		this.productType = productType;
		this.description = description;
		this.numberOfUnities = numberOfUnities;
		this.price = price;
		this.revenueMargin = revenueMargin;
		this.saleState = saleState;
		this.arrivalDate = arrivalDate;
		this.modificationDate = modificationDate ;
	}
	
	
	//Getters and setters//
	
	
	public Long getEan() {
		return ean;
	}

	public void setEan(Long ean) {
		this.ean = ean;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
		this.modificationDate = LocalDate.now();
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
		this.modificationDate = LocalDate.now();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		this.modificationDate = LocalDate.now();
	}
	public int getNumberrOfUnities() {
		return numberOfUnities;
	}
	public void setNumberrOfUnities(int numberOfUnities) {
		this.numberOfUnities = numberOfUnities;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRevenueMargin() {
		return revenueMargin;
	}
	public void setRevenueMargin(float revenueMargin) {
		this.revenueMargin = revenueMargin;
	}
	public String getSaleState() {
		return saleState;
	}
	public void setSaleState(String saleState) {
		this.saleState = saleState;
		this.modificationDate = LocalDate.now();
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalDate getModificationDate() {
		return modificationDate;
	}
	
	
	
	
}
