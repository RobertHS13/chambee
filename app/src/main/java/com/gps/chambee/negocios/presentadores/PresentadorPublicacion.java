package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Publicacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PresentadorPublicacion extends Presentador<Publicacion>{
    public Publicacion procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("publicaciones");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;

        String urlDescriptiva = jsonObject.optString("url_descriptiva");
        String titulo = jsonObject.optString("titulo");
        String descripcion = jsonObject.optString("descripcion");
        double pagoMaximo = jsonObject.optDouble("pago_maximo");
        double pagoMinimo = jsonObject.optDouble("pago_minimo");
        String tiempo = jsonObject.optString("tiempo");
        long idPerfil = jsonObject.optLong("id_perfil");
        boolean estado= jsonObject.optBoolean("estado");
        int visitas = jsonObject.optInt("visitas");
        int meInteresa = jsonObject.optInt("me_interesa");
        String fecha = jsonObject.optString("fecha");

        int id = jsonObject.optInt("id_publicaciones");


        return new Publicacion.PublicacionBuilder()
                .setUrlDescriptiva(urlDescriptiva)

                .setTitulo(titulo)
                .setDescripcion(descripcion)
                .setPagoMaximo((float)pagoMaximo)
                .setPagoMinimo((float)pagoMinimo)
                .setTiempo(tiempo)
                .setIdPerfil(idPerfil)
                .setEstado(estado)
                .setVistas(visitas)
                .setMeInteresa(meInteresa)
                .setFecha(fecha)
                .setID(id)
                .build();
    }
}
