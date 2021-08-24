package com.relesi.architecture.domain;

import java.io.Serializable;

public class Address implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String publicArea;
	private String number;
	private String complement;
	private String district;
	private String zipCode;

	private Client client;

	private City city;

	public Address() {

	}

	public Address(Integer id, String publicArea, String number, String complement, String district, String zipCode,
			Client client, City city) {
		super();
		this.id = id;
		this.publicArea = publicArea;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.zipCode = zipCode;
		this.client = client;
		this.setCity(city);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublicArea() {
		return publicArea;
	}

	public void setPublicArea(String publicArea) {
		this.publicArea = publicArea;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
