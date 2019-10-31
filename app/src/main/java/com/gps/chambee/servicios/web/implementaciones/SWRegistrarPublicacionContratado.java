package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.PublicacionContratado;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarPublicacionContratado extends ServicioWebEscritura {
    public SWRegistrarPublicacionContratado(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        PublicacionContratado publicacionContratado = (PublicacionContratado) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("idPerfil", String.valueOf(publicacionContratado.getIdPerfil()));
        params.put("idPublicacion", String.valueOf(publicacionContratado.getIdPublicacion()));
        params.put("fechaAceptacion", publicacionContratado.getFechaAceptacion());
        params.put("fechaCompletado", publicacionContratado.getFechaCompletado());
        params.put("fechaCancelacion", publicacionContratado.getFechaCancelacion());
        params.put("estado", String.valueOf(publicacionContratado.isEstado()));

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