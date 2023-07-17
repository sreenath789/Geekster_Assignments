package com.example.RandomJokes.Controller;

import com.example.RandomJokes.Model.Jokes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokesController {

    @RequestMapping("/postdata")
    public String postData(@RequestBody Jokes jokes) {
        System.out.println(jokes);
        return "Sreenath";
    }
}
