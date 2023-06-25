/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.example.marvelapi.controllers;

import com.dev.example.marvelapi.MarvelController;
import com.dev.example.marvelapi.dao.repository.EventRepository;
import com.dev.example.marvelapi.models.Events;
import com.dev.example.marvelconsumer.MarvelApiClient;
import com.dev.example.marvelconsumer.models.MarvelData;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/characters")
    public MarvelData getAll() {
        MarvelApiClient apiClient = new MarvelApiClient(baseUrl, apiKey, privateKey, ts);
        // Saving register
        Events event = new Events();
        event.setType("ALL");
        event.setUserRegistered("SYSTEM");
        event.setCreatedAt(new Date());
        eventRepository.save(event);
        return apiClient.getCharacterData();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/characters/{id}")
   public MarvelData get(@PathVariable(value = "id") Integer id) throws Exception {
       MarvelApiClient apiClient = new MarvelApiClient(baseUrl, apiKey, privateKey, ts, id);
        // Saving register
        Events event = new Events();
        event.setType("ID: " + id);
        event.setUserRegistered("SYSTEM");
        event.setCreatedAt(new Date());
        eventRepository.save(event);
        return apiClient.getCharacterData();
    }
}
