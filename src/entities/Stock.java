package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stock  {

	public List<Product> products = new ArrayList<Product>();
	public List<ProductMostruario> productsMostruario = new ArrayList<ProductMostruario>();
		
	public void addProduct (long id, String name, Double price, Integer quantity, String category) {
		Product product = new Product (id, name, price, quantity, category);
		
		products.add(product);
	}
	
	public void addProductMostruario (String codigo, Long codigoBarra, String serie, String name, String description, String category, Double price, Double tax, String manufacturingDate, String validationDate, String color, String material) {
		ProductMostruario productMostruario = 
				new ProductMostruario(codigo, codigoBarra, serie, description, tax, manufacturingDate, validationDate, 
						color, material, name, price, category);
				
		productsMostruario.add(productMostruario);
	}
	
	public void editProducts (long id, String name, Double price, Integer quantity, String category) {
		removeProduct(id);
		
		addProduct(id, name, price, quantity, category);
					
	}
	public void removeProduct(long id) {
		Product product = new Product();
		product.setId(id);
		
		int indexNumber = products.indexOf(product);
		
		products.remove(indexNumber);
	}
			
	public void printProducts () { 
		
		for (Product product : getProducts()) {
			System.out.println(product.toString());
		}
	}
	
	public void addProductfromMostruario() {
	
		for (ProductMostruario productMostruario : productsMostruario) {
		
			Product product = new Product();
			product.setId(productMostruario.getCodigoBarra());
			
			int indexNumber = products.indexOf(product);
								
			if (indexNumber == -1) { //se ñ existe na lista de produtos 1 elemento c/ este código de barra, add na lista
			
				long id = productMostruario.getCodigoBarra();
				String name = productMostruario.getName();
				double price = this.totalPrice(productMostruario.getPrice(), productMostruario.getTax());  
				Integer quantity = 1;
				String categoria = productMostruario.getCategory();
						
				this.addProduct(id, name, price, quantity, categoria);
			}
			//buscar o product na lista e incrementar a quantidade deste product (criar método p/ incrementar quantidade na classe product)
			
			else {
				this.products.get(indexNumber).incrementQuantity();
				
			}
			
			
		}
		System.out.println("Os produtos foram importados com sucesso para o estoque!");
	}
	
	public double totalPrice (double price, double tax) { 
		
		double soma = (price + (price * tax / 100)) * 1.45;   
		double monetaryValue = new BigDecimal(String.valueOf(soma)).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		return monetaryValue;
	}

	public List<Product> getProducts() { 
		return products;
	}

}	
	
		
