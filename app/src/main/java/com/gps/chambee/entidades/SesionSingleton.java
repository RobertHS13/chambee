package com.gps.chambee.entidades;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.gps.chambee.R;

import java.util.HashMap;
import java.util.Map;

public class SesionSingleton {

    private static SesionSingleton instance = null;

    private Context context;
    private Map<String, Object> datos;
    private Map<String, Integer> imagenes;

    SesionSingleton(Context context) {
        this.context = context;
        datos = new HashMap<>();
        imagenes = new HashMap<>();

        agregarImagen("Industrial", R.drawable.ic_explore);
        agregarImagen("Servicios", R.drawable.ic_explore);
    }

    public static SesionSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new SesionSingleton(context);
        }

        instance.context = context;
        return instance;
    }

    public Object getValue(String key) {
        return datos.get(key);
    }

    public Bitmap getImagen(String key) {
        int id = imagenes.get(key);
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

    public void agregarImagen(String key, int imagen){
        imagenes.put(key, imagen);
    }

    public void agregarDato(String key, Object dato){
        datos.put(key, dato);
    }
}