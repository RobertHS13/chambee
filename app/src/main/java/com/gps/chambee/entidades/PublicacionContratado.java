package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class PublicacionContratado implements Parcelable {

    private long idPerfil;
    private long idPublicacion;
    private String fechaAceptacion;
    private String fechaCompletado;
    private String fechaCancelacion;
    private boolean estado;

    public PublicacionContratado(PublicacionContratadoBuilder builder) {
        this.idPerfil = builder.idPerfil;
        this.idPublicacion = builder.idPublicacion;
        this.fechaAceptacion = builder.fechaAceptacion;
        this.fechaCompletado = builder.fechaCompletado;
        this.fechaCancelacion = builder.fechaCancelacion;
        this.estado = builder.estado;
    }

    protected PublicacionContratado(Parcel in) {
        idPerfil = in.readLong();
        idPublicacion = in.readLong();
        fechaAceptacion = in.readString();
        fechaCompletado = in.readString();
        fechaCancelacion = in.readString();
        estado = in.readByte() != 0;
    }

    public static final Creator<PublicacionContratado> CREATOR = new Creator<PublicacionContratado>() {
        @Override
        public PublicacionContratado createFromParcel(Parcel in) {
            return new PublicacionContratado(in);
        }

        @Override
        public PublicacionContratado[] newArray(int size) {
            return new PublicacionContratado[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idPerfil);
        dest.writeLong(idPublicacion);
        dest.writeString(fechaAceptacion);
        dest.writeString(fechaCompletado);
        dest.writeString(fechaCancelacion);
        dest.writeByte((byte) (estado ? 1 : 0));
    }

    public static class PublicacionContratadoBuilder{
        private long idPerfil;
        private long idPublicacion;
        private String fechaAceptacion;
        private String fechaCompletado;
        private String fechaCancelacion;
        private boolean estado;

        public PublicacionContratadoBuilder() { }

        public PublicacionContratado build(){
            return new PublicacionContratado(this);
        }

        public PublicacionContratadoBuilder setIdPerfil(long idPerfil) {
            this.idPerfil = idPerfil;
            return this;
        }

        public PublicacionContratadoBuilder setIdPublicacion(long idPublicacion) {
            this.idPublicacion = idPublicacion;
            return this;
        }

        public PublicacionContratadoBuilder setFechaAceptacion(String fechaAceptacion) {
            this.fechaAceptacion = fechaAceptacion;
            return this;
        }

        public PublicacionContratadoBuilder setFechaCompletado(String fechaCompletado) {
            this.fechaCompletado = fechaCompletado;
            return this;
        }

        public PublicacionContratadoBuilder setFechaCancelacion(String fechaCancelacion) {
            this.fechaCancelacion = fechaCancelacion;
            return this;
        }

        public PublicacionContratadoBuilder setEstado(boolean estado) {
            this.estado = estado;
            return this;
        }
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(String fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public String getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(String fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
