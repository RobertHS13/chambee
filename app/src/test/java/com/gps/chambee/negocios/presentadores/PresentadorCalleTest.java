package com.gps.chambee.negocios.presentadores;

import com.gps.chambee.entidades.Calle;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class PresentadorCalleTest {

    @Test
    public void procesar() {

        Calle calle = new Calle.CalleBuilder().build();
        Calle calleEsperada = new Calle.CalleBuilder().
                setNombre("Calle").build();

        JSONObject object = new JSONObject();
        try {
            object.put("calle", "Calle");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PresentadorCalle presentadorCalle = new PresentadorCalle();
        calle = presentadorCalle.procesar(object);

        assertEquals(calleEsperada, calle);

    }
}