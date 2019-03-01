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

import java.util.ArrayList;
import java.util.List;

public class form_opciones extends AppCompatActivity {
    public static final String CHEAT_STRING = "CHEAT_STRING";
    public static final boolean CHEAT = false;

    public static ArrayList<Integer> PREGUNTAS_SESION_INT = new ArrayList<>();
    public static ArrayList<String> PREGUNTAS_SESION_STRING = new ArrayList<>();
    public static ArrayList<Integer> PREGUNTAS_SESION_STATUS = new ArrayList<>();
    public static boolean[] PREGUNTAS_SESION_RESP = new boolean[PREGUNTAS_SESION_INT.size()];
    public static ArrayList<Integer> PREGUNTAS_SESION_DIFICULTAD = new ArrayList<>();
    public static ArrayList<Integer> PREGUNTAS_SESION_CATEGORIA = new ArrayList<>();
    public static boolean PARTIDA_CURSO = false;
    public static boolean PARTIDA_CONTINUADA = false;
    public static final int CHEAT_INT = 1;
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
        CheatsText = findViewById(R.id.cheat_text);
        EntretenimientoCheck = findViewById(R.id.entretenimiento_check);
        IdiomasCheck = findViewById(R.id.idiomas_check);
        MatematicasCheck = findViewById(R.id.matematicas_check);
        CienciasCheck = findViewById(R.id.ciencias_check);
        DeportesCheck = findViewById(R.id.deportes_check);
        CheatsSwitch = findViewById(R.id.cheat_switch);
        CheatsScroll = findViewById(R.id.num_cheats_scroll);
        PreguntaScroll = findViewById(R.id.num_preguntas_scroll);
        Facil = findViewById(R.id.facil_rb);
        ;
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
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 2 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 2) {
                        PreguntaScroll.setValue(count * 2);
                    }
                    PreguntaScroll.setMaxValue(count * 2);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        Medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dificil.setChecked(false);
                Facil.setChecked(false);
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 4 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 4) {
                        PreguntaScroll.setValue(count * 4);
                    }
                    PreguntaScroll.setMaxValue(count * 4);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        Dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facil.setChecked(false);
                Medio.setChecked(false);
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        HistoriaCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        GeografiaCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        ArteCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        DeportesCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        EntretenimientoCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        IdiomasCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        MatematicasCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        CienciasCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count * 5 == 0) {
                    PreguntaScroll.setValue(1);
                    PreguntaScroll.setMaxValue(1);
                } else {
                    if (PreguntaScroll.getValue() > count * 5) {
                        PreguntaScroll.setValue(count * 5);
                    }
                    PreguntaScroll.setMaxValue(count * 5);
                }
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });

        AtrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                if (GeografiaCheck.isChecked()) {
                    count++;
                }
                if (HistoriaCheck.isChecked()) {
                    count++;
                }
                if (ArteCheck.isChecked()) {
                    count++;
                }
                if (EntretenimientoCheck.isChecked()) {
                    count++;
                }
                if (IdiomasCheck.isChecked()) {
                    count++;
                }
                if (MatematicasCheck.isChecked()) {
                    count++;
                }
                if (CienciasCheck.isChecked()) {
                    count++;
                }
                if (DeportesCheck.isChecked()) {
                    count++;
                }
                if (count == 0) {
                    Toast.makeText(form_opciones.this,
                            "Tiene que haber al menos una categoría seleccionada para continuar.",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                Bundle parmetros = new Bundle();
                parmetros.putBoolean("cheat", CheatsSwitch.isChecked());
                parmetros.putInt("cheat_num", CheatsScroll.getValue());
                parmetros.putBoolean("historia", HistoriaCheck.isChecked());
                parmetros.putBoolean("geografia", GeografiaCheck.isChecked());
                parmetros.putBoolean("idiomas", IdiomasCheck.isChecked());
                parmetros.putBoolean("ciencias", CienciasCheck.isChecked());
                parmetros.putBoolean("deportes", DeportesCheck.isChecked());
                parmetros.putBoolean("entretenimiento", EntretenimientoCheck.isChecked());
                parmetros.putBoolean("matematicas", MatematicasCheck.isChecked());
                parmetros.putBoolean("arte", ArteCheck.isChecked());
                parmetros.putBoolean("partida_curso", PARTIDA_CURSO);
                parmetros.putBoolean("partida_continuada", PARTIDA_CONTINUADA);

                parmetros.putBooleanArray("preguntas_respuestas", PREGUNTAS_SESION_RESP);
                parmetros.putInt("preguntas_num", PreguntaScroll.getValue());
                if (Facil.isChecked()) {
                    parmetros.putInt("dificultad", 1);
                } else if (Medio.isChecked()) {
                    parmetros.putInt("dificultad", 2);
                } else if (Dificil.isChecked()) {
                    parmetros.putInt("dificultad", 3);
                } else {
                    parmetros.putInt("dificultad", 0);
                }
                Intent config = new Intent(form_opciones.this, MainActivity.class);
                config.putExtras(parmetros);
                config.putIntegerArrayListExtra("preguntas_int", PREGUNTAS_SESION_INT);
                config.putIntegerArrayListExtra("preguntas_categoria", PREGUNTAS_SESION_CATEGORIA);
                config.putIntegerArrayListExtra("preguntas_dificultad", PREGUNTAS_SESION_DIFICULTAD);
                config.putIntegerArrayListExtra("preguntas_status", PREGUNTAS_SESION_STATUS);
                config.putStringArrayListExtra("preguntas_string", PREGUNTAS_SESION_STRING);

                startActivity(config);
            }
        });
        CheatsSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheatsSwitch.isChecked()) {
                    CheatsScroll.setVisibility(View.VISIBLE);
                    CheatsText.setVisibility(View.VISIBLE);
                    CheatsScroll.setValue(1);
                } else {
                    CheatsScroll.setVisibility(View.INVISIBLE);
                    CheatsText.setVisibility(View.INVISIBLE);
                }
            }
        });

        PreguntaScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheatsScroll.getValue() > PreguntaScroll.getValue()) {
                    CheatsScroll.setValue(PreguntaScroll.getValue());
                }
                CheatsScroll.setMaxValue(PreguntaScroll.getValue());
            }
        });
        Bundle parametros = this.getIntent().getExtras();
        PARTIDA_CURSO = parametros.getBoolean("partida_curso");
        PARTIDA_CONTINUADA = parametros.getBoolean("partida_continuada");
        if (parametros != null) {

            CheatsSwitch.setChecked(parametros.getBoolean("cheat"));
            if (CheatsSwitch.isChecked()) {
                CheatsScroll.setVisibility(View.VISIBLE);
                CheatsText.setVisibility(View.VISIBLE);
                CheatsScroll.setValue(parametros.getInt("cheat_num"));
            } else {
                CheatsScroll.setVisibility(View.INVISIBLE);
                CheatsText.setVisibility(View.INVISIBLE);
                CheatsScroll.setValue(parametros.getInt("cheat_num"));

            }
            PreguntaScroll.setValue(parametros.getInt("preguntas_num"));
            int DIFICULTAD = parametros.getInt("dificultad");
            if (DIFICULTAD == 1) {
                Facil.setChecked(true);
                Medio.setChecked(false);
                Dificil.setChecked(false);
            } else if (DIFICULTAD == 2) {
                Facil.setChecked(false);
                Medio.setChecked(true);
                Dificil.setChecked(false);
            } else if (DIFICULTAD == 3) {
                Facil.setChecked(false);
                Medio.setChecked(false);
                Dificil.setChecked(true);
            } else {
                Facil.setChecked(false);
                Medio.setChecked(false);
                Dificil.setChecked(false);
            }
            HistoriaCheck.setChecked(parametros.getBoolean("historia"));
            GeografiaCheck.setChecked(parametros.getBoolean("geografia"));
            IdiomasCheck.setChecked(parametros.getBoolean("idiomas"));
            CienciasCheck.setChecked(parametros.getBoolean("ciencias"));
            DeportesCheck.setChecked(parametros.getBoolean("deportes"));
            EntretenimientoCheck.setChecked(parametros.getBoolean("entretenimiento"));
            MatematicasCheck.setChecked(parametros.getBoolean("matematicas"));
            ArteCheck.setChecked(parametros.getBoolean("arte"));

            if (HistoriaCheck.isChecked() && GeografiaCheck.isChecked() && IdiomasCheck.isChecked() && CienciasCheck.isChecked()
                    && DeportesCheck.isChecked() && EntretenimientoCheck.isChecked() && MatematicasCheck.isChecked() && ArteCheck.isChecked()) {
                TodosCheck.setChecked(true);
            }


        } else {

            Medio.setChecked(true);
            CheatsScroll.setVisibility(View.INVISIBLE);
            CheatsText.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("cheat", CheatsSwitch.isChecked());
        outState.putInt("cheat_num", CheatsScroll.getValue());

    }
}
