package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Medalla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorMedalla extends Presentador<Medalla>{
    public Medalla procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("medallas");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;

        String nombre = jsonObject.optString("nombre");
        String urlMedalla = jsonObject.optString("url_medalla");
        String descripcion = jsonObject.optString("descripcion");
        int id = jsonObject.optInt("id_medalla");





        return new Medalla.MedallaBuilder()
                .setNombre(nombre)
                .setUrlMedalla(urlMedalla)
                .setDescripcion(descripcion)
                .setId(id)
                .build();
    }
}
