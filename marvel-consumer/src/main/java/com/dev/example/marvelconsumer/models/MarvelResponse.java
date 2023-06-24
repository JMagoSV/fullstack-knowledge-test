package com.dev.example.marvelconsumer.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter @NoArgsConstructor
public class MarvelResponse {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private MarvelData data;
}
