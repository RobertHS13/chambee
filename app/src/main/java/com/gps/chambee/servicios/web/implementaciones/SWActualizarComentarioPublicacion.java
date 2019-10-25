package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.ComentarioPublicacion;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWActualizarComentarioPublicacion extends ServicioWebEscritura {
    public SWActualizarComentarioPublicacion(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        String id = args[0].toString();
        ComentarioPublicacion comentarioPublicacion = (ComentarioPublicacion) args[1];

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        params.put("idPerfil", String.valueOf(comentarioPublicacion.getIdPerfil()));
        params.put("comentario", comentarioPublicacion.getComentario());
        params.put("fecha", comentarioPublicacion.getFecha());
        params.put("idPublicacion", String.valueOf(comentarioPublicacion.getIdPublicacion()));

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