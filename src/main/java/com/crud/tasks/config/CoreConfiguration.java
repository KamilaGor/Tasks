package com.crud.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {

	@Bean
	public RestTemplate restTemplate() { //kl. restTemplate(ze Springa) umożliwia realizoawnie żądań HTTP pomiędzy serwerami
		return new RestTemplate();
	}
}
