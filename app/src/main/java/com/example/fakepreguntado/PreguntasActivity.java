package com.example.fakepreguntado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class PreguntasActivity extends AppCompatActivity {

    TextView numPregunta;
    Button cheatActivityButton;
    ImageButton pregAnterior;
    ImageButton pregSiguiente;
    TextView textoPregunta;
    ImageButton correctButton;
    ImageButton incorrectButton;

    public double puntajeTotal=0;

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

        //Pendiente
        numPregunta.setText("");
        //Pendiente
        cheatActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //Pendiente
        pregAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //Pendiente
        pregSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //Pendiente
        textoPregunta.setText("");
        //Pendiente
        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //Pendiente
        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
