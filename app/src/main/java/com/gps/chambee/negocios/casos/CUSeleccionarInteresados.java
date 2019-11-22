package com.gps.chambee.negocios.casos;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.entidades.Perfil;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.implementaciones.SWSeleccionarInteresados;

import org.json.JSONObject;

import java.util.List;

public class CUSeleccionarInteresados extends CasoUso<List<Perfil>> {
    public CUSeleccionarInteresados(
            Context context,
            EventoPeticionAceptada<List<Perfil>> eventoPeticionAceptada,
            EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new SWSeleccionarInteresados(
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
