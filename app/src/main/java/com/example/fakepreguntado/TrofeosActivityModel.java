package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrofeosActivityModel extends ViewModel {
    public List<Usuario> highestHonestScores;
    public List<Usuario> highestMixedScores;
    public Usuario newUser;

    public void loadHonestScores(String name, int points, boolean cheatState) {
        if (highestHonestScores == null) {
            BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
            newUser = new Usuario(bancoDeUsuarios.getAllUsers().size(), name, points, cheatState);
            highestHonestScores = bancoDeUsuarios.getHonestUsers();
            if (!cheatState){highestHonestScores.add(newUser);}
            Collections.sort(highestHonestScores, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return Integer.compare(o2.getPuntajeMax(),o1.getPuntajeMax());
                }
            });
        }
    }

    public void loadMixedScores(Usuario u1, Usuario u2, Usuario u3){
        if(highestMixedScores==null){
            BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
            highestMixedScores = bancoDeUsuarios.getMixedUsers(u1,u2,u3);
            Collections.sort(highestMixedScores, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return Integer.compare(o2.getPuntajeMax(),o1.getPuntajeMax());
                }
            });
        }
    }
}
