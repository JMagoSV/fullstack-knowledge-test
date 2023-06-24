package com.dev.example.marvelconsumer.models;

import java.util.ArrayList;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter @NoArgsConstructor
public class MarvelData {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private ArrayList<Result> results;
}
