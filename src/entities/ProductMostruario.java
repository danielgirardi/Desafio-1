package entities;

import java.util.Objects;

public class ProductMostruario {

	public String codigo;
	public Long codigoBarra;
	public String serie;
	public String description;
	public Double tax;
	public Integer manufacturingDate;
	public Integer validationDate;
	public String color;
	public String material;
	public String name;
	public Double price;
	public Integer quantity;
	public String category;
	public Integer id;
	
	public ProductMostruario() {
		
	}

	public ProductMostruario(String codigo, Long codigoBarra, String serie, String description, Double tax,
			Integer manufacturingDate, Integer validationDate, String color, String material, String name, Double price,
			Integer quantity, String category, Integer id) {
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
		this.quantity = quantity;
		this.category = category;
		this.id = id;
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

	public Integer getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Integer manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Integer getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(Integer validationDate) {
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
		return "ProductMostruario [codigo=" + codigo + ", codigoBarra=" + codigoBarra + ", serie=" + serie
				+ ", description=" + description + ", tax=" + tax + ", manufacturingDate=" + manufacturingDate
				+ ", validationDate=" + validationDate + ", color=" + color + ", material=" + material + ", name="
				+ name + ", price=" + price + ", quantity=" + quantity + ", category=" + category + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, codigo, codigoBarra, color, description, id, manufacturingDate, material, name,
				price, quantity, serie, tax, validationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductMostruario other = (ProductMostruario) obj;
		return Objects.equals(category, other.category) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(codigoBarra, other.codigoBarra) && Objects.equals(color, other.color)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(manufacturingDate, other.manufacturingDate)
				&& Objects.equals(material, other.material) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(serie, other.serie) && Objects.equals(tax, other.tax)
				&& Objects.equals(validationDate, other.validationDate);
	}
	
	
	
	
	
}
