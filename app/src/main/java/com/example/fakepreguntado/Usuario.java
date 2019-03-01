package com.example.fakepreguntado;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private int id;
    private String name;
    private int puntajeMax;
    private boolean cheat;

    public Usuario(int id, String name, int puntajeMax, boolean cheat) {
        this.id = id;
        this.name = name;
        this.puntajeMax = puntajeMax;
        this.cheat = cheat;
    }

    protected Usuario(Parcel in) {
        id=in.readInt();
        name=in.readString();
        puntajeMax=in.readInt();
        cheat=in.readInt()==1;
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }
        public Usuario[] newArray(int size) {

            return new Usuario[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(puntajeMax);
        dest.writeInt(cheat?1:0);
    }


    public int getUserId() {
        return id;
    }

    public void setUserId(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String nam) {
        name = nam;
    }

    public int getPuntajeMax() {
        return puntajeMax;
    }

    public void setPuntajeMax(int puntaje) {
        puntajeMax = puntaje;
    }

    public void setCheatingStatus() {
        cheat = true;
    }

    public boolean getCheatStatus() {
        return cheat;
    }

}
