package com.cg.hippokart.dto;

import java.util.Collection;
import java.util.Set;

import com.cg.hippokart.entity.Product;
import com.cg.hippokart.entity.Role;

public class UserDTO {
	private int userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String username;
	private boolean enabled;
	private String mobileNo;
	private Set<Product> item;
	private Collection<Role> roles;

	
	public Set<Product> getItem() {
		return item;
	}
	public void setItem(Set<Product> item) {
		this.item = item;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
