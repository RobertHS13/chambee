package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Pais;
import com.gps.chambee.entidades.Perfil;

import java.util.regex.Pattern;

public class ValidadorPerfil extends Validador<Perfil>{

    protected ValidadorPerfil(Perfil perfil) {
        super(perfil);
    }

    @Override
    protected void definirValidaciones() {

        //Oficio
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getOficio().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El oficio no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getOficio();
            }
        });

        //Acerca
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getAcerca().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "Acerca de no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getAcerca();
            }
        });

        //Fecha nacimiento
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                try {
                    String[] fechaNacimiento = t.getFechaNacimiento().split("-");

                    if (fechaNacimiento.length < 3)
                        return false;

                    Integer.parseInt(fechaNacimiento[0]);
                    Integer.parseInt(fechaNacimiento[1]);
                    Integer.parseInt(fechaNacimiento[2]);

                    return true;
                } catch (Exception ex) {
                    return false;
                }
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "La fecha debe de tener el siguiente formato: 'AAAA-MM-DD'";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getFechaNacimiento();
            }
        });
    }
}
