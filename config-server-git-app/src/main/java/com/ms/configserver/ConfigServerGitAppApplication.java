package com.ms.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerGitAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitAppApplication.class, args);
	}

}
