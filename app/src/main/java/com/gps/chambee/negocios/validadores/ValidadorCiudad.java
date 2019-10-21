package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Ciudad;

import java.util.regex.Pattern;

public class ValidadorCiudad extends Validador<Ciudad>{

    public ValidadorCiudad(Ciudad ciudad) {
        super(ciudad);
    }

    @Override
    protected void definirValidaciones() {

        //Nombre de la Ciudad
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getNombre().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre de la ciudad no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });
    }
}
