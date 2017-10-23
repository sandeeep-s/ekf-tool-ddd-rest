package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.client.domain.ClientAsset;
import com.gefa.ekf.client.exceptions.MalformedAssetException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;

public class ClientCreateAssetActivity extends Activity {

	private ClientAsset asset;

	public void createAsset(ClientAsset asset, URI assetURI) {

		try {
			AssetRepresentation assetRepresentation = httpBinding.createAsset(asset.getAssetRepresentation(), assetURI);
			this.asset = new ClientAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);

		} catch (MalformedAssetException e) {
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			e.printStackTrace();
		}

	}

	public ClientAsset getAsset() {
		return asset;
	}

}
