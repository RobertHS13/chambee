package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Categoria;

public class ValidadorCategoria extends Validador<Categoria> {
    protected ValidadorCategoria(Categoria categoria) {
        super(categoria);
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
                return "El nombre de la categoria no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getNombre();
            }
        });

    }
}
