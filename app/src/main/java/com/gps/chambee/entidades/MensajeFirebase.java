package com.gps.chambee.entidades;

public class MensajeFirebase {

    public static class Builder {

        private String emisor;
        private String receptor;
        private String mensaje;
        private int tipoVista;

        public Builder() { }

        public Builder setEmisor(String emisor) {
            this.emisor = emisor;
            return this;
        }

        public Builder setReceptor(String receptor) {
            this.receptor = receptor;
            return this;
        }

        public Builder setMensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public Builder setTipoVista(int tipoVista) {
            this.tipoVista = tipoVista;
            return this;
        }

        public MensajeFirebase build() {
            return new MensajeFirebase(this);
        }
    }

    private String emisor;
    private String receptor;
    private String mensaje;
    private int tipoVista;

    private MensajeFirebase() { }

    public MensajeFirebase(Builder builder) {
        this.emisor = builder.emisor;
        this.receptor = builder.receptor;
        this.mensaje = builder.mensaje;
        this.tipoVista = builder.tipoVista;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTipoVista() {
        return tipoVista;
    }

    public void setTipoVista(int tipoVista) {
        this.tipoVista = tipoVista;
    }
}
