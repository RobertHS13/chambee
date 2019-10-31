package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Medalla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PresentadorListaMedalla extends Presentador<List<Medalla>> {
    @Override
    public List<Medalla> procesar(JSONObject json) {

        JSONArray jsonArray = json.optJSONArray("medallas");
        List<Medalla> medallaList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;
            try {
                jsonObject = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            assert jsonObject != null;
            Medalla medalla = new Medalla.MedallaBuilder()
                    .setNombre(jsonObject.optString("nombre"))
                    .setDescripcion(jsonObject.optString("descripcion"))
                    .setUrlMedalla(jsonObject.optString("url_medalla"))
                    .build();

            medallaList.add(medalla);
        }
        return medallaList;
    }
}
