package com.gefa.ekf.boundary.fit.inbound;

import com.gefa.ekf.application.AssetService;
import com.gefa.ekf.boundary.fit.domain.FITAssetEvent;
import com.gefa.ekf.domain.Asset;
import com.gefa.ekf.domain.Asset.Builder;
import com.gefa.ekf.domain.repositories.AssetRepository;
import com.gefa.ekf.domain.repositories.TestBusinessTypeRepository;
import com.gefa.ekf.domain.repositories.TestDealerRepository;
import com.gefa.ekf.domain.repositories.TestManufacturerRepository;

public class ProcessFITAssetEventActivity {

	private AssetService assetService;

	private AssetRepository assetRepository;

	public void create(FITAssetEvent fitAssetEvent) {

		if (assetRepository.exists(fitAssetEvent.getAssetNumber())) {
			Asset asset = assetRepository.getAsset(fitAssetEvent.getAssetNumber());
			assetService.update(asset);
		} else {
			assetService.create(createAssetFromEvent(fitAssetEvent));
		}
	}

	private Asset createAssetFromEvent(FITAssetEvent fitAssetEvent) {
		Builder assetBuilder = new Asset.Builder(new TestDealerRepository(), new TestManufacturerRepository(),
				new TestBusinessTypeRepository());
		return assetBuilder.build();
	}

	private Asset updateAssetFromEvent(Asset asset, FITAssetEvent fitAssetEvent) {
		return asset;
	}
}
