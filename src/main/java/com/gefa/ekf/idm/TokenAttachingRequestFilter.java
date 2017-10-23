package com.gefa.ekf.idm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest.TokenRequestBuilder;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

public class TokenAttachingRequestFilter implements ClientRequestFilter {

	public static final String CONFIG_FILE_NAME = "configuration.properties";

	public static final String OAUTH_IDP_TOKEN_URL = "oauth2.idpTokenUrl";

	public static final String OAUTH_CLIENT_ID = "oauth2.clientId";

	public static final String OAUTH_CLIENT_SECRET = "oauth2.clientSecret";

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {

		try {
			attachAccessToken(requestContext);
		} catch (OAuthSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void attachAccessToken(ClientRequestContext requestContext)
			throws OAuthSystemException, OAuthProblemException, IOException {
		HttpHeader httpHeader = retrieveAccessToken();
		addAccessTokenHeader(requestContext, httpHeader);
	}

	private HttpHeader retrieveAccessToken() throws OAuthSystemException, OAuthProblemException, IOException {
		TokenRequestBuilder requestBuilder;

		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
		properties.load(inputStream);

		requestBuilder = OAuthClientRequest.tokenLocation(properties.getProperty(OAUTH_IDP_TOKEN_URL));
		requestBuilder.setGrantType(GrantType.CLIENT_CREDENTIALS);
		requestBuilder.setClientId(properties.getProperty(OAUTH_CLIENT_ID));
		requestBuilder.setClientSecret(properties.getProperty(OAUTH_CLIENT_SECRET));

		OAuthClientRequest request = requestBuilder.buildBodyMessage();

		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

		OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(request,
				OAuthJSONAccessTokenResponse.class);

		String accessToken = oAuthResponse.getAccessToken();
		return new HttpHeader("Authorization", "bearer " + accessToken);

	}

	private void addAccessTokenHeader(ClientRequestContext requestContext, HttpHeader httpHeader) {
		requestContext.getHeaders().add(httpHeader.getName(), httpHeader.getValue());
	}

}
