package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;


public class PreguntasActivity extends AppCompatActivity {
    public static boolean CHEAT=false;
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
    public static boolean USER_CHEATER=false;
    public static  int CHEAT_COUNT = 0;
    TextView auxPregunta;
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
        auxPregunta=findViewById(R.id.texto_pregunta_respondida);
        numPregunta = findViewById(R.id.num_pregunta);
        finPreguntas = findViewById(R.id.endQuizz_btn);
        cheatActivityButton = findViewById(R.id.cheat_activity_button);
        pregAnteriorbtn = findViewById(R.id.ant_pregunta);
        pregSiguientebtn = findViewById(R.id.sig_pregunta);
        textoPregunta = findViewById(R.id.texto_pregunta);
        correctButton = findViewById(R.id.correct_button);
        incorrectButton = findViewById(R.id.incorrect_button);

        Bundle parametros = this.getIntent().getExtras();
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
            if(!CHEAT)
            {
                cheatActivityButton.setVisibility(View.INVISIBLE);
            }
        List<Integer> aux2 = new ArrayList<>();
        if (Historia) {
            aux2.add(0);
        }
        if (Geografia) {
            aux2.add(1);
        }
        if (Idiomas) {
            aux2.add(2);
        }
        if (Ciencias) {
            aux2.add(3);
        }
        if (Deportes) {
            aux2.add(4);
        }
        if (Entretenimiento) {
            aux2.add(5);
        }
        if (Matematicas) {
            aux2.add(6);
        }
        if (Arte) {
            aux2.add(7);
        }

        preguntasActivityModel = ViewModelProviders.of(this).get(PreguntasActivityModel.class);
        preguntasActivityModel.loadGameQuestions(PREGUNTAS_NUM,DIFICULTAD,aux2);
        CHEAT_COUNT=0;
       int as=CHEAT_NUM-CHEAT_COUNT;
        cheatActivityButton.setText("Cheat: "+as);
        numPregunta.setText(preguntasActivityModel.getCurrentQuestionIndexText());

        finPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean as=false;
                String aux="";

                if(as){
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(PreguntasActivity.this);
                    dialogo1.setTitle("Importante");
                    dialogo1.setMessage("¿Terminar partida? No se respondieron las preguntas :"+aux+" y se marcarán como incorrectas.");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            aceptar2();
                        }
                    });
                    dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            finish();
                        }
                    });
                    dialogo1.show();
                }else{
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(PreguntasActivity.this);
                    dialogo1.setTitle("Importante");
                    dialogo1.setMessage("¿Terminar partida?");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {

                            aceptar();
                        }
                    });
                    dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            finish();
                        }
                    });
                    dialogo1.show();
                }


            }
        });
        Question question = preguntasActivityModel.getCurrentQuestion();
        String res="";
        if(question.getAnswer()){
            res="VERDADERO";
        }else{
            res="FALSO";
        }
        if (question.getStatus()==2) {
            auxPregunta.setText("ACERTASTE!! :) , RESPONDISTE "+res);
        }else  if (question.getStatus()==1){
            auxPregunta.setText("TE EQUIVOCASTE AQUÍ :'(, RESPONDISTE "+res);
        }else{
            auxPregunta.setText("");
        }
        cheatActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CHEAT_NUM-CHEAT_COUNT>0){
                    CHEAT_COUNT++;
                    int as=CHEAT_NUM-CHEAT_COUNT;
                    USER_CHEATER= true;
                    cheatActivityButton.setText("Cheat: "+as);
                    String res="";

                    //   preguntasActivityModel.PassCheatingStatus();
                    if(preguntasActivityModel.getCurrentQuestion().getAnswer()){
                        res="VERDADERO";
                    }else{
                        res="FALSO";
                    }
                Toast.makeText(PreguntasActivity.this,
                        "La respuesta correcta es "+res,
                        Toast.LENGTH_SHORT).show();
            }}
        });

        pregAnteriorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoPregunta.setText(preguntasActivityModel.getPreviousQuestion().getQuestion());
                numPregunta.setText(preguntasActivityModel.getCurrentQuestionIndexText());
                Question question = preguntasActivityModel.getCurrentQuestion();

                String res="";
                if(question.getAnswer()){
                    res="VERDADERO";
                }else{
                    res="FALSO";
                }
                if (question.getStatus()==2) {
                    auxPregunta.setText("ACERTASTE!! :) , RESPONDISTE "+res);
                }else  if (question.getStatus()==1){
                    auxPregunta.setText(":(, RESPONDISTE "+res);
                }else{
                    auxPregunta.setText("");
                }
            }
        });

        pregSiguientebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoPregunta.setText(preguntasActivityModel.getNextQuestion().getQuestion());
                numPregunta.setText(preguntasActivityModel.getCurrentQuestionIndexText());
                Question question = preguntasActivityModel.getCurrentQuestion();
                String res="";
