package br.com.desafio.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.entities.ProductMostruario;
import br.com.desafio.entities.Product;


public class Stock  {

	public List<Product> products = new ArrayList<Product>();
	public List<ProductMostruario> productsMostruario = new ArrayList<ProductMostruario>();
		
	public void addProduct (String code, String name, Double price, Integer quantity, String category) {
		Product product = new Product (code, name, price, quantity, category);
		
		products.add(product);
	}

	public void addProduct (String code, String name, double price, int quantity, String category, long codigoBarra,
							String serie, String description,Double tax, String manufacturingDate, String validationDate,
							String color, String material) {
		Product product = new Product(code, name, price, quantity, category, codigoBarra, serie, description,
				tax, manufacturingDate, validationDate, color, material);

		products.add(product);
	}
	
	public void addProductMostruario (String codigo, Long codigoBarra, String serie, String name, String description, String category, Double price, Double tax, String manufacturingDate, String validationDate, String color, String material) {
		ProductMostruario productMostruario = new ProductMostruario(codigo, codigoBarra, serie, description, tax, manufacturingDate,
				validationDate, color, material, name, price, category);
				
		productsMostruario.add(productMostruario);
	}

	public void editProducts (String code, String name, Double price, Integer quantity, String category) {
		removeProduct(code);
		addProduct(code, name, price, quantity, category);
					
	}
	public void removeProduct(String code) {
		Product product = new Product();
		product.setCode(code);
		
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
			product.setCode(productMostruario.getCodigo());
			
			int indexNumber = products.indexOf(product);
								
			if (indexNumber == -1) {
			
				String code = productMostruario.getCodigo();
				String name = productMostruario.getName();
				double price = this.totalPrice(productMostruario.getPrice(), productMostruario.getTax());  
				Integer quantity = 1;
				String category = productMostruario.getCategory();
				long codigoBarra = productMostruario.getCodigoBarra();
				String serie = productMostruario.getSerie();
				String description = productMostruario.getDescription();
				Double tax = productMostruario.getTax();
				String manufacturingDate = productMostruario.getManufacturingDate();
				String validationDate = productMostruario.getValidationDate();
				String color = productMostruario.getColor();
				String material = productMostruario.getMaterial();

				this.addProduct(code, name, price, quantity, category, codigoBarra,
				serie, description, tax, manufacturingDate, validationDate, color, material);
			}
			
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

	public List<ProductMostruario> getProductMostruario () { return productsMostruario;}

	public boolean isProductInStock(String code){
		Product product = new Product();
		product.setCode(code);

		int indexNumber = products.indexOf(product);

		if (indexNumber == -1){
			return false;
		}
		else{
			return true;
		}
	}
}
	
		
