package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.vistas.DetallePublicacion;
import com.gps.chambee.entidades.vistas.PublicacionEmpresa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorDetallesPublicacion extends Presentador<DetallePublicacion> {

    @Override
    public DetallePublicacion procesar(JSONObject json) {

        JSONArray array = null;
        JSONObject jsonObject = null;

        try {
            array = json.getJSONArray("detalles_publicacion");
            jsonObject = array.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;

        DetallePublicacion detallePublicacion =
                new DetallePublicacion.DetallePublicacionBuilder()
                        .setUrlPerfil(jsonObject.optString("url_perfil"))
                        .setUrlPortada(jsonObject.optString("url_portada"))
                        .setDescripcion(jsonObject.optString("descripcion"))
                        .setNombrePerfil(jsonObject.optString("nombre_perfil"))
                        .setTrabajo(jsonObject.optString("nombre_trabajo"))
                        .setCantidadInteresados(jsonObject.optInt("cantidad_interesados"))
                        .build();

        return detallePublicacion;
    }
}