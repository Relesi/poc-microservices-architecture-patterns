package com.relesi.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relesi.architecture.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
