package com.relesi.architecture.domain.enums;

public enum ClientType {

	NATURALPERSON(1, "Natural Person"), LEGALPERSON(2, "Legal Person");

	private int cod;
	private String description;

	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
		
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	

	public static ClientType toEnum(Integer id) {
		
		if (id == null) {
			return null;
		}
		
		for (ClientType x : ClientType.values()) {
			
			if (id.equals(x.getCod())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Invalid id " + id);
	}

}
