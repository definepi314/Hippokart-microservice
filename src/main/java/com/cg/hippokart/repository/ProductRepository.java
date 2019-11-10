package com.cg.hippokart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hippokart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

	@Query("select a from Product a where a.productId=?1")
	Product getByProductId(String productId);

	@Query("select a from Product a ")
	List<Product> getAllProducts();

	@Query("delete  from Product a where a.productId=?1")
	Product removeProductById(String productId);

	
	@Query("delete from Product a")
	String removeAll();



	
}
