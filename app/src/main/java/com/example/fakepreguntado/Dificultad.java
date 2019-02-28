package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class Dificultad {

    private int category_id;
    private String category;
    private int puntaje;
    public Dificultad(int category_id, String category, int puntaje) {
        this.category_id = category_id;
        this.category = category;
        this.puntaje=puntaje;
    }
    public List<Dificultad> getAllDificultades() {
        List<Dificultad> dificultad = new ArrayList<>();
        dificultad = new ArrayList<>();
        dificultad.add(new Dificultad(1,"Facil",1));
        dificultad.add(new Dificultad(2,"Media",2));
        dificultad.add(new Dificultad(3,"Dificil",3));

        return dificultad;
    }
}
