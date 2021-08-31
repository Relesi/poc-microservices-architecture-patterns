package com.relesi.architecture.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.relesi.architecture.domain.PurchaseOrder;
import com.relesi.architecture.services.PurchaseOrderService;

@RestController
@RequestMapping(value = "/purchaseOrder")
public class PurchaseOrderResource {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		PurchaseOrder obj = purchaseOrderService.search(id);
		return ResponseEntity.ok().body(obj);

	}

}
