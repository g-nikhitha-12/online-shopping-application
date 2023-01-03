package com.cg.osa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.cg.osa.dto.OrderDTO;
import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.OrderException;
import com.cg.osa.repository.IOrderRepository;

@Service
@Transactional
public class IOrderServiceImpl implements IOrderService{
	@Autowired
	private IOrderRepository  orderRepository;
	
	public OrderDTO addOrder(OrderDTO order) throws OrderException  {
		if(orderRepository.existsById(order.getOrderId())) {
			throw new OrderException("order already exist");
		}
		else {
		orderRepository.save(order);
		return order;
		}
	}
	public OrderDTO updateOrder(OrderDTO order) throws OrderException {
		if(orderRepository.existsById(order.getOrderId())) {
		orderRepository.save(order);
		return order;
		}
		else {
			throw new OrderException("order not found");
		}
	}
	public OrderDTO removeOrder(int id)  throws OrderException{
		if(orderRepository.existsById(id)) {
		OrderDTO order=orderRepository.findById(id).get();
		List<ProductDTO> l=order.getProductList();
		  l.clear();
		  order.setProductList(l);
		  orderRepository.save(order);
		orderRepository.deleteById(id);
		
		return order;
	}
		else {
			throw new OrderException("Id not found");
		}
	}
	public OrderDTO viewOrderById(int id)throws OrderException
	{
		if(orderRepository.existsById(id)) {
		return orderRepository.findById(id).get();
		}
		else {
			throw new OrderException("Id not found");
		}
		
	}
	
	public List<OrderDTO>viewAllOrders()
	{
		return orderRepository.findAll();
	}
	public List<OrderDTO>viewAllOrdersByLocation(String city)throws OrderException
	{
		List<OrderDTO> list= orderRepository.findAll();
	   	  List<OrderDTO> orderCity = new ArrayList<OrderDTO>();
	   	  for(int i=0;i<list.size();i++) {
	   		OrderDTO order=list.get(i);
	   		  if(city.equals(order.getAddress().getCity())) {
	   			  orderCity.add(order);
	   		  }
	   		  
	   	  }
	   if(orderCity.size()!=0) {
		   return orderCity;
	   }
	   else {
		   throw new OrderException("no order in the city "+city);
	   }
	}
	public List<OrderDTO>viewAllOrdersByCustomerId(int customerId)throws OrderException
	{
		List<OrderDTO> list= orderRepository.findAll();
	   	  List<OrderDTO> orderById = new ArrayList<OrderDTO>();
	   	  for(int i=0;i<list.size();i++) {
	   		OrderDTO order=list.get(i);
	   		  if(customerId==order.getCustomer().getCustomerId()) {
	   			  orderById.add(order);
	   		  }
	   		  
	   	  }
	   	  if(orderById.size()!=0) {
		return orderById;
	   	  }else {
	   		throw new OrderException("no order from the customer");
	   	  }
	}
}
