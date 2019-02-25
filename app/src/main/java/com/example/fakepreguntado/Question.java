package com.example.fakepreguntado;

public class Question {
    private int id;
    private String pregunta;
    private boolean respuesta;
    private int puntaje;

    public Question(int id, String pregunta, boolean respuesta, int puntaje) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.puntaje = puntaje;
    }

    public int getId(){ return id;}

    public String getQuestion(){ return pregunta;}

    public boolean getAnswer(){ return respuesta;}

    public int getPoints(){return puntaje;}
}
