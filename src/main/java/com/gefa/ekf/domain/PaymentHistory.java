package com.gefa.ekf.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PaymentHistory {

	private List<Payment> payments;

	public PaymentHistory(List<Payment> payments) {
		this.payments = payments;
	}

	public void addInterestPayment(PaymentType elementType, Date dueDate, BigDecimal amount) {
		payments.add(new Payment(elementType, dueDate, amount));
	}

}
