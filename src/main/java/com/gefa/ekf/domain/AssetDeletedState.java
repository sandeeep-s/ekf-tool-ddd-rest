package com.gefa.ekf.domain;

public class AssetDeletedState extends AssetState {

	private Asset asset;

	public AssetDeletedState(Asset asset) {
		this.asset = asset;
	}

	@Override
	public void moveToDeletedState() {
		throw new UnsupportedOperationException();
	}

}
