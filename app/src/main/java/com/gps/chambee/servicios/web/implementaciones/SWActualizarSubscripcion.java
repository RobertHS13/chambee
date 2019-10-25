package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Subscripcion;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWActualizarSubscripcion extends ServicioWebEscritura {
    public SWActualizarSubscripcion(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        String id = args[0].toString();
        Subscripcion subscripcion = (Subscripcion) args[1];

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        params.put("idPerfil", String.valueOf(subscripcion.getIdPerfil()));
        params.put("fechaInicio", subscripcion.getFechaInicio());
        params.put("fechaFinal", subscripcion.getFechaFinal());
        params.put("fechaCancelancion", subscripcion.getFechaCancelancion());

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