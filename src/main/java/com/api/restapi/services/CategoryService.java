package com.api.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.restapi.domain.Category;
import com.api.restapi.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Category obj = repo.findOne(id);
		
		return obj;
	}
	
}
