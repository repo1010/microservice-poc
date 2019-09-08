package com.ms.securecli;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SecurecliAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurecliAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
			resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
			resourceDetails.setAccessTokenUri("http://localhost:8802/authserver/oauth/token");
			resourceDetails.setScope(Arrays.asList("book_read"));
			resourceDetails.setClientId("admin");
			resourceDetails.setClientSecret("adminsecret");
			resourceDetails.setUsername("guest1");
			resourceDetails.setPassword("guest1");
			
			OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
			
			String token = template.getAccessToken().toString();
			System.out.println("Token :" + token);
			
			String s =	template.getForObject("http://localhost:8801/services/books", String.class);
			
			System.out.println("Result : "+ s);
	}

}
