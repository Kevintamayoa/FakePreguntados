package com.example.fakepreguntado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
                Intent config=new Intent(MainActivity.this,form_opciones.class);
                startActivity(config);
            }
        });

        Playbtn=findViewById(R.id.jugar_btn);
        Playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(MainActivity.this,PreguntasActivity.class);
                startActivity(play);
            }
        });
    }
}
