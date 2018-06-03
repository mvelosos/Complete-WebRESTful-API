package com.api.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.restapi.domain.Client;
import com.api.restapi.repositories.ClientRepository;
import com.api.restapi.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id) {
		Client obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Object not found! Id: "+id
					+", Type: "+Client.class.getName());
		}
		return obj;
	}
	
}
