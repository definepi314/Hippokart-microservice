package com.cg.hippokart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.dto.ResponseDTO;
import com.cg.hippokart.dto.UserDTO;
import com.cg.hippokart.entity.User;
import com.cg.hippokart.service.UserService;
import com.cg.hippokart.util.Constants;

@RestController
public class UserController {

	private static final Logger _LOGGER = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;


	@GetMapping("/getUserProfile")
	public ResponseDTO getUserProfile(String userId) {

		System.out.println("Entering getUserProfile()_controller");
		_LOGGER.debug("Entering getUserProfile()_controller");
		ResponseDTO responseDTO = new ResponseDTO(Constants.STATUS_FAILURE);

		User user = userService.getUserProfile(userId);
		System.out.println(" :) ");
		responseDTO.setStatus(Constants.STATUS_SUCCESS);
		responseDTO.setRequest(null);
		responseDTO.setResponse(user);
		System.out.println(" :) "+responseDTO.getStatus()+" "+responseDTO.getResponse());
		_LOGGER.debug("Exiting getUserProfile()_controller");
		return responseDTO;
	}
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@RequestBody ProductDTO productDTO) {

		return userService.addToCart(productDTO);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestBody UserDTO userDTO) {

		return userService.addUser(userDTO);
	}
	
	
	@RequestMapping(value = "/addToWishlist", method = RequestMethod.POST)
	public String addToWishlist(@RequestBody ProductDTO productDTO) {

		return userService.addToWishlist(productDTO);
	}
	
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public String updateMobileNumber(@RequestBody UserDTO userDTO) {

		return userService.updateMobileNumber(userDTO);
	}
	
	@RequestMapping(value = "/addCardInformation", method = RequestMethod.POST)
	public String addCardInformation(@RequestBody UserDTO userDTO) {

		return userService.addCardInformation(userDTO);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestBody UserDTO userDTO) {

		return userService.changePassword(userDTO);
	}
	

}
