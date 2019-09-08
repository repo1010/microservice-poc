package com.ms.secureui;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@Configuration
public class ResourceConfig {

	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
		return new OAuth2RestTemplate(resource, context);
	}

	/*
	 * @Bean public OAuth2RestTemplate oauth2RestTemplate() {
	 * ResourceOwnerPasswordResourceDetails resourceDetails = new
	 * ResourceOwnerPasswordResourceDetails();
	 * resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
	 * resourceDetails.setAccessTokenUri(
	 * "http://localhost:8802/authserver/oauth/token");
	 * resourceDetails.setScope(Arrays.asList("book_read"));
	 * resourceDetails.setClientId("admin");
	 * resourceDetails.setClientSecret("adminsecret");
	 * resourceDetails.setUsername("guest1"); resourceDetails.setPassword("guest1");
	 * resourceDetails.setGrantType("password");
	 * 
	 * OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
	 * 
	 * String token = template.getAccessToken().toString();
	 * System.out.println("Token :" + token); return template; }
	 */

}
