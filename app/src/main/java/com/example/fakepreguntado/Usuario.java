package com.example.fakepreguntado;

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

    public boolean getCheatStatus(){return cheat;}
}
