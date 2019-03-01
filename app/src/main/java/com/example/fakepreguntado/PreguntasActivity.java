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
    public static boolean CHEAT=false;
    public static boolean PARTIDA_CURSO=false;
    public static boolean PARTIDA_CONTINUADA=false;
    public static  int CHEAT_NUM = 3;
    public static  int PREGUNTAS_NUM = 15;
    public static  int DIFICULTAD = 1;
    public static boolean Geografia=true;
    public static boolean Historia=true;
    public static boolean Arte=true;
    public static boolean Entretenimiento=true;
    public static boolean Idiomas=true;
    public static boolean Matematicas=true;
    public static boolean Ciencias=true;
    public static boolean Deportes=true;
    public  static ArrayList<Integer> PREGUNTAS_SESION_INT=new ArrayList<>();
    public  static List<Question> PREGUNTAS_SESION=new ArrayList<>();
    public  static ArrayList<String> PREGUNTAS_SESION_STRING=new ArrayList<>();
    public  static ArrayList<Integer> PREGUNTAS_SESION_STATUS=new ArrayList<>();
    public  static boolean[] PREGUNTAS_SESION_RESP = new boolean[PREGUNTAS_SESION_INT.size()];
    public  static ArrayList<Integer> PREGUNTAS_SESION_DIFICULTAD=new ArrayList<>();
    public  static ArrayList<Integer> PREGUNTAS_SESION_CATEGORIA=new ArrayList<>();

    TextView numPregunta;
    Button finPreguntas;
    Button cheatActivityButton;
    ImageButton pregAnteriorbtn;
    ImageButton pregSiguientebtn;
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
        finPreguntas = findViewById(R.id.endQuizz_btn);
        cheatActivityButton = findViewById(R.id.cheat_activity_button);
        pregAnteriorbtn = findViewById(R.id.ant_pregunta);
        pregSiguientebtn = findViewById(R.id.sig_pregunta);
        textoPregunta = findViewById(R.id.texto_pregunta);
        correctButton = findViewById(R.id.correct_button);
        incorrectButton = findViewById(R.id.incorrect_button);

        Bundle parametros = this.getIntent().getExtras();
        PARTIDA_CONTINUADA=parametros.getBoolean("partida_continuada");
        PARTIDA_CURSO=parametros.getBoolean("partida_curso");
            CHEAT = parametros.getBoolean("cheat");
            CHEAT_NUM=parametros.getInt("cheat_num");
            Historia=parametros.getBoolean("historia");
            Geografia=parametros.getBoolean("geografia");
            Idiomas=parametros.getBoolean("idiomas");
            Ciencias= parametros.getBoolean("ciencias");
            Deportes=parametros.getBoolean("deportes");
            Entretenimiento=parametros.getBoolean("entretenimiento");
            Matematicas=parametros.getBoolean("matematicas");
            Arte= parametros.getBoolean("arte");
            PREGUNTAS_NUM=parametros.getInt("preguntas_num");
            DIFICULTAD=  parametros.getInt("dificultad");

            PREGUNTAS_SESION_RESP=  parametros.getBooleanArray("preguntas_respuestas");
            PREGUNTAS_SESION_INT=parametros.getIntegerArrayList("preguntas_int")      ;
            PREGUNTAS_SESION_CATEGORIA=parametros.getIntegerArrayList("preguntas_categoria")      ;
            PREGUNTAS_SESION_DIFICULTAD=parametros.getIntegerArrayList("preguntas_dificultad")      ;
            PREGUNTAS_SESION_STATUS=parametros.getIntegerArrayList("preguntas_status")      ;
            PREGUNTAS_SESION_STRING=parametros.getStringArrayList("preguntas_string")      ;
            for(int i=0;i<PREGUNTAS_SESION_INT.size();i++){
                PREGUNTAS_SESION.add(new Question(PREGUNTAS_SESION_INT.get(i),PREGUNTAS_SESION_STRING.get(i),
                        PREGUNTAS_SESION_STATUS.get(i),PREGUNTAS_SESION_RESP[i],PREGUNTAS_SESION_DIFICULTAD.get(i),PREGUNTAS_SESION_CATEGORIA.get(i)));
            }

        preguntasActivityModel = ViewModelProviders.of(this).get(PreguntasActivityModel.class);
        preguntasActivityModel.loadGameQuestions(PREGUNTAS_SESION);
        preguntasActivityModel.loadNewUser();

        numPregunta.setText(preguntasActivityModel.getCurrentQuestionIndexText());

        finPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cheatActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntasActivityModel.PassCheatingStatus();
                Toast.makeText(PreguntasActivity.this,
                        "La respuesta correcta es "+
                                Boolean.toString(preguntasActivityModel.getCurrentQuestion().getAnswer()).toUpperCase(),
                        Toast.LENGTH_LONG).show();
            }
        });

        pregAnteriorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoPregunta.setText(preguntasActivityModel.getPreviousQuestion().getQuestion());
                numPregunta.setText(preguntasActivityModel.getCurrentQuestionIndexText());
            }
        });

        pregSiguientebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoPregunta.setText(preguntasActivityModel.getNextQuestion().getQuestion());
                numPregunta.setText(preguntasActivityModel.getCurrentQuestionIndexText());
            }
        });

        textoPregunta.setText(preguntasActivityModel.getCurrentQuestion().getQuestion());

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = preguntasActivityModel.getCurrentQuestion();
                if(question.getStatus()==0) {
                    if (question.getAnswer()) {
                        Toast.makeText(PreguntasActivity.this,
                                "¡¡CORRECTO!!",
                                Toast.LENGTH_SHORT).show();
                        preguntasActivityModel.setCurrentQuestionStatus(true);
                    }else{
                        Toast.makeText(PreguntasActivity.this,
                                "¡¡INCORRECTO!!",
                                Toast.LENGTH_SHORT).show();
                        preguntasActivityModel.setCurrentQuestionStatus(false);
                    }
                }else{
                    if (question.getStatus()==2) {
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡CORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡INCORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = preguntasActivityModel.getCurrentQuestion();
                if(question.getStatus()==0) {
                    if (!question.getAnswer()) {
                        Toast.makeText(PreguntasActivity.this,
                                "¡¡CORRECTO!!",
                                Toast.LENGTH_SHORT).show();
                        preguntasActivityModel.setCurrentQuestionStatus(true);
                    }else{
                        Toast.makeText(PreguntasActivity.this,
                                "¡¡INCORRECTO!!",
                                Toast.LENGTH_SHORT).show();
                        preguntasActivityModel.setCurrentQuestionStatus(false);
                    }
                }else{
                    if (question.getStatus()==2) {
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡CORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡INCORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
