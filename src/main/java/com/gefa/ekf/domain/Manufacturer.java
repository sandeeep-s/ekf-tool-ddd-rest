package com.gefa.ekf.domain;

public class Manufacturer {

	private String title;

	private Long resourceId;

	public Manufacturer(String title, Long resourceId) {
		this.title = title;
		this.resourceId = resourceId;
	}

	public String getTitle() {
		return title;
	}

	public Long getResourceId() {
		return resourceId;
	}

}
