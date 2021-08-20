package com.relesi.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relesi.architecture.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
