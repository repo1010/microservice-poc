package com.ms.secureservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SecureserviceAppApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(SecureserviceAppApplication.class, args);
	}

	
	
	@RequestMapping(value  = "/books", method=RequestMethod.GET)
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		System.out.println("In book resource");
		 books.add(new Book(100, "Spring In Action", "ABC"));
		 books.add(new Book(102, "Hibernate In Action", "DEF"));
		 books.add(new Book(103, "Angular In Action", "LMN"));

		return books;
	}

	 class Book implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Integer id;
		private String name;
		private String author;

		public Book() {

		}

		public Book(Integer id, String name, String author) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

	}
}
