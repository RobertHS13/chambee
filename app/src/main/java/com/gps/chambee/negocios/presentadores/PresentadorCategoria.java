package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Categoria;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorCategoria extends Presentador<Categoria>{
    public Categoria procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("cateforias");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;
        int id = jsonObject.optInt("id_categoria");
        String nombre = jsonObject.optString("nombre");





        return new Categoria.CategoriaBuilder()
                .setId(id)
                .setNombre(nombre)
                .build();
    }
}
