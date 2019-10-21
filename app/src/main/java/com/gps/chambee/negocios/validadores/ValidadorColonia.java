package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Colonia;

import java.util.regex.Pattern;

public class ValidadorColonia extends Validador<Colonia>{

    public ValidadorColonia(Colonia colonia) {
        super(colonia);
    }

    @Override
    protected void definirValidaciones() {

        //Nombre de la Colonia
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getNombre().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre de la colonia no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });
    }
}
