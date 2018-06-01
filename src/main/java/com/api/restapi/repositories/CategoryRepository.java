package com.api.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.restapi.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
