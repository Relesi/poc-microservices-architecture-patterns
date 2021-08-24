package com.relesi.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relesi.architecture.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
