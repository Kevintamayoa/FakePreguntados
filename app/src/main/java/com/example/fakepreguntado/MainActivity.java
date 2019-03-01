package com.example.fakepreguntado;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Config;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String CHEATED_FLAG_KEY = "CHEATED_FLAG_KEY";
    public static final String CHEAT_STRING="CHEAT_STRING";
    public static boolean CHEAT=false;
    public static  int CHEAT_INT = 1;
    public static  int CHEAT_NUM = 3;
    public static  int PREGUNTAS_NUM = 15;
    public static  int DIFICULTAD = 1;
    public static boolean Geografia=true;
    public static boolean Historia=true;
    public static boolean Arte=false;
    public static boolean Entretenimiento=false;
    public static boolean Idiomas=true;
    public static boolean Matematicas=false;
    public static boolean Ciencias=false;
    public static boolean Deportes=false;
    Button Configbtn;
    Button Playbtn;

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

        Playbtn=findViewById(R.id.jugar_btn);
        Playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(MainActivity.this,PreguntasActivity.class);
                startActivity(play);
            }
        });
         Bundle parametros = this.getIntent().getExtras();
         if (parametros != null) {
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
         }
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
