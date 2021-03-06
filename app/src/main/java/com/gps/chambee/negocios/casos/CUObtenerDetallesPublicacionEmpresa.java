package com.gps.chambee.negocios.casos;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.entidades.vistas.DetallePublicacion;
import com.gps.chambee.negocios.presentadores.PresentadorDetallePublicacionEmpresa;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.implementaciones.SWObtenerDetallesPublicacionEmpresa;

import org.json.JSONObject;

public class CUObtenerDetallesPublicacionEmpresa extends CasoUso<DetallePublicacion> {


    public CUObtenerDetallesPublicacionEmpresa(Context context, EventoPeticionAceptada<DetallePublicacion> eventoPeticionAceptada, EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new SWObtenerDetallesPublicacionEmpresa(
                context,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        DetallePublicacion publicacionEmpresa = new PresentadorDetallePublicacionEmpresa().procesar(response);
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
