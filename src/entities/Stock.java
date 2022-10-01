package entities;

import java.util.ArrayList;
import java.util.List;

public class Stock  {

	public List<Product> products = new ArrayList<Product>();
	public List<ProductMostruario> productsMostruario = new ArrayList<ProductMostruario>();
		
	public void addProduct (Integer id, String name, Double price, Integer quantity, String category) {
		Product product = new Product (id, name, price, quantity, category);
		
		products.add(product);
	}
	
	public void addProductMostruario (String codigo, Long codigoBarra, String serie, String name, String description, String category, Double price, Double tax, String manufacturingDate, String validationDate, String color, String material) {
		ProductMostruario productMostruario = 
				new ProductMostruario(codigo, codigoBarra, serie, description, tax, manufacturingDate, validationDate, 
						color, material, name, price, category);
				
		productsMostruario.add(productMostruario);
	}
	
	public void editProducts (Integer id, String name, Double price, Integer quantity, String category) {
		removeProduct(id);
		
		addProduct(id, name, price, quantity, category);
					
	}
	public void removeProduct(Integer id) {
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

	public List<Product> getProducts() { 
		return products;
	}
	}	
	
		
