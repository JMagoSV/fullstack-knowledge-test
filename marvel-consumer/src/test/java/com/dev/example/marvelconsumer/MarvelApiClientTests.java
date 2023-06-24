package com.dev.example.marvelconsumer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
* @author Mauricio González
* 
*/
public class MarvelApiClientTests {
    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/characters";
    private static final String API_KEY = "ABC";
    private static final String PRIVATE_KEY = "123";
    private static final String TS = "1";

    @BeforeEach                                         
    void setUp() {
    }

    @Test                                               
    @DisplayName("Pruebas para la función buildUrlRequest")   
    void testBuildUrlRequest() {
		MarvelApiClient apiClient = new MarvelApiClient(BASE_URL, API_KEY, PRIVATE_KEY, TS);
        String valueExpected = "https://gateway.marvel.com/v1/public/characters?apikey=ABC&ts=1&hash=e140b3523802f887cca35c013069926b";
        assertAll("Función buildUrlRequest en clase MarvelApiClient",
            () -> assertNotNull(apiClient.buildUrlRequest(), "La url no debería ser null")
            , () -> assertEquals(valueExpected, apiClient.buildUrlRequest(), "La URL no está siendo formada correctamente")
        );
    }

    @Test                                               
    @DisplayName("Pruebas para la función buildUrlRequest con limit y offset")   
    void testBuildUrlRequestWithLimitAndOffset() {
        int limit = 20, offset = 0;
		MarvelApiClient apiClient = new MarvelApiClient(BASE_URL, API_KEY, PRIVATE_KEY, TS, limit, offset);
        assertAll("Función buildUrlRequest en clase MarvelApiClient",
            () -> assertNotNull(apiClient.buildUrlRequest(), "La url no debería ser null")
            , () -> assertTrue(apiClient.buildUrlRequest().contains("limit"), "La URL debe contener limit")
            , () -> assertTrue(apiClient.buildUrlRequest().contains("offset"), "La URL debe contener offset")
        );
    }

    @Test                                               
    @DisplayName("Pruebas para la función buildUrlRequest con characterId")
    void testBuildUrlRequestWithCharacterId() {
        int characterId = 123;
		MarvelApiClient apiClient = new MarvelApiClient(BASE_URL, API_KEY, PRIVATE_KEY, TS, characterId);
        assertAll("Función buildUrlRequest en clase MarvelApiClient",
            () -> assertNotNull(apiClient.buildUrlRequest(), "La url no debería ser null")
            , () -> assertFalse(apiClient.buildUrlRequest().contains("limit"), "La URL debe contener limit")
            , () -> assertFalse(apiClient.buildUrlRequest().contains("offset"), "La URL debe contener offset")
        );
    }
    
}
