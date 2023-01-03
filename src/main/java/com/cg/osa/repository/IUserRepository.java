package com.cg.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.osa.dto.UserDTO;
@Repository
public interface IUserRepository extends JpaRepository<UserDTO,Integer>{



	@Query("select user from UserDTO user where user.userId=:id and user.password=:pwd")
	List<UserDTO> validateUser(@Param("id")int id,@Param("pwd")String pwd);

}

