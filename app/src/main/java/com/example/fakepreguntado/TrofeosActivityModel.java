package com.example.fakepreguntado;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrofeosActivityModel extends ViewModel {

    public void setPlayer(List<Usuario> player) {
        Player = player;
    }

    public List<Usuario> getPlayer() {
        return Player;
    }

    public List<Usuario> Player;

    public List<Usuario> highestHonestScores;
    public List<Usuario> highestMixedScores;
    public List<Usuario> newUsers;

    public void loadHonestScores(List<Usuario> auxuser) {
        if (highestHonestScores == null) {
            BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
            highestHonestScores = bancoDeUsuarios.getHonestUsers();
            if (auxuser != null) {
                newUsers = auxuser;
                for (Usuario aux : auxuser) {
                    if (!aux.getCheatStatus()) {
                        highestHonestScores.add(aux);
                    }
                }
            }
            Collections.sort(highestHonestScores, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return Integer.compare(o2.getPuntajeMax(), o1.getPuntajeMax());
                }
            });
        }
    }

    public int getPlayersSize(int i) {
        BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
        return bancoDeUsuarios.getAllUsers().size() + i + 1;
    }

    public String getHonestUserName(int i) {
        return highestHonestScores.get(i).getName();
    }
    public String getHonestPunt(int i) {
        return highestHonestScores.get(i).getPuntajeMax()+"";
    }

    public void loadMixedScores(Usuario u1, Usuario u2, Usuario u3) {
        if (highestMixedScores == null) {
            BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
            highestMixedScores = bancoDeUsuarios.getMixedUsers(u1, u2, u3);
            if (newUsers != null) {
                for (Usuario aux : newUsers) {
                    if (aux.getUserId() != u1.getUserId() && aux.getUserId() != u2.getUserId() && aux.getUserId() != u3.getUserId()) {
                        highestMixedScores.add(aux);
                    }
                }
            }
            Collections.sort(highestMixedScores, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return Integer.compare(o2.getPuntajeMax(), o1.getPuntajeMax());
                }
            });
        }
    }
}
