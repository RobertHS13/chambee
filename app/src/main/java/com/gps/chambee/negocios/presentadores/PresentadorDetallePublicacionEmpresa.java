package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.DetallePublicacionEmpresa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorDetallePublicacionEmpresa extends Presentador<DetallePublicacionEmpresa> {
    @Override
    public DetallePublicacionEmpresa procesar(JSONObject json) {

        JSONArray array = null;
        try {
            array = json.getJSONArray("detalles_publicacion");
            JSONObject jsonObject = array.getJSONObject(0);

            assert jsonObject != null;
            // DetallePublicacionEmpresa publicacionEmpresa = new DetallePublicacionEmpresa.DetallePublicacionEmpresaBuilder();


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
