package com.dev.example.marvelapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@EnableCaching
@EntityScan("com.dev.example.marvelapi.models")
@ComponentScan({ "com.dev.example.marvelapi.dao" })
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@RequestMapping(path = "/api/marvel")
public @interface MarvelController {

}
