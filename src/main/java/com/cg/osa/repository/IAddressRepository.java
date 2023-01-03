package com.cg.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.osa.dto.AddressDTO;

public interface IAddressRepository extends JpaRepository<AddressDTO,Integer>{

}
