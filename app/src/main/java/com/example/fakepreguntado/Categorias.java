package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class Categorias {
    private List<String> categorias;

    public List<String> getAllCategories() {
        if (categorias == null) {
            categorias = new ArrayList<>();
            categorias.add(new String("Historia"));
            categorias.add(new String("Geografía"));
            categorias.add(new String("Idiomas"));
            categorias.add(new String("Ciencias"));
            categorias.add(new String("Deportes"));
            categorias.add(new String("Entretenimiento"));
            categorias.add(new String("Matemáticas"));
            categorias.add(new String("Arte"));
        }
        return categorias;
    }
}
