package com.gefa.ekf.client.activities;

import com.gefa.ekf.boundary.rest.representations.ApprovalRepresentation;
import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;

public class RepresentationHypermediaProcessor {

	Actions extractNextActionsFromAssetRepresentation(AssetRepresentation assetRepresentation) {

		Actions actions = new Actions();

		if (null != assetRepresentation) {
			if (null != assetRepresentation.getSelfLink()) {
				actions.add(new ClientReadAssetActivity(assetRepresentation.getSelfLink().getUri()));
			}

			if (null != assetRepresentation.getUpdateLink()) {
				actions.add(new ClientUpdateAssetActivity(assetRepresentation.getUpdateLink().getUri()));
			}

			if (null != assetRepresentation.getRemoveLink()) {
				actions.add(new ClientRemoveAssetActivity(assetRepresentation.getRemoveLink().getUri()));
			}
			if (null != assetRepresentation.getApproveLink()) {
				actions.add(new ClientApproveAssetActivity(assetRepresentation.getApproveLink().getUri()));
			}
		}

		return actions;

	}

	Actions extractNextActionsFromApprovalRepresentation(ApprovalRepresentation approvalRepresentation) {
		Actions actions = new Actions();
		if (null != approvalRepresentation) {
			if (null != approvalRepresentation.getAssetLink()) {
				actions.add(new ClientReadAssetActivity(approvalRepresentation.getAssetLink().getUri()));
			}
		}
		return actions;

	}

}
