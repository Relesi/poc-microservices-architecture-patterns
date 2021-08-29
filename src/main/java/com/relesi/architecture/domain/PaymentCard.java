package com.relesi.architecture.domain;

import com.relesi.architecture.domain.enums.PaymentState;

public class PaymentCard extends Payment {

	private static final long serialVersionUID = 1L;

	private Integer parcelNumber;

	public PaymentCard() {

	}

	public PaymentCard(Integer id, PaymentState state, Order order, Integer parcelNumber) {
		super(id, state, order);
		this.parcelNumber = parcelNumber;
	}

	public Integer getParcelNumber() {
		return parcelNumber;
	}

	public void setParcelNumber(Integer parcelNumber) {
		this.parcelNumber = parcelNumber;
	}

}
