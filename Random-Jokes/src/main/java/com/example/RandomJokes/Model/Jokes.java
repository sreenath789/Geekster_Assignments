package com.example.RandomJokes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Jokes {

    private int id;
    private String type;
    private String setup;
    private String punchline;
}
