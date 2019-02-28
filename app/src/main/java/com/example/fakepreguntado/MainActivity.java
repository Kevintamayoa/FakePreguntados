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
