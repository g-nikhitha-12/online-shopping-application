package com.cg.osa.service;

import java.util.List;

import com.cg.osa.dto.CustomerDTO;

import com.cg.osa.exception.CustomerException;

public interface ICustomerService {
	CustomerDTO addCustomer(CustomerDTO cust)throws CustomerException;
	CustomerDTO updateCustomer(CustomerDTO cust)throws CustomerException;
	CustomerDTO removeCustomer(int id) throws CustomerException;
	CustomerDTO viewCustomer(int id) throws CustomerException;
	
	List<CustomerDTO> viewAllCustomerByCity(String city)throws CustomerException;
	List<CustomerDTO> viewAllCustomer();

}
