package com.dev.example.marvelapi.dao.service;

import java.util.Date;
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
    public Events create(String type) throws Exception {
        // Saving register
        Events event = new Events();
        event.setType(type);
        event.setUserRegistered("SYSTEM");
        event.setCreatedAt(new Date());
        return eventRepository.save(event);
    }
    
    @Override
    public List<Events> findAll() {
        return (List<Events>) eventRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    

}
