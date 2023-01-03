package com.cg.osa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.osa.dto.CustomerDTO;
import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.CustomerException;
import com.cg.osa.repository.ICustomerRepository;
@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	 @Autowired
	    private ICustomerRepository customerRepository;
	 
	    
	    public CustomerDTO addCustomer(CustomerDTO cust) throws CustomerException{
	    	if(customerRepository.existsById(cust.getCustomerId())) {
	    		 throw new CustomerException("Id already exist");
	    	}
	    	else {
	    	return customerRepository.save(cust);
	    	}
	    	
	    }
	    public CustomerDTO updateCustomer(CustomerDTO cust)throws CustomerException {
	    	if(customerRepository.existsById(cust.getCustomerId())) {
	    		return customerRepository.save(cust); 
	    	}
	    	else {
	    		throw new CustomerException("Id does not exist");
	    	}
	    	
	    }
    public CustomerDTO removeCustomer(int id) throws CustomerException{
 	   if(customerRepository.existsById(id)) {
 		   CustomerDTO cust=customerRepository.findById(id).get();
 	    customerRepository.deleteById(id);
 	    return cust;
 	   }else {
 		   throw new CustomerException("Id not found");
 	   }
 	   
    }
    public List<CustomerDTO> viewAllCustomer(){
 	   return customerRepository.findAll();
    }

   public CustomerDTO viewCustomer(int id) throws CustomerException{
 	  if(customerRepository.existsById(id)) {
 	  return customerRepository.findById(id).get();
 	  }
 	  else {
 		  throw new CustomerException("Id not found");
 	  }
   }
  
   
   public List<CustomerDTO> viewAllCustomerByCity(String city) throws CustomerException{
	  List<CustomerDTO> list = customerRepository.findAll();
	  List<CustomerDTO> custCity = list.stream().filter(customerDTO->customerDTO.getAddress().getCity().equals(city)).collect(Collectors.toList());
	  if(custCity.size()!=0) {
	   return custCity;
   }else {
		  throw new CustomerException("no customer from the city "+city);
   }
   }       

}
