package com.dev.example.marvelapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.dev.example.marvelapi.dao.service.EventService;
import com.dev.example.marvelconsumer.MarvelApiClient;
import com.dev.example.marvelconsumer.models.MarvelData;
import com.dev.example.marvelconsumer.models.Result;

@WebMvcTest(controllers = CharactersController.class)
@ActiveProfiles("test")
class CharactersControllerTest {
    @Value("${marvel.base-url}" )
    private String baseUrl;
    @Value("${marvel.api-key}" )
    private String apiKey;
    @Value("${marvel.private-key}" )
    private String privateKey;
    @Value("${marvel.ts}" )
    private String ts;

	@Autowired
    private MockMvc mockMvc;
                                                 
    @MockBean
    private EventService eventService;
                                               
    private MarvelData marvelData;       
                                            
    @BeforeEach                           
    void setUp() throws Exception {
    	marvelData = new MarvelData();
        MarvelApiClient apiClient = new MarvelApiClient(baseUrl, apiKey, privateKey, ts);
        marvelData = apiClient.getCharacterData();
//        marvelData.getResults().remove(0);
	}
    
    @Test
    void shouldFetchAllCharacters() throws Exception {
        this.mockMvc.perform(get("/api/marvel/characters"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results.size()", is(marvelData.getResults().size())));
    }
    

    @Test
    void shouldFetchOneCharacterById() throws Exception {
    	// Lo ideal es guardar un registro nuevo y consultar por ese ID
        Result firstCharacter = marvelData.getResults().get(0);

        this.mockMvc.perform(get("/api/marvel/characters/{id}", firstCharacter.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[0].name", is(firstCharacter.getName())))
                .andExpect(jsonPath("$.results[0].description", is(firstCharacter.getDescription())));
    }
    
    @Test
    void shouldReturn404WhenFindCharactersById() throws Exception {
        final Long characterId = 99999999L;
        this.mockMvc.perform(get("/api/marvel/characters/{id}", characterId))
                .andExpect(status().isNotFound());
    }

}
