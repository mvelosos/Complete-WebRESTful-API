package com.api.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.restapi.domain.Category;
import com.api.restapi.repositories.CategoryRepository;
import com.api.restapi.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Category obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Object not found! Id: "+id
					+", Type: "+Category.class.getName());
		}
		return obj;
	}
	
}
