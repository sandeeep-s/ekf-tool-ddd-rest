package com.gefa.ekf.domain;

public class VRDRequest {

	private Asset asset;
	private String reason;
	private VRDRequestDetail vrdRequestDetail;

	public VRDRequest(Asset asset, String reason, VRDRequestDetail vrdRequestDetail) {
		this.asset = asset;
		this.reason = reason;
		this.vrdRequestDetail = vrdRequestDetail;
	}

	public Asset getAsset() {
		return asset;
	}

	public String getReason() {
		return reason;
	}

	public VRDRequestDetail getVrdRequestDetail() {
		return vrdRequestDetail;
	}

}
