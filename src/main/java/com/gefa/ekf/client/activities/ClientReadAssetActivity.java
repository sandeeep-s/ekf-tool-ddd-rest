package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.client.domain.ClientAsset;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.domain.Asset;

public class ClientReadAssetActivity extends Activity {

	private final URI assetURI;
	private ClientAsset asset;

	public ClientReadAssetActivity(URI assetURI) {
		this.assetURI = assetURI;
	}

	public void readAsset() throws NotFoundException, ServiceFailureException {
			AssetRepresentation assetRepresentation = httpBinding.retrieveAsset(assetURI);
			this.asset = new ClientAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);
	}
	
	public ClientAsset getAsset() {
		return asset;
	}
}
