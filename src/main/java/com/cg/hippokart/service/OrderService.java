package com.cg.hippokart.service;

import java.util.List;

import com.cg.hippokart.dto.ProductDTO;

public interface OrderService {

	String checkOut(ProductDTO productDTO);

	//List<ProductDTO> getCartItems(String userId);

	
}
