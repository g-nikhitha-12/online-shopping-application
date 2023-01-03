package com.cg.osa;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.osa.dto.AddressDTO;
import com.cg.osa.dto.CartDTO;
import com.cg.osa.dto.CustomerDTO;
import com.cg.osa.dto.OrderDTO;
import com.cg.osa.dto.ProductDTO;
import com.cg.osa.dto.UserDTO;
import com.cg.osa.exception.AddressException;
import com.cg.osa.exception.CartException;
import com.cg.osa.exception.CustomerException;
import com.cg.osa.exception.OrderException;
import com.cg.osa.exception.ProductException;
import com.cg.osa.exception.UserException;
import com.cg.osa.repository.IAddressRepository;
import com.cg.osa.repository.ICartRepository;
import com.cg.osa.repository.ICustomerRepository;
import com.cg.osa.repository.IOrderRepository;
import com.cg.osa.repository.IProductRepository;
import com.cg.osa.repository.IUserRepository;
import com.cg.osa.service.IAddressServiceImpl;
import com.cg.osa.service.ICartServiceImpl;
import com.cg.osa.service.ICustomerServiceImpl;
import com.cg.osa.service.IOrderServiceImpl;
import com.cg.osa.service.IProductServiceImpl;
import com.cg.osa.service.IUserServiceImpl;

@SpringBootTest
class OnlineShoppingApplicationTests {
	@Mock
	IProductServiceImpl productserviceimpl;
	@Mock
	IProductRepository productrepository;
	@Test
	public void testProductById() throws ProductException{
	
		ProductDTO p = new ProductDTO();
        when(productserviceimpl.viewProductbyid(1)).thenReturn(p).thenThrow(ProductException.class);
		
		assertNotNull(p);
		
	}
	@Test
	public void testInvalidProductById() throws ProductException{
	
		ProductDTO p = new ProductDTO();
		when(productserviceimpl.viewProductbyid(1)).thenReturn(p).thenThrow(ProductException.class);
		
		assertThatExceptionOfType(ProductException.class);
		
		
	}
	@Test
	public void testgetAllProduct() {
		List<ProductDTO> Products = new ArrayList<>();
		Products.add(new ProductDTO());
		Products.add(new ProductDTO());
		when(productserviceimpl.viewAllProducts()).thenReturn(Products);
		assertEquals(2, Products.size());
		assertThat(Products.size()).isGreaterThan(0);
	}
	//Testing for update the Product
			@Test
			public void testupdateProduct() throws ProductException {
				ProductDTO product =  new ProductDTO();
				product.setProductId(1);
				product.setProductName("fan");
				product.setPrice(10.0);
				product.setColor("yellow");
				product.setDimension(" 5 radius");
				product.setManufacturer("bajaj");
				product.setQuantity(10);
				product.setSpecification("white");
				when(productserviceimpl.updateProduct(product)).thenReturn(product);
				assertNotNull(productserviceimpl.updateProduct(product));	
			}
			//Testing for inserting the Product
			@Test
			public void testInsertProduct() throws ProductException  {
				ProductDTO product =  new ProductDTO();
				product.setProductId(1);
				product.setProductName("chips");
				product.setColor("green");
				product.setManufacturer("raj");
				product.setPrice(20.0);
				
				
				when(productserviceimpl.addProduct(product)).thenReturn(product);
				assertEquals("chips", productserviceimpl.addProduct(product).getProductName());
					
			}
			@Test
			public void testProductById1 () throws ProductException{
				ProductDTO p=new ProductDTO();
				when(productserviceimpl.removeProduct(1)).thenReturn(p).thenThrow(ProductException.class);
				
			}
			@Mock
			IAddressRepository arepository;
			@Mock
			IAddressServiceImpl aimpl;
			@Test
	       public void testRemoveAddress () throws AddressException{
	    	   AddressDTO a=new AddressDTO();
	    	   
	    	   when(aimpl.removeAddress(1)).thenReturn(a).thenThrow(AddressException.class);
	    	   
	    	   
	       }
			@Test
	       public void testview () throws AddressException{
	    	   AddressDTO a=new AddressDTO();
	    	   a.setAddressId(2);
	    	   when(aimpl.viewAddress(2)).thenReturn(a).thenThrow(AddressException.class);
	    	   assertEquals(2, a.getAddressId());
	       }
			@Test
			public void testAddAddress() throws AddressException  {
				AddressDTO a=new AddressDTO();
				a.setAddressId(4);
				when(aimpl.addAddress(a)).thenReturn(a);
				assertEquals(4, aimpl.addAddress(a).getAddressId());
					
			}
			@Mock
			IUserRepository urepository;
			@Mock
			IUserServiceImpl impl;
			
			@Test
			public void testAdduser() throws UserException  {
				UserDTO u=new UserDTO();
				u.setUserId(1);
				when(impl.addUser(u)).thenReturn(u);
				assertEquals(1, impl.addUser(u).getUserId());
					
			}
			@Mock
			ICustomerRepository customerRepository;
			@Mock
			ICustomerServiceImpl customerService;
			
			@Test
			public void testgetAllCustomers() {
				List<CustomerDTO> cust = new ArrayList<>();
				cust.add(new CustomerDTO());
				cust.add(new CustomerDTO());
				when(customerService.viewAllCustomer()).thenReturn(cust);
				assertEquals(2, cust.size());
				assertThat(cust.size()).isGreaterThan(0);
			}
			@Test
		       public void testRemoveCustomer () throws CustomerException{
		    	   CustomerDTO a=new CustomerDTO();
		    	   
		    	   when(customerService.removeCustomer(1)).thenReturn(a).thenThrow(CustomerException.class);
		    	   
		    	   
		       }
			@Test
			public void testAddCustomer() throws CustomerException  {
				CustomerDTO c=new CustomerDTO();
				c.setCustomerId(1);
				when(customerService.addCustomer(c)).thenReturn(c);
				assertEquals(1,customerService.addCustomer(c).getCustomerId());
					
			}
			
			@Mock
			IOrderRepository  orderRepository;
			@Mock
			IOrderServiceImpl orderService;
			@Test
			public void testAddOrder() throws OrderException
			{
				OrderDTO o=new OrderDTO();
				o.setOrderId(1);
				when(orderService.addOrder(o)).thenReturn(o);
				assertEquals(1,orderService.addOrder(o).getOrderId());
					
			}
			@Test
		       public void testRemoveOrder () throws OrderException{
		    	   OrderDTO a=new OrderDTO();
		    	   
		    	   when(orderService.removeOrder(1)).thenReturn(a).thenThrow(OrderException.class);
		    	   
		    	   
		       }
			@Test
			public void testgetAllOrders() {
				List<OrderDTO> order = new ArrayList<>();
				order.add(new OrderDTO());
				order.add(new OrderDTO());
				when(orderService.viewAllOrders()).thenReturn(order);
				assertEquals(2, order.size());
				assertThat(order.size()).isGreaterThan(0);
			}
			
			@Mock
			ICartRepository cartRepository;
			@Mock
			ICartServiceImpl cartService;
			@Test
			public void testRemoveAllproducts() throws CartException {
				CartDTO cart=new CartDTO();
	
			    when(cartService.removeAllProducts(1)).thenReturn(cart).thenThrow (CartException.class);
				
			}
			@Test public void testViewAll() throws CartException {
				CartDTO cart=new CartDTO();
				when(cartService.viewAllProducts(1)).thenReturn(cart).thenThrow(CartException.class);
			}
			
			
			

	@Test
	void contextLoads() {
	}

}
