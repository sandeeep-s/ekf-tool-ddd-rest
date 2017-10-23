package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.boundary.rest.representations.ApprovalRepresentation;
import com.gefa.ekf.client.domain.ClientAsset;
import com.gefa.ekf.client.exceptions.CannotApproveException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.domain.Asset;

public class ClientApproveAssetActivity extends Activity {

	private final URI assetApproveURI;

	public ClientApproveAssetActivity(URI assetApproveURI) {
		this.assetApproveURI = assetApproveURI;
	}

	public void approveAsset(ClientAsset asset) throws NotFoundException, ServiceFailureException, CannotApproveException {
			ApprovalRepresentation approvalRepresentation = httpBinding.approveAsset(new ApprovalRepresentation(),
					assetApproveURI);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromApprovalRepresentation(approvalRepresentation);
	}

}
