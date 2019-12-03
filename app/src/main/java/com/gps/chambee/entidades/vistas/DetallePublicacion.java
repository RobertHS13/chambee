package com.gps.chambee.entidades.vistas;

import android.os.Parcel;
import android.os.Parcelable;

import com.gps.chambee.entidades.Categoria;
import com.gps.chambee.entidades.Perfil;

import java.util.List;

public class DetallePublicacion implements Parcelable {

    private String urlPerfil;
    private String urlPortada;
    private String nombrePerfil;
    private String trabajo;
    private String costos;
    private String descripcion;
    private Integer cantidadInteresados;
    private List<Perfil> listaInteresados;
    private List<Categoria> listaAreasDeInteres;
    private List<ComentarioPublicacion> listaComentarios;

    public DetallePublicacion(DetallePublicacionBuilder builder) {
        this.urlPerfil = builder.urlPerfil;
        this.urlPortada = builder.urlPortada;
        this.nombrePerfil = builder.nombrePerfil;
        this.trabajo = builder.trabajo;
        this.costos = builder.costos;
        this.descripcion = builder.descripcion;
        this.cantidadInteresados = builder.cantidadInteresados;
        this.listaInteresados = builder.listaInteresados;
        this.listaAreasDeInteres = builder.listaAreasDeInteres;
        this.listaComentarios = builder.listaComentarios;
    }

    protected DetallePublicacion(Parcel in) {
        urlPerfil = in.readString();
        urlPortada = in.readString();
        nombrePerfil = in.readString();
        trabajo = in.readString();
        costos = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0) {
            cantidadInteresados = null;
        } else {
            cantidadInteresados = in.readInt();
        }
        listaInteresados = in.createTypedArrayList(Perfil.CREATOR);
        listaAreasDeInteres = in.createTypedArrayList(Categoria.CREATOR);
        listaComentarios = in.createTypedArrayList(ComentarioPublicacion.CREATOR);
    }

    public static final Creator<DetallePublicacion> CREATOR = new Creator<DetallePublicacion>() {
        @Override
        public DetallePublicacion createFromParcel(Parcel in) {
            return new DetallePublicacion(in);
        }

        @Override
        public DetallePublicacion[] newArray(int size) {
            return new DetallePublicacion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlPerfil);
        dest.writeString(urlPortada);
        dest.writeString(nombrePerfil);
        dest.writeString(trabajo);
        dest.writeString(costos);
        dest.writeString(descripcion);
        if (cantidadInteresados == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cantidadInteresados);
        }
        dest.writeTypedList(listaInteresados);
        dest.writeTypedList(listaAreasDeInteres);
        dest.writeTypedList(listaComentarios);
    }

    public static class DetallePublicacionBuilder {
        private String urlPerfil;
        private String urlPortada;
        private String nombrePerfil;
        // Puesto ofrecido o buscado.
        private String trabajo;
        private String costos;
        private String descripcion;
        private Integer cantidadInteresados;
        private List<Perfil> listaInteresados;
        private List<Categoria> listaAreasDeInteres;
        private List<ComentarioPublicacion> listaComentarios;

        public DetallePublicacionBuilder setUrlPerfil(String urlPerfil) {
            this.urlPerfil = urlPerfil;
            return this;
        }

        public DetallePublicacionBuilder setUrlPortada(String urlPortada) {
            this.urlPortada = urlPortada;
            return this;
        }

        public DetallePublicacionBuilder setNombrePerfil(String nombrePerfil) {
            this.nombrePerfil = nombrePerfil;
            return this;
        }

        public DetallePublicacionBuilder setTrabajo(String trabajo) {
            this.trabajo = trabajo;
            return this;
        }

        public DetallePublicacionBuilder setCostos(String costos) {
            this.costos = costos;
            return this;
        }

        public DetallePublicacionBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public DetallePublicacionBuilder setCantidadInteresados(Integer cantidadInteresados) {
            this.cantidadInteresados = cantidadInteresados;
            return this;
        }

        public DetallePublicacionBuilder setListaInteresados(List<Perfil> listaInteresados) {
            this.listaInteresados = listaInteresados;
            return this;
        }

        public DetallePublicacionBuilder setListaAreasDeInteres(List<Categoria> listaAreasDeInteres) {
            this.listaAreasDeInteres = listaAreasDeInteres;
            return this;
        }

        public DetallePublicacionBuilder setListaComentarios(List<ComentarioPublicacion> listaComentarios) {
            this.listaComentarios = listaComentarios;
            return this;
        }

        public DetallePublicacion build() {
            return  new DetallePublicacion(this);
        }
    }

    public String getUrlPerfil() { return urlPerfil; }
    public String getUrlPortada() {
        return urlPortada;
    }
    public String getNombrePerfil() {
        return nombrePerfil;
    }
    public String getNombreTrabajo() { return trabajo; }
    public String getCostos() {
        return costos;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Integer getCantidadInteresados() {
        return cantidadInteresados;
    }
    public List<Perfil> getListaInteresados() {
        return listaInteresados;
    }
    public List<Categoria> getListaAreasDeInteres() {
        return listaAreasDeInteres;
    }
    public List<ComentarioPublicacion> getListaComentarios() {
        return listaComentarios;
    }

    public void setUrlPerfil(String urlPerfil) {
        this.urlPerfil = urlPerfil;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public void setCostos(String costos) {
        this.costos = costos;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadInteresados(Integer cantidadInteresados) {
        this.cantidadInteresados = cantidadInteresados;
    }

    public void setListaInteresados(List<Perfil> listaInteresados) {
        this.listaInteresados = listaInteresados;
    }

    public void setListaAreasDeInteres(List<Categoria> listaAreasDeInteres) {
        this.listaAreasDeInteres = listaAreasDeInteres;
    }

    public void setListaComentarios(List<ComentarioPublicacion> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }
}
