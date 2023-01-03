package com.cg.osa.service;

import java.util.List;

import com.cg.osa.dto.AddressDTO;
import com.cg.osa.exception.AddressException;

public interface IAddressService {
	public AddressDTO addAddress(AddressDTO add)throws AddressException;
	public AddressDTO updateAddress(AddressDTO add) throws AddressException;
	public AddressDTO removeAddress(int id) throws AddressException;
	public AddressDTO viewAddress(int id) throws AddressException;
	
	List<AddressDTO> viewAllAddress();
}


