package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Subscripcion;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarSubscripcion extends ServicioWebEscritura {
    public SWRegistrarSubscripcion(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        Subscripcion subscripcion = (Subscripcion) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("idPerfil", String.valueOf(subscripcion.getIdPerfil()));
        params.put("fechaInicio", subscripcion.getFechaInicio());
        params.put("fechaFinal", subscripcion.getFechaFinal());
        params.put("fechaCancelancion", subscripcion.getFechaCancelancion());

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "chabee.online/escritura/serviceweb_alta_subscripciones.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}