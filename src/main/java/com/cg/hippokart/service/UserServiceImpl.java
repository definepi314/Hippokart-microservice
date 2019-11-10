package com.cg.hippokart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.dto.UserDTO;
import com.cg.hippokart.entity.Cart;
import com.cg.hippokart.entity.Product;
import com.cg.hippokart.entity.User;
import com.cg.hippokart.entity.WishList;
import com.cg.hippokart.exception.BusinessException;
import com.cg.hippokart.repository.CartRepository;
import com.cg.hippokart.repository.UserRepository;
import com.cg.hippokart.repository.WishlistRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger _LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private User user;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;

	
	@Autowired
	private WishlistRepository wishlistRepository;

	@Override
	public User getUserProfile(String userId) {
		_LOGGER.debug(" Entering getUserProfile()_Service");

		user = userRepository.getOne(userId);
		if (user != null) {
			_LOGGER.info("spring-sso: " + user.getUsername());
			return user;
		}

		_LOGGER.debug(" Exiting getUserProfile()_Service");
		return user;
	}

	@Override
	public String addUser(UserDTO dto) {
		if (userRepository.getUserByName(dto.getUsername())== null) {
			User user = new User();
			user.setFirstName(dto.getFirstName());
			user.setLastName(dto.getLastName());
			user.setMobileNo(dto.getMobileNo());
			user.setUsername(dto.getUsername());
			user.setEmailId(dto.getEmailId());
			user.setPassword(dto.getPassword());
			userRepository.save(user);
			return "SUCCESS";
		} else {
			throw new BusinessException("User with username " + dto.getUsername() + " already present");
		}

	}

	

	@Override
	public String addToCart(ProductDTO productDTO) {
		String result = "";
		Cart cart = new Cart();
		System.out.println("Inside...................");
		User user = userRepository.getUserByName(productDTO.getUser().getUsername());
		System.out.println("-----------------"+user);
		if(!(cartRepository.getCartForCheckOut(productDTO.getUser().getUserId(), productDTO.getProductId())==null)){
			 cart = cartRepository.getCartForCheckOut(productDTO.getUser().getUserId(), productDTO.getProductId());
		}
		
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		cart.setProduct(product);;
		cart.setUser(user);
		try {
			cartRepository.save(cart);
			result = "SUCESS";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@Override
	public String addToWishlist(ProductDTO productDTO) {
		String result = "";
		WishList wishList = new WishList();
		User user = userRepository.getUserByName(productDTO.getUser().getUsername());
		if(!(wishlistRepository.getWishList(productDTO.getUser().getUserId(), productDTO.getProductId())==null)){
			wishList = wishlistRepository.getWishList(productDTO.getUser().getUserId(), productDTO.getProductId());
		}
		
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		wishList.setProduct(product);
		wishList.setUser(user);
		try {
			wishlistRepository.save(wishList);
			result = "SUCESS";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@Override
	public String updateMobileNumber(UserDTO userDTO) {
		String result = "";
		User userToUpdate = userRepository.findByUserId(userDTO.getUserId());
		userToUpdate.setMobileNo(userDTO.getMobileNo());
		try {
			userRepository.save(userToUpdate);
			result = "SUCCESS";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
		
	}

	@Override
	public String addCardInformation(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
