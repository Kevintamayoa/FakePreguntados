package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class BancoDeUsuarios {
    public List<Usuario> getAllUsers() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1,"AAA",89,false));
        usuarios.add(new Usuario(2,"ABA",85,true));
        usuarios.add(new Usuario(3,"ACA",65,false));
        usuarios.add(new Usuario(4,"ADA",61,true));
        usuarios.add(new Usuario(5,"AEA",68,true));
        usuarios.add(new Usuario(6,"AFA",80,false));
        usuarios.add(new Usuario(7,"AGA",84,false));
        return usuarios;
    }

    public List<Usuario> getHonestUsers(){
        List<Usuario> usuarios = new ArrayList<>();
        for (Usuario aux : getAllUsers()){
            if(!aux.getCheatStatus()){
                usuarios.add(aux);
            }
        }
        return usuarios;
    }

    public List<Usuario> getMixedUsers(Usuario u1, Usuario u2, Usuario u3){
        List<Usuario> usuarios = new ArrayList<>();
        for (Usuario aux : getAllUsers()){
            if(aux.getUserId()!=u1.getUserId()&&aux.getUserId()!=u2.getUserId()&&aux.getUserId()!=u3.getUserId()){
                usuarios.add(aux);
            }
        }
        return usuarios;
    }
}
