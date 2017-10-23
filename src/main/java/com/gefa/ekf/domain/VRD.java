package com.gefa.ekf.domain;

import java.io.File;

public class VRD {

	private String registrationNumber;

	private String registeredTo;

	private File registrationDocument;

	public VRD(String registrationNumber, String registeredTo, File vehicleRegistrationDocument) {
		this.registrationNumber = registrationNumber;
		this.registeredTo = registeredTo;
		this.registrationDocument = vehicleRegistrationDocument;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getRegisteredTo() {
		return registeredTo;
	}

	public File getRegistrationDocument() {
		return registrationDocument;
	}

}
