package com.gefa.ekf.boundary.rest.resources;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/approve")
public interface ApprovalResource {

	@PUT
	@Path("/{assetId}")
	Response approve(@PathParam("assetId") Long assetId);

}
