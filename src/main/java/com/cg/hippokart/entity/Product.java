package com.cg.hippokart.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Product implements Serializable {
	
	
	private static final long serialVersionUID = 5186013952828648626L;

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public List<WishList> getWishListlist() {
		return wishListlist;
	}

	public void setWishListlist(List<WishList> wishListlist) {
		this.wishListlist = wishListlist;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Column
	private String productCategory;
	
	@Column
	private String productDescription;
	
	@Column
	private String productManufacturer;
	
	
	@Column
	private String productName;
	
	
	@Column
	private double productPrice;
	
	@Column
	private Integer unitStock;

	@Column
	private String imageId;

	
	 public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Cart> cartList;
 
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<WishList> wishListlist;

	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="category_id", referencedColumnName = "category_id")
	 @JsonIgnore
		private Category category;
	
	// Getters and Setter
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	public String getProductCategory() {
		return productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}



	public double getProductPrice() {
		return productPrice;
	}

	

	public int getProductId() {
		return productId;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

		public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	
	

	public Integer getUnitStock() {
		return unitStock;
	}

	public void setUnitStock(Integer unitStock) {
		this.unitStock = unitStock;
	}

}
