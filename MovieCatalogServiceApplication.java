package io.microservices.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServiceApplication {

	@Bean// just executes once and acts as producer
    public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}// can be written anywhere between the class path
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
//before running  localhost:8082/catalog/1  run movie-info-service as its url is used in this class.