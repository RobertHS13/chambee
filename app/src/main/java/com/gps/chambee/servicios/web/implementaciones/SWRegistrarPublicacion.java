package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Publicacion;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarPublicacion extends ServicioWebEscritura {
    public SWRegistrarPublicacion(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        Publicacion publicacion = (Publicacion) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("urlDescriptiva", publicacion.getUrlDescriptiva());
        params.put("titulo", publicacion.getTitulo());
        params.put("descripcion", publicacion.getDescripcion());
        params.put("pagoMaximo", String.valueOf(publicacion.getPagoMaximo()));
        params.put("pagoMinimo", String.valueOf(publicacion.getPagoMinimo()));
        params.put("tiempo", publicacion.getTiempo());
        params.put("idPerfil", String.valueOf(publicacion.getIdPerfil()));
        params.put("estado", String.valueOf(publicacion.isEstado()));
        params.put("vistas", String.valueOf(publicacion.getVistas()));
        params.put("meInteresa", String.valueOf(publicacion.getMeInteresa()));
        params.put("fecha", publicacion.getFecha());

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "chabee.online/escritura/serviceweb_alta_publicaciones.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}