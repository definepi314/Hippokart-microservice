package com.cg.hippokart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hippokart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

	
	@Query("select c from Category c")
	List<Category> getAllCategories();

}
