package com.gefa.ekf.boundary.rest.representations;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gefa.ekf.domain.Asset;

public class AssetRepresentation extends Representation {

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

	public AssetRepresentation() {

	}

	public AssetRepresentation(Asset asset, Link... links) {
		this.gevisNumber = asset.getDealer().getGevisNumber();
		this.businessType = asset.getBusinessType().getEnglishTitle();
		this.serialNumber = asset.getSerialNumber();
		this.manufacturerTitle = asset.getManufacturer().getTitle();
		this.assetName = asset.getAssetName();
		this.requestedDisbursementDate = asset.getRequestedDisbursementDate();
		this.internalRefNo = asset.getInternalRefNo();
		this.constructionYear = asset.getConstructionYear();
		switch (asset.getDisbursementParty()) {
		case INVOICING_PARTY:
			this.disbursementParty = "invoicing-party";
			break;
		default:
			this.disbursementParty = "dealer";
			break;
		}
		this.vatIncludedInDisbursment = asset.getVatIncludedInDisbursment();
		this.paymentProofAvailable = asset.getPaymentProofAvailable();
		this.paymentProofDocument = asset.getPaymentProofDocument();
		this.invoiceDate = asset.getInvoice().getInvoiceDate();
		this.invoiceNumber = asset.getInvoice().getInvoiceNumber();
		this.invoiceDocument = asset.getInvoice().getInvoiceDocument();
		this.vrdAvailable = asset.getVrdAvailable();
		this.registrationNumber = asset.getVrd().getRegistrationNumber();
		this.registeredTo = asset.getVrd().getRegisteredTo();
		this.vehicleRegistrationDocument = asset.getVrd().getRegistrationDocument();
		this.netPrice = asset.getNetPrice();
		this.commentsToGEFA = asset.getCommentsToGEFA();
		this.assetComments = asset.getAssetComments();
		this.subsidyStartDate = asset.getSubsidyStartDate();
		this.subsidyEndDate = asset.getSubsidyEndDate();
		this.cumulatedInterest = asset.getCumulatedInterest();
		this.utilization = null;

		if (null != asset.getDisbursement()) {
			this.disbursementAmount = asset.getDisbursement().getAmount();
			this.disbursementDate = asset.getDisbursement().getDisbursementDate();
		}

		this.assetStatus = asset.getAssetState().toString();
		this.links = Arrays.asList(links);

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

	@JsonIgnore
	public Link getSelfLink() {
		return getLinkByName("self");
	}

	@JsonIgnore
	public Link getUpdateLink() {
		return getLinkByName("update");
	}

	@JsonIgnore
	public Link getRemoveLink() {
		return getLinkByName("remove");
	}

	@JsonIgnore
	public Link getApproveLink() {
		return getLinkByName("approve");
	}

}
