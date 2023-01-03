package com.cg.osa.service;

import java.util.List;

import com.cg.osa.dto.UserDTO;
import com.cg.osa.exception.UserException;

public interface IUserService {
	public UserDTO addUser(UserDTO user) throws UserException;
	public UserDTO removeUser(int id) throws UserException;
	public UserDTO viewUser(int id)throws UserException;
	public boolean signOut(UserDTO user);
	public List<UserDTO> validateUser(int id,String pwd)throws UserException;
}
