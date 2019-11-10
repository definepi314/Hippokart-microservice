package com.cg.hippokart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.service.OrderService;

@RestController
public class OrderController {

	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/checkOut", method = RequestMethod.POST)
	public String checkOut(@RequestBody ProductDTO productDTO) {
	return orderService.checkOut(productDTO);
}
	
	/*@RequestMapping(value = "/getCartItems", method = RequestMethod.GET)
	public List<ProductDTO> getCartItems(@RequestParam String userId) {
	return orderService.getCartItems(userId);
}*/
}