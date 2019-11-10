package com.cg.hippokart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hippokart.entity.WishList;

public interface WishlistRepository extends JpaRepository<WishList, String>{
	
	@Query("select a from WishList a where a.user.userId=?1 and a.product.productId=?2")
	WishList getWishList(int userId,int productId);


}
