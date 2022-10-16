package br.com.desafio.entities;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
		
	public String name;
	public Double price;
	public Integer quantity;
	public String category;
	public String code;
	public long codigoBarra;
	public String serie;
	public String description;
	public Double tax;
	public String manufacturingDate;
	public String validationDate;
	public String color;
	public String material;
	public Product () {
	}

	public Product(String code, String name, double price, int quantity, String category) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.code = code;
		this.codigoBarra = 0;
		this.serie = "n/a";
		this.description = "n/a";
		this.tax = 2.0;
		this.manufacturingDate = "n/a";
		this.validationDate = "n/a";
		this.color = "n/a";
		this.material = "n/a";

	}

	public Product(String code, String name, double price, int quantity, String category, long codigoBarra, String serie, String description,
		Double tax, String manufacturingDate, String validationDate, String color, String material){

		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.code = code;
		this.codigoBarra = codigoBarra;
		this.serie = serie;
		this.description = description;
		this.tax = tax;
		this.manufacturingDate = manufacturingDate;
		this.validationDate = validationDate;
		this.color = color;
		this.material = material;
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
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public long getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(long codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(String validationDate) {
		this.validationDate = validationDate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "code= " + code + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category=" + category;
	}

	@Override
	public int hashCode() { 
		return Objects.hash(code);
	}

	@Override		//usado tamb�m p/ testes unit�rios
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}
	
	public void incrementQuantity(){
		this.quantity ++;
	}
}