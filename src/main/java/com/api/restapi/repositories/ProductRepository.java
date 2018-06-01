package com.api.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.restapi.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
