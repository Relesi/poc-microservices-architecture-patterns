package com.relesi.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relesi.architecture.domain.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Integer> {

}
