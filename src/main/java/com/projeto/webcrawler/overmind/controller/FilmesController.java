package com.projeto.webcrawler.overmind.controller;

import com.projeto.webcrawler.overmind.model.Passing;
import com.projeto.webcrawler.overmind.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FilmesController {

    @Autowired
    private ApiService apiService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/filmes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Passing> getFilmes() throws IOException {
        return apiService.getFilmes();
    }

}
