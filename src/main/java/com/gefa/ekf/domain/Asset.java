package com.gefa.ekf.domain;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.gefa.ekf.domain.repositories.BusinessTypeRepository;
import com.gefa.ekf.domain.repositories.DealerRepository;
import com.gefa.ekf.domain.repositories.ManufacturerRepository;

public class Asset extends AggregateRoot {

	private AssetState assetCreatedState;
	private AssetState assetDeletedState;
	private AssetState assetSubmittedState;
	private AssetState assetApprovedState;
	private AssetState assetArchivedState;

	private Long id;
	private Dealer dealer;
	private Manufacturer manufacturer;
	private BusinessType businessType;
	private PaymentHistory paymentHistory;
	private PaymentPlan paymentPlan;
	private Invoice invoice;
	private VRD vrd;

	private String objCatalogId;
	private String serialNumber;
	private String assetName;
	private String internalRefNo;
	private Date requestedDisbursementDate;
	private Integer constructionYear;
	private DisbursementParty disbursementParty;
	private BigDecimal netPrice;
	private Boolean paymentProofAvailable;
	private File paymentProofDocument;
	private Boolean vatIncludedInDisbursment;
	private Boolean vrdAvailable;
	private String commentsToGEFA;
	private String assetComments;
	private Integer financeDurationInMonths;
	private Date deRegistrationDate;
	private String initiatingUser;
	private Long vendorId;
	private Disbursement disbursement;
	private BigDecimal cumulatedInterest;
	private BigDecimal currentValue;
	private BigDecimal fixedInterest;
	private Date subsidyStartDate;
	private Date subsidyEndDate;
	private List<Attachment> attachments;

	private AssetState assetState;

	public AssetState getAssetCreatedState() {
		return assetCreatedState;
	}

	public AssetState getAssetDeletedState() {
		return assetDeletedState;
	}

	public AssetState getAssetSubmittedState() {
		return assetSubmittedState;
	}

	public AssetState getAssetApprovedState() {
		return assetApprovedState;
	}

	public AssetState getAssetArchivedState() {
		return assetArchivedState;
	}

