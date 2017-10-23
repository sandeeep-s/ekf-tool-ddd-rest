package com.gefa.ekf.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {

	private PaymentType elementType;

	private Date dueDate;

	private BigDecimal amount;

	public Payment(PaymentType elementType, Date dueDate, BigDecimal amount) {
		this.elementType = elementType;
		this.dueDate = dueDate;
		this.amount = amount;
	}
}
