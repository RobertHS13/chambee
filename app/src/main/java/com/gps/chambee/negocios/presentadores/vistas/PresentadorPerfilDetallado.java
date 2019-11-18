package com.gps.chambee.negocios.presentadores.vistas;

import com.gps.chambee.entidades.vistas.PerfilDetallado;
import com.gps.chambee.negocios.presentadores.Presentador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PresentadorPerfilDetallado  extends Presentador<PerfilDetallado> {
    @Override
    public PerfilDetallado procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("perfil_detallado");

        JSONObject jsonObject = null;
        try{
            jsonObject = jsonArray.getJSONObject(0);
        }catch(JSONException e){
            e.printStackTrace();
        }

        assert jsonObject != null;
        PerfilDetallado perfilDetallado = new PerfilDetallado();
        perfilDetallado.setUrlPerfil(jsonObject.optString("perfil"));
        perfilDetallado.setUrlPortada(jsonObject.optString("portada"));
        perfilDetallado.setNombrePersona(jsonObject.optString("nombre"));
        perfilDetallado.setApellidosPersona(jsonObject.optString("apellidos"));
        perfilDetallado.setEdad(jsonObject.optInt("edad"));
        perfilDetallado.setPuesto(jsonObject.optString("puesto"));
        perfilDetallado.setEstrellas(jsonObject.optDouble("estrellas"));
        perfilDetallado.setEstado(jsonObject.optString("estado"));
        perfilDetallado.setCiudad(jsonObject.optString("ciudad"));
        perfilDetallado.setAcerca(jsonObject.optString("acerca"));

        return perfilDetallado;
    }
}
