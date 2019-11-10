package com.cg.hippokart.service;

import java.util.List;

import com.cg.hippokart.entity.Category;

public interface CategoryService {

	Category getCategoryByName(String productCategory);

	List<Category> getAllCategories();

}
