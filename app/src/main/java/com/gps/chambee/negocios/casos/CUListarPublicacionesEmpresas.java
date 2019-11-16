package com.gps.chambee.negocios.casos;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.entidades.vistas.PublicacionEmpresa;
import com.gps.chambee.negocios.presentadores.PresentadorListaPublicacionEmpresa;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.implementaciones.SWSeleccionarPublicacionEmpresa;

import org.json.JSONObject;

import java.util.List;

public class CUListarPublicacionesEmpresas extends  CasoUso{

    public CUListarPublicacionesEmpresas(Context context, EventoPeticionAceptada eventoPeticionAceptada, EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new SWSeleccionarPublicacionEmpresa(context, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                PresentadorListaPublicacionEmpresa presentadorListaPublicacionEmpresa =
                        new PresentadorListaPublicacionEmpresa();
                List<PublicacionEmpresa> publicaciones = presentadorListaPublicacionEmpresa.procesar(response);

                eventoPeticionAceptada.alAceptarPeticion(publicaciones);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                eventoPeticionRechazada.alRechazarOperacion();
            }
        });
    }

}