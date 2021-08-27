package com.relesi.architecture.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.relesi.architecture.domain.Client;
import com.relesi.architecture.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Client obj = clientService.search(id);
		return ResponseEntity.ok().body(obj);

	}

}
