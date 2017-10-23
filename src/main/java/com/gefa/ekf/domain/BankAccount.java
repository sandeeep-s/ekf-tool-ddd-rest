package com.gefa.ekf.domain;

public class BankAccount {

	private String bankName;

	private String accountNumber;

	public BankAccount(String bankName, String accountNumber) {
		this.bankName = bankName;
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

}
