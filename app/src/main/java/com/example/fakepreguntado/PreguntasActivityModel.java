package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModel;

import java.util.List;

public class PreguntasActivityModel extends ViewModel {
    private List<Question> preguntas;
    private int currentQuestionIndex;
    private Usuario usuario;
    private double puntajeFinal;

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void incrementCurrentQuestionIndex() {
        currentQuestionIndex = (currentQuestionIndex + 1) % preguntas.size();
    }

    public void decrementCurrentQuestionIndex() {
        currentQuestionIndex = (currentQuestionIndex == 0) ? preguntas.size() - 1 : currentQuestionIndex - 1;
    }

    public void loadGameQuestions(int num,int dificultad,List<Integer> categorias) {
        if (preguntas == null) {
            currentQuestionIndex = 0;
 BancoDePreguntas bancoDePreguntas=new BancoDePreguntas();
            preguntas = bancoDePreguntas.getQuestionsByParams(num,dificultad, categorias);
        }
    }
    public int GetPuntajeTotal() {
        int puntaje=0;
        if(preguntas!=null){
            for(Question obj:preguntas){
                if(obj.getStatus()==2){
                    puntaje+=obj.getDifficulty();
                }
            }
        }
        return puntaje;
    }


    public void loadNewUser(boolean cheat){
        if(usuario==null){
            BancoDeUsuarios obj= new BancoDeUsuarios();
            usuario = new Usuario(obj.getAllUsers().size()+1,"AAA",0,cheat);
        }
    }

    public void PassCheatingStatus(){
        usuario.setCheatingStatus();
    }

    public Question getCurrentQuestion() {
        return preguntas.get(currentQuestionIndex);
    }

    public Question getNextQuestion() {
        incrementCurrentQuestionIndex();
        return preguntas.get(currentQuestionIndex);
    }

    public Question getPreviousQuestion() {
        decrementCurrentQuestionIndex();
        return preguntas.get(currentQuestionIndex);
    }

    public String getCurrentQuestionIndexText(){
        return (currentQuestionIndex+1)+"/"+preguntas.size();
    }

    public void setCurrentQuestionStatus(boolean choice){
            preguntas.get(currentQuestionIndex).setStatus(choice);
    }

    //public void Puntaje
}
