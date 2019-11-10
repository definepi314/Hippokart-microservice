
package com.cg.hippokart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.dto.ResponseDTO;
import com.cg.hippokart.entity.Product;
import com.cg.hippokart.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	public String addProducts(@RequestBody ProductDTO productDTO) {

		return productService.addProduct(productDTO);
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public ResponseDTO getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = "/removeProductById", method = RequestMethod.GET)
	public Product removeProductById(@RequestParam String productId) {
		return productService.removeProductById(productId);
	}
	
	@RequestMapping(value = "/removeProducts", method = RequestMethod.GET)
	public String removeProducts(@RequestParam String productId) {
		return productService.removeProducts();
	}
}
