package com.gps.chambee.negocios.validadores;

import com.gps.chambee.entidades.Subscripcion;

public class ValidadorSubscripcion extends Validador<Subscripcion> {


    protected ValidadorSubscripcion(Subscripcion subscripcion) {
        super(subscripcion);
    }

    @Override
    protected void definirValidaciones() {
        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                try {
                    String[] fechaInicio = t.getFechaInicio().split("-");

                    if (fechaInicio.length < 3)
                        return false;

                    Integer.parseInt(fechaInicio[0]);
                    Integer.parseInt(fechaInicio[1]);
                    Integer.parseInt(fechaInicio[2]);

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
                return t.getFechaInicio();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                try {
                    String[] fechaFinal = t.getFechaFinal().split("-");

                    if (fechaFinal.length < 3)
                        return false;

                    Integer.parseInt(fechaFinal[0]);
                    Integer.parseInt(fechaFinal[1]);
                    Integer.parseInt(fechaFinal[2]);

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
                return t.getFechaFinal();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                try {
                    String[] fechaFinal = t.getFechaFinal().split("-");

                    if (fechaFinal.length < 3)
                        return false;

                    Integer.parseInt(fechaFinal[0]);
                    Integer.parseInt(fechaFinal[1]);
                    Integer.parseInt(fechaFinal[2]);

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
                return t.getFechaFinal();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                try {
                    String[] fechaFinal = t.getFechaFinal().split("-");

                    if (fechaFinal.length < 3)
                        return false;

                    Integer.parseInt(fechaFinal[0]);
                    Integer.parseInt(fechaFinal[1]);
                    Integer.parseInt(fechaFinal[2]);

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
                return t.getFechaFinal();
            }
        });

        agregarValidacion(new ValidadorPropiedad() {
            @Override
            public boolean validar() {
                try {
                    String[] fechaCancelacion = t.getFechaCancelancion().split("-");

                    if (fechaCancelacion.length < 3)
                        return false;

                    Integer.parseInt(fechaCancelacion[0]);
                    Integer.parseInt(fechaCancelacion[1]);
                    Integer.parseInt(fechaCancelacion[2]);

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
                return t.getFechaCancelancion();
            }
        });




    }
}
