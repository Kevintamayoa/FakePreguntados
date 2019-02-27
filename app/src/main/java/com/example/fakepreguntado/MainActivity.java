package com.example.fakepreguntado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Configbtn;
    Button Playbtn;
    Button Trophiesbtn;
    Button Continuebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configbtn=findViewById(R.id.config_btn);
        Playbtn=findViewById(R.id.jugar_btn);
        Trophiesbtn = findViewById(R.id.puntajes_btn);
        Continuebtn = findViewById(R.id.continuar_btn);

        Configbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent config=new Intent(MainActivity.this,form_opciones.class);
                startActivity(config);
            }
        });

        Playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(MainActivity.this,PreguntasActivity.class);
                startActivity(play);
            }
        });

        Trophiesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TrofeosActivity.class);
                startActivity(intent);
            }
        });

        Continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
