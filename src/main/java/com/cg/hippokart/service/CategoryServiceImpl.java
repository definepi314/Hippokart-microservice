package com.cg.hippokart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.hippokart.entity.Category;
import com.cg.hippokart.repository.CategoryRepository;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category getCategoryByName(String productCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.getAllCategories();
	}

}
