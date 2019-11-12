package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class DetallePublicacionEmpresa implements Parcelable {

    private PublicacionEmpresa publicacion;
    private List<String> listaCostos;
    private List<String> listaInteresados;
    private List<String> listaAreasDeInteres;
    private List<ComentarioPublicacion> listaComentarios;

    public DetallePublicacionEmpresa(DetallePublicacionEmpresaBuilder builder){
        this.publicacion = builder.publicacion;
        this.listaAreasDeInteres = builder.listaAreasDeInteres;
        this.listaComentarios = builder.listaComentarios;
        this.listaInteresados = builder.listaInteresados;
        this.listaCostos = builder.listaCostos;
    }

    protected DetallePublicacionEmpresa(Parcel in) {
        publicacion = in.readParcelable(PublicacionEmpresa.class.getClassLoader());
        listaCostos = in.createStringArrayList();
        listaInteresados = in.createStringArrayList();
        listaAreasDeInteres = in.createStringArrayList();
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
        dest.writeStringList(listaCostos);
        dest.writeStringList(listaInteresados);
        dest.writeStringList(listaAreasDeInteres);
        dest.writeTypedList(listaComentarios);
    }

    public static class DetallePublicacionEmpresaBuilder {
        private PublicacionEmpresa publicacion;
        private List<String> listaCostos;
        private List<String> listaInteresados;
        private List<String> listaAreasDeInteres;
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

        public DetallePublicacionEmpresaBuilder setListaCostos(List<String> listaCostos) {
            this.listaCostos = listaCostos;
            return this;
        }

        public DetallePublicacionEmpresaBuilder setListaInteresados(List<String> listaInteresados) {
            this.listaInteresados = listaInteresados;
            return this;
        }

        public DetallePublicacionEmpresaBuilder setListaAreasDeInteres(List<String> listaAreasDeInteres) {
            this.listaAreasDeInteres = listaAreasDeInteres;
            return this;
        }

        public DetallePublicacionEmpresaBuilder setListaComentarios(List<ComentarioPublicacion> listaComentarios) {
            this.listaComentarios = listaComentarios;
            return this;
        }
    }

}
