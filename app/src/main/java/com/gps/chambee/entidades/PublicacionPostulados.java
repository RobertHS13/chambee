package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class PublicacionPostulados implements Parcelable {

    private int id;
    private int idPublicacion;
    private int idPerfil;

    public PublicacionPostulados(PublicacionPostuladosBuilder builder) {
        this.id = builder.id;
        this.idPublicacion = builder.idPublicacion;
        this.idPerfil = builder.idPerfil;
    }

    protected PublicacionPostulados(Parcel in) {
        id = in.readInt();
        idPublicacion = in.readInt();
        idPerfil = in.readInt();
    }

    public static final Creator<PublicacionPostulados> CREATOR = new Creator<PublicacionPostulados>() {
        @Override
        public PublicacionPostulados createFromParcel(Parcel in) {
            return new PublicacionPostulados(in);
        }

        @Override
        public PublicacionPostulados[] newArray(int size) {
            return new PublicacionPostulados[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(idPublicacion);
        dest.writeInt(idPerfil);
    }

    public static class PublicacionPostuladosBuilder{
        private int id;
        private int idPublicacion;
        private int idPerfil;

        public PublicacionPostuladosBuilder() { }

        public PublicacionPostulados build(){
            return new PublicacionPostulados(this);
        }

        public PublicacionPostuladosBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PublicacionPostuladosBuilder setIdPublicacion(int idPublicacion) {
            this.idPublicacion = idPublicacion;
            return this;
        }

        public PublicacionPostuladosBuilder setIdPerfil(int idPerfil) {
            this.idPerfil = idPerfil;
            return this;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
}
