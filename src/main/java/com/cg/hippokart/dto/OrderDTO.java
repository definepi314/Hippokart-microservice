package com.cg.hippokart.dto;

import com.cg.hippokart.entity.BillingAddress;
import com.cg.hippokart.entity.ShippingAddress;
import com.cg.hippokart.entity.User;

public class OrderDTO {
	
	private int orderId;
	

	
	private User user;
	
	private ShippingAddress shippingAddress;
	
	private BillingAddress billingAddress;

	

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

}
