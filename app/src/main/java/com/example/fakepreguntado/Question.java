package com.example.fakepreguntado;

public class Question {
    private int id;
    private String pregunta;
    private int status;
    private boolean respuesta;
    private int dificultad;
    private int categoria;
    private int puntaje;

    public Question(int id, String pregunta, boolean respuesta, int dificultad, int categoria) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.dificultad = dificultad;
        this.categoria = categoria;
    }
    private int pregunta_id;
    public Question(int id, int pregunta, int status) {
        this.id = id;
        pregunta_id = pregunta;
        this.status = status;
    }
    public int getQuestionId(){return id;}

    public String getQuestion(){return pregunta;}

    public int getStatus(){return status;}

    public boolean getAnswer(){return respuesta;}

    public int getDifficulty() {return dificultad;}

    public int getCategory(){return categoria;}

    public int getPoints(){return puntaje;}
}
