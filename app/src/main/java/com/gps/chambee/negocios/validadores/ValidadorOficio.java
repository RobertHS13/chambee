package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Oficio;

import java.util.regex.Pattern;

public class ValidadorOficio extends Validador<Oficio>{

    protected ValidadorOficio(Oficio oficio) {
        super(oficio);
    }

    @Override
    protected void definirValidaciones() {

        //Nombre del oficio
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getNombre().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre del oficio no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });

        //Especialidad
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getEspecialidad().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El nombre de la especialidad no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getEspecialidad();
            }
        });
    }
}
