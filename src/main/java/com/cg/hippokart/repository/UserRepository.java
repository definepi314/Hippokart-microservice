package com.cg.hippokart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hippokart.dto.UserDTO;
import com.cg.hippokart.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("select u from User u where u.userId=?1")
	User findByUserId(int userId);

	@Query("select u from User u where u.username=?1")
	User getUserByName(String userName);

}
