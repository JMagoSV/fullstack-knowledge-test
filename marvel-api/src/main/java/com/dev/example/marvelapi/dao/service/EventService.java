package com.dev.example.marvelapi.dao.service;

import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.dev.example.marvelapi.dao.repository.EventRepository;
import com.dev.example.marvelapi.models.Events;


@Service
public class EventService implements EventServiceInt {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Events create(LinkedHashMap<String, Object> entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public List<Events> findAll() {
        return (List<Events>) eventRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    

}
