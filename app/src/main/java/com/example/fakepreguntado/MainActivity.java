package com.example.fakepreguntado;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Config;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static boolean CHEAT=false;
    public static boolean PARTIDA_CURSO=false;
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
    public  static ArrayList<String> PREGUNTAS_SESION_STRING=new ArrayList<>();
    public  static ArrayList<Integer> PREGUNTAS_SESION_STATUS=new ArrayList<>();
    public  static boolean[] PREGUNTAS_SESION_RESP = new boolean[PREGUNTAS_SESION_INT.size()];
    public  static ArrayList<Integer> PREGUNTAS_SESION_DIFICULTAD=new ArrayList<>();
    public  static ArrayList<Integer> PREGUNTAS_SESION_CATEGORIA=new ArrayList<>();
    Button Configbtn;
    Button Playbtn;
    Button Continuarbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configbtn=findViewById(R.id.config_btn);
  Configbtn.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
          Intent config = new Intent(MainActivity.this, form_opciones.class);
          Bundle parametros = new Bundle();
          parametros.putBoolean("cheat", CHEAT);
          parametros.putInt("cheat_num", CHEAT_NUM);
          parametros.putBoolean("historia", Historia);
          parametros.putBoolean("geografia", Geografia);
          parametros.putBoolean("idiomas", Idiomas);
          parametros.putBoolean("ciencias", Ciencias);
          parametros.putBoolean("deportes", Deportes);
          parametros.putBoolean("entretenimiento", Entretenimiento);
          parametros.putBoolean("matematicas", Matematicas);
          parametros.putBoolean("arte", Arte);
          parametros.putInt("preguntas_num",PREGUNTAS_NUM);
          parametros.putInt("dificultad", DIFICULTAD);
          config.putExtras(parametros);
          startActivity(config);
      }});
        Continuarbtn=findViewById(R.id.continuar_btn);
        Continuarbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent config = new Intent(MainActivity.this, form_opciones.class);
                Bundle parametros = new Bundle();
                parametros.putBoolean("cheat", CHEAT);
                parametros.putInt("cheat_num", CHEAT_NUM);
                parametros.putBoolean("historia", Historia);
                parametros.putBoolean("geografia", Geografia);
                parametros.putBoolean("idiomas", Idiomas);
                parametros.putBoolean("ciencias", Ciencias);
                parametros.putBoolean("deportes", Deportes);
                parametros.putBoolean("entretenimiento", Entretenimiento);
                parametros.putBoolean("matematicas", Matematicas);
                parametros.putBoolean("arte", Arte);
                parametros.putInt("preguntas_num",PREGUNTAS_NUM);
                parametros.putInt("dificultad", DIFICULTAD);
                config.putExtras(parametros);
                startActivity(config);
            }});

        Playbtn=findViewById(R.id.jugar_btn);
        Playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(PARTIDA_CURSO){
  AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
  dialogo1.setTitle("Importante");
  dialogo1.setMessage("¿Iniciar una nueva partida? se eliminarán los avances de la anterior.");
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
}else{
            BancoDePreguntas aux= new BancoDePreguntas();
            List<Integer> aux2=new ArrayList<>();
            if(Historia){
                aux2.add(0);
            }
            if(Geografia){
                aux2.add(1);
            }
            if(Idiomas){
                aux2.add(2);
            }
            if(Ciencias){
                aux2.add(3);
            }
            if(Deportes){
                aux2.add(4);
            }
            if(Entretenimiento){
                aux2.add(5);
            }
            if(Matematicas){
                aux2.add(6);
            }
            if(Arte){
                aux2.add(7);
            }
            List<Question> PREGUNTAS_SESION=aux.getQuestionsByParams(PREGUNTAS_NUM,DIFICULTAD,aux2);
            PREGUNTAS_SESION_INT.clear();
            PREGUNTAS_SESION_STRING.clear();
            PREGUNTAS_SESION_CATEGORIA.clear();
            PREGUNTAS_SESION_DIFICULTAD.clear();
            PREGUNTAS_SESION_STATUS.clear();
            PREGUNTAS_SESION_RESP=new boolean[PREGUNTAS_SESION.size()];
            for (int i=0;i<PREGUNTAS_SESION.size();i++){
                PREGUNTAS_SESION_INT.add(PREGUNTAS_SESION.get(i).getQuestionId());
                PREGUNTAS_SESION_STRING.add(PREGUNTAS_SESION.get(i).getQuestion());
                PREGUNTAS_SESION_CATEGORIA.add(PREGUNTAS_SESION.get(i).getCategory());
                PREGUNTAS_SESION_DIFICULTAD.add(PREGUNTAS_SESION.get(i).getDifficulty());
                PREGUNTAS_SESION_STATUS.add(PREGUNTAS_SESION.get(i).getStatus());
                PREGUNTAS_SESION_RESP[i]=PREGUNTAS_SESION.get(i).getAnswer();
            }
            PARTIDA_CURSO=true;
                Intent config = new Intent(MainActivity.this, PreguntasActivity.class);
                Bundle parametros = new Bundle();

                parametros.putBoolean("cheat", CHEAT);
                parametros.putInt("cheat_num", CHEAT_NUM);
                parametros.putBoolean("historia", Historia);
                parametros.putBoolean("geografia", Geografia);
                parametros.putBoolean("idiomas", Idiomas);
                parametros.putBoolean("ciencias", Ciencias);
                parametros.putBoolean("deportes", Deportes);
                parametros.putBoolean("entretenimiento", Entretenimiento);
                parametros.putBoolean("matematicas", Matematicas);
                parametros.putBoolean("arte", Arte);
                parametros.putInt("preguntas_num",PREGUNTAS_NUM);
                parametros.putInt("dificultad", DIFICULTAD);
              parametros.putBooleanArray("preguntas_respuestas",PREGUNTAS_SESION_RESP);
            parametros.putBoolean("partida_curso", PARTIDA_CURSO);
            config.putExtras(parametros);
             config.putIntegerArrayListExtra("preguntas_int",PREGUNTAS_SESION_INT);
             config.putIntegerArrayListExtra("preguntas_categoria",PREGUNTAS_SESION_CATEGORIA);
             config.putIntegerArrayListExtra("preguntas_dificultad",PREGUNTAS_SESION_DIFICULTAD);
             config.putIntegerArrayListExtra("preguntas_status",PREGUNTAS_SESION_STATUS);
             config.putStringArrayListExtra("preguntas_string",PREGUNTAS_SESION_STRING);

                startActivity(config);
            }}
        });
         Bundle parametros = this.getIntent().getExtras();
         if (parametros != null) {
         PARTIDA_CURSO=parametros.getBoolean("partida_curso");
        if(PARTIDA_CURSO){
            Continuarbtn.setVisibility(View.VISIBLE);
        }else{
            Continuarbtn.setVisibility(View.INVISIBLE);
        }
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
         }else{
             if(PARTIDA_CURSO){
                 Continuarbtn.setVisibility(View.VISIBLE);
             }else{
                 Continuarbtn.setVisibility(View.INVISIBLE);
             }
         }
    }
    public void aceptar() {
        BancoDePreguntas aux= new BancoDePreguntas();
        List<Integer> aux2=new ArrayList<>();
        if(Historia){
            aux2.add(0);
        }
        if(Geografia){
            aux2.add(1);
        }
        if(Idiomas){
            aux2.add(2);
        }
        if(Ciencias){
            aux2.add(3);
        }
        if(Deportes){
            aux2.add(4);
        }
        if(Entretenimiento){
            aux2.add(5);
        }
        if(Matematicas){
            aux2.add(6);
        }
        if(Arte){
            aux2.add(7);
        }
        List<Question> PREGUNTAS_SESION=aux.getQuestionsByParams(PREGUNTAS_NUM,DIFICULTAD,aux2);
        PREGUNTAS_SESION_INT.clear();
        PREGUNTAS_SESION_STRING.clear();
        PREGUNTAS_SESION_CATEGORIA.clear();
        PREGUNTAS_SESION_DIFICULTAD.clear();
        PREGUNTAS_SESION_STATUS.clear();
        PREGUNTAS_SESION_RESP=new boolean[PREGUNTAS_SESION.size()];
        for (int i=0;i<PREGUNTAS_SESION.size();i++){
            PREGUNTAS_SESION_INT.add(PREGUNTAS_SESION.get(i).getQuestionId());
            PREGUNTAS_SESION_STRING.add(PREGUNTAS_SESION.get(i).getQuestion());
            PREGUNTAS_SESION_CATEGORIA.add(PREGUNTAS_SESION.get(i).getCategory());
            PREGUNTAS_SESION_DIFICULTAD.add(PREGUNTAS_SESION.get(i).getDifficulty());
            PREGUNTAS_SESION_STATUS.add(PREGUNTAS_SESION.get(i).getStatus());
            PREGUNTAS_SESION_RESP[i]=PREGUNTAS_SESION.get(i).getAnswer();
        }
        PARTIDA_CURSO=true;
        Intent config = new Intent(MainActivity.this, PreguntasActivity.class);
        Bundle parametros = new Bundle();

        parametros.putBoolean("cheat", CHEAT);
        parametros.putInt("cheat_num", CHEAT_NUM);
        parametros.putBoolean("historia", Historia);
        parametros.putBoolean("geografia", Geografia);
        parametros.putBoolean("idiomas", Idiomas);
        parametros.putBoolean("ciencias", Ciencias);
        parametros.putBoolean("deportes", Deportes);
        parametros.putBoolean("entretenimiento", Entretenimiento);
        parametros.putBoolean("matematicas", Matematicas);
        parametros.putBoolean("arte", Arte);
        parametros.putInt("preguntas_num",PREGUNTAS_NUM);
        parametros.putInt("dificultad", DIFICULTAD);
        parametros.putBooleanArray("preguntas_respuestas",PREGUNTAS_SESION_RESP);
        parametros.putBoolean("partida_curso", PARTIDA_CURSO);
        config.putExtras(parametros);
        config.putIntegerArrayListExtra("preguntas_int",PREGUNTAS_SESION_INT);
        config.putIntegerArrayListExtra("preguntas_categoria",PREGUNTAS_SESION_CATEGORIA);
        config.putIntegerArrayListExtra("preguntas_dificultad",PREGUNTAS_SESION_DIFICULTAD);
        config.putIntegerArrayListExtra("preguntas_status",PREGUNTAS_SESION_STATUS);
        config.putStringArrayListExtra("preguntas_string",PREGUNTAS_SESION_STRING);

        startActivity(config);
    }


    @Override
 protected void onSaveInstanceState(Bundle outState) {
     super.onSaveInstanceState(outState);
 }
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      super.onActivityResult(requestCode, resultCode, data);

      switch (requestCode) {
          case form_opciones.CHEAT_INT:
              if (resultCode == RESULT_OK) {
                 //CHEAT data.getBundleExtra(CHEAT_STRING);
              } else if (resultCode == RESULT_CANCELED) {

              }
              break;

          default:
              // other activities...
              break;
      }
  }
}
