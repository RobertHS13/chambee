package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Oficio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PresentadorListaOficio extends  Presentador<List<Oficio>>{


    @Override
    public List<Oficio> procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("oficios");
        List<Oficio> oficioList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;
            try {
                jsonObject = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            assert jsonObject != null;
            Oficio oficio = new Oficio.OficioBuilder()
                    .setNombre(jsonObject.optString("nombre"))
                    .setEspecialidad(jsonObject.optString("especialidad"))
                    .build();

            oficioList.add(oficio);
        }
        return oficioList;
    }
}
