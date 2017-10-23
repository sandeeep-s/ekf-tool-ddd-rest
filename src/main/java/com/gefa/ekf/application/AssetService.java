package com.gefa.ekf.application;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.ekf.domain.Asset;
import com.gefa.ekf.domain.Payment;
import com.gefa.ekf.domain.events.AssetCreatedEvent;
import com.gefa.ekf.domain.events.DomainEvent;
import com.gefa.ekf.domain.repositories.MapAssetRepository;
import com.gefa.ekf.exceptions.AssetRemovalException;
import com.gefa.ekf.infrastructure.DomainEventsDispatcher;

@ApplicationScoped
public class AssetService {

	@Inject
	private MapAssetRepository assetRepository;
	// private AssetRepository assetRepository;

	@Inject
	private DomainEventsDispatcher domainEventsDispatcher;

	public Long create(Asset asset) {
		asset.setAssetState(asset.getAssetCreatedState());
		asset.addDomainEvent(new AssetCreatedEvent(asset));
		for (DomainEvent domainEvent : asset.getDomainEvents()) {
			domainEventsDispatcher.dispatch(domainEvent);
		}
		return assetRepository.saveAsset(asset);
	}

	public void update(Asset asset) {
		Asset assetFromRepo = assetRepository.getAsset(asset.getId());
		assetFromRepo.moveToCreatedState();
		
		//  TODO Update the assetFromRepo details onto asset 
		assetRepository.updateAsset(asset);
	}

	public void updatePaymentPlan(Long assetNumber, List<Payment> payments) {
		Asset asset = assetRepository.getAsset(assetNumber);
		asset.addPaymentPlan(payments);
		assetRepository.updateAsset(asset);
	}

	public void updatePayments(Long assetNumber, List<Payment> payments) {
		Asset asset = assetRepository.getAsset(assetNumber);
		asset.addPayments(payments);
		assetRepository.updateAsset(asset);
	}

	public List<Asset> getAssetsForDealer(Long gevisNumber) {
		return assetRepository.getAssetsByDealer(gevisNumber);
	}

	public Asset getAsset(Long assetId) {
		return assetRepository.getAsset(assetId);
	}

	public Asset removeAsset(Long assetId) {
		try {
			Asset asset = assetRepository.getAsset(assetId);
			asset.moveToDeletedState();
			return assetRepository.delete(assetId);
		} catch (UnsupportedOperationException e) {
			throw new AssetRemovalException();
		}

	}

	public void submit(Asset asset){
		
	}
	
	public void approve(Asset asset){
		
	}

	public void archive(Asset asset){
		
	}

}
