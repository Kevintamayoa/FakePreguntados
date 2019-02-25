package com.example.fakepreguntado;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class trophies extends AppCompatActivity {

    ImageView endTrophy;
    TextView primerLugar;
    TextView segundoLugar;
    TextView tercerLugar;
    TextView cuartoLugar;
    TextView quintoLugar;
    TextView sextoLugar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophies);

        endTrophy = findViewById(R.id.image_trophies);
        primerLugar = findViewById(R.id.primer_lugar);
        segundoLugar = findViewById(R.id.segundo_lugar);
        tercerLugar = findViewById(R.id.tercer_lugar);
        cuartoLugar = findViewById(R.id.cuarto_lugar);
        quintoLugar = findViewById(R.id.quinto_lugar);
        sextoLugar = findViewById(R.id.sexto_lugar);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
