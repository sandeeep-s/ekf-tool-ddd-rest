package com.gefa.ekf.domain;

public class Address {

	private String name;
	private String streetAndNumber;
	private String postalCode;
	private String city;
	private String country;

	public Address(String name, String streetAndNumber, String postalCode, String city, String country) {
		this.name = name;
		this.streetAndNumber = streetAndNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

}
