package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrofeosActivity extends AppCompatActivity {
    ImageView endTrophy;
    TextView primerLugar;
    TextView segundoLugar;
    TextView tercerLugar;
    TextView cuartoLugar;
    TextView quintoLugar;
    TextView sextoLugar;

    TrofeosActivityModel trofeosActivityModel;
    public final String JUGADORES = "JUGADORES";
    public final String PROSCEDENCES_ACTIVITY = "PROSCEDENCES_ACTIVITY";
    public final String CHEAT_STATE="user_cheater";
    public final String PUNTAJE_FINAL="PUNTAJE_FINAL";
    public ArrayList<Usuario> Jugadores;
    public Usuario JugadorActual;
    public String playerName = "";
    public int Puntaje = 0;
    public boolean Cheatstate = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophies);

        endTrophy = findViewById(R.id.image_trophies);
        primerLugar = findViewById(R.id.primer_lugar);
        segundoLugar = findViewById(R.id.segundo_lugar);
        tercerLugar = findViewById(R.id.tercer_lugar);
        cuartoLugar = findViewById(R.id.cuarto_lugar);
        quintoLugar = findViewById(R.id.quinto_lugar);
        sextoLugar = findViewById(R.id.sexto_lugar);

        final Bundle bundle = this.getIntent().getExtras();
        if (bundle.getBoolean(PROSCEDENCES_ACTIVITY)&&Jugadores==null) {
            trofeosActivityModel = ViewModelProviders.of(TrofeosActivity.this).get(TrofeosActivityModel.class);
            trofeosActivityModel.loadHonestScores(null);
            primerLugar.setText("1er Lugar: " + trofeosActivityModel.getHonestUserName(0));
            segundoLugar.setText("2do Lugar: " + trofeosActivityModel.getHonestUserName(1));
            tercerLugar.setText("3er Lugar: " + trofeosActivityModel.getHonestUserName(2));
            trofeosActivityModel.loadMixedScores(trofeosActivityModel.highestHonestScores.get(0),
                    trofeosActivityModel.highestHonestScores.get(1),
                    trofeosActivityModel.highestHonestScores.get(2));
            cuartoLugar.setText("4to Lugar: " + trofeosActivityModel.highestMixedScores.get(0).getName());
            quintoLugar.setText("5to Lugar: " + trofeosActivityModel.highestMixedScores.get(1).getName());
            sextoLugar.setText("6to Lugar: " + trofeosActivityModel.highestMixedScores.get(2).getName());

            if (trofeosActivityModel.highestMixedScores.get(0).getCheatStatus()) {
                cuartoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
            }
            if (trofeosActivityModel.highestMixedScores.get(1).getCheatStatus()) {
                quintoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
            }
            if (trofeosActivityModel.highestMixedScores.get(2).getCheatStatus()) {
                sextoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
            }
            if (Puntaje < 15) {
                endTrophy.setColorFilter(Color.rgb(153, 101, 21));
            } else if (Puntaje >= 15 && Puntaje < 30) {
                endTrophy.setColorFilter(Color.rgb(212, 175, 55));
            } else if (Puntaje >= 30 && Puntaje < 45) {
                endTrophy.setColorFilter(Color.rgb(197, 179, 88));
            } else if (Puntaje >= 45) {
                endTrophy.setColorFilter(Color.rgb(255, 215, 0));
            }
        } else if (bundle.getBoolean(PROSCEDENCES_ACTIVITY) && Jugadores!=null) {
            trofeosActivityModel = ViewModelProviders.of(TrofeosActivity.this).get(TrofeosActivityModel.class);
            Jugadores = bundle.getParcelableArrayList(JUGADORES);
            trofeosActivityModel.loadHonestScores(Jugadores);
            primerLugar.setText("1er Lugar: " + trofeosActivityModel.getHonestUserName(0));
            segundoLugar.setText("2do Lugar: " + trofeosActivityModel.getHonestUserName(1));
            tercerLugar.setText("3er Lugar: " + trofeosActivityModel.getHonestUserName(2));
            trofeosActivityModel.loadMixedScores(trofeosActivityModel.highestHonestScores.get(0),
                    trofeosActivityModel.highestHonestScores.get(1),
                    trofeosActivityModel.highestHonestScores.get(2));
            cuartoLugar.setText("4to Lugar: " + trofeosActivityModel.highestMixedScores.get(0).getName());
            quintoLugar.setText("5to Lugar: " + trofeosActivityModel.highestMixedScores.get(1).getName());
            sextoLugar.setText("6to Lugar: " + trofeosActivityModel.highestMixedScores.get(2).getName());
            if (trofeosActivityModel.highestMixedScores.get(0).getCheatStatus()) {
                cuartoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
            }
            if (trofeosActivityModel.highestMixedScores.get(1).getCheatStatus()) {
                quintoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
            }
            if (trofeosActivityModel.highestMixedScores.get(2).getCheatStatus()) {
                sextoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
            }
            if (Puntaje < 15) {
                endTrophy.setColorFilter(Color.rgb(153, 101, 21));
            } else if (Puntaje >= 15 && Puntaje < 30) {
                endTrophy.setColorFilter(Color.rgb(212, 175, 55));
            } else if (Puntaje >= 30 && Puntaje < 45) {
                endTrophy.setColorFilter(Color.rgb(197, 179, 88));
            } else if (Puntaje >= 45) {
                endTrophy.setColorFilter(Color.rgb(255, 215, 0));
            }
        } else {
            LinearLayout LL = new LinearLayout(TrofeosActivity.this);
            LL.setOrientation(LinearLayout.HORIZONTAL);
            final NumberPicker letras = new NumberPicker(TrofeosActivity.this);
            letras.setMaxValue(25);
            letras.setMinValue(0);
            letras.setDisplayedValues(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"
                    , "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});

            final NumberPicker letras2 = new NumberPicker(TrofeosActivity.this);
            letras2.setMaxValue(25);
            letras2.setMinValue(0);
            letras2.setDisplayedValues(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"
                    , "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});

            final NumberPicker letras3 = new NumberPicker(TrofeosActivity.this);
            letras3.setMaxValue(25);
            letras3.setMinValue(0);
            letras3.setDisplayedValues(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"
                    , "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 50);
            params.gravity = Gravity.CENTER;

            LinearLayout.LayoutParams letrasparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            letrasparams.weight = 1;
            LL.setLayoutParams(params);
            LL.addView(letras, letrasparams);
            LL.addView(letras2, letrasparams);
            LL.addView(letras3, letrasparams);

            AlertDialog.Builder nameChooser = new AlertDialog.Builder(TrofeosActivity.this);
            nameChooser.setTitle("JUGADOR");
            nameChooser.setMessage("Elige un nombre de 3 letras");
            nameChooser.setView(LL);
            nameChooser.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    trofeosActivityModel = ViewModelProviders.of(TrofeosActivity.this).get(TrofeosActivityModel.class);
                    playerName = passNameFromDialog(letras.getValue(), letras2.getValue(), letras3.getValue());
                    Jugadores=bundle.getParcelableArrayList(JUGADORES);
                    Puntaje = bundle.getInt(PUNTAJE_FINAL);
                    Bundle parametros = new Bundle();
                    Puntaje= parametros.getInt("puntaje");
                    Cheatstate = bundle.getBoolean(CHEAT_STATE);
                    if (savedInstanceState == null) {
                        Jugadores = new ArrayList<>();
                        JugadorActual = new Usuario(trofeosActivityModel.getPlayersSize(Jugadores.size()), playerName, Puntaje, Cheatstate);
                        Jugadores.add(JugadorActual);
                    } else {
                        JugadorActual = new Usuario(trofeosActivityModel.getPlayersSize(Jugadores.size()), playerName, Puntaje, Cheatstate);
                        Jugadores.add(JugadorActual);
                    }
                    trofeosActivityModel.loadHonestScores(Jugadores);
                    primerLugar.setText("1er Lugar: " + trofeosActivityModel.getHonestUserName(0));
                    segundoLugar.setText("2do Lugar: " + trofeosActivityModel.getHonestUserName(1));
                    tercerLugar.setText("3er Lugar: " + trofeosActivityModel.getHonestUserName(2));
                    trofeosActivityModel.loadMixedScores(trofeosActivityModel.highestHonestScores.get(0),
                            trofeosActivityModel.highestHonestScores.get(1),
                            trofeosActivityModel.highestHonestScores.get(2));
                    cuartoLugar.setText("4to Lugar: " + trofeosActivityModel.highestMixedScores.get(0).getName());
                    quintoLugar.setText("5to Lugar: " + trofeosActivityModel.highestMixedScores.get(1).getName());
                    sextoLugar.setText("6to Lugar: " + trofeosActivityModel.highestMixedScores.get(2).getName());
                    if (trofeosActivityModel.highestMixedScores.get(0).getCheatStatus()) {
                        cuartoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
                    }
                    if (trofeosActivityModel.highestMixedScores.get(1).getCheatStatus()) {
                        quintoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
                    }
                    if (trofeosActivityModel.highestMixedScores.get(2).getCheatStatus()) {
                        sextoLugar.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_cheater_24dp, 0);
                    }
                    if (Puntaje < 15) {
                        endTrophy.setColorFilter(Color.rgb(153, 101, 21));
                    } else if (Puntaje >= 15 && Puntaje < 30) {
                        endTrophy.setColorFilter(Color.rgb(212, 175, 55));
                    } else if (Puntaje >= 30 && Puntaje < 45) {
                        endTrophy.setColorFilter(Color.rgb(197, 179, 88));
                    } else if (Puntaje >= 45) {
                        endTrophy.setColorFilter(Color.rgb(255, 215, 0));
                    }
                }
            });
            nameChooser.show();
            endTrophy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TrofeosActivity.this,
                            "Tu Puntaje final fue "+Puntaje+" puntos",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent Mainmenu = new Intent(TrofeosActivity.this,MainActivity.class);
        Bundle Param = new Bundle();
        Param.putParcelableArrayList(JUGADORES,Jugadores);
        startActivity(Mainmenu);
    }

    public String passNameFromDialog(int s1, int s2, int s3) {
        return Character.toString((char) (s1 + 65)) + Character.toString((char) (s2 + 65)) + Character.toString((char) (s3 + 65));
    }
}


