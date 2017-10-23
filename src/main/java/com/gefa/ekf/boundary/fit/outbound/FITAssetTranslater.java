package com.gefa.ekf.boundary.fit.outbound;

import com.gefa.ekf.boundary.fit.domain.FITAsset;
import com.gefa.ekf.domain.Asset;
import com.gefa.ekf.domain.events.AssetCreatedEvent;

public class FITAssetTranslater {

	public FITAsset toFITAsset(AssetCreatedEvent assetCreatedEvent) {
		return new FITAsset();
	}

	public Asset fromFITAsset(FITAsset fitAsset) {
		return null;
	}

}
