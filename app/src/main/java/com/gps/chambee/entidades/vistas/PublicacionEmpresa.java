package com.gps.chambee.entidades.vistas;


import android.os.Parcel;
import android.os.Parcelable;

public class PublicacionEmpresa implements Parcelable {

    private String urlImagenEmpresa;
    private String nombreEmpresa;
    private String tiempo;
    private String etiqueta;
    private Integer interesados;
    private Integer comentarios;
    private Integer vistos;
    private String descripcion;
    private String nombreTrabajo;
    private String urlImagenTrabajo;
    // Campos que serán 1 o 0, dependiendo de lo que panda devuelva
    // Servirán para indicar que el usuario actual, tiene o no
    // vista o interesada la publicacion.
    private Integer vista;
    private Integer interesada;

    public static class PublicacionEmpresaBuilder {
        private String urlImagenEmpresa;
        private String nombreEmpresa;
        private String tiempo;
        private String etiqueta;
        private Integer interesados;
        private Integer comentarios;
        private Integer vistos;
        private String descripcion;
        private String nombreTrabajo;
        private String urlImagenTrabajo;

        private Integer vista;
        private Integer interesada;

        public PublicacionEmpresaBuilder setUrlImagenEmpresa(String urlImagenEmpresa) {
            this.urlImagenEmpresa = urlImagenEmpresa;
            return this;
        }
        public PublicacionEmpresaBuilder setNombreEmpresa(String nombreEmpresa) {
            this.nombreEmpresa = nombreEmpresa;
            return this;
        }
        public PublicacionEmpresaBuilder setTiempo(String tiempo) {
            this.tiempo = tiempo;
            return this;
        }
        public PublicacionEmpresaBuilder setEtiqueta(String etiqueta) {
            this.etiqueta = etiqueta;
            return this;
        }
        public PublicacionEmpresaBuilder setInteresados(Integer interesados) {
            this.interesados = interesados;
            return this;
        }
        public PublicacionEmpresaBuilder setComentarios(Integer comentarios) {
            this.comentarios = comentarios;
            return this;
        }
        public PublicacionEmpresaBuilder setVistos(Integer vistos) {
            this.vistos = vistos;
            return this;
        }
        public PublicacionEmpresaBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        public PublicacionEmpresaBuilder setNombreTrabajo(String nombreTrabajo) {
            this.nombreTrabajo = nombreTrabajo;
            return this;
        }
        public PublicacionEmpresaBuilder setUrlImagenTrabajo(String urlImagenTrabajo) {
            this.urlImagenTrabajo = urlImagenTrabajo;
            return this;
        }
        public PublicacionEmpresaBuilder setVista(Integer vista) {
            this.vista = vista;
            return this;
        }
        public PublicacionEmpresaBuilder setInteresada(Integer interesada) {
            this.interesada = interesada;
            return this;
        }

        public PublicacionEmpresa build(){
            return new PublicacionEmpresa(this);
        }
    }

    public PublicacionEmpresa(PublicacionEmpresaBuilder builder) {
        this.nombreEmpresa = builder.nombreEmpresa;
        this.nombreTrabajo = builder.nombreTrabajo;
        this.comentarios = builder.comentarios;
        this.descripcion = builder.descripcion;
        this.etiqueta = builder.etiqueta;
        this.interesada = builder.interesada;
        this.interesados = builder.interesados;
        this.tiempo = builder.tiempo;
        this.urlImagenEmpresa = builder.urlImagenEmpresa;
        this.urlImagenTrabajo = builder.urlImagenTrabajo;
        this.vista = builder.vista;
        this.vistos = builder.vistos;
    }

    protected PublicacionEmpresa(Parcel in) {
        urlImagenEmpresa = in.readString();
        nombreEmpresa = in.readString();
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
        nombreTrabajo = in.readString();
        urlImagenTrabajo = in.readString();
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
        return urlImagenEmpresa;
    }

    public void setUrlImagenEmpresa(String urlImagenEmpresa) {
        this.urlImagenEmpresa = urlImagenEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
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

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public String getUrlImagenTrabajo() {
        return urlImagenTrabajo;
    }

    public void setUrlImagenTrabajo(String urlImagenTrabajo) {
        this.urlImagenTrabajo = urlImagenTrabajo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlImagenEmpresa);
        dest.writeString(nombreEmpresa);
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
        dest.writeString(nombreTrabajo);
        dest.writeString(urlImagenTrabajo);
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
