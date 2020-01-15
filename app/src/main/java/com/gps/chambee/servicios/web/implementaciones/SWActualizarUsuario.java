package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Usuario;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWActualizarUsuario extends ServicioWebEscritura {
    public SWActualizarUsuario(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(context, listener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        String id = args[0].toString();
        Usuario user = (Usuario) args[1];

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        params.put("nombre", user.getNombre());
        params.put("apellidos", user.getApellidos());
        params.put("correo_electronico", user.getCorreoElectronico());
        params.put("telefono", user.getTelefono());
        params.put("contrasena", user.getContrasenia());

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        //return "chabee.online/escritura/serviceweb_cambio_usuarios.php";
        return "http://www.chambee.online/chambee_php/escritura/cambio/serviceweb_cambio_usuarios.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}