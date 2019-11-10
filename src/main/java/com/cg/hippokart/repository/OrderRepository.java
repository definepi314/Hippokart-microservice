package com.cg.hippokart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hippokart.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

}
