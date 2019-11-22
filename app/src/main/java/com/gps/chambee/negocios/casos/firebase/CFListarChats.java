package com.gps.chambee.negocios.casos.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.gps.chambee.entidades.vistas.VistaChat;
import com.gps.chambee.servicios.firebase.ServicioFirebase;
import com.gps.chambee.servicios.firebase.peticiones.SFListarChats;

import java.util.List;

public class CFListarChats extends CasoUsoFirebase<List<VistaChat>> {

    private String idEmisor;

    public CFListarChats(String idEmisor, EventoPeticionAceptada<List<VistaChat>> eventoPeticionAceptada, EventoPeticionRechazada eventoPeticionRechazada) {
        super(eventoPeticionAceptada, eventoPeticionRechazada);

        this.idEmisor = idEmisor;
    }

    @Override
    protected ServicioFirebase definirServicioFirebase() {
        return new SFListarChats(new ServicioFirebase.EventoTareaCompletada<DataSnapshot>() {
            @Override
            public void alCompletarTarea(DataSnapshot snapshot) {

            }
        }, new ServicioFirebase.EventoTareaCancelada() {
            @Override
            public void alCancelarTarea(DatabaseError databaseError) {

            }
        });
    }
}
