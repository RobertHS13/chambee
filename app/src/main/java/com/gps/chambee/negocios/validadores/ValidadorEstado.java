package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Estado;

import java.util.regex.Pattern;

public class ValidadorEstado extends Validador<Estado>{

    public ValidadorEstado(Estado estado) {
        super(estado);
    }

    @Override
    protected void definirValidaciones() {

        //Nombre de la Calle
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getNombre().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre del estado no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });
    }
}
