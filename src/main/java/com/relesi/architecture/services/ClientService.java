package com.relesi.architecture.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relesi.architecture.domain.Client;
import com.relesi.architecture.repositories.ClientRepository;
import com.relesi.architecture.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository ClientRepository;

	public Client find(Integer id) {
		Optional<Client> obj = ClientRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found!  Id: " + id + ", Tipo: " + Client.class.getName()));

	}

}
