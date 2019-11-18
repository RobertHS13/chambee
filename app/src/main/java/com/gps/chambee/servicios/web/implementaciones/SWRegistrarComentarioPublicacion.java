package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Comentario;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarComentarioPublicacion extends ServicioWebEscritura {
    public SWRegistrarComentarioPublicacion(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        Comentario comentario = (Comentario) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("idPerfil", String.valueOf(comentario.getIdPerfil()));
        params.put("comentario", comentario.getComentario());
        params.put("fecha", comentario.getFecha());
        params.put("idPublicacion", String.valueOf(comentario.getIdPublicacion()));

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "chabee.online/escritura/serviceweb_alta_comentario_publicacion.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}