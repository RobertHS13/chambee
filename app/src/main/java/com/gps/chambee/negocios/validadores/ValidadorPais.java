package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Pais;

import java.util.regex.Pattern;

public class ValidadorPais extends Validador<Pais>{

    protected ValidadorPais(Pais pais) {
        super(pais);
    }

    @Override
    protected void definirValidaciones() {

        //Nombre del País
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getNombre().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre del país no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });
    }
}
