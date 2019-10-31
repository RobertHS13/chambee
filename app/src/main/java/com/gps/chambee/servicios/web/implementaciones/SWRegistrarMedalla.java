package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Medalla;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarMedalla extends ServicioWebEscritura {
    public SWRegistrarMedalla(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        Medalla medalla = (Medalla) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("nombre", medalla.getNombre());
        params.put("urlMedalla", medalla.getUrlMedalla());
        params.put("descripcion", medalla.getDescripcion());

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "chabee.online/escritura/serviceweb_alta_medallas.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}