package com.bbt.vendor.google;

import java.io.IOException;

import com.google.api.client.extensions.java6.auth.oauth2.AbstractPromptReceiver;

public class GoogleReciever extends AbstractPromptReceiver {

	private String redirectUri = "http://localhost/";

	public void setRedirectUri(String sRedirectUri) {
		redirectUri = sRedirectUri;
	}

	@Override
	public String getRedirectUri() throws IOException {
		return redirectUri;
	}

}
