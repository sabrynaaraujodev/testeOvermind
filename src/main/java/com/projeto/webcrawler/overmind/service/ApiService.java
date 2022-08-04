package com.projeto.webcrawler.overmind.service;

import com.projeto.webcrawler.overmind.model.Passing;

import java.io.IOException;
import java.util.List;

public interface ApiService
{
    List<Passing> getFilmes() throws IOException;
}