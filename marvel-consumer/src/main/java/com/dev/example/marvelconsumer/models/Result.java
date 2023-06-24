package com.dev.example.marvelconsumer.models;

import java.util.ArrayList;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter @NoArgsConstructor
public class Result {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private Comics comics;
    private Series series;
    private Stories stories;
    private Events events;
    private ArrayList<Url> urls;
}
