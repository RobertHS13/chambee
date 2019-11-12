package com.gps.chambee.entidades;

import com.gps.chambee.entidades.Usuario;

import java.util.HashMap;

public class SingletonSesion {

    private static SingletonSesion instance = null;

    HashMap <String, Object> objetosSesion;

    SingletonSesion(){
        objetosSesion = new HashMap<String, Object>();
    }

    public static SingletonSesion getInstance(){
        if (instance == null){
            return new SingletonSesion();
        }
        return instance;
    }

    public HashMap<String, Object> getObjetosSesion() {
        return objetosSesion;
    }
}