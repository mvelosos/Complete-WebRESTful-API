package com.api.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.restapi.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
