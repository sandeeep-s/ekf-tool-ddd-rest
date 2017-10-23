package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.client.domain.ClientAsset;
import com.gefa.ekf.client.exceptions.CannotUpdateAssetException;
import com.gefa.ekf.client.exceptions.MalformedAssetException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;

public class ClientUpdateAssetActivity extends Activity {

	private final URI assetURI;

	private ClientAsset asset;

	public ClientUpdateAssetActivity(URI assetURI) {
		this.assetURI = assetURI;
	}

	public void updateAsset(ClientAsset asset) {
		try {
			AssetRepresentation assetRepresentation = httpBinding.updateAsset(asset.getAssetRepresentation(), assetURI);
			this.asset = new ClientAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);
		} catch (MalformedAssetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotUpdateAssetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ClientAsset getAsset() {
		return asset;
	}

}
