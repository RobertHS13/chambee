package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Ciudad;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarCiudad extends ServicioWebEscritura {
    public SWRegistrarCiudad(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        Ciudad ciudad = (Ciudad) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("nombre", ciudad.getNombre());

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "chabee.online/escritura/serviceweb_alta_ciudades.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}