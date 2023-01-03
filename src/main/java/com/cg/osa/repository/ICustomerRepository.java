package com.cg.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.osa.dto.CustomerDTO;


public interface ICustomerRepository extends JpaRepository<CustomerDTO, Integer>{

	
}