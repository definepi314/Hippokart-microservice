package com.cg.hippokart.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User implements Serializable {

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + ", username=" + username + ", enabled=" + enabled + ", mobileNo="
				+ mobileNo + ", cartList=" + cartList + ", roles=" + roles + "]";
	}

	private static final long serialVersionUID = 2681531852204068105L;
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	public List<Cart> getCartList() {
		return cartList;
	}

	public int getUserId() {
		return userId;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailId;
	@Column
	private String password;
	@Column
	private String username;
	@Column
	private boolean enabled;
	@Column
	private String mobileNo;

	/*
	 * @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 * 
	 * @JoinTable( name="Product", joinColumns = @JoinColumn(name="USER_ID"),
	 * inverseJoinColumns = @JoinColumn(name="PRODUCT_ID") ) private
	 * Set<Product> item;
	 */

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Cart> cartList;

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	  @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	    @JoinTable(name="user_roles",
	        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id")},
	        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")}
	    )
	private Collection<Role> roles;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
