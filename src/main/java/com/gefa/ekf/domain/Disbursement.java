package com.gefa.ekf.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Disbursement {

	private BigDecimal amount;

	private Date disbursementDate;

	public Disbursement(BigDecimal amount, Date disbursementDate) {
		this.amount = amount;
		this.disbursementDate = disbursementDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Date getDisbursementDate() {
		return disbursementDate;
	}

}
