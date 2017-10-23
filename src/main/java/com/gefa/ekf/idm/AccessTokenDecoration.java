package com.gefa.ekf.idm;

import javax.ws.rs.client.Client;

public class AccessTokenDecoration {

	public static Client bindClient(Client client) {
		client.register(new TokenAttachingRequestFilter());
		return client;
	}

}
