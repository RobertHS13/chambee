package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Subscripcion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorSubscripcion extends Presentador<Subscripcion>{
    public Subscripcion procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("subscripcion");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;
        long id = jsonObject.optLong("id_subscripcion");
        long idPerfil = jsonObject.optLong("id_perfil");
        String fechaInicio = jsonObject.optString("fecha_inicio");
        String fechaFinal = jsonObject.optString("fecha_final");
        String fechaCancelacion = jsonObject.optString("fecha_cancelacion");




        return new Subscripcion.SubscripcionBuilder()
                .setId(id)
                .setIdPerfil(idPerfil)
                .setFechaInicio(fechaInicio)
                .setFechaFinal(fechaFinal)
                .setFechaCancelancion(fechaCancelacion)
                .build();
    }
}
