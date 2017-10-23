package com.gefa.ekf.boundary.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gefa.ekf.application.AssetService;
import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.boundary.rest.representations.Link;
import com.gefa.ekf.boundary.rest.representations.converters.AssetConverter;
import com.gefa.ekf.domain.Asset;
import com.gefa.ekf.domain.Asset.Builder;
import com.gefa.ekf.domain.repositories.TestBusinessTypeRepository;
import com.gefa.ekf.domain.repositories.TestDealerRepository;
import com.gefa.ekf.domain.repositories.TestManufacturerRepository;

@ApplicationScoped
public class UpdateAssetActivity {


	@Inject
	private AssetService assetService;

	@Inject
	private AssetConverter assetConverter;


	public AssetRepresentation update(Long id, AssetRepresentation assetRepresentation, UriInfo uriInfo) {
		Asset asset = assetConverter.toAsset(assetRepresentation, id);
		
		assetService.update(asset);

		String assetURI = uriInfo.getRequestUri().toString();
		Link assetSelflink = new Link("self", assetURI, MediaType.APPLICATION_XML);
		Link assetUpdatelink = new Link("update", assetURI, MediaType.APPLICATION_XML);
		Link assetDeletelink = new Link("remove", assetURI, MediaType.APPLICATION_XML);

		return new AssetRepresentation(asset, assetSelflink, assetUpdatelink, assetDeletelink);
	}

	private Asset getAsset(AssetRepresentation assetRepresentation) {
		Builder assetBuilder = new Asset.Builder(new TestDealerRepository(), new TestManufacturerRepository(),
				new TestBusinessTypeRepository());
		assetBuilder.gevisNumber(101010L);
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

}
