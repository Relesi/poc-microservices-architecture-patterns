package com.relesi.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relesi.architecture.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
