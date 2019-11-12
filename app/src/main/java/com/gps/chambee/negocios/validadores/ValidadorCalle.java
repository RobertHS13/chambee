package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Calle;

import java.util.regex.Pattern;

public class ValidadorCalle extends Validador<Calle> {

    public ValidadorCalle(Calle calle) {
        super(calle);
    }

    @Override
    protected void definirValidaciones(){

        //Nombre de la Calle
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getNombre().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre de la calle no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });
    }
}
