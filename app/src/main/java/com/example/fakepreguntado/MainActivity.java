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
    Button Configbtn;
    Button Playbtn;
    Button Trophiesbtn;
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
        Trophiesbtn=findViewById(R.id.puntajes_btn);
        Trophiesbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent config = new Intent(MainActivity.this, TrofeosActivity.class);
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
                parametros.putBoolean("PROSCEDENCES_ACTIVITY",true);
                config.putExtras(parametros);
                startActivity(config);
            }});
        Playbtn=findViewById(R.id.jugar_btn);
        Playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoDePreguntas aux = new BancoDePreguntas();
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
                parametros.putInt("preguntas_num", PREGUNTAS_NUM);
                parametros.putInt("dificultad", DIFICULTAD);
                config.putExtras(parametros);

                startActivity(config);
            }}
        );
         Bundle parametros = this.getIntent().getExtras();
         if (parametros != null)

    {

        CHEAT = parametros.getBoolean("cheat");
        CHEAT_NUM = parametros.getInt("cheat_num");
        Historia = parametros.getBoolean("historia");
        Geografia = parametros.getBoolean("geografia");
        Idiomas = parametros.getBoolean("idiomas");
        Ciencias = parametros.getBoolean("ciencias");
        Deportes = parametros.getBoolean("deportes");
        Entretenimiento = parametros.getBoolean("entretenimiento");
        Matematicas = parametros.getBoolean("matematicas");
        Arte = parametros.getBoolean("arte");
        PREGUNTAS_NUM = parametros.getInt("preguntas_num");
        DIFICULTAD = parametros.getInt("dificultad");
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
        config.putExtras(parametros);

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
