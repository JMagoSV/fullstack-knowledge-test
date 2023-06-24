package com.dev.example.marvelconsumer.models;

import java.util.ArrayList;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter @NoArgsConstructor
public class Series {
    private int available;
    private String collectionURI;
    private ArrayList<Item> items;
    private int returned;
}
