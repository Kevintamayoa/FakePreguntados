package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String name;
    private int puntajeMax;
    private boolean cheat;

    public Usuario(int id, String name, int puntajeMax, boolean cheat) {
        this.id = id;
        this.name = name;
        this.puntajeMax = puntajeMax;
        this.cheat = cheat;
    }

    public int getUserId(){return id;}

    public void setUserId(String name){this.name=name;}

    public String getName(){return name;}

    public void setName(String nam){name=nam;}

    public int getPuntajeMax(){return puntajeMax;}

    public void setPuntajeMax(int puntaje){puntajeMax=puntaje;}

    public void setCheatingStatus(){cheat = true;}

    public boolean getCheatStatus(){return cheat;}

}
