/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.example.marvelapi.controllers;

import com.dev.example.marvelapi.MarvelController;
import com.dev.example.marvelapi.dao.repository.EventRepository;
import com.dev.example.marvelapi.dao.service.EventService;
import com.dev.example.marvelapi.models.Events;
import com.dev.example.marvelconsumer.MarvelApiClient;
import com.dev.example.marvelconsumer.models.MarvelData;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Mauricio González
 */

@MarvelController
public class CharactersController {
    @Value("${marvel.base-url}" )
    private String baseUrl;
    @Value("${marvel.api-key}" )
    private String apiKey;
    @Value("${marvel.private-key}" )
    private String privateKey;
    @Value("${marvel.ts}" )
    private String ts;
    
    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET, value = "/characters")
    public MarvelData getAll() throws Exception {
        MarvelApiClient apiClient = new MarvelApiClient(baseUrl, apiKey, privateKey, ts);
        // Saving register
        eventService.create("ALL");
        return apiClient.getCharacterData();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/characters/{id}")
   public MarvelData get(@PathVariable(value = "id") Integer id) throws Exception {
       MarvelApiClient apiClient = new MarvelApiClient(baseUrl, apiKey, privateKey, ts, id);
       MarvelData marvelData = null;
       try {
           marvelData = apiClient.getCharacterData();
           // Saving register
           eventService.create("ID: " + id);
       } catch (Exception ex) {
           eventService.create("ERROR: " + id);
    	   throw new ResponseStatusException(
    			   HttpStatus.NOT_FOUND, "entity not found"
		 );
       }
       return marvelData;
    }
}
