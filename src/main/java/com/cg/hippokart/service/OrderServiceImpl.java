package com.cg.hippokart.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hippokart.dto.ProductDTO;
import com.cg.hippokart.entity.Cart;
import com.cg.hippokart.repository.CartRepository;
import com.cg.hippokart.repository.OrderRepository;
import com.cg.hippokart.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public String checkOut(ProductDTO productDTO) {
		String result = "";
		try {
			if (paymentCheck() == true) {
				Cart cart  = cartRepository.getCartForCheckOut(productDTO.getUser().getUserId(), productDTO.getProductId());
				/*if(cart.equals("")){
					
				}*/
				deleteCart(cart);
				result = "Confirmed Order";
			}
		} catch (Exception e) {
			result = e.getMessage();
		}

		return result;
	}

	/*@Override
	public List<ProductDTO> getCartItems(String userId) {
		List<Cart> enList = cartRepository.getCartItems(userId);
		Iterator<Cart> it = enList.iterator();
		List<ProductDTO> dtoList = new ArrayList<>();
		while (it.hasNext()) {
			Cart cart = (Cart) it.next();
			ProductDTO productDTO = new ProductDTO();
			dtoList.add(productDTO);
		}
		return dtoList;
	}*/

	public boolean paymentCheck() {
		return true;
	}
	
	public void deleteCart(Cart cart){
		cartRepository.delete(cart);
	}
}
