package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Trabajo implements Parcelable {

    private String nombre;
    private int idCategoria;
    private int id;

    public Trabajo(TrabajoBuilder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.idCategoria = builder.idCategoria;
    }

    protected Trabajo(Parcel in) {
        nombre = in.readString();
        idCategoria = in.readInt();
        id = in.readInt();
    }

    public static final Creator<Trabajo> CREATOR = new Creator<Trabajo>() {
        @Override
        public Trabajo createFromParcel(Parcel in) {
            return new Trabajo(in);
        }

        @Override
        public Trabajo[] newArray(int size) {
            return new Trabajo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(idCategoria);
        dest.writeInt(id);
    }

    public static class TrabajoBuilder{
        private String nombre;
        private int idCategoria;
        private int id;

        public TrabajoBuilder() {
        }

        public Trabajo build(){
            return new Trabajo(this);
        }

        public TrabajoBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public TrabajoBuilder setIdCategoria(int idCategoria) {
            this.idCategoria = idCategoria;
            return this;
        }

        public TrabajoBuilder setId(int id) {
            this.id = id;
            return this;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
