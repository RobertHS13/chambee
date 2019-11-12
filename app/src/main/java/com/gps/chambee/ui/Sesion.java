package com.gps.chambee.ui;

import java.util.HashMap;
import java.util.Map;

public class Sesion {
    private static Sesion INSTANCIA;

    private final Map<String,Object> entidades = new HashMap<>();
    private Sesion(){

    }
    public static Sesion instance(){
        if(INSTANCIA == null){
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }
    public void agregarEntidad(String id, Object entidad){
        entidades.put(id,entidad);
    }
    public Object obtenerEntidad(String id){
        return entidades.get(id);
    }
}
