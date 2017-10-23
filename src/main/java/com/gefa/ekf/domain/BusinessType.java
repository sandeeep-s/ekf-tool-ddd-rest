package com.gefa.ekf.domain;

public class BusinessType {

	private String title;

	private String englishTitle;

	private Long resourceId;

	public BusinessType(String title, String englishTitle, Long resourceId) {

		this.title = title;
		this.englishTitle = englishTitle;
		this.resourceId = resourceId;

	}

	public String getTitle() {
		return title;
	}

	public String getEnglishTitle() {
		return englishTitle;
	}

	public Long getResourceId() {
		return resourceId;
	}

}
