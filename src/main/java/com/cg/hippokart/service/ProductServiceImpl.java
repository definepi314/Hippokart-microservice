package com.cg.hippokart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hippokart.controller.UserController;
import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.dto.ResponseDTO;
import com.cg.hippokart.entity.Product;
import com.cg.hippokart.repository.ProductRepository;
import com.cg.hippokart.util.Constants;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger _LOGGER = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
    private ProductRepository productRepository;

	@Override
	public String addProduct(ProductDTO dto) {
		String result = "";
		Product product = new Product();
		product.setProductId(dto.getProductId());	
		product.setProductName(dto.getProductName());
		product.setProductPrice(dto.getProductPrice());	
		try {
			productRepository.save(product);
			result = "SUCCESS";
		} catch (Exception e) {
			result = e.getMessage();
		}
	
		
		return result;
	}

	@Override
	public ResponseDTO getAllProducts() {
		
		System.out.println("Entering getAllProducts()_controller");
		_LOGGER.debug("Entering getAllProducts()_controller");
		ResponseDTO responseDTO = new ResponseDTO(Constants.STATUS_FAILURE);
		List<Product> list = productRepository.getAllProducts();
		
		System.out.println(" :) ");
		responseDTO.setStatus(Constants.STATUS_SUCCESS);
		responseDTO.setRequest(null);
		responseDTO.setResponse(list);
		System.out.println(" :) "+responseDTO.getStatus()+" "+responseDTO.getResponse());
		_LOGGER.debug("Exiting getAllProducts()_controller");
		
		return responseDTO;
	}

	@Override
	public Product removeProductById(String productId) {
		System.out.println("Entering removeProductById()_controller");
		_LOGGER.debug("Entering removeProductById()_controller");
		 
		
		return productRepository.removeProductById(productId);
	}

	@Override
	public String removeProducts() {
		System.out.println("Entering removeProductById()_controller");
		_LOGGER.debug("Entering removeProductById()_controller");
		
		
		return productRepository.removeAll();
	}

    
	
	
	

	

	    

	

	
	

	

}
