package com.gefa.ekf.domain;

public class Transformation {

	private Asset asset;
	private BusinessType to;
	private Boolean requestedVRD;
	private VRDRequestDetail vrdRequestDetail;
	private BankAccount bankAccount;

	public Transformation(Asset asset, BusinessType to, Boolean requestedVRD, VRDRequestDetail vrdRequestDetail,
			BankAccount bankAccount) {
		this.asset = asset;
		this.to = to;
		this.requestedVRD = requestedVRD;
		this.vrdRequestDetail = vrdRequestDetail;
		this.bankAccount = bankAccount;
	}

	public Asset getAsset() {
		return asset;
	}

	public BusinessType getTo() {
		return to;
	}

	public Boolean getRequestedVRD() {
		return requestedVRD;
	}

	public VRDRequestDetail getVrdRequestDetail() {
		return vrdRequestDetail;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

}
