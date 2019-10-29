package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Medalla;

public class ValidadorMedalla extends Validador<Medalla> {

    protected ValidadorMedalla(Medalla medalla) {
        super(medalla);
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
                return "El nombre de la medalla no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getDescripcion().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El  de la descripcion no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getDescripcion();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getUrlMedalla().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "La url no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });



    }
}
