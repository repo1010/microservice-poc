package com.ms.secureui.controller;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.secureui.model.Book;

@Controller
@EnableOAuth2Sso
public class ResourceController extends WebSecurityConfigurerAdapter {

	@Autowired
	private OAuth2ClientContext clientContext;

	@Autowired
	private OAuth2RestTemplate oauth2RestTemplate;

	String url = "http://localhost:8801/services/books";

	@RequestMapping("/books")
	public String loadBooksInfo(Model model) {
		OAuth2AccessToken t = clientContext.getAccessToken();
		System.out.println("Token Value :" + t.getValue());

		ResponseEntity<ArrayList<Book>> books = oauth2RestTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<ArrayList<Book>>() {
				});
		model.addAttribute("books", books.getBody());
		return "booksinfo";
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/resource")
	public String getResource() {
		return "resource";
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/login**").permitAll().anyRequest().authenticated();
	}

}
