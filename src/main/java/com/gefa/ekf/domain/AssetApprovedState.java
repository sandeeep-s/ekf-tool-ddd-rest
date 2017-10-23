package com.gefa.ekf.domain;

public class AssetApprovedState extends AssetState {

	private Asset asset;

	public AssetApprovedState(Asset asset) {
		this.asset = asset;
	}

	public void moveToArchivedState() {
		asset.setAssetState(asset.getAssetArchivedState());
	}

}
