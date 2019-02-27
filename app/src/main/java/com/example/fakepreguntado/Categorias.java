package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class Categorias {
    private int category_id;
    private String category;

    public Categorias(int category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }

    public List<Categorias> getAllCategories() {
        List<Categorias> categorias = new ArrayList<>();
        if (categorias == null) {
            categorias = new ArrayList<>();
            categorias.add(new Categorias(0,"Historia"));
            categorias.add(new Categorias(1,"Geografía"));
            categorias.add(new Categorias(2,"Idiomas"));
            categorias.add(new Categorias(3,"Ciencias"));
            categorias.add(new Categorias(4,"Deportes"));
            categorias.add(new Categorias(5,"Entretenimiento"));
            categorias.add(new Categorias(6,"Matemáticas"));
            categorias.add(new Categorias(7,"Arte"));
        }
        return categorias;
    }
}
