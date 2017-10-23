package com.gefa.ekf.domain;

public class AssetCreatedState extends AssetState {

	private Asset asset;

	public AssetCreatedState(Asset asset) {
		this.asset = asset;
	}

	@Override
	public void moveToDeletedState() {
		asset.setAssetState(asset.getAssetDeletedState());
	}

	@Override
	public void moveToSubmittedState() {
		asset.setAssetState(asset.getAssetSubmittedState());
	}

}
