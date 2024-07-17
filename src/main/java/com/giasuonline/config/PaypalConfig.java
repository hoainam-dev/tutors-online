package com.giasuonline.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration
public class PaypalConfig {

	@Bean
	public Map<String, String> paypalSdkConfig() {
		Map<String, String> sdkConfig = new HashMap<>();
		sdkConfig.put("mode", "sandbox");
		return sdkConfig;
	}

	@Bean
	public OAuthTokenCredential authTokenCredential() {
		return new OAuthTokenCredential(
				"AXWArcT-ykcNlQYlbfnmF7wvSdFfnegi8SBxBeEk6sw95Tz5Z_HsvWr39ireNnivAqbnkNq7QJ7bIgCQ",
				"EPR6Z223AnSnahFsiyRoqKQwklUsfL8-oOIKY554_B_zwE4G0GqEcKU2jss3uij-vrDR482qLgJw7G6x",
				paypalSdkConfig());
	}

	@Bean
	public APIContext apiContext() throws PayPalRESTException {
		APIContext apiContext = new APIContext(authTokenCredential().getAccessToken());
		apiContext.setConfigurationMap(paypalSdkConfig());
		return apiContext;
	}
}
