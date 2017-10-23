package com.gefa.ekf.domain;

import java.io.File;
import java.util.Date;

public class Invoice {

	private String invoiceNumber;

	private Date invoiceDate;

	private File invoiceDocument;

	public Invoice(String invoiceNumber, Date invoiceDate, File invoiceDocument) {
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.invoiceDocument = invoiceDocument;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public File getInvoiceDocument() {
		return invoiceDocument;
	}

}
