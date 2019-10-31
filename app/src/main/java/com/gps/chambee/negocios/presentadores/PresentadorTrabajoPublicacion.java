package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.TrabajoPublicacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorTrabajoPublicacion {

    public TrabajoPublicacion procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("trabajo_publicacion");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;

        int id = jsonObject.optInt("id_trabajo");
        int idPublicacion = jsonObject.optInt("id_publicacion");
        int idTrabajoPublicacion = jsonObject.optInt("id_trabajo_publicacion");

        return new TrabajoPublicacion.TrabajoPublicacionBuilder()
                .setId(idTrabajoPublicacion)
                .setIdPublicacion(idPublicacion)
                .setIdTrabajo(id)
                .build();
    }
}
