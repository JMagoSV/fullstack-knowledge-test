package com.dev.example.marvelconsumer.models;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter @NoArgsConstructor
public class Item {
    private String resourceURI;
    private String name;
    private String type;
}
