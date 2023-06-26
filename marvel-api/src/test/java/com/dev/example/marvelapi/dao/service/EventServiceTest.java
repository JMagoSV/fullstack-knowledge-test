package com.dev.example.marvelapi.dao.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.dev.example.marvelapi.dao.repository.EventRepository;
import com.dev.example.marvelapi.models.Events;

class EventServiceTest {
	
	@Mock
    EventRepository eventRepository;
	private AutoCloseable closeable;
	
	@InjectMocks
	private EventService eventService;

	private List<Events> listEvents;
	private Events event;
	
	@BeforeEach
	void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        event = new Events();
        event.setId(1L);
        event.setType("ALL");
        event.setUserRegistered("None");
        event.setCreatedAt(new Date());
        listEvents = new ArrayList<>();
        listEvents.add(event);
	}
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

	@Test
	void findAll() {
		when(eventRepository.findAll()).thenReturn(listEvents);
		assertNotNull(eventService.findAll(), "La lista no debería ser null");
	}

	@Test
	void create() throws Exception {
		when(eventRepository.save(any(Events.class))).thenReturn(event);
		assertNotNull(eventService.create("ALL"), "Al guardar debe devolver un objeto");
	}

}
