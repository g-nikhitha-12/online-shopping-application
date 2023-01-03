package com.cg.osa.service;

import java.util.List;

import com.cg.osa.dto.OrderDTO;
import com.cg.osa.exception.OrderException;

public interface IOrderService {
	OrderDTO addOrder(OrderDTO order)throws OrderException;
	OrderDTO updateOrder(OrderDTO order)throws OrderException;
	OrderDTO removeOrder(int id)throws OrderException;
	OrderDTO viewOrderById(int id)throws OrderException;
	List<OrderDTO> viewAllOrders();
	List<OrderDTO> viewAllOrdersByLocation(String City)throws OrderException;
	List<OrderDTO> viewAllOrdersByCustomerId(int customerId)throws OrderException;


}
