package com.cg.hippokart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hippokart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

	@Query("select a from Cart a where a.user.userId=?1")
	List<Cart> getCartItems(int userId);

	@Query("select a from Cart a where a.user.userId=?1 and a.product.productId=?2")
	Cart getCartForCheckOut(int userId,int productId);

}
