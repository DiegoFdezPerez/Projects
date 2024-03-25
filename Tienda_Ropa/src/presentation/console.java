package presentation;
import business_logic.InventoryProductService;
import business_logic.SaleService;
import enities.InventoryProduct;
import enities.Sale;

import java.sql.SQLException;
import java.util.*;

public class console {
	
	public void start() throws SQLException {
		InventoryProductService inventory = new InventoryProductService();
		SaleService sales = new SaleService();
		
		int option;
		
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Operaciones del sitema:");
	
	do {
		
		System.out.println("1 - Mostrar Inventario");
		System.out.println("2 - Mostrar Ventas");
		System.out.println("3 - Agregar Venta");
		System.out.println("4 - Salir");
		
		option = scanner.nextInt();
		
		switch(option) {
		
		case 1: //Mostrar Inventario
			
			List<InventoryProduct> products = inventory.getAllProducts();
			System.out.println("\n Inventario: \n");
			System.out.println("EAN / Marca / Tipo / Descripcion / Cantidad / Precio / Estado / Fecha de Alta / Fecha de Modificacion \n" );
			
			for(InventoryProduct product: products) {
				
				System.out.println(product.getEan() + " / " + product.getBrand() + " / " + product.getProductType() + " / " + product.getDescription() + " / " + product.getNumberrOfUnities() 
				 + " / " + product.getPrice() + " / " + product.getSaleState() + " / " + product.getArrivalDate() + " / " + product.getModificationDate());
			}
			
			System.out.println("\n");
			
			break;
			
		case 2: //Mostrar Ventas
			
			List <Sale> salesList = sales.getAllSales();
			System.out.println("Ventas:\n");
			System.out.println("Ticket / Vendedor / Productos / Fecha y hora\n");
			
			for(Sale sale: salesList) {
				
				System.out.print(sale.getTicketNumber() + " / " + sale.getVendor() + " / ");

				for(int i = 0 ;i< sale.getProducts().size(); i++) {
					
					Long ean = sale.getProducts().get(i);
					System.out.print( inventory.getProduct(ean).getDescription() );
					
					if(i<sale.getProducts().size()-1)
						System.out.print(" , ");
						
				}
				
				System.out.print(" / " + sale.getStamp() +"\n");
				
			}
			
			System.out.println("\n");
			
			break;
			
		case 3: //Agregar Venta
			
			System.out.println("Inserte los datos de la venta:");
			
			
			System.out.println("Inserte el numero de vendedor");
			int vendor = scanner.nextInt();
			
			List<Long> prod = new ArrayList<Long>();
			
			boolean keepOn = true;
			
			
			do {
				boolean keepOn2 = true;
				
				System.out.println("Inserte el codigo del producto:");
				long code = scanner.nextLong();
				Long codeLong = Long.valueOf(code);
				prod.add(codeLong);
				
				while (keepOn2)
					{
					
					System.out.println("¿Desea agregar otro producto?: SI / NO:");
					String answer = scanner.next();
				
				
				if (answer.equalsIgnoreCase("no"))
					{keepOn=false;
					keepOn2=false;
				    break;}
				else if (answer.equalsIgnoreCase("si"))
					{keepOn=true;
					keepOn2=false;
				    break;}
				else
					{System.out.println("Inserte una opcion valida");}
				
				}
			}while (keepOn);

				sales.addSale(vendor, prod);	
				break;	
		case 4:
			
			System.out.println("Saliendo del programa");
			break;
			
		default:
			System.out.println("Seleccione una opcion valida");
			break;
			
		}
		
		
	}
   while(option!=4);	
	
	scanner.close();
	
	}
	


}
