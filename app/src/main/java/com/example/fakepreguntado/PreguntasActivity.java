package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PreguntasActivity extends AppCompatActivity {

    TextView numPregunta;
    Button cheatActivityButton;
    ImageButton pregAnterior;
    ImageButton pregSiguiente;
    TextView textoPregunta;
    ImageButton correctButton;
    ImageButton incorrectButton;

    public double puntajeTotal=0;

    PreguntasActivityModel preguntasActivityModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        numPregunta = findViewById(R.id.num_pregunta);
        cheatActivityButton = findViewById(R.id.cheat_activity_button);
        pregAnterior = findViewById(R.id.ant_pregunta);
        pregSiguiente = findViewById(R.id.sig_pregunta);
        textoPregunta = findViewById(R.id.texto_pregunta);
        correctButton = findViewById(R.id.correct_button);
        incorrectButton = findViewById(R.id.incorrect_button);

        preguntasActivityModel = ViewModelProviders.of(this).get(PreguntasActivityModel.class);
        preguntasActivityModel.loadGameQuestions();

        numPregunta.setText(preguntasActivityModel.getCurrentQuestionIndexText());
        //Pendiente
        cheatActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pregAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoPregunta.setText(preguntasActivityModel.getPreviousQuestion().getQuestion());
            }
        });

        pregSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoPregunta.setText(preguntasActivityModel.getNextQuestion().getQuestion());
            }
        });

        textoPregunta.setText(preguntasActivityModel.getCurrentQuestion().getQuestion());

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = preguntasActivityModel.getCurrentQuestion();
                if (question.getAnswer()) {
                    Toast.makeText(PreguntasActivity.this,
                            "¡¡CORRECTO!!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PreguntasActivity.this,
                            "¡¡INCORRECTO!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = preguntasActivityModel.getCurrentQuestion();
                if (!question.getAnswer()) {
                    Toast.makeText(PreguntasActivity.this,
                            "¡¡CORRECTO!!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PreguntasActivity.this,
                            "¡¡INCORRECTO!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
