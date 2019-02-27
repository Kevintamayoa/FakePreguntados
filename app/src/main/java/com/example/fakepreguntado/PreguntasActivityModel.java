package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModel;

import java.util.List;

public class PreguntasActivityModel extends ViewModel {
    private BancoDePreguntas bancoDePreguntas;
    private List<Question> preguntas;
    private int currentQuestionIndex;

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void incrementCurrentQuestionIndex() {
        currentQuestionIndex = (currentQuestionIndex + 1) % preguntas.size();
    }

    public void decrementCurrentQuestionIndex() {
        currentQuestionIndex = (currentQuestionIndex == 0) ? preguntas.size() - 1 : currentQuestionIndex - 1;
    }

    public void loadGameQuestions() {
        if (bancoDePreguntas == null) {
            currentQuestionIndex = 0;
            bancoDePreguntas = new BancoDePreguntas();
            preguntas = bancoDePreguntas.getAllQuestions();
        }
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
        return currentQuestionIndex+"/"+preguntas.size()+1;
    }
}
