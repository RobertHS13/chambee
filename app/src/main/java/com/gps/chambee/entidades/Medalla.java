package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Medalla implements Parcelable {

    private String nombre;
    private String urlMedalla;
    private String descripcion;
    private int id;

    public Medalla(MedallaBuilder builder) {
        this.nombre = builder.nombre;
        this.urlMedalla = builder.urlMedalla;
        this.descripcion = builder.descripcion;
        this.id = builder.id;
    }

    public static class MedallaBuilder{
        private String nombre;
        private String urlMedalla;
        private String descripcion;
        private int id;

        public MedallaBuilder() { }

        public Medalla build(){
            return new Medalla(this);
        }

        public MedallaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public MedallaBuilder setUrlMedalla(String urlMedalla) {
            this.urlMedalla = urlMedalla;
            return this;
        }

        public MedallaBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public MedallaBuilder setId(int id) {
            this.id = id;
            return this;
        }
    }

    protected Medalla(Parcel in) {
        nombre = in.readString();
        urlMedalla = in.readString();
        descripcion = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(urlMedalla);
        dest.writeString(descripcion);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Medalla> CREATOR = new Creator<Medalla>() {
        @Override
        public Medalla createFromParcel(Parcel in) {
            return new Medalla(in);
        }

        @Override
        public Medalla[] newArray(int size) {
            return new Medalla[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlMedalla() {
        return urlMedalla;
    }

    public void setUrlMedalla(String urlMedalla) {
        this.urlMedalla = urlMedalla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
