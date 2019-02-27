package com.example.fakepreguntado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;

public class form_opciones extends AppCompatActivity {
    CheckBox todosCheck;
    CheckBox historiaCheck;
    CheckBox geografiaCheck;
    CheckBox idiomasCheck;
    CheckBox cienciasCheck;
    CheckBox deportesCheck;
    CheckBox entretenimientoCheck;
    CheckBox matematicasCheck;
    CheckBox arteCheck;
    ScrollableNumberPicker numPreguntasScroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_opciones);
        todosCheck=findViewById(R.id.todos_check);
        historiaCheck=findViewById(R.id.historia_check);
        geografiaCheck=findViewById(R.id.geografia_check);
        idiomasCheck=findViewById(R.id.idiomas_check);
        cienciasCheck=findViewById(R.id.ciencias_check);
        deportesCheck=findViewById(R.id.deportes_check);
        entretenimientoCheck=findViewById(R.id.entretenimiento_check);
        matematicasCheck=findViewById(R.id.matematicas_check);
        arteCheck=findViewById(R.id.arte_check);
        numPreguntasScroll=findViewById(R.id.numpreguntas_scroll);


        todosCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!todosCheck.isChecked()) {
                    historiaCheck.setChecked(false);
                    geografiaCheck.setChecked(false);
                    idiomasCheck.setChecked(false);
                    cienciasCheck.setChecked(false);
                    deportesCheck.setChecked(false);
                    entretenimientoCheck.setChecked(false);
                    matematicasCheck.setChecked(false);
                    arteCheck.setChecked(false);
                }else{
                    historiaCheck.setChecked(true);
                    geografiaCheck.setChecked(true);
                    idiomasCheck.setChecked(true);
                    cienciasCheck.setChecked(true);
                    deportesCheck.setChecked(true);
                    entretenimientoCheck.setChecked(true);
                    matematicasCheck.setChecked(true);
                    arteCheck.setChecked(true);
                }
            }
        });
    }
}
