package com.gefa.ekf.client.network;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gefa.ekf.boundary.rest.representations.ApprovalRepresentation;
import com.gefa.ekf.boundary.rest.representations.AssetRepresentation;
import com.gefa.ekf.client.exceptions.CannotApproveException;
import com.gefa.ekf.client.exceptions.CannotCancelException;
import com.gefa.ekf.client.exceptions.CannotUpdateAssetException;
import com.gefa.ekf.client.exceptions.MalformedAssetException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.idm.AccessTokenDecoration;

public class HttpBinding {

	public AssetRepresentation createAsset(AssetRepresentation assetRepresentation, URI assetURI)
			throws MalformedAssetException, ServiceFailureException {

		Client client = ClientBuilder.newClient();
		AccessTokenDecoration.bindClient(client);
		WebTarget target = client.target(assetURI);

		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(assetRepresentation, MediaType.APPLICATION_JSON));

		int status = response.getStatus();

		if (status == 400) {
			throw new MalformedAssetException();
		} else if (status == 500) {
			throw new ServiceFailureException();
		} else if (status == 201) {
			return response.readEntity(AssetRepresentation.class);
		}

		throw new RuntimeException(String.format("Unexpected response [%d] while creating asset resource [%s]", status,
				assetURI.toString()));

	}

	public AssetRepresentation retrieveAsset(URI assetURI) throws NotFoundException, ServiceFailureException {

		Client client = ClientBuilder.newClient();
		AccessTokenDecoration.bindClient(client);
		WebTarget target = client.target(assetURI);

		Response response = target.request(MediaType.APPLICATION_JSON).get();

		int status = response.getStatus();

		if (status == 404) {
			throw new NotFoundException();
		} else if (status == 500) {
			throw new ServiceFailureException();
		} else if (status == 200) {
			return response.readEntity(AssetRepresentation.class);
		}

		throw new RuntimeException(String.format("Unexpected response [%d] while retrieveing asset resource [%s]",
				status, assetURI.toString()));
	}

	public AssetRepresentation updateAsset(AssetRepresentation assetRepresentation, URI assetURI)
			throws MalformedAssetException, NotFoundException, CannotUpdateAssetException, ServiceFailureException {

		Client client = ClientBuilder.newClient();
		AccessTokenDecoration.bindClient(client);
		WebTarget target = client.target(assetURI);

		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(assetRepresentation, MediaType.APPLICATION_JSON));

		int status = response.getStatus();

		if (400 == status) {
			throw new MalformedAssetException();
		} else if (404 == status) {
			throw new NotFoundException();
		} else if (409 == status) {
			throw new CannotUpdateAssetException();
		} else if (500 == status) {
			throw new ServiceFailureException();
		} else if (200 == status) {
			return response.readEntity(AssetRepresentation.class);
		}

		throw new RuntimeException(String.format("Unexpected response [%d] while updating asset resource [%s]", status,
				assetURI.toString()));
	}

	public AssetRepresentation removeAsset(URI assetURI)
			throws NotFoundException, ServiceFailureException, CannotCancelException {

		Client client = ClientBuilder.newClient();
		AccessTokenDecoration.bindClient(client);
		WebTarget target = client.target(assetURI);

		Response response = target.request(MediaType.APPLICATION_JSON).delete();

		int status = response.getStatus();

		if (status == 404) {
			throw new NotFoundException();
		} else if (status == 405) {
			throw new CannotCancelException();
		} else if (status == 500) {
			throw new ServiceFailureException();
		} else if (status == 200) {
			return response.readEntity(AssetRepresentation.class);
		}

		throw new RuntimeException(String.format("Unexpected response [%d] while removing asset resource [%s]", status,
				assetURI.toString()));
	}

	public ApprovalRepresentation approveAsset(ApprovalRepresentation approvalRepresentation, URI approveAssetURI)
			throws NotFoundException, ServiceFailureException, CannotApproveException {
		Client client = ClientBuilder.newClient();
		AccessTokenDecoration.bindClient(client);
		WebTarget target = client.target(approveAssetURI);

		Response response = target.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(approvalRepresentation, MediaType.APPLICATION_JSON));

		int status = response.getStatus();

		if (status == 404) {
			throw new NotFoundException();
		} else if (status == 405) {
			throw new CannotApproveException();
		} else if (status == 500) {
			throw new ServiceFailureException();
		} else if (status == 200) {
			return response.readEntity(ApprovalRepresentation.class);
		}

		throw new RuntimeException(String.format("Unexpected response [%d] while approving asset resource [%s]", status,
				approveAssetURI.toString()));

	}

}
