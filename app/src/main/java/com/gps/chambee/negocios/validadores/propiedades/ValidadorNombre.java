package com.gps.chambee.negocios.validadores.propiedades;

import com.gps.chambee.negocios.validadores.Validador;

import java.util.regex.Pattern;

public class ValidadorNombre extends Validador<String> {

    public ValidadorNombre(String s) {
        super(s);
    }

    @Override
    protected void definirValidaciones() {

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t;
            }
        });

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                String nombre = t;
                Pattern regex = Pattern.compile("[^a-zA-Z]");
                return !regex.matcher(nombre).find();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre solo puede contener letras de la 'A' a la 'Z'";
            }

            @Override
            public Object propiedadInvalida() {
                return t;
            }
        });
    }
}
