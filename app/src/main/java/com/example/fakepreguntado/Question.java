package com.example.fakepreguntado;

public class Question {
    private int id;
    private String pregunta;
    private boolean status;
    private boolean respuesta;
    private boolean cheatStatus;
    private int dificultad;
    private int categoria;
    private int puntaje;

    public Question(int id, String pregunta, boolean status, boolean respuesta, boolean cheatStatus, int dificultad, int categoria, int puntaje) {
        this.id = id;
        this.pregunta = pregunta;
        this.status = status;
        this.respuesta = respuesta;
        this.cheatStatus = cheatStatus;
        this.dificultad = dificultad;
        this.categoria = categoria;
        this.puntaje = puntaje;
    }

    public int getQuestionId(){return id;}

    public String getQuestion(){return pregunta;}

    public boolean getStatus(){return status;}

    public void setStatus(){status=true;}

    public boolean getAnswer(){return respuesta;}

    public boolean getCheatStatus(){return cheatStatus;}

    public void setCheatStatus(){cheatStatus=true;}

    public int getDifficulty() {return dificultad;}

    public int getCategory(){return categoria;}

    public int getPoints(){return puntaje;}


}
