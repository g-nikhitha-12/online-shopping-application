
package com.cg.osa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="product_table")
public class ProductDTO {
	@Id

    @NotNull(message = "prodcut id cannot be null")
	@Column(name="pid")
	int productId;
	@Column(name="productname")
	@NotBlank(message = "product name cannot be null")
	String productName;
	@Column(name="price")
	@Max(value = 10000)
	@Min(value = 10)
	double price;
	@Column(name="color")
	@NotBlank(message = "color cannot be null")
	String color;
	@Column(name="dimension")
	@NotBlank(message = "dimension cannot be null")
	String dimension;
	@Column(name="specification")
	@NotBlank(message = "specification cannot be null")
	String specification;
	@Column(name="manufacturer")
	@NotBlank(message = "manfacturer cannot be null")
	String manufacturer;
	@Column(name="quantity")
	@NotBlank(message = "qnt cannot be null")
	int quantity;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="catid")
	CategoryDTO category;

	public ProductDTO() {
		super();
	}

	public ProductDTO( int productId,
			String productName, double price,
			String color,
			String dimension,
			 String specification,
			 String manufacturer,
			 int quantity, CategoryDTO category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price + ", color="
				+ color + ", dimension=" + dimension + ", specification=" + specification + ", manufacturer="
				+ manufacturer + ", quantity=" + quantity + ", category=" + category + "]";
	}
	
}
