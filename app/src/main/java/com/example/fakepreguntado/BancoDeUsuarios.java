package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class BancoDeUsuarios {
    public List<Usuario> getAllUsers() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1,"AAA",20,false));
        usuarios.add(new Usuario(2,"ABA",15,true));
        usuarios.add(new Usuario(3,"ACA",10,false));
        usuarios.add(new Usuario(4,"ADA",21,true));
        usuarios.add(new Usuario(5,"AEA",3,true));
        usuarios.add(new Usuario(6,"AFA",2,false));
        usuarios.add(new Usuario(7,"AGA",1,false));
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
