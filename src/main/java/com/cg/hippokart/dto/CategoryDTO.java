package com.cg.hippokart.dto;

import java.util.List;

import com.cg.hippokart.entity.Product;

public class CategoryDTO {
private int categoryId;
	
	
	public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
	private String categoryName;
	public List<Product> item;
	public List<Product> getItem() {
		return item;
	}
	public void setItem(List<Product> item) {
		this.item = item;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
