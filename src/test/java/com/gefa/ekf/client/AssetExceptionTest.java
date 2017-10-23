package com.gefa.ekf.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.jboss.resteasy.test.TestPortProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.gefa.ekf.client.activities.ClientReadAssetActivity;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.server.MyServer;

@Ignore
public class AssetExceptionTest {
	@BeforeClass
	public static void init() throws Exception {
		MyServer.startContainer();
	}

	@AfterClass
	public static void stop() throws Exception {
		MyServer.stopContainer();
	}

	private String getEntryPointURI() {
		return TestPortProvider.generateURL("/ekf-tool-rest-easy/asset");
	}

	/*
	 * private String getEntryPointURI() { return
	 * "http://localhost:8080/ekf-tool-rest-easy/asset/9"; }
	 */

	@Test(expected = NotFoundException.class)
	public void testReadAssetNotFoundException() throws URISyntaxException {
		ClientReadAssetActivity clientReadAssetActivity = new ClientReadAssetActivity(
				new URI(getEntryPointURI() + "/9"));
		clientReadAssetActivity.readAsset();
	}
}
