package com.cg.osa.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cart_table")
public class CartDTO {

	@Id
	@NotNull(message = "cartId cannot be null")
	private int cartId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cid")
	private CustomerDTO customer;
	@OneToMany(cascade=CascadeType.PERSIST)
	List<ProductDTO> products=new ArrayList<ProductDTO>();
	
	
	public CartDTO(int cartId, CustomerDTO customer, List<ProductDTO> products) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.products = products;
	}
public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
public CartDTO() {
	super();
}
@Override
public String toString() {
	return "CartDTO [cartId=" + cartId + ", customer=" + customer + ", products=" + products + "]";
}
	
	
	
}
