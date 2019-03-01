package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TrofeosActivity extends AppCompatActivity {
    ImageView endTrophy;
    TextView primerLugar;
    TextView segundoLugar;
    TextView tercerLugar;
    TextView cuartoLugar;
    TextView quintoLugar;
    TextView sextoLugar;

    TrofeosActivityModel trofeosActivityModel;

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

        trofeosActivityModel = ViewModelProviders.of(this).get(TrofeosActivityModel.class);
        trofeosActivityModel.loadHonestScores("ABB",70,false);

        //endTrophy.setImageTintList();
        primerLugar.setText(primerLugar.getText()+trofeosActivityModel.highestHonestScores.get(0).getName());
        segundoLugar.setText(segundoLugar.getText()+trofeosActivityModel.highestHonestScores.get(1).getName());
        tercerLugar.setText(tercerLugar.getText()+trofeosActivityModel.highestHonestScores.get(2).getName());

        trofeosActivityModel.loadMixedScores(trofeosActivityModel.highestHonestScores.get(0),
                                             trofeosActivityModel.highestHonestScores.get(1),
                                             trofeosActivityModel.highestHonestScores.get(2));
        cuartoLugar.setText(cuartoLugar.getText()+trofeosActivityModel.highestMixedScores.get(0).getName());
        quintoLugar.setText(quintoLugar.getText()+trofeosActivityModel.highestMixedScores.get(1).getName());
        sextoLugar.setText(sextoLugar.getText()+trofeosActivityModel.highestMixedScores.get(2).getName());
    }
}
