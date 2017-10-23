package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.client.domain.ClientAsset;
import com.gefa.ekf.client.exceptions.CannotCancelException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.domain.Asset;

public class ClientRemoveAssetActivity extends Activity {

	private final URI assetURI;

	private ClientAsset asset;

	public ClientRemoveAssetActivity(URI assetURI) {
		this.assetURI = assetURI;
	}

	public void removeAsset(ClientAsset asset) {
		try {
			AssetRepresentation assetRepresentation = httpBinding.removeAsset(assetURI);
			this.asset = new ClientAsset(assetRepresentation);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCancelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ClientAsset getAsset() {
		return asset;
	}
	
}
