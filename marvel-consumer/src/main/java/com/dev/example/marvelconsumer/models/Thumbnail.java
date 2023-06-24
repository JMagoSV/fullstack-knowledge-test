package com.dev.example.marvelconsumer.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter @NoArgsConstructor
public class Thumbnail {
    private String path;
    private String extension;
}
