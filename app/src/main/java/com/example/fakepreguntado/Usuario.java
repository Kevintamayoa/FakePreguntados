package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String name;
    private double puntajeMax;
    private boolean cheat;

    public Usuario(int id, String name, double puntajeMax, boolean cheat) {
        this.id = id;
        this.name = name;
        this.puntajeMax = puntajeMax;
        this.cheat = cheat;
    }

    public int getUserId(){return id;}

    public String getName(){return name;}

    public double getPuntajeMax(){return puntajeMax;}

    public void setPuntajeMax(double puntaje){puntajeMax=puntaje;}

    public void setCheatingStatus(){cheat = true;}

    public boolean getCheatStatus(){return cheat;}
    public static List<Usuario> Usuarios=new ArrayList<Usuario>();

}
