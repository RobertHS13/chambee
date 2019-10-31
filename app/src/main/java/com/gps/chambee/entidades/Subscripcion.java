package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Subscripcion implements Parcelable {

    private long id;
    private long idPerfil;
    private String fechaInicio;
    private String fechaFinal;
    private String fechaCancelancion;

    public Subscripcion(SubscripcionBuilder builder) {
        this.id = builder.id;
        this.idPerfil = builder.idPerfil;
        this.fechaInicio = builder.fechaInicio;
        this.fechaFinal = builder.fechaFinal;
        this.fechaCancelancion = builder.fechaCancelancion;
    }

    protected Subscripcion(Parcel in) {
        id = in.readLong();
        idPerfil = in.readLong();
        fechaInicio = in.readString();
        fechaFinal = in.readString();
        fechaCancelancion = in.readString();
    }

    public static final Creator<Subscripcion> CREATOR = new Creator<Subscripcion>() {
        @Override
        public Subscripcion createFromParcel(Parcel in) {
            return new Subscripcion(in);
        }

        @Override
        public Subscripcion[] newArray(int size) {
            return new Subscripcion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(idPerfil);
        dest.writeString(fechaInicio);
        dest.writeString(fechaFinal);
        dest.writeString(fechaCancelancion);
    }

    public static class SubscripcionBuilder {
        private long id;
        private long idPerfil;
        private String fechaInicio;
        private String fechaFinal;
        private String fechaCancelancion;

        public SubscripcionBuilder() { }

        public Subscripcion build(){
            return new Subscripcion(this);
        }

        public SubscripcionBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public SubscripcionBuilder setIdPerfil(long idPerfil) {
            this.idPerfil = idPerfil;
            return this;
        }

        public SubscripcionBuilder setFechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public SubscripcionBuilder setFechaFinal(String fechaFinal) {
            this.fechaFinal = fechaFinal;
            return this;
        }

        public SubscripcionBuilder setFechaCancelancion(String fechaCancelancion) {
            this.fechaCancelancion = fechaCancelancion;
            return this;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getFechaCancelancion() {
        return fechaCancelancion;
    }

    public void setFechaCancelancion(String fechaCancelancion) {
        this.fechaCancelancion = fechaCancelancion;
    }
}
