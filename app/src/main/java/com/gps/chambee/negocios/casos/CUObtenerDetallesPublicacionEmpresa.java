package com.gps.chambee.negocios.casos;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.entidades.DetallePublicacionEmpresa;
import com.gps.chambee.negocios.presentadores.Presentador;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.implementaciones.SWObtenerDetallesPublicacionEmpresa;

import org.json.JSONObject;

public class CUObtenerDetallesPublicacionEmpresa extends CasoUso<DetallePublicacionEmpresa> {


    public CUObtenerDetallesPublicacionEmpresa(Context context, EventoPeticionAceptada<DetallePublicacionEmpresa> eventoPeticionAceptada, EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new SWObtenerDetallesPublicacionEmpresa(
                context,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        DetallePublicacionEmpresa publicacionEmpresa = new PresentadorDetallePublicacionEmpres().procesar(response);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
    }
}
