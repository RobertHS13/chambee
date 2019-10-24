package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Localidad;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarLocalidad extends ServicioWebEscritura{
    public SWRegistrarLocalidad(Context context, Response.Listener<String> responseListener, Response.ErrorListener errorListener) {
        super(context, responseListener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        Localidad localidad = (Localidad) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("idPais", localidad.getIdPais());
        params.put("idEstado", localidad.getIdEstado());
        params.put("idCiudad", localidad.getIdCiudad());

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return null;
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}