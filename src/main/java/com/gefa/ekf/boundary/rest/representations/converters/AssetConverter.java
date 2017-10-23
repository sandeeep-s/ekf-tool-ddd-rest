package com.gefa.ekf.boundary.rest.representations.converters;

import javax.enterprise.context.ApplicationScoped;

import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.boundary.rest.representations.Link;
import com.gefa.ekf.domain.Asset;
import com.gefa.ekf.domain.Asset.Builder;
import com.gefa.ekf.domain.repositories.TestBusinessTypeRepository;
import com.gefa.ekf.domain.repositories.TestDealerRepository;
import com.gefa.ekf.domain.repositories.TestManufacturerRepository;

@ApplicationScoped
public class AssetConverter {

	public Asset toAsset(AssetRepresentation assetRepresentation) {
		Builder assetBuilder = new Asset.Builder(new TestDealerRepository(), new TestManufacturerRepository(),
				new TestBusinessTypeRepository());
		assetBuilder.gevisNumber(assetRepresentation.getGevisNumber());
		assetBuilder.businessType(assetRepresentation.getBusinessType());
		assetBuilder.serialNumber(assetRepresentation.getSerialNumber());
		assetBuilder.manufacturer(assetRepresentation.getManufacturerTitle());
		assetBuilder.assetName(assetRepresentation.getAssetName());
		assetBuilder.requestedDisbursementDate(assetRepresentation.getRequestedDisbursementDate());
		assetBuilder.internalRefNo(assetRepresentation.getInternalRefNo());
		assetBuilder.constructionYear(assetRepresentation.getConstructionYear());
		assetBuilder.disbursementParty(assetRepresentation.getDisbursementParty());
		assetBuilder.vatIncludedInDisbursment(assetRepresentation.getVatIncludedInDisbursment());
		assetBuilder.paymentProofAvailable(assetRepresentation.getPaymentProofAvailable());
		assetBuilder.paymentProofDocument(assetRepresentation.getPaymentProofDocument());
		assetBuilder.invoice(assetRepresentation.getInvoiceNumber(), assetRepresentation.getInvoiceDate(),
				assetRepresentation.getInvoiceDocument());
		assetBuilder.vrdAvailable(assetRepresentation.getVrdAvailable());
		assetBuilder.vrd(assetRepresentation.getRegistrationNumber(), assetRepresentation.getRegisteredTo(),
				assetRepresentation.getVehicleRegistrationDocument());
		assetBuilder.netPrice(assetRepresentation.getNetPrice());
		assetBuilder.commentsToGEFA(assetRepresentation.getCommentsToGEFA());
		assetBuilder.assetComments(assetRepresentation.getAssetComments());

		return assetBuilder.build();

	}

	public Asset toAsset(AssetRepresentation assetRepresentation, Long assetId) {
		Builder assetBuilder = new Asset.Builder(new TestDealerRepository(), new TestManufacturerRepository(),
				new TestBusinessTypeRepository());
		assetBuilder.id(assetId);
		assetBuilder.gevisNumber(assetRepresentation.getGevisNumber());
		assetBuilder.businessType(assetRepresentation.getBusinessType());
		assetBuilder.serialNumber(assetRepresentation.getSerialNumber());
		assetBuilder.manufacturer(assetRepresentation.getManufacturerTitle());
		assetBuilder.assetName(assetRepresentation.getAssetName());
		assetBuilder.requestedDisbursementDate(assetRepresentation.getRequestedDisbursementDate());
		assetBuilder.internalRefNo(assetRepresentation.getInternalRefNo());
		assetBuilder.constructionYear(assetRepresentation.getConstructionYear());
		assetBuilder.disbursementParty(assetRepresentation.getDisbursementParty());
		assetBuilder.vatIncludedInDisbursment(assetRepresentation.getVatIncludedInDisbursment());
		assetBuilder.paymentProofAvailable(assetRepresentation.getPaymentProofAvailable());
		assetBuilder.paymentProofDocument(assetRepresentation.getPaymentProofDocument());
		assetBuilder.invoice(assetRepresentation.getInvoiceNumber(), assetRepresentation.getInvoiceDate(),
				assetRepresentation.getInvoiceDocument());
		assetBuilder.vrdAvailable(assetRepresentation.getVrdAvailable());
		assetBuilder.vrd(assetRepresentation.getRegistrationNumber(), assetRepresentation.getRegisteredTo(),
				assetRepresentation.getVehicleRegistrationDocument());
		assetBuilder.netPrice(assetRepresentation.getNetPrice());
		assetBuilder.commentsToGEFA(assetRepresentation.getCommentsToGEFA());
		assetBuilder.assetComments(assetRepresentation.getAssetComments());

		return assetBuilder.build();

	}

	public AssetRepresentation fromAsset(Asset asset, Link... links) {
		return new AssetRepresentation(asset, links);
	}

}
