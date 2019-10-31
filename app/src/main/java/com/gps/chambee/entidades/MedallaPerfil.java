package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigInteger;

public class MedallaPerfil implements Parcelable {
    private String idMedalla;
    private long idPerfil;
    private long id;

    public MedallaPerfil(MedallaPerfilBuilder builder){
        this.idMedalla = builder.idMedalla;
        this.idPerfil = builder.idPerfil;
        this.id = builder.id;
    }

    protected MedallaPerfil(Parcel in) {
        idMedalla = in.readString();
        idPerfil = in.readLong();
        id = in.readLong();
    }

    public static final Creator<MedallaPerfil> CREATOR = new Creator<MedallaPerfil>() {
        @Override
        public MedallaPerfil createFromParcel(Parcel in) {
            return new MedallaPerfil(in);
        }

        @Override
        public MedallaPerfil[] newArray(int size) {
            return new MedallaPerfil[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idMedalla);
        dest.writeLong(idPerfil);
        dest.writeLong(id);
    }

    public static class MedallaPerfilBuilder{
        private String idMedalla;
        private long idPerfil;
        private long id;

        public MedallaPerfilBuilder() {
        }

        public MedallaPerfil bulid(){
            return new MedallaPerfil(this);
        }

        public MedallaPerfilBuilder setIdMedalla(String idMedalla) {
            this.idMedalla = idMedalla;
            return this;
        }

        public MedallaPerfilBuilder setIdPerfil(long idPerfil) {
            this.idPerfil = idPerfil;
            return this;
        }

        public MedallaPerfilBuilder setId(long id) {
            this.id = id;
            return this;
        }
    }

    public String getIdMedalla() {
        return idMedalla;
    }

    public void setIdMedalla(String idMedalla) {
        this.idMedalla = idMedalla;
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}