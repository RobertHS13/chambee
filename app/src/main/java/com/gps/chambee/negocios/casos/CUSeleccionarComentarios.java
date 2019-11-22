package com.gps.chambee.negocios.casos;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.entidades.vistas.ComentarioPublicacion;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.implementaciones.SWSeleccionarComentarios;

import org.json.JSONObject;

import java.util.List;

public class CUSeleccionarComentarios extends CasoUso<List<ComentarioPublicacion>> {
    public CUSeleccionarComentarios(
            Context context,
            EventoPeticionAceptada<List<ComentarioPublicacion>> eventoPeticionAceptada,
            EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new SWSeleccionarComentarios(
                context,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
    }
}
