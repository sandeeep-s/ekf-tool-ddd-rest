package com.gefa.ekf.domain;

public class AssetSubmittedState extends AssetState {

	private Asset asset;

	public AssetSubmittedState(Asset asset) {
		this.asset = asset;
	}

	@Override
	public void moveToApprovedState() {
		asset.setAssetState(asset.getAssetApprovedState());
	}

}
