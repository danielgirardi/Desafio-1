package br.com.desafio;

import java.util.Objects;

public class ProductMostruario {

	public String codigo;
	public Long codigoBarra;
	public String serie;
	public String description;
	public Double tax;
	public String manufacturingDate;
	public String validationDate;
	public String color;
	public String material;
	public String name;
	public Double price;
	public String category;
	
	public ProductMostruario() {
		
	}

	public ProductMostruario(String codigo, Long codigoBarra, String serie, String description, Double tax,
			String manufacturingDate, String validationDate, String color, String material, String name, Double price,
			String category) {
		super();
		this.codigo = codigo;
		this.codigoBarra = codigoBarra;
		this.serie = serie;
		this.description = description;
		this.tax = tax;
		this.manufacturingDate = manufacturingDate;
		this.validationDate = validationDate;
		this.color = color;
		this.material = material;
		this.name = name;
		this.price = price;
		this.category = category;
	
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(Long codigoBarra) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
		
}
