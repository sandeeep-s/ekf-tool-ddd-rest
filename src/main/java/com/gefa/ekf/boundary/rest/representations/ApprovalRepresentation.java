package com.gefa.ekf.boundary.rest.representations;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ApprovalRepresentation extends Representation {

	public ApprovalRepresentation() {

	}

	public ApprovalRepresentation(Link... links) {
		this.links = Arrays.asList(links);
	}

	@JsonIgnore
	public Link getAssetLink() {
		return getLinkByName("asset");
	}

}
