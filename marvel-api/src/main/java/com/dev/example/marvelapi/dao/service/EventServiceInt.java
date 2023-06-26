package com.dev.example.marvelapi.dao.service;

import com.dev.example.marvelapi.models.Events;
import java.util.List;

public interface EventServiceInt {
    
    public Events create(String type) throws Exception;

    // public Events update(LinkedHashMap<String, Object> entity) throws Exception;

    // public Events delete(Long id) throws Exception;

    // public Events findById(Long id) throws Exception;
    
    public List<Events> findAll();
    
    // public List<Events> findByUid();
}
