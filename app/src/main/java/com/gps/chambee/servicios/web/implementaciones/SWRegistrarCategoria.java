package com.gps.chambee.servicios.web.implementaciones;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.gps.chambee.entidades.Categoria;
import com.gps.chambee.servicios.web.ServicioWeb;
import com.gps.chambee.servicios.web.ServicioWebEscritura;

import java.util.HashMap;
import java.util.Map;

public class SWRegistrarCategoria extends ServicioWebEscritura{
    public SWRegistrarCategoria(Context context, Response.Listener<String> responseListener, Response.ErrorListener errorListener) {
        super(context, responseListener, errorListener);
    }

    @Override
    protected Map<String, String> definirParams(Object... args) {
        Categoria categoria = (Categoria) args[0];

        Map<String, String> params = new HashMap<>();
        params.put("nombre", categoria.getNombre());

        return params;
    }

    @Override
    protected String definirUrl(Object... args) {
        return "chabee.online/escritura/serviceweb_alta_categorias.php";
    }

    @Override
    protected Request definirRequest(String url, Object... args) {
        return null;
    }
}