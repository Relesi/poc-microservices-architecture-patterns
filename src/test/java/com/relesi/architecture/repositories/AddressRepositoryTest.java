package com.relesi.architecture.repositories;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.relesi.architecture.domain.Address;
import com.relesi.architecture.domain.City;
import com.relesi.architecture.domain.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepository;

	@Before
	public void setUp() throws Exception {

		Address address = new Address();
		address.setPublicArea("Apt 201");
		address.setDistrict("Englewood");
		address.setNumber("2001");
		address.setZipCode("05880560");
		address.setComplement("89");

		address.setCity(new City());
		address.setClient(new Client());
		this.addressRepository.save(address);

	}
	
	//TODO

}
