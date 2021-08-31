package com.relesi.architecture.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relesi.architecture.domain.PurchaseOrder;
import com.relesi.architecture.repositories.PurchaseOrderRepository;
import com.relesi.architecture.services.exceptions.ObjectNotFoundException;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	public PurchaseOrder search(Integer id) {
		Optional<PurchaseOrder> obj = purchaseOrderRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found!  Id: " + id + ", Tipo: " + PurchaseOrder.class.getName()));

	}
	





}
