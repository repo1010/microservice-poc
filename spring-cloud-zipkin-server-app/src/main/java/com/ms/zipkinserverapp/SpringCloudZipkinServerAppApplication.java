package com.ms.zipkinserverapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SpringCloudZipkinServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinServerAppApplication.class, args);
	}

}