if(question.getAnswer()){
    res="VERDADERO";
}else{
    res="FALSO";
}
                if (question.getStatus()==2) {
                    auxPregunta.setText("ACERTASTE!! :) , RESPONDISTE "+res);
                }else  if (question.getStatus()==1){
                    auxPregunta.setText("TE EQUIVOCASTE AQUÍ :'(, RESPONDISTE "+res);
                }else{
                    auxPregunta.setText("");
                }
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
                        auxPregunta.setText("ACERTASTE!! :) , RESPONDISTE: VERDADERO");
                          }else{
                        Toast.makeText(PreguntasActivity.this,
                                "¡¡INCORRECTO!!",
                                Toast.LENGTH_SHORT).show();
                        preguntasActivityModel.setCurrentQuestionStatus(false);
                        auxPregunta.setText("TE EQUIVOCASTE AQUÍ :'(, RESPONDISTE: VERDADERO");

                    }
                }else{
                   if (question.getStatus()==2) {
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡CORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                       auxPregunta.setText("ACERTASTE!! :) , RESPONDISTE: VERDADERO");
                    }else{
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡INCORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                       auxPregunta.setText("TE EQUIVOCASTE AQUÍ :'(, RESPONDISTE: VERDADERO");

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
         auxPregunta.setText("ACERTASTE!! :) , RESPONDISTE: FALSO");

                    }else{
                        Toast.makeText(PreguntasActivity.this,
                                "¡¡INCORRECTO!!",
                                Toast.LENGTH_SHORT).show();
                        preguntasActivityModel.setCurrentQuestionStatus(false);
                        auxPregunta.setText("TE EQUIVOCASTE AQUÍ :'(, RESPONDISTE: FALSO");
   }
                }else{
                    if (question.getStatus()==2) {
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡CORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                        auxPregunta.setText("ACERTASTE!! :) , RESPONDISTE: FALSO");

                    }else{
                        Toast.makeText(PreguntasActivity.this,
                                "La pregunta ya fue contestada y fue ¡¡INCORRECTA!!",
                                Toast.LENGTH_SHORT).show();
                        auxPregunta.setText("TE EQUIVOCASTE AQUÍ :'(, RESPONDISTE: FALSO");

                    }
                }
            }
        });


    }
    public void aceptar() {
        Bundle parmetros = new Bundle();
        parmetros.putBoolean("cheat", CHEAT);
        parmetros.putInt("cheat_num", CHEAT_NUM);
        parmetros.putBoolean("historia", Historia);
        parmetros.putBoolean("geografia", Geografia);
        parmetros.putBoolean("idiomas", Idiomas);
        parmetros.putBoolean("ciencias", Ciencias);
        parmetros.putBoolean("deportes", Deportes);
        parmetros.putBoolean("entretenimiento", Entretenimiento);
        parmetros.putBoolean("matematicas", Matematicas);
        parmetros.putBoolean("arte", Arte);
       parmetros.putBoolean("user_cheater", USER_CHEATER);
        parmetros.putBoolean("PROSCEDENCES_ACTIVITY",false);
        parmetros.putInt("preguntas_num", PREGUNTAS_NUM);
        parmetros.putInt("dificultad", DIFICULTAD);
        PreguntasActivityModel aux=new PreguntasActivityModel();
        parmetros.putInt("puntaje", aux.GetPuntajeTotal());
        Intent config=new Intent(PreguntasActivity.this,TrofeosActivity.class);
        config.putExtras(parmetros);
        startActivity(config);
    }
    public void aceptar2() {
        Bundle parmetros = new Bundle();
        parmetros.putBoolean("cheat", CHEAT);
        parmetros.putInt("cheat_num", CHEAT_NUM);
        parmetros.putBoolean("historia", Historia);
        parmetros.putBoolean("geografia", Geografia);
        parmetros.putBoolean("idiomas", Idiomas);
        parmetros.putBoolean("ciencias", Ciencias);
        parmetros.putBoolean("deportes", Deportes);
        parmetros.putBoolean("entretenimiento", Entretenimiento);
        parmetros.putBoolean("matematicas", Matematicas);
        parmetros.putBoolean("arte", Arte);
        parmetros.putBoolean("user_cheater", USER_CHEATER);
        parmetros.putBoolean("PROSCEDENCES_ACTIVITY",false);
        parmetros.putInt("preguntas_num", PREGUNTAS_NUM);
        parmetros.putInt("dificultad", DIFICULTAD);
        PreguntasActivityModel aux=new PreguntasActivityModel();
        parmetros.putInt("puntaje", aux.GetPuntajeTotal());
        Intent config=new Intent(PreguntasActivity.this,TrofeosActivity.class);
        config.putExtras(parmetros);
        startActivity(config);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
