package com.dev.example.marvelapi;

import com.dev.example.marvelconsumer.MarvelApiClient;
import com.dev.example.marvelconsumer.models.MarvelData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarvelApiApplication {
    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/characters";
    private static final String API_KEY = "abc";
    private static final String PRIVATE_KEY = "123";
    private static final String TS = "1";
	private static final Integer CHARACTER_ID = 1011334;

	public static void main(String[] args) {
		MarvelApiClient apiClient = new MarvelApiClient(BASE_URL, API_KEY, PRIVATE_KEY, TS, CHARACTER_ID);
		// MarvelApiClient apiClient = new MarvelApiClient(BASE_URL, API_KEY, PRIVATE_KEY, TS);
		MarvelData response = apiClient.getCharacterData();
		System.err.println("Debe retornar la respuesta " + response.getCount());
		SpringApplication.run(MarvelApiApplication.class, args);
	}

}
