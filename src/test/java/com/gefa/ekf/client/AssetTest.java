package com.gefa.ekf.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;

import com.gefa.ekf.client.activities.Actions;
import com.gefa.ekf.client.activities.ClientApproveAssetActivity;
import com.gefa.ekf.client.activities.ClientCreateAssetActivity;
import com.gefa.ekf.client.activities.ClientReadAssetActivity;
import com.gefa.ekf.client.activities.ClientRemoveAssetActivity;
import com.gefa.ekf.client.activities.ClientUpdateAssetActivity;
import com.gefa.ekf.client.domain.ClientAsset;
import com.gefa.ekf.client.exceptions.CannotApproveException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.domain.TestClientAssetFactory;

public class AssetTest {

	/*
	 * @BeforeClass public static void init() throws Exception {
	 * MyServer.startContainer(); }
	 * 
	 * @AfterClass public static void stop() throws Exception {
	 * MyServer.stopContainer();
	 * 
	 * }
	 * 
	 * private String getEntryPointURI() { return
	 * TestPortProvider.generateURL("/ekf-tool-rest-easy/asset"); }
	 */

	private String getEntryPointURI() {
		return "http://localhost:8080/ekf-tool-ddd-rest/asset";
	}

	@Test
	public void testCreateAsset() throws URISyntaxException, NotFoundException, ServiceFailureException {
		ClientCreateAssetActivity clientCreateAssetActivity = new ClientCreateAssetActivity();

		TestClientAssetFactory testClientAssetFactory = new TestClientAssetFactory();
		ClientAsset asset = testClientAssetFactory.createAsset();

		clientCreateAssetActivity.createAsset(asset, new URI(getEntryPointURI()));

		ClientAsset createdAsset = null;
		Actions actions = clientCreateAssetActivity.getActions();

		if (actions.has(ClientReadAssetActivity.class)) {
			ClientReadAssetActivity clientReadAssetActivity = actions.get(ClientReadAssetActivity.class);
			clientReadAssetActivity.readAsset();
			createdAsset = clientReadAssetActivity.getAsset();
			actions = clientReadAssetActivity.getActions();
		}
		assertEquals(asset.getAssetName(), createdAsset.getAssetName());

	}

	@Test
	public void testUpdateAsset() throws URISyntaxException, NotFoundException, ServiceFailureException {
		ClientCreateAssetActivity clientCreateAssetActivity = new ClientCreateAssetActivity();

		TestClientAssetFactory testClientAssetFactory = new TestClientAssetFactory();
		ClientAsset asset = testClientAssetFactory.createAsset();

		clientCreateAssetActivity.createAsset(asset, new URI(getEntryPointURI()));

		ClientAsset createdAsset = clientCreateAssetActivity.getAsset();
		Actions actions = clientCreateAssetActivity.getActions();

		if (actions.has(ClientReadAssetActivity.class)) {
			ClientReadAssetActivity clientReadAssetActivity = actions.get(ClientReadAssetActivity.class);
			clientReadAssetActivity.readAsset();
			createdAsset = clientReadAssetActivity.getAsset();
			actions = clientReadAssetActivity.getActions();
		}

		if (actions.has(ClientUpdateAssetActivity.class)) {
			ClientUpdateAssetActivity clientUpdateAssetActivity = actions.get(ClientUpdateAssetActivity.class);
			createdAsset.setAssetName("Dummy-Name");
			clientUpdateAssetActivity.updateAsset(createdAsset);
			actions = clientUpdateAssetActivity.getActions();
		}

		ClientAsset updateAsset = null;
		if (actions.has(ClientReadAssetActivity.class)) {
			ClientReadAssetActivity clientReadAssetActivity = actions.get(ClientReadAssetActivity.class);
			clientReadAssetActivity.readAsset();
			updateAsset = clientReadAssetActivity.getAsset();
			actions = clientReadAssetActivity.getActions();
		}

		assertEquals("Dummy-Name", updateAsset.getAssetName());

	}

	@Test(expected = NotFoundException.class)
	public void testRemoveAsset() throws URISyntaxException, NotFoundException, ServiceFailureException {
		ClientCreateAssetActivity clientCreateAssetActivity = new ClientCreateAssetActivity();

		TestClientAssetFactory testClientAssetFactory = new TestClientAssetFactory();
		ClientAsset asset = testClientAssetFactory.createAsset();

		clientCreateAssetActivity.createAsset(asset, new URI(getEntryPointURI()));

		ClientAsset createdAsset = clientCreateAssetActivity.getAsset();
		Actions actions = clientCreateAssetActivity.getActions();

		ClientReadAssetActivity clientReadAssetActivity = null;
		if (actions.has(ClientReadAssetActivity.class)) {
			clientReadAssetActivity = actions.get(ClientReadAssetActivity.class);
			clientReadAssetActivity.readAsset();
			createdAsset = clientReadAssetActivity.getAsset();
			actions = clientReadAssetActivity.getActions();
		}

		if (actions.has(ClientRemoveAssetActivity.class)) {
			ClientRemoveAssetActivity clientRemoveAssetActivity = actions.get(ClientRemoveAssetActivity.class);
			clientRemoveAssetActivity.removeAsset(createdAsset);
			createdAsset = clientRemoveAssetActivity.getAsset();
			actions = clientRemoveAssetActivity.getActions();

		}

		assertNull(actions);
		clientReadAssetActivity.readAsset();

	}

	@Test
	@Ignore
	public void testApproveAsset()
			throws URISyntaxException, NotFoundException, ServiceFailureException, CannotApproveException {
		ClientCreateAssetActivity clientCreateAssetActivity = new ClientCreateAssetActivity();

		TestClientAssetFactory testClientAssetFactory = new TestClientAssetFactory();
		ClientAsset asset = testClientAssetFactory.createAsset();

		clientCreateAssetActivity.createAsset(asset, new URI(getEntryPointURI()));

		ClientAsset createdAsset = clientCreateAssetActivity.getAsset();
		Actions actions = clientCreateAssetActivity.getActions();

		if (actions.has(ClientReadAssetActivity.class)) {
			ClientReadAssetActivity clientReadAssetActivity = actions.get(ClientReadAssetActivity.class);
			clientReadAssetActivity.readAsset();
			createdAsset = clientReadAssetActivity.getAsset();
			actions = clientReadAssetActivity.getActions();
		}

		if (actions.has(ClientApproveAssetActivity.class)) {
			ClientApproveAssetActivity clientApproveAssetActivity = actions.get(ClientApproveAssetActivity.class);
			clientApproveAssetActivity.approveAsset(createdAsset);
			actions = clientApproveAssetActivity.getActions();
		}

		if (actions.has(ClientReadAssetActivity.class)) {
			ClientReadAssetActivity clientReadAssetActivity = actions.get(ClientReadAssetActivity.class);
			clientReadAssetActivity.readAsset();
			createdAsset = clientReadAssetActivity.getAsset();
			actions = clientReadAssetActivity.getActions();
		}

		// TODO Correct condition
		//assertEquals(AssetStatus.StatusCode.APPROVED, createdAsset.getAssetStatus());

	}

}
