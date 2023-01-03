package com.cg.osa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.osa.dto.AddressDTO;
import com.cg.osa.exception.AddressException;
import com.cg.osa.repository.IAddressRepository;

@Service
public class IAddressServiceImpl implements IAddressService {
	@Autowired
	IAddressRepository arepository;
	public AddressDTO addAddress(AddressDTO add) throws AddressException
	{
		if(!arepository.existsById(add.getAddressId()))
		{
			arepository.save(add);
			return add;
		}
		else
		{
			throw new AddressException("Id already Exist");
		}
	}
	public AddressDTO updateAddress(AddressDTO add)
	{
		arepository.save(add);
		return add;
	}

	public AddressDTO removeAddress(int id) throws AddressException
	{
		if(arepository.existsById(id))
		{
			AddressDTO adto=arepository.findById(id).get();
			arepository.deleteById(id);
			return adto;
		}
		else
		{
			throw new AddressException("Id does not Exist");
		}
		
		
	}
	public AddressDTO viewAddress(int id) throws AddressException
	{
		if(arepository.existsById(id))
		{
			return arepository.findById(id).get();
		}
		else
		{
			throw new AddressException("Address Id not exist");
		}
	}
	public List<AddressDTO> viewAllAddress()
	{
		return arepository.findAll();
	}
	

}
