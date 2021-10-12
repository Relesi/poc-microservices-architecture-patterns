package com.relesi.architecture.repositories;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.relesi.architecture.domain.Address;
import com.relesi.architecture.domain.Client;
import com.relesi.architecture.services.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientService clientService;

	public static final Integer ID = 1;

	@Before
	public void setUp() throws Exception {

		Client client = new Client();
		client.setName("Renato");
		client.setEmail("renato@renato.com.br");
		client.setItinOrEin("299.009.009.09");
		// client.setType(null);

		client.setAddresses(new ArrayList<Address>());
		client.setTelephones(null);
		client.setPurchaseOrder(new ArrayList<>());
		this.clientRepository.save(client);

	}

	@Test
	public void testSearch() {
		final Optional<Client> client = Optional.ofNullable(this.clientService.find(ID));
		assertTrue(client.isPresent());
	}

}
