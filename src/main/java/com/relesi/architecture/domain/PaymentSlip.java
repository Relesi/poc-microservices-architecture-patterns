package com.relesi.architecture.domain;

import java.util.Date;

import com.relesi.architecture.domain.enums.PaymentState;

public class PaymentSlip extends Payment {
	
	private static final long serialVersionUID = 1L; 


	private Date dueDate;
	private Date payDate;
	
	public PaymentSlip() {
		
	}

	public PaymentSlip(Integer id, PaymentState state, Order order, Date dueDate, Date payDate ) {
		super(id, state, order);
		this.dueDate = dueDate;
		this.payDate = payDate;
		
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	
	
	
	
}
