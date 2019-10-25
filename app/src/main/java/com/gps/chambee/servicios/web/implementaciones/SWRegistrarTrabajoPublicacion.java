package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.TrabajoPublicacion;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarTrabajoPublicacion extends ServicioWebEscritura {
    public SWRegistrarTrabajoPublicacion(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        TrabajoPublicacion trabajoPublicacion = (TrabajoPublicacion) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("idPublicacion", String.valueOf(trabajoPublicacion.getIdPublicacion()));
        params.put("idTrabajo", String.valueOf(trabajoPublicacion.getIdTrabajo()));

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "Here goes the URL With the php script.";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}