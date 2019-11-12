package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class ComentarioPublicacion implements Parcelable {
    private long idPerfil;
    private String comentario;
    private String fecha;
    private long idPublicacion;
    private int id;

    public ComentarioPublicacion(ComentarioPublicacionBuilder builder) {
        this.idPerfil = builder.idPerfil;
        this.comentario = builder.comentario;
        this.fecha = builder.fecha;
        this.idPublicacion = builder.idPublicacion;
        this.id = builder.id;
    }

    protected ComentarioPublicacion(Parcel in) {
        idPerfil = in.readLong();
        comentario = in.readString();
        fecha = in.readString();
        idPublicacion = in.readLong();
        id = in.readInt();
    }

    public static final Creator<ComentarioPublicacion> CREATOR = new Creator<ComentarioPublicacion>() {
        @Override
        public ComentarioPublicacion createFromParcel(Parcel in) {
            return new ComentarioPublicacion(in);
        }

        @Override
        public ComentarioPublicacion[] newArray(int size) {
            return new ComentarioPublicacion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idPerfil);
        dest.writeString(comentario);
        dest.writeString(fecha);
        dest.writeLong(idPublicacion);
        dest.writeInt(id);
    }

    public static class ComentarioPublicacionBuilder {
        private long idPerfil;
        private String comentario;
        private String fecha;
        private long idPublicacion;
        private int id;

        public ComentarioPublicacionBuilder() {  }

        public ComentarioPublicacion build() {
            return new ComentarioPublicacion(this);
        }

        public ComentarioPublicacionBuilder setIdPerfil(long idPerfil) {
            this.idPerfil = idPerfil;
            return this;
        }

        public ComentarioPublicacionBuilder setComentario(String comentario) {
            this.comentario = comentario;
            return this;
        }

        public ComentarioPublicacionBuilder setFecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public ComentarioPublicacionBuilder setIdPublicacion(long idPublicacion) {
            this.idPublicacion = idPublicacion;
            return this;
        }

        public ComentarioPublicacionBuilder setId(int id) {
            this.id = id;
            return this;
        }
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}