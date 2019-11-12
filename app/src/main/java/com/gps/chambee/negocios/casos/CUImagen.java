package com.gps.chambee.negocios.casos;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebImagen;
import com.gps.chambee.servicios.web.implementaciones.SWEliminarPerfilUsuario;

public class CUImagen extends CasoUso<Bitmap>{
    public CUImagen(Context context, EventoPeticionAceptada<Bitmap> eventoPeticionAceptada, EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new ServicioWebImagen(context, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                eventoPeticionAceptada.alAceptarPeticion(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                eventoPeticionRechazada.alRechazarOperacion();
            }
        }) {
            @Override
            protected String definirUrl(Object... args) {
                return null;
            }
        };
    }
}
