package com.gefa.ekf.domain;

public class Payoff {

	private Asset asset;
	private String reasonForPayoff;
	private Boolean requestedVRD;
	private VRDRequestDetail vrdRequestDetail;
	private BankAccount bankAccount;

	public Payoff(Asset asset, String reasonForPayoff, Boolean requestedVRD, VRDRequestDetail vrdRequestDetail,
			BankAccount bankAccount) {
		this.asset = asset;
		this.reasonForPayoff = reasonForPayoff;
		this.requestedVRD = requestedVRD;
		this.vrdRequestDetail = vrdRequestDetail;
		this.bankAccount = bankAccount;
	}

	public Asset getAsset() {
		return asset;
	}

	public String getReasonForPayoff() {
		return reasonForPayoff;
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
