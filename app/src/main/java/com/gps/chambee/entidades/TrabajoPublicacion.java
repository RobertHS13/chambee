package com.gps.chambee.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class TrabajoPublicacion implements Parcelable {

    private int id;
    private int idPublicacion;
    private int idTrabajo;

    public TrabajoPublicacion(TrabajoPublicacionBuilder builder){
        this.id = builder.id;
        this.idPublicacion = builder.idPublicacion;
        this.idTrabajo = builder.idTrabajo;
    }

    protected TrabajoPublicacion(Parcel in) {
        id = in.readInt();
        idPublicacion = in.readInt();
        idTrabajo = in.readInt();
    }

    public static final Creator<TrabajoPublicacion> CREATOR = new Creator<TrabajoPublicacion>() {
        @Override
        public TrabajoPublicacion createFromParcel(Parcel in) {
            return new TrabajoPublicacion(in);
        }

        @Override
        public TrabajoPublicacion[] newArray(int size) {
            return new TrabajoPublicacion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(idPublicacion);
        dest.writeInt(idTrabajo);
    }

    public static class TrabajoPublicacionBuilder {
        private int id;
        private int idPublicacion;
        private int idTrabajo;

        public TrabajoPublicacionBuilder() {
        }

        public TrabajoPublicacion build(){
            return  new TrabajoPublicacion(this);
        }

        public TrabajoPublicacionBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TrabajoPublicacionBuilder setIdPublicacion(int idPublicacion) {
            this.idPublicacion = idPublicacion;
            return this;
        }

        public TrabajoPublicacionBuilder setIdTrabajo(int idTrabajo) {
            this.idTrabajo = idTrabajo;
            return this;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }
}
