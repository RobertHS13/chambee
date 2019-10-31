package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Publicacion;

public class ValidadorPublicacion extends Validador<Publicacion> {
    protected ValidadorPublicacion(Publicacion publicacion) {
        super(publicacion);
    }

    @Override
    protected void definirValidaciones() {
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getDescripcion().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "La descripcion no puede estar vacía";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getDescripcion();
            }
        });
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getTitulo().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El titulo no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getTitulo();
            }
        });
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                return !t.getUrlDescriptiva().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "La url no puede estar vacía";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getUrlDescriptiva();
            }
        });
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                try{
                    String[] fecha = t.getFecha().split("-");

                    if (fecha.length<3)
                        return false;

                    Integer.parseInt(fecha[0]);
                    Integer.parseInt(fecha[1]);
                    Integer.parseInt(fecha[2]);

                    return true;

                }catch(Exception ex){
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
                return t.getFecha();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {

            @Override
            public boolean validar() {
                return !t.getTiempo().isEmpty();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El tiempo no puede estar vacío";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getTiempo();
            }
        });


        agregarValidacion(new ValidadorPropiedad() {

            @Override
            public boolean validar() {
                return t.getPagoMinimo() > t.getPagoMaximo();
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El pago minimo  no puede ser mayor que el maximo";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getPagoMinimo();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {

            @Override
            public boolean validar() {
                return t.getPagoMinimo() >= 0;
            }

        }, new ErrorValidacion() {
            @Override
            public String mensajeError() {
                return "El pago minimo tiene que ser mayor a 0";
            }

            @Override
            public Object propiedadInvalida() {
                return t.getPagoMinimo();
            }
        });



    }
}
