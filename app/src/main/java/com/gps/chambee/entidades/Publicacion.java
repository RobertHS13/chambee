package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Publicacion implements Parcelable {

    private String urlDescriptiva;
    private String titulo;
    private String descripcion;
    private float pagoMaximo;
    private float pagoMinimo;
    private String tiempo;
    private long idPerfil;
    private boolean estado;
    private int vistas;
    private int meInteresa;
    private String fecha;
    private int id;

    public Publicacion(PublicacionBuilder builder){
        this.urlDescriptiva = builder.urlDescriptiva;
        this.titulo = builder.titulo;
        this.descripcion = builder.descripcion;
        this.pagoMaximo = builder.pagoMaximo;
        this.pagoMinimo = builder.pagoMinimo;
        this.tiempo = builder.tiempo;
        this.idPerfil = builder.idPerfil;
        this.estado = builder.estado;
        this.vistas = builder.vistas;
        this.meInteresa = builder.meInteresa;
        this.fecha = builder.fecha;

    }

    protected Publicacion(Parcel in) {
        urlDescriptiva = in.readString();
        titulo = in.readString();
        descripcion = in.readString();
        pagoMaximo = in.readFloat();
        pagoMinimo = in.readFloat();
        tiempo = in.readString();
        idPerfil = in.readLong();
        estado = in.readByte() != 0;
        vistas = in.readInt();
        meInteresa = in.readInt();
        fecha = in.readString();
    }

    public static final Creator<Publicacion> CREATOR = new Creator<Publicacion>() {
        @Override
        public Publicacion createFromParcel(Parcel in) {
            return new Publicacion(in);
        }

        @Override
        public Publicacion[] newArray(int size) {
            return new Publicacion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlDescriptiva);
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeFloat(pagoMaximo);
        dest.writeFloat(pagoMinimo);
        dest.writeString(tiempo);
        dest.writeLong(idPerfil);
        dest.writeByte((byte) (estado ? 1 : 0));
        dest.writeInt(vistas);
        dest.writeInt(meInteresa);
        dest.writeString(fecha);
    }

    public static class PublicacionBuilder{
        private String urlDescriptiva;
        private String titulo;
        private String descripcion;
        private float pagoMaximo;
        private float pagoMinimo;
        private String tiempo;
        private long idPerfil;
        private boolean estado;
        private int vistas;
        private int meInteresa;
        private String fecha;

        public PublicacionBuilder() { }

        public PublicacionBuilder setUrlDescriptiva(String urlDescriptiva) {
            this.urlDescriptiva = urlDescriptiva;
            return this;
        }

        public PublicacionBuilder setTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public PublicacionBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public PublicacionBuilder setPagoMaximo(float pagoMaximo) {
            this.pagoMaximo = pagoMaximo;
            return this;
        }

        public PublicacionBuilder setPagoMinimo(float pagoMinimo) {
            this.pagoMinimo = pagoMinimo;
            return this;
        }

        public PublicacionBuilder setTiempo(String tiempo) {
            this.tiempo = tiempo;
            return this;
        }

        public PublicacionBuilder setIdPerfil(long idPerfil) {
            this.idPerfil = idPerfil;
            return this;
        }

        public PublicacionBuilder setEstado(boolean estado) {
            this.estado = estado;
            return this;
        }

        public PublicacionBuilder setVistas(int vistas) {
            this.vistas = vistas;
            return this;
        }

        public PublicacionBuilder setMeInteresa(int meInteresa) {
            this.meInteresa = meInteresa;
            return this;
        }

        public PublicacionBuilder setFecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public Publicacion build(){
            return new Publicacion(this);
        }
    }

    public String getUrlDescriptiva() {
        return urlDescriptiva;
    }

    public void setUrlDescriptiva(String urlDescriptiva) {
        this.urlDescriptiva = urlDescriptiva;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPagoMaximo() {
        return pagoMaximo;
    }

    public void setPagoMaximo(float pagoMaximo) {
        this.pagoMaximo = pagoMaximo;
    }

    public float getPagoMinimo() {
        return pagoMinimo;
    }

    public void setPagoMinimo(float pagoMinimo) {
        this.pagoMinimo = pagoMinimo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public int getMeInteresa() {
        return meInteresa;
    }

    public void setMeInteresa(int meInteresa) {
        this.meInteresa = meInteresa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
