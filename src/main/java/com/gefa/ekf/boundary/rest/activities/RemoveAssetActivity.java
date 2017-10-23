package com.gefa.ekf.boundary.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.ekf.application.AssetService;
import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.domain.Asset;
import com.gefa.ekf.exceptions.AssetRemovalException;

@ApplicationScoped
public class RemoveAssetActivity {

	@Inject
	private AssetService assetService;

	public AssetRepresentation delete(Long assetId) throws AssetRemovalException {

		Asset asset = assetService.removeAsset(assetId);
		

		return new AssetRepresentation(asset);
	}

}
