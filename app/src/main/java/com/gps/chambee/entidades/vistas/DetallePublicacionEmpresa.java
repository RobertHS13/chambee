package com.gps.chambee.entidades.vistas;

import android.os.Parcel;
import android.os.Parcelable;

import com.gps.chambee.entidades.Categoria;
import com.gps.chambee.entidades.Perfil;

import java.util.List;

public class DetallePublicacionEmpresa implements Parcelable {

    private PublicacionEmpresa publicacion;
    private String costos;
    private String descripcion;
    private Integer cantidadInteresados;
    private List<Perfil> listaInteresados;
    private List<Categoria> listaAreasDeInteres;
    private List<ComentarioPublicacion> listaComentarios;

    public DetallePublicacionEmpresa(DetallePublicacionEmpresaBuilder builder){
        this.publicacion = builder.publicacion;
        this.descripcion = builder.descripcion;
        this.costos = builder.costos;
        this.cantidadInteresados = builder.cantidadInteresados;
        this.listaAreasDeInteres = builder.listaAreasDeInteres;
        this.listaComentarios = builder.listaComentarios;
        this.listaInteresados = builder.listaInteresados;
        this.costos = builder.listaCostos;
    }

    protected DetallePublicacionEmpresa(Parcel in) {
        publicacion = in.readParcelable(PublicacionEmpresa.class.getClassLoader());
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

    public static final Creator<DetallePublicacionEmpresa> CREATOR = new Creator<DetallePublicacionEmpresa>() {
        @Override
        public DetallePublicacionEmpresa createFromParcel(Parcel in) {
            return new DetallePublicacionEmpresa(in);
        }

        @Override
        public DetallePublicacionEmpresa[] newArray(int size) {
            return new DetallePublicacionEmpresa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(publicacion, flags);
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

    public static class DetallePublicacionEmpresaBuilder {
        private PublicacionEmpresa publicacion;
        private String costos;
        private String descripcion;
        private Integer cantidadInteresados;
        private String listaCostos;
        private List<Perfil> listaInteresados;
        private List<Categoria> listaAreasDeInteres;
        private List<ComentarioPublicacion> listaComentarios;

        public DetallePublicacionEmpresaBuilder(){

        }

        public DetallePublicacionEmpresa build(){
            return new DetallePublicacionEmpresa(this);
        }

        public DetallePublicacionEmpresaBuilder setPublicacion(PublicacionEmpresa publicacion) {
            this.publicacion = publicacion;
            return this;
        }

        public DetallePublicacionEmpresaBuilder setListaCostos(String listaCostos) {
            this.listaCostos = listaCostos;
            return this;
        }

        public DetallePublicacionEmpresaBuilder setListaInteresados(List<Perfil> listaInteresados) {
            this.listaInteresados = listaInteresados;
            return this;
        }

        public DetallePublicacionEmpresaBuilder setListaAreasDeInteres(List<Categoria> listaAreasDeInteres) {
            this.listaAreasDeInteres = listaAreasDeInteres;
            return this;
        }

        public DetallePublicacionEmpresaBuilder setListaComentarios(List<ComentarioPublicacion> listaComentarios) {
            this.listaComentarios = listaComentarios;
            return this;
        }
    }

    public PublicacionEmpresa getPublicacion() {
        return publicacion;
    }

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
}
