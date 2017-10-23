package com.gefa.ekf.boundary.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.gefa.ekf.boundary.rest.activities.ApproveAssetActivity;
import com.gefa.ekf.boundary.rest.representations.ApprovalRepresentation;

public class ApprovalResourceImpl implements ApprovalResource {

	/*
	 * private ApproveAssetActivity approveAssetActivity = new
	 * ApproveAssetActivity();
	 */
	@Inject
	private ApproveAssetActivity approveAssetActivity;

	@Context
	UriInfo uriInfo;

	public Response approve(Long assetId) {
		ApprovalRepresentation responseRepresentation = approveAssetActivity.approveAsset(assetId, uriInfo);
		ResponseBuilder builder = Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
				.entity(responseRepresentation);

		return builder.build();
	}

}
