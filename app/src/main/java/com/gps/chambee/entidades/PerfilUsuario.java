package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class PerfilUsuario implements Parcelable {

    private int id;
    private String idUsuario;
    private long idPerfil;

    public PerfilUsuario(PerfilUsuarioBuilder builder) {
        this.id = builder.id;
        this.idUsuario = builder.idUsuario;
        this.idPerfil = builder.idPerfil;
    }

    protected PerfilUsuario(Parcel in) {
        id = in.readInt();
        idUsuario = in.readString();
        idPerfil = in.readLong();
    }

    public static final Creator<PerfilUsuario> CREATOR = new Creator<PerfilUsuario>() {
        @Override
        public PerfilUsuario createFromParcel(Parcel in) {
            return new PerfilUsuario(in);
        }

        @Override
        public PerfilUsuario[] newArray(int size) {
            return new PerfilUsuario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(idUsuario);
        dest.writeLong(idPerfil);
    }

    public static class PerfilUsuarioBuilder {
        private int id;
        private String idUsuario;
        private long idPerfil;

        public PerfilUsuarioBuilder() {
        }

        public PerfilUsuario build() {
            return new PerfilUsuario(this);
        }

        public PerfilUsuarioBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PerfilUsuarioBuilder setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public PerfilUsuarioBuilder setIdPerfil(long idPerfil) {
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }
}
