package com.gefa.ekf.client.domain;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;

public class ClientAsset {

	private Long id;
	private Long gevisNumber;
	private String businessType;
	private String serialNumber;
	private String manufacturerTitle;
	private String assetName;
	private Date requestedDisbursementDate;
	private String internalRefNo;
	private Integer constructionYear;
	private String disbursementParty;
	private Boolean vatIncludedInDisbursment;
	private Boolean paymentProofAvailable;
	private File paymentProofDocument;
	private Date invoiceDate;
	private String invoiceNumber;
	private File invoiceDocument;
	private Boolean vrdAvailable;
	private String registrationNumber;
	private String registeredTo;
	private File vehicleRegistrationDocument;
	private BigDecimal netPrice;
	private String commentsToGEFA;
	private String assetComments;
	private Date subsidyStartDate;
	private Date subsidyEndDate;
	private BigDecimal utilization;
	private BigDecimal cumulatedInterest;
	private BigDecimal disbursementAmount;
	private Date disbursementDate;
	private String assetStatus;

	public ClientAsset() {

	}

	public ClientAsset(AssetRepresentation assetRepresentation) {
		this.gevisNumber = assetRepresentation.getGevisNumber();
		this.businessType = assetRepresentation.getBusinessType();
		this.serialNumber = assetRepresentation.getSerialNumber();
		this.manufacturerTitle = assetRepresentation.getManufacturerTitle();
		this.assetName = assetRepresentation.getAssetName();
		this.requestedDisbursementDate = assetRepresentation.getRequestedDisbursementDate();
		this.internalRefNo = assetRepresentation.getInternalRefNo();
		this.constructionYear = assetRepresentation.getConstructionYear();
		this.disbursementParty = assetRepresentation.getDisbursementParty();
		this.vatIncludedInDisbursment = assetRepresentation.getVatIncludedInDisbursment();
		this.paymentProofAvailable = assetRepresentation.getPaymentProofAvailable();
		this.paymentProofDocument = assetRepresentation.getPaymentProofDocument();
		this.invoiceDate = assetRepresentation.getInvoiceDate();
		this.invoiceNumber = assetRepresentation.getInvoiceNumber();
		this.invoiceDocument = assetRepresentation.getInvoiceDocument();
		this.vrdAvailable = assetRepresentation.getVrdAvailable();
		this.registrationNumber = assetRepresentation.getRegistrationNumber();
		this.registeredTo = assetRepresentation.getRegisteredTo();
		this.vehicleRegistrationDocument = assetRepresentation.getVehicleRegistrationDocument();
		this.netPrice = assetRepresentation.getNetPrice();
		this.commentsToGEFA = assetRepresentation.getCommentsToGEFA();
		this.assetComments = assetRepresentation.getAssetComments();
		this.subsidyStartDate = assetRepresentation.getSubsidyStartDate();
		this.subsidyEndDate = assetRepresentation.getSubsidyEndDate();
		this.cumulatedInterest = assetRepresentation.getCumulatedInterest();
		this.utilization = null;
		this.disbursementAmount = assetRepresentation.getDisbursementAmount();
		this.disbursementDate = assetRepresentation.getDisbursementDate();
		this.assetStatus = assetRepresentation.getAssetStatus().toString();

	}

	public AssetRepresentation getAssetRepresentation() {
		AssetRepresentation assetRepresentation = new AssetRepresentation();
		assetRepresentation.setGevisNumber(this.getGevisNumber());
		assetRepresentation.setBusinessType(this.getBusinessType());
		assetRepresentation.setSerialNumber(this.getSerialNumber());
		assetRepresentation.setManufacturerTitle(this.getManufacturerTitle());
		assetRepresentation.setAssetName(this.getAssetName());
		assetRepresentation.setRequestedDisbursementDate(this.getRequestedDisbursementDate());
		assetRepresentation.setInternalRefNo(this.getInternalRefNo());
		assetRepresentation.setConstructionYear(this.getConstructionYear());
		assetRepresentation.setDisbursementParty(this.getDisbursementParty());
		assetRepresentation.setVatIncludedInDisbursment(this.getVatIncludedInDisbursment());
		assetRepresentation.setPaymentProofAvailable(this.getPaymentProofAvailable());
		assetRepresentation.setPaymentProofDocument(this.getPaymentProofDocument());
		assetRepresentation.setInvoiceDate(this.getInvoiceDate());
		assetRepresentation.setInvoiceNumber(this.getInvoiceNumber());
		assetRepresentation.setInvoiceDocument(this.getInvoiceDocument());
		assetRepresentation.setVrdAvailable(this.getVrdAvailable());
		assetRepresentation.setRegistrationNumber(this.getRegistrationNumber());
		assetRepresentation.setRegisteredTo(this.getRegisteredTo());
		assetRepresentation.setVehicleRegistrationDocument(this.getVehicleRegistrationDocument());
		assetRepresentation.setNetPrice(this.getNetPrice());
		assetRepresentation.setCommentsToGEFA(this.getCommentsToGEFA());
		assetRepresentation.setAssetComments(this.getAssetComments());
		assetRepresentation.setSubsidyEndDate(this.getSubsidyEndDate());
		assetRepresentation.setSubsidyEndDate(this.getSubsidyEndDate());
		assetRepresentation.setCumulatedInterest(this.getCumulatedInterest());
		assetRepresentation.setUtilization(this.getUtilization());
		assetRepresentation.setDisbursementAmount(this.getDisbursementAmount());
		assetRepresentation.setDisbursementDate(this.getDisbursementDate());
		assetRepresentation.setAssetStatus(this.getAssetStatus());
		return assetRepresentation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGevisNumber() {
		return gevisNumber;
	}

	public void setGevisNumber(Long gevisNumber) {
		this.gevisNumber = gevisNumber;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getManufacturerTitle() {
		return manufacturerTitle;
	}

	public void setManufacturerTitle(String manufacturerTitle) {
		this.manufacturerTitle = manufacturerTitle;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Date getRequestedDisbursementDate() {
		return requestedDisbursementDate;
	}

	public void setRequestedDisbursementDate(Date requestedDisbursementDate) {
		this.requestedDisbursementDate = requestedDisbursementDate;
	}

	public String getInternalRefNo() {
		return internalRefNo;
	}

	public void setInternalRefNo(String internalRefNo) {
		this.internalRefNo = internalRefNo;
	}

	public Integer getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(Integer constructionYear) {
		this.constructionYear = constructionYear;
	}

	public String getDisbursementParty() {
		return disbursementParty;
	}

	public void setDisbursementParty(String disbursementParty) {
		this.disbursementParty = disbursementParty;
	}

	public Boolean getVatIncludedInDisbursment() {
		return vatIncludedInDisbursment;
	}

	public void setVatIncludedInDisbursment(Boolean vatIncludedInDisbursment) {
		this.vatIncludedInDisbursment = vatIncludedInDisbursment;
	}

	public Boolean getPaymentProofAvailable() {
		return paymentProofAvailable;
	}

	public void setPaymentProofAvailable(Boolean paymentProofAvailable) {
		this.paymentProofAvailable = paymentProofAvailable;
	}

	public File getPaymentProofDocument() {
		return paymentProofDocument;
	}

	public void setPaymentProofDocument(File paymentProofDocument) {
		this.paymentProofDocument = paymentProofDocument;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public File getInvoiceDocument() {
		return invoiceDocument;
	}

	public void setInvoiceDocument(File invoiceDocument) {
		this.invoiceDocument = invoiceDocument;
	}

	public Boolean getVrdAvailable() {
		return vrdAvailable;
	}

	public void setVrdAvailable(Boolean vrdAvailable) {
		this.vrdAvailable = vrdAvailable;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegisteredTo() {
		return registeredTo;
	}

	public void setRegisteredTo(String registeredTo) {
		this.registeredTo = registeredTo;
	}

	public File getVehicleRegistrationDocument() {
		return vehicleRegistrationDocument;
	}

	public void setVehicleRegistrationDocument(File vehicleRegistrationDocument) {
		this.vehicleRegistrationDocument = vehicleRegistrationDocument;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public String getCommentsToGEFA() {
		return commentsToGEFA;
	}

	public void setCommentsToGEFA(String commentsToGEFA) {
		this.commentsToGEFA = commentsToGEFA;
	}

	public String getAssetComments() {
		return assetComments;
	}

	public void setAssetComments(String assetComments) {
		this.assetComments = assetComments;
	}

	public Date getSubsidyStartDate() {
		return subsidyStartDate;
	}

	public void setSubsidyStartDate(Date subsidyStartDate) {
		this.subsidyStartDate = subsidyStartDate;
	}

	public Date getSubsidyEndDate() {
		return subsidyEndDate;
	}

	public void setSubsidyEndDate(Date subsidyEndDate) {
		this.subsidyEndDate = subsidyEndDate;
	}

	public BigDecimal getUtilization() {
		return utilization;
	}

	public void setUtilization(BigDecimal utilization) {
		this.utilization = utilization;
	}

	public BigDecimal getCumulatedInterest() {
		return cumulatedInterest;
	}

	public void setCumulatedInterest(BigDecimal cumulatedInterest) {
		this.cumulatedInterest = cumulatedInterest;
	}

	public BigDecimal getDisbursementAmount() {
		return disbursementAmount;
	}

	public void setDisbursementAmount(BigDecimal disbursementAmount) {
		this.disbursementAmount = disbursementAmount;
	}

	public Date getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

}
