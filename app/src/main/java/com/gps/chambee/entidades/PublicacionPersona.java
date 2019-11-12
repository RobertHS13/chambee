package com.gps.chambee.entidades;


import android.os.Parcel;
import android.os.Parcelable;

public class PublicacionPersona implements Parcelable {

    private String urlImagenPersona;
    private String nombrePersona;
    private String tiempo;
    private String etiqueta;
    private Integer interesados;
    private Integer comentarios;
    private Integer vistos;
    private String descripcion;
    // Campos que serán 1 o 0, dependiendo de lo que panda devuelva
    // Servirán para indicar que el usuario actual, tiene o no
    // vista o interesada la publicacion.
    private Integer vista;
    private Integer interesada;

    public static class PublicacionPersonaBuilder {
        private String urlImagenPersona;
        private String nombrePersona;
        private String tiempo;
        private String etiqueta;
        private Integer interesados;
        private Integer comentarios;
        private Integer vistos;
        private String descripcion;

        private Integer vista;
        private Integer interesada;

        public PublicacionPersonaBuilder setUrlImagenPersona(String urlImagenPersona) {
            this.urlImagenPersona = urlImagenPersona;
            return this;
        }
        public PublicacionPersonaBuilder setNombrePersona(String nombrePersona) {
            this.nombrePersona = nombrePersona;
            return this;
        }
        public PublicacionPersonaBuilder setTiempo(String tiempo) {
            this.tiempo = tiempo;
            return this;
        }
        public PublicacionPersonaBuilder setEtiqueta(String etiqueta) {
            this.etiqueta = etiqueta;
            return this;
        }
        public PublicacionPersonaBuilder setInteresados(Integer interesados) {
            this.interesados = interesados;
            return this;
        }
        public PublicacionPersonaBuilder setComentarios(Integer comentarios) {
            this.comentarios = comentarios;
            return this;
        }
        public PublicacionPersonaBuilder setVistos(Integer vistos) {
            this.vistos = vistos;
            return this;
        }
        public PublicacionPersonaBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        public PublicacionPersonaBuilder setVista(Integer vista) {
            this.vista = vista;
            return this;
        }
        public PublicacionPersonaBuilder setInteresada(Integer interesada) {
            this.interesada = interesada;
            return this;
        }

        public PublicacionPersona build(){
            return new PublicacionPersona(this);
        }
    }

    public PublicacionPersona(PublicacionPersonaBuilder builder) {
        this.nombrePersona = builder.nombrePersona;
        this.comentarios = builder.comentarios;
        this.descripcion = builder.descripcion;
        this.etiqueta = builder.etiqueta;
        this.interesada = builder.interesada;
        this.interesados = builder.interesados;
        this.tiempo = builder.tiempo;
        this.urlImagenPersona = builder.urlImagenPersona;
        this.vista = builder.vista;
        this.vistos = builder.vistos;
    }

    protected PublicacionPersona(Parcel in) {
        urlImagenPersona = in.readString();
        nombrePersona = in.readString();
        tiempo = in.readString();
        etiqueta = in.readString();
        if (in.readByte() == 0) {
            interesados = null;
        } else {
            interesados = in.readInt();
        }
        if (in.readByte() == 0) {
            comentarios = null;
        } else {
            comentarios = in.readInt();
        }
        if (in.readByte() == 0) {
            vistos = null;
        } else {
            vistos = in.readInt();
        }
        descripcion = in.readString();
        if (in.readByte() == 0) {
            vista = null;
        } else {
            vista = in.readInt();
        }
        if (in.readByte() == 0) {
            interesada = null;
        } else {
            interesada = in.readInt();
        }
    }

    public static final Creator<PublicacionEmpresa> CREATOR = new Creator<PublicacionEmpresa>() {
        @Override
        public PublicacionEmpresa createFromParcel(Parcel in) {
            return new PublicacionEmpresa(in);
        }

        @Override
        public PublicacionEmpresa[] newArray(int size) {
            return new PublicacionEmpresa[size];
        }
    };

    public String getUrlImagenEmpresa() {
        return urlImagenPersona;
    }

    public void setUrlImagenEmpresa(String urlImagenEmpresa) {
        this.urlImagenPersona = urlImagenPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Integer getInteresados() {
        return interesados;
    }

    public void setInteresados(Integer interesados) {
        this.interesados = interesados;
    }

    public Integer getComentarios() {
        return comentarios;
    }

    public void setComentarios(Integer comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getVistos() {
        return vistos;
    }

    public void setVistos(Integer vistos) {
        this.vistos = vistos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlImagenPersona);
        dest.writeString(nombrePersona);
        dest.writeString(tiempo);
        dest.writeString(etiqueta);
        if (interesados == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(interesados);
        }
        if (comentarios == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(comentarios);
        }
        if (vistos == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(vistos);
        }
        dest.writeString(descripcion);
        if (vista == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(vista);
        }
        if (interesada == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(interesada);
        }
    }
}
