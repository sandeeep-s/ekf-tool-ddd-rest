package com.gefa.ekf.boundary.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gefa.ekf.boundary.rest.representations.ApprovalRepresentation;
import com.gefa.ekf.boundary.rest.representations.Link;
import com.gefa.ekf.domain.Asset;
import com.gefa.ekf.domain.repositories.MapAssetRepository;

@ApplicationScoped
public class ApproveAssetActivity {

	@Inject
	private MapAssetRepository assetRepository;

	public ApprovalRepresentation approveAsset(Long assetId, UriInfo uriInfo) {
		Asset asset = assetRepository.find(assetId);
///		asset.setAssetStatus(new AssetStatus(AssetStatus.StatusCode.APPROVED));
		String assetURI = uriInfo.getBaseUri() + "asset/" + assetId;
		Link assetlink = new Link("asset", assetURI, MediaType.APPLICATION_XML);

		return new ApprovalRepresentation(assetlink);
	}

}
