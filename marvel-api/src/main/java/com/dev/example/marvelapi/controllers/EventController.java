/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.example.marvelapi.controllers;

import com.dev.example.marvelapi.MarvelController;
import com.dev.example.marvelapi.dao.service.EventService;
import com.dev.example.marvelapi.utils.Constants;
import com.dev.example.marvelapi.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mauricio González
 */

@MarvelController
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET, value = "/events")
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS, eventService.findAll());
    }
}
