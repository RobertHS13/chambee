package com.gps.chambee.entidades;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String contrasenia;
    private String telefono;

    private Usuario(UsuarioBuilder builder){
        this.nombre = builder.nombre;
        this.apellidos = builder.apellidos;
        this.correoElectronico = builder.correoElectronico;
        this.telefono = builder.telefono;
        this.contrasenia = builder.contrasenia;
    }

    public static class UsuarioBuilder{
        private String nombre;
        private String apellidos;
        private String correoElectronico;
        private String contrasenia;
        private String telefono;

        public UsuarioBuilder(){

        }

        public UsuarioBuilder setNombre(String nombre){
            this.nombre = nombre;
            return this;
        }

        public UsuarioBuilder setApellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public UsuarioBuilder setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
            return  this;
        }

        public UsuarioBuilder setContrasenia(String contrasenia) {
            this.contrasenia = contrasenia;
            return this;
        }

        public UsuarioBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Usuario build(){
            return new Usuario(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
