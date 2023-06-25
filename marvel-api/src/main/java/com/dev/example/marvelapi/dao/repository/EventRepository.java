package com.dev.example.marvelapi.dao.repository;

import com.dev.example.marvelapi.models.Events;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Events, Long> {
	List<Events> findAll(Sort sort);
}
