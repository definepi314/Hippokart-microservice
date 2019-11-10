package com.cg.hippokart.service;

import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.dto.UserDTO;
import com.cg.hippokart.entity.User;

public interface UserService {

	String addUser(UserDTO user);

	User getUserProfile(String userId);


	String addToCart(ProductDTO productDTO);

	String addToWishlist(ProductDTO productDTO);

	String updateMobileNumber(UserDTO userDTO);

	String addCardInformation(UserDTO userDTO);

	String changePassword(UserDTO userDTO);
}
