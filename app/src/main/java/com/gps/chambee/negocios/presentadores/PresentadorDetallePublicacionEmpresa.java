package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.vistas.DetallePublicacionEmpresa;
import com.gps.chambee.entidades.vistas.PublicacionEmpresa;

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

            PublicacionEmpresa publicacionEmpresa =
                    new PublicacionEmpresa.PublicacionEmpresaBuilder()
                            .setNombreEmpresa(jsonObject.optString("nombre_empresa"))
                            .setDescripcion(jsonObject.optString("descripcion"))
                            .setNombreTrabajo(jsonObject.optString("nombre_trabajo"))
                            .setUrlImagenEmpresa(jsonObject.optString("url_imagen_empresa"))
                            .setUrlImagenTrabajo(jsonObject.optString("url_imagen_trabajo"))
                            .build();

            DetallePublicacionEmpresa detallePublicacionEmpresa =
                    new DetallePublicacionEmpresa.DetallePublicacionEmpresaBuilder()
                            .setPublicacion(publicacionEmpresa)
                            .build();


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
