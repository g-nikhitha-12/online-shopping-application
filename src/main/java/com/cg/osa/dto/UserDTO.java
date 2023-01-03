package com.cg.osa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="user_table")
public class UserDTO {
	@Id
	@NotNull (message="sorry id cannot be null")
	int userId;
	@Column(name="password")
    @NotBlank(message="sorry password should not be blank")
    
	String password;
	@Column(name="role")
	@NotBlank(message="sorry password should not be blank")
	 @Max(value=30,message="sorry maximum characters are 30")
	String role;
	public UserDTO(int userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public UserDTO() {
		super();
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	

}
