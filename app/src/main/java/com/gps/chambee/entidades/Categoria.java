package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Categoria implements Parcelable {

    private String nombre;
    private int id;

    public Categoria(CategoriaBuilder builder){
        this.nombre = builder.nombre;
        this.id = builder.id;
    }

    protected Categoria(Parcel in) {
        nombre = in.readString();
        id = in.readInt();
    }

    public static final Creator<Categoria> CREATOR = new Creator<Categoria>() {
        @Override
        public Categoria createFromParcel(Parcel in) {
            return new Categoria(in);
        }

        @Override
        public Categoria[] newArray(int size) {
            return new Categoria[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(id);
    }

    public static class CategoriaBuilder {
        private String nombre;
        private int id;

        public CategoriaBuilder() { }

        public CategoriaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public CategoriaBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public Categoria build(){
            return new Categoria(this);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

