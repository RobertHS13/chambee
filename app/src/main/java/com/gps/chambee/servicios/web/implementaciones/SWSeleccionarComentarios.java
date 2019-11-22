package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Response;
import com.gps.chambee.servicios.web.ServicioWebLectura;

import org.json.JSONObject;

public class SWSeleccionarComentarios extends ServicioWebLectura {
    public SWSeleccionarComentarios(
            Context context,
            Response.Listener<JSONObject> responseListener,
            Response.ErrorListener errorListener) {
        super(context, responseListener, errorListener);
    }

    @Override
    protected String definirUrl(Object... args) {
        return "";
    }
}
