package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class BancoDePreguntas {
    private List<Question> questions;

    public List<Question> getAllQuestions() {
        if (questions == null) {
            questions = new ArrayList<>();
            questions.add(new Question(1, "", false,1,1));
            questions.add(new Question(2, "", false,1,1));
            questions.add(new Question(3, "", false,1,1));
            questions.add(new Question(4, "", false,1,1));
            questions.add(new Question(5, "", false,1,1));
            questions.add(new Question(6, "", false,1,1));
            questions.add(new Question(7, "", false,1,1));
            questions.add(new Question(8, "", false,1,1));
            questions.add(new Question(9, "", false,1,1));
            questions.add(new Question(10, "", false,1,1));
            questions.add(new Question(11, "", false,1,1));
            questions.add(new Question(12, "", false,1,1));
            questions.add(new Question(13, "", false,1,1));
            questions.add(new Question(14, "", false,1,1));
            questions.add(new Question(15, "", false,1,1));
            questions.add(new Question(16, "", false,1,1));
            questions.add(new Question(17, "", false,1,1));
            questions.add(new Question(18, "", false,1,1));
            questions.add(new Question(19, "", false,1,1));
            questions.add(new Question(20, "", false,1,1));
            questions.add(new Question(21, "", false,1,1));
            questions.add(new Question(22, "", false,1,1));
            questions.add(new Question(23, "", false,1,1));
            questions.add(new Question(24, "", false,1,1));
            questions.add(new Question(25, "", false,1,1));
            questions.add(new Question(26, "", false,1,1));
            questions.add(new Question(27, "", false,1,1));
            questions.add(new Question(28, "", false,1,1));
            questions.add(new Question(29, "", false,1,1));
            questions.add(new Question(30, "", false,1,1));
            questions.add(new Question(31, "", false,1,1));
            questions.add(new Question(32, "", false,1,1));
            questions.add(new Question(33, "", false,1,1));
            questions.add(new Question(34, "", false,1,1));
            questions.add(new Question(35, "", false,1,1));
            questions.add(new Question(36, "", false,1,1));
            questions.add(new Question(37, "", false,1,1));
            questions.add(new Question(38, "", false,1,1));
            questions.add(new Question(39, "", false,1,1));
            questions.add(new Question(40, "", false,1,1));
        }

        return questions;
    }
}
