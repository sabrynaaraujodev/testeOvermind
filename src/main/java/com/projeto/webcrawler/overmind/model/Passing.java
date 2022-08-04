package com.projeto.webcrawler.overmind.model;


import lombok.Data;

import java.io.Serializable;


@Data
public class Passing implements Serializable {
    private final static long serialVersionUID = 5798633039064811438L;


    private String titulo;
    private String nota;

    public Passing() {
    }

    public Passing(String titulo, String nota) {
        this.titulo = titulo;
        this.nota = nota;
    }
}
