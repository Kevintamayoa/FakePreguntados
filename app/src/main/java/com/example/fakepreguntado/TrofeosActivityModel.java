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

    public void loadHonestScores(Usuario user) {
        if (highestHonestScores == null) {
            BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
            newUser = user;
            highestHonestScores = bancoDeUsuarios.getHonestUsers();
            if (!newUser.getCheatStatus()){highestHonestScores.add(newUser);}
            Collections.sort(highestHonestScores, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return Integer.compare(o2.getPuntajeMax(),o1.getPuntajeMax());
                }
            });
        }
    }

    public int getPlayersSize(int i){
        BancoDeUsuarios bancoDeUsuarios =new BancoDeUsuarios();
        return bancoDeUsuarios.getAllUsers().size()+i+1;
    }

    public String getHonestUserName(int i){
        return highestHonestScores.get(i).getName();
    }

    public void loadMixedScores(Usuario u1, Usuario u2, Usuario u3){
        if(highestMixedScores==null){
            BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
            highestMixedScores = bancoDeUsuarios.getMixedUsers(u1,u2,u3);
            if(newUser.getUserId()!=u1.getUserId()&&newUser.getUserId()!=u2.getUserId()&&newUser.getUserId()!=u3.getUserId()){
                highestMixedScores.add(newUser);
            }
            Collections.sort(highestMixedScores, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return Integer.compare(o2.getPuntajeMax(),o1.getPuntajeMax());
                }
            });
        }
    }
}
