package com.relesi.architecture.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.relesi.architecture.domain.enums.ClientType;

public class Client implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private Double itinOrEin;
	private Integer type;

	private List<Address> addresses = new ArrayList<>();

	private Set<String> phones = new HashSet<>();

	public Client() {

	}

	public Client(Integer id, String name, String email, Double itinOrEin, ClientType type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.itinOrEin = itinOrEin;
		this.type = type.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getItinOrEin() {
		return itinOrEin;
	}

	public void setItinOrEin(Double itinOrEin) {
		this.itinOrEin = itinOrEin;
	}

	public ClientType getType() {
		return ClientType.toEnum(type);
	}

	public void setType(ClientType type) {
		this.type = type.getCod();
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
