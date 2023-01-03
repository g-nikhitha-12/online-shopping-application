package com.cg.osa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.osa.dto.UserDTO;
import com.cg.osa.exception.UserException;
import com.cg.osa.repository.IUserRepository;
@Service
public class IUserServiceImpl {
	@Autowired
	IUserRepository urepository;
	public UserDTO addUser(UserDTO user)throws UserException
	{
		if(!urepository.existsById(user.getUserId()))
		{
			urepository.save(user);
			return user;
		}
		else
		{
			throw new UserException("Id alredy Exist");
		}
	}
	public UserDTO removeUser(int id) throws UserException
	{
		if(urepository.existsById(id))
		{
			UserDTO udto=urepository.findById(id).get();
			urepository.deleteById(id);
			return udto;
		}
		else
		{
			throw new UserException("Id Not Found");
		}
	}
	public UserDTO viewUser(int id)throws UserException
	{
		if(urepository.existsById(id))
		{
			UserDTO udto=urepository.findById(id).get();
			return udto;
		}
		else
		{
			throw new UserException("Id not Found");
		}
	}
	
	public boolean signOut(UserDTO user)
	{
		return true;
	}
	
	public List<UserDTO> validateUser(int id,String pwd)throws UserException
	{
		
		List<UserDTO> credentials= urepository.validateUser(id,pwd);
		if(credentials.size()==0) {
			throw new UserException("Login credentials mismatched");
		}
		else {
			return credentials;
		}
		
	}
}
