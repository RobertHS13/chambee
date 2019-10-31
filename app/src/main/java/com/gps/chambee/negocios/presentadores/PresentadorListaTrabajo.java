package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Trabajo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PresentadorListaTrabajo extends Presentador<List<Trabajo>>{
    @Override
    public List<Trabajo> procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("trabajos");
        List<Trabajo> trabajoList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;
            try {
                jsonObject = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            assert jsonObject != null;
            Trabajo trabajo = new Trabajo.TrabajoBuilder()
                    .setNombre(jsonObject.optString("nombre"))
                    .build();

            trabajoList.add(trabajo);
        }
        return trabajoList;
    }
}
