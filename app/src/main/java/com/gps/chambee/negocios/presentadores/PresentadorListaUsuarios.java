package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PresentadorListaUsuarios extends Presentador<List<Usuario>> {

    @Override
    public List<Usuario> procesar(JSONObject json) {
        JSONArray jsonArray = json.optJSONArray("usuario");
        List<Usuario> usuarioList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;
            try {
                jsonObject = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            assert jsonObject != null;
            Usuario usuario = new Usuario.UsuarioBuilder()
                    .setNombre(jsonObject.optString("nombre"))
                    .setApellidos(jsonObject.optString("apellidos"))
                    .setCorreoElectronico(jsonObject.optString("correoElectronico"))
                    .setContrasenia(jsonObject.optString("contrasenia"))
                    .setTelefono(jsonObject.optString("telefono"))
                    .build();

            usuarioList.add(usuario);
        }
        return usuarioList;
    }
}
