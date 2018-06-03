package com.api.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.restapi.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
