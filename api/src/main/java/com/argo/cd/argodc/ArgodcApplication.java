package com.argo.cd.argodc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ArgodcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgodcApplication.class, args);
	}


	@RestController
	@RequestMapping("/api")
	static class Api {
		@RequestMapping("/hello")
		public String hello() {
			return "Hello from ArgoCD! This is a Java Spring Boot Application.";
		}

	}
}
