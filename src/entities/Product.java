package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
		
	public String name;
	public Double price;
	public Integer quantity;
	public String category;
	public Integer id;
	 
	public Product () {
	}

	public Product(int id, String name, double price, int quantity, String category) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id= " + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category=" + category;
	}

	@Override
	public int hashCode() { 
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	//devo incrementar quantidade
	public void addProduct (Integer id, String name, Double price, Integer quantity, String category) {
		public List<Product> products = new ArrayList<Product>();
		//for ()
		
		return (id, name, price, quantity, category);
	}
}