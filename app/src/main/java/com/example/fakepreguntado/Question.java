package com.example.fakepreguntado;

public class Question {

    private int id;
    private String pregunta;
    private int status;//status==1 es incorecto, status==2 es correcto
    private boolean respuesta;
    private int dificultad;
    private int categoria;

    public Question(int id, String pregunta,int status, boolean respuesta, int dificultad, int categoria) {
        this.id = id;
        this.pregunta = pregunta;
        this.status=status;
        this.respuesta = respuesta;
        this.dificultad = dificultad;
        this.categoria = categoria;
    }

    public int getQuestionId(){return id;}

    public String getQuestion(){return pregunta;}

    public int getStatus(){return status;}

    public void setStatus(boolean choice){
        if(choice){
            status=2;
        }
        else{status=1;}
    }

    public boolean getAnswer(){return respuesta;}

    public int getDifficulty() {return dificultad;}

    public int getCategory(){return categoria;}

}
