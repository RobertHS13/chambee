package com.gps.chambee.negocios.casos;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.entidades.Categoria;
import com.gps.chambee.negocios.presentadores.Presentador;
import com.gps.chambee.negocios.presentadores.PresentadorListaCategoria;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.implementaciones.SWSeleccionarCategorias;

import org.json.JSONObject;

import java.util.List;

public class CUSeleccionarCategorias extends CasoUso<List<Categoria>> {
    public CUSeleccionarCategorias(
            Context context,
            EventoPeticionAceptada<List<Categoria>> eventoPeticionAceptada,
            EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new SWSeleccionarCategorias(context, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                PresentadorListaCategoria presentadorListaCategoria = new PresentadorListaCategoria();
                List<Categoria> categorias = presentadorListaCategoria.procesar(response);
                Log.i("SWSC", "onResponse: " + response.toString());
                eventoPeticionAceptada.alAceptarPeticion(categorias);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                eventoPeticionRechazada.alRechazarOperacion();
            }
        });
    }
}
