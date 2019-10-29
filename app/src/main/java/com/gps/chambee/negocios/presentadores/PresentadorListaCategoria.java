package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Categoria;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PresentadorListaCategoria extends Presentador<List<Categoria>> {
    @Override
    public List<Categoria> procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("categorias");
        List<Categoria> categoriaList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;
            try {
                jsonObject = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            assert jsonObject != null;
            Categoria categoria = new Categoria.CategoriaBuilder()
                    .setNombre(jsonObject.optString("nombre"))
                    .build();

            categoriaList.add(categoria);
        }
        return categoriaList;
    }
}
