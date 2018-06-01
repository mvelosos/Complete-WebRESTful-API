package com.api.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.restapi.domain.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
