package com.cg.osa.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="order_table")
public class OrderDTO {
	@Id
	@NotNull(message="sorry id cannot be null")
	int orderId;
	@Column(name="orderDate")
	LocalDate orderDate;
	@Column(name="orderStatus")
	@NotBlank(message = " orderstatus to be updated")
	String orderStatus;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="customer_id")
	CustomerDTO customer;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "product_order", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	List<ProductDTO> productList=new ArrayList<ProductDTO>();

	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="address_id")
	AddressDTO address;

	public OrderDTO(int orderId, LocalDate orderDate, String orderStatus, CustomerDTO customer,
			List<ProductDTO> productList, AddressDTO address) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.productList = productList;
		this.address = address;
	}

	public OrderDTO() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public List<ProductDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", customer=" + customer + ", productList=" + productList + ", address=" + address + "]";
	}
	
	

	

}
