package com.example.fakepreguntado;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;

public class form_opciones extends AppCompatActivity {
    public static final String CHEATED_FLAG_KEY = "CHEATED_FLAG_KEY";
    public static final String CHEAT_STRING="CHEAT_STRING";
    public static final boolean CHEAT=false;
    public static final int CHEAT_INT = 1;
    public static final int CHEAT_NUM = 3;
    public static final int PREGUNTAS_NUM = 15;
    public static final int DIFICULTAD = 1;
    public static final boolean Geografia=false;
    public static final boolean Historia=false;
    public static final boolean Arte=false;
    public static final boolean Entretenimiento=false;
    public static final boolean Idiomas=false;
    public static final boolean Matematicas=false;
    public static final boolean Ciencias=false;
    public static final boolean Deportes=false;
    Button AtrasButton;
    CheckBox TodosCheck;
    CheckBox GeografiaCheck;
    CheckBox HistoriaCheck;
    CheckBox ArteCheck;
    CheckBox EntretenimientoCheck;
    CheckBox IdiomasCheck;
    CheckBox MatematicasCheck;
    CheckBox CienciasCheck;
    CheckBox DeportesCheck;
    ScrollableNumberPicker CheatsScroll;
    ScrollableNumberPicker PreguntaScroll;
    RadioButton Facil;
    RadioButton Medio;
    RadioButton Dificil;
    Switch CheatsSwitch;
    TextView CheatsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_opciones);
        AtrasButton = findViewById(R.id.atras_buttom);
        TodosCheck = findViewById(R.id.todos_check);
        GeografiaCheck = findViewById(R.id.geografia_check);
        HistoriaCheck = findViewById(R.id.historia_check);
        ArteCheck = findViewById(R.id.arte_check);
        CheatsText=findViewById(R.id.cheat_text);
        EntretenimientoCheck = findViewById(R.id.entretenimiento_check);
        IdiomasCheck = findViewById(R.id.idiomas_check);
        MatematicasCheck = findViewById(R.id.matematicas_check);
        CienciasCheck = findViewById(R.id.ciencias_check);
        DeportesCheck = findViewById(R.id.deportes_check);
        CheatsSwitch = findViewById(R.id.cheat_switch);
        CheatsScroll = findViewById(R.id.num_cheats_scroll);
        PreguntaScroll = findViewById(R.id.num_preguntas_scroll);
        Facil = findViewById(R.id.facil_rb);;
        Medio = findViewById(R.id.media_rb);
        Dificil = findViewById(R.id.dificil_rb);
        TodosCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TodosCheck.isChecked()) {
                    GeografiaCheck.setChecked(true);
                    HistoriaCheck.setChecked(true);
                    ArteCheck.setChecked(true);
                    EntretenimientoCheck.setChecked(true);
                    IdiomasCheck.setChecked(true);
                    MatematicasCheck.setChecked(true);
                    CienciasCheck.setChecked(true);
                    DeportesCheck.setChecked(true);
                } else {
                    GeografiaCheck.setChecked(false);
                    HistoriaCheck.setChecked(false);
                    ArteCheck.setChecked(false);
                    EntretenimientoCheck.setChecked(false);
                    IdiomasCheck.setChecked(false);
                    MatematicasCheck.setChecked(false);
                    CienciasCheck.setChecked(false);
                    DeportesCheck.setChecked(false);
                }
            }
        });
        Facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dificil.setChecked(false);
                Medio.setChecked(false);
            }
        });
        Medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dificil.setChecked(false);
                Facil.setChecked(false);
            }
        });
        Dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facil.setChecked(false);
                Medio.setChecked(false);
            }
        });
        PreguntaScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
     AtrasButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Bundle parmetros = new Bundle();
             parmetros.putBoolean("cheat", CheatsSwitch.isChecked());
             Intent config=new Intent(form_opciones.this,MainActivity.class);
             config.putExtras(parmetros);
             startActivity(config);
         }
     });
        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            CheatsSwitch.setChecked(parametros.getBoolean("cheat"));
        }


     Medio.setChecked(true);
     CheatsScroll.setVisibility(View.INVISIBLE);
     CheatsText.setVisibility(View.INVISIBLE);
     CheatsSwitch.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (CheatsSwitch.isChecked()) {
                 CheatsScroll.setVisibility(View.VISIBLE);
                 CheatsText.setVisibility(View.VISIBLE);
                 CheatsScroll.setValue(3);
             } else {
                 CheatsScroll.setVisibility(View.INVISIBLE);
                 CheatsText.setVisibility(View.INVISIBLE);
             }
         }
     });
    }
@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putBoolean(CHEAT_STRING, CHEAT);
}
    }
