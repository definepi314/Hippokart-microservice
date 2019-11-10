package com.cg.hippokart.service;

import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.dto.ResponseDTO;
import com.cg.hippokart.entity.Product;

public interface ProductService {



	String addProduct(ProductDTO dto);

	ResponseDTO getAllProducts();

	Product  removeProductById(String productId);

	String removeProducts();

	
}
