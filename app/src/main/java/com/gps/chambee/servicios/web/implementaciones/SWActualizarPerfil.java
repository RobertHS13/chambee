package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Perfil;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWActualizarPerfil extends ServicioWebEscritura {
    public SWActualizarPerfil(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        String id = args[0].toString();
        Perfil perfil = (Perfil) args[1];

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        params.put("urlPerfil", perfil.getUrlPerfil());
        params.put("urlPortada", perfil.getUrlPortada());
        params.put("oficio", perfil.getOficio());
        params.put("acerca", perfil.getAcerca());
        params.put("fechaNacimiento", perfil.getFechaNacimiento());
        params.put("idLocalidad", String.valueOf(perfil.getIdLocalidad()));
        params.put("idUsuario", perfil.getIdUsuario());
        params.put("idColonia", perfil.getIdColonia());
        params.put("idCalle", perfil.getIdCalle());
        params.put("calificacion", String.valueOf(perfil.getCalificacion()));

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "chabee.online/escritura/serviceweb_cambio_perfiles.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}