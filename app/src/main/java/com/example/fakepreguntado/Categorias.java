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

    public int getCategory_id(){return category_id;}

    public String getCategory(){return category;}
}
