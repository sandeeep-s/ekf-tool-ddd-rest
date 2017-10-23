package com.gefa.ekf.domain;

public class VRDRequestDetail {
	private String receivingParty;
	private Address address;
	private DeliveryOption deliveryOption;

	public VRDRequestDetail(String receivingParty, Address address, DeliveryOption deliveryOption) {
		this.receivingParty = receivingParty;
		this.address = address;
		this.deliveryOption = deliveryOption;
	}

	public String getReceivingParty() {
		return receivingParty;
	}

	public Address getAddress() {
		return address;
	}

	public DeliveryOption getDeliveryOption() {
		return deliveryOption;
	}

}
