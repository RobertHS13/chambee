package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Trabajo;

public class ValidadorTrabajo extends Validador<Trabajo> {
    protected ValidadorTrabajo(Trabajo trabajo) {
        super(trabajo);
    }

    @Override
    protected void definirValidaciones() {
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getNombre().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre  no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });



    }
}
