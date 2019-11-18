package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Trabajo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorTrabajo extends Presentador<Trabajo>{

    public Trabajo procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("trabajos");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;
        String nombre = jsonObject.optString("nombre");
        int id = jsonObject.optInt("id_trabajo");
        int idCategoria = jsonObject.optInt("id_categoria");

        return new Trabajo.TrabajoBuilder()
                .setNombre(nombre)
                .setId(id)
                .setIdCategoria(idCategoria)
                .build();
    }
}
