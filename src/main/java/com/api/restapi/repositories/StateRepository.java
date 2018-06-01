package com.api.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.restapi.domain.State;

public interface StateRepository extends JpaRepository<State, Integer> {

}
