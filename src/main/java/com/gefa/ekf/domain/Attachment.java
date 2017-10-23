package com.gefa.ekf.domain;

public class Attachment {

	private byte[] data;
	private String contentType;
	private String comments;

	public Attachment(byte[] data, String contentType, String comments) {
		this.data = data;
		this.contentType = contentType;
		this.comments = comments;
	}

	public byte[] getData() {
		return data;
	}

	public String getContentType() {
		return contentType;
	}

	public String getComments() {
		return comments;
	}

}
