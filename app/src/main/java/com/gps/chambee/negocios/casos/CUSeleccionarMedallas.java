package com.gps.chambee.negocios.casos;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gps.chambee.entidades.Categoria;
import com.gps.chambee.entidades.Medalla;
import com.gps.chambee.negocios.presentadores.PresentadorListaCategoria;
import com.gps.chambee.negocios.presentadores.PresentadorListaMedalla;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.implementaciones.SWSeleccionarMedallas;

import org.json.JSONObject;

import java.util.List;

public class CUSeleccionarMedallas extends  CasoUso<Medalla> {
    public CUSeleccionarMedallas(Context context, EventoPeticionAceptada<Lits<Medalla>> eventoPeticionAceptada, EventoPeticionRechazada eventoPeticionRechazada) {
        super(context, eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioWeb definirServicioWeb() {
        return new SWSeleccionarMedallas(context, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                PresentadorListaMedalla presentadorListaMedalla = new PresentadorListaMedalla();
                List<Medalla> medallas = presentadorListaMedalla.procesar(response);
                Log.i("SWSC", "onResponse: " + response.toString());
                eventoPeticionAceptada.alAceptarPeticion((Medalla) medallas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                eventoPeticionRechazada.alRechazarOperacion();
            }
        });
    }
}