	public Long getId() {
		return id;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public PaymentHistory getPaymentHistory() {
		return paymentHistory;
	}

	public PaymentPlan getPaymentPlan() {
		return paymentPlan;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public VRD getVrd() {
		return vrd;
	}

	public String getObjCatalogId() {
		return objCatalogId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getAssetName() {
		return assetName;
	}

	public String getInternalRefNo() {
		return internalRefNo;
	}

	public Date getRequestedDisbursementDate() {
		return requestedDisbursementDate;
	}

	public Integer getConstructionYear() {
		return constructionYear;
	}

	public DisbursementParty getDisbursementParty() {
		return disbursementParty;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public Boolean getPaymentProofAvailable() {
		return paymentProofAvailable;
	}

	public File getPaymentProofDocument() {
		return paymentProofDocument;
	}

	public Boolean getVatIncludedInDisbursment() {
		return vatIncludedInDisbursment;
	}

	public Boolean getVrdAvailable() {
		return vrdAvailable;
	}

	public String getCommentsToGEFA() {
		return commentsToGEFA;
	}

	public String getAssetComments() {
		return assetComments;
	}

	public Integer getFinanceDurationInMonths() {
		return financeDurationInMonths;
	}

	public Date getDeRegistrationDate() {
		return deRegistrationDate;
	}

	public String getInitiatingUser() {
		return initiatingUser;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public Disbursement getDisbursement() {
		return disbursement;
	}

	public BigDecimal getCumulatedInterest() {
		return cumulatedInterest;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public BigDecimal getFixedInterest() {
		return fixedInterest;
	}

	public Date getSubsidyStartDate() {
		return subsidyStartDate;
	}

	public Date getSubsidyEndDate() {
		return subsidyEndDate;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public AssetState getAssetState() {
		return assetState;
	}

	public void setAssetState(AssetState assetState) {
		this.assetState = assetState;
	}

	private Asset(Builder builder) {
		this.assetCreatedState = new AssetCreatedState(this);
		this.assetDeletedState = new AssetDeletedState(this);
		this.assetApprovedState = new AssetApprovedState(this);
		this.assetArchivedState = new AssetArchivedState(this);
		this.assetSubmittedState = new AssetSubmittedState(this);

		this.id = builder.id;
		this.dealer = builder.dealer;
		this.manufacturer = builder.manufacturer;
		this.businessType = builder.businessType;
		this.invoice = builder.invoice;
		this.vrd = builder.vrd;

		this.objCatalogId = builder.objCatalogId;
		this.serialNumber = builder.serialNumber;
		this.assetName = builder.assetName;
		this.internalRefNo = builder.internalRefNo;
		this.requestedDisbursementDate = builder.requestedDisbursementDate;
		this.constructionYear = builder.constructionYear;
		this.disbursementParty = builder.disbursementParty;
		this.netPrice = builder.netPrice;
		this.paymentProofAvailable = builder.paymentProofAvailable;
		this.paymentProofDocument = builder.paymentProofDocument;
		this.vatIncludedInDisbursment = builder.vatIncludedInDisbursment;
		this.vrdAvailable = builder.vrdAvailable;
		this.commentsToGEFA = builder.commentsToGEFA;
		this.assetComments = builder.assetComments;
		this.financeDurationInMonths = builder.financeDurationInMonths;
		this.deRegistrationDate = builder.deRegistrationDate;
		this.initiatingUser = builder.initiatingUser;
		this.vendorId = builder.vendorId;
		this.disbursement = builder.disbursement;
		this.cumulatedInterest = builder.cumulatedInterest;
		this.currentValue = builder.currentValue;
		this.fixedInterest = builder.fixedInterest;
		this.subsidyStartDate = builder.subsidyStartDate;
		this.subsidyEndDate = builder.subsidyEndDate;
		this.attachments = builder.attachments;
		this.assetState = builder.assetState;
	}

	public void addPaymentPlan(List<Payment> payments) {
		this.paymentPlan = new PaymentPlan(payments);
	}

	public void addPayments(List<Payment> payments) {
		this.paymentHistory = new PaymentHistory(payments);
	}

	public void moveToCreatedState() {
		assetState.moveToCreatedState();
	}

	public void moveToDeletedState() {
		assetState.moveToDeletedState();
	}

	public void moveToSubmittedState() {
		assetState.moveToSubmittedState();
	}

	public void moveToApprovedState() {
		assetState.moveToApprovedState();
	}

	public void moveToArchivedState() {
		assetState.moveToArchivedState();
	}

	public static class Builder {
		private Long id;
		private Dealer dealer;
		private Manufacturer manufacturer;
		private BusinessType businessType;
		private Invoice invoice;
		private VRD vrd;
		private String objCatalogId;
		private String serialNumber;
		private String assetName;
		private String internalRefNo;
		private Date requestedDisbursementDate;
		private Integer constructionYear;
		private DisbursementParty disbursementParty;
		private BigDecimal netPrice;
		private Boolean paymentProofAvailable;
		private File paymentProofDocument;
		private Boolean vatIncludedInDisbursment;
		private Boolean vrdAvailable;
		private String commentsToGEFA;
		private String assetComments;
		private Integer financeDurationInMonths;
		private Date deRegistrationDate;
		private String initiatingUser;
		private Long vendorId;
		private Disbursement disbursement;
		private BigDecimal cumulatedInterest;
		private BigDecimal currentValue;
		private BigDecimal fixedInterest;
		private Date subsidyStartDate;
		private Date subsidyEndDate;
		private List<Attachment> attachments;
		private AssetState assetState;

		private DealerRepository dealerRepository;
		private ManufacturerRepository manufacturerRepository;
		private BusinessTypeRepository businessTypeRepository;

		public Builder(DealerRepository dealerRepository, ManufacturerRepository manufacturerRepository,
				BusinessTypeRepository businessTypeRepository) {
			this.dealerRepository = dealerRepository;
			this.businessTypeRepository = businessTypeRepository;
			this.manufacturerRepository = manufacturerRepository;

		}

		public Builder(Asset asset, DealerRepository dealerRepository, ManufacturerRepository manufacturerRepository,
				BusinessTypeRepository businessTypeRepository) {
			this.id = asset.getId();
			this.serialNumber = asset.getSerialNumber();
			this.dealer = asset.getDealer();
			this.manufacturer = asset.getManufacturer();
			this.businessType = asset.getBusinessType();
			this.invoice = asset.getInvoice();
			this.vrd = asset.getVrd();
			this.objCatalogId = asset.getObjCatalogId();
			this.assetName = asset.getAssetName();
			this.internalRefNo = asset.getInternalRefNo();
			this.requestedDisbursementDate = asset.getRequestedDisbursementDate();
			this.constructionYear = asset.getConstructionYear();
			this.disbursementParty = asset.getDisbursementParty();
			this.netPrice = asset.getNetPrice();
			this.paymentProofAvailable = asset.getPaymentProofAvailable();
			this.paymentProofDocument = asset.getPaymentProofDocument();
			this.vatIncludedInDisbursment = asset.getVatIncludedInDisbursment();
			this.vrdAvailable = asset.getVrdAvailable();
			this.commentsToGEFA = asset.getCommentsToGEFA();
			this.assetComments = asset.getAssetComments();
			this.financeDurationInMonths = asset.getFinanceDurationInMonths();
			this.deRegistrationDate = asset.getDeRegistrationDate();
			this.initiatingUser = asset.getInitiatingUser();
			this.vendorId = asset.getVendorId();
			this.disbursement = asset.getDisbursement();
			this.cumulatedInterest = asset.getCumulatedInterest();
			this.currentValue = asset.currentValue;
			this.fixedInterest = asset.fixedInterest;
			this.subsidyStartDate = asset.getSubsidyStartDate();
			this.subsidyEndDate = asset.getSubsidyEndDate();
			this.attachments = asset.getAttachments();
			this.assetState = asset.getAssetState();
			this.dealerRepository = dealerRepository;
			this.businessTypeRepository = businessTypeRepository;
			this.manufacturerRepository = manufacturerRepository;

		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder serialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
			return this;
		}

		public Builder gevisNumber(Long gevisNumber) {
			this.dealer = dealerRepository.getDealer(gevisNumber);
			return this;
		}

		public Builder manufacturer(String manufacturerTitle) {
			this.manufacturer = manufacturerRepository.getManufacturer(manufacturerTitle);
			return this;
		}

		public Builder businessType(String businessType) {
			this.businessType = businessTypeRepository.getBusinessType(businessType);
			return this;
		}

		public Builder invoice(String invoiceNumber, Date invoiceDate, File invoiceDocument) {
			this.invoice = createInvoice(invoiceNumber, invoiceDate, invoiceDocument);
			return this;
		}

		public Builder vrd(String registrationNumber, String registeredTo, File vehicleRegistrationDocument) {
			this.vrd = createVRD(registrationNumber, registeredTo, vehicleRegistrationDocument);
			return this;
		}

		public Builder objCatalogId(String objCatalogId) {
			this.objCatalogId = objCatalogId;
			return this;
		}

		public Builder assetName(String assetName) {
			this.assetName = assetName;
			return this;
		}

		public Builder internalRefNo(String internalRefNo) {
			this.internalRefNo = internalRefNo;
			return this;
		}

		public Builder requestedDisbursementDate(Date requestedDisbursementDate) {
			this.requestedDisbursementDate = requestedDisbursementDate;
			return this;
		}

		public Builder constructionYear(Integer constructionYear) {
			this.constructionYear = constructionYear;
			return this;
		}

		public Builder disbursementParty(String disbursementParty) {
			switch (disbursementParty) {
			case "invoicing-party":
				this.disbursementParty = DisbursementParty.INVOICING_PARTY;
				break;
			default:
				this.disbursementParty = DisbursementParty.DEALER;
				break;
			}
			return this;
		}

		public Builder netPrice(BigDecimal netPrice) {
			this.netPrice = netPrice;
			return this;
		}

		public Builder paymentProofAvailable(Boolean paymentProofAvailable) {
			this.paymentProofAvailable = paymentProofAvailable;
			return this;
		}

		public Builder paymentProofDocument(File paymentProofDocument) {
			this.paymentProofDocument = paymentProofDocument;
			return this;
		}

		public Builder vatIncludedInDisbursment(Boolean vatIncludedInDisbursment) {
			this.vatIncludedInDisbursment = vatIncludedInDisbursment;
			return this;
		}

		public Builder vrdAvailable(Boolean vrdAvailable) {
			this.vrdAvailable = vrdAvailable;
			return this;
		}

		public Builder commentsToGEFA(String commentsToGEFA) {
			this.commentsToGEFA = commentsToGEFA;
			return this;
		}

		public Builder assetComments(String assetComments) {
			this.assetComments = assetComments;
			return this;
		}

		public Builder financeDurationInMonths(Integer financeDurationInMonths) {
			this.financeDurationInMonths = financeDurationInMonths;
			return this;
		}

		public Builder deRegistrationDate(Date deRegistrationDate) {
			this.deRegistrationDate = deRegistrationDate;
			return this;
		}

		public Builder initiatingUser(String initiatingUser) {
			this.initiatingUser = initiatingUser;
			return this;
		}

		public Builder vendorId(Long vendorId) {
			this.vendorId = vendorId;
			return this;
		}

		public Builder disbursement(BigDecimal disbursementAmount, Date disbursementDate) {
			this.disbursement = createDisbursement(disbursementAmount, disbursementDate);
			return this;
		}

		public Builder cumulatedInterest(BigDecimal cumulatedInterest) {
			this.cumulatedInterest = cumulatedInterest;
			return this;
		}

		public Builder currentValue(BigDecimal currentValue) {
			this.currentValue = currentValue;
			return this;
		}

		public Builder fixedInterest(BigDecimal fixedInterest) {
			this.fixedInterest = fixedInterest;
			return this;
		}

		public Builder subsidyStartDate(Date subsidyStartDate) {
			this.subsidyStartDate = subsidyStartDate;
			return this;
		}

		public Builder subsidyEndDate(Date subsidyEndDate) {
			this.subsidyEndDate = subsidyEndDate;
			return this;
		}

		public Builder assetState(AssetState assetState) {
			this.assetState = assetState;
			return this;
		}

		public Builder attachment(byte[] data, String contentType, String comments) {
			this.attachments.add(new Attachment(data, contentType, comments));
			return this;
		}

		private Invoice createInvoice(String invoiceNumber, Date invoiceDate, File invoiceDocument) {
			return new Invoice(invoiceNumber, invoiceDate, invoiceDocument);
		}

		private VRD createVRD(String registrationNumber, String registeredTo, File vehicleRegistrationDocument) {
			return new VRD(registrationNumber, registeredTo, vehicleRegistrationDocument);
		}

		private Disbursement createDisbursement(BigDecimal disbursementAmount, Date disbursementDate) {
			return new Disbursement(disbursementAmount, disbursementDate);
		}

		public Asset build() {
			return new Asset(this);
		}
	}

}
