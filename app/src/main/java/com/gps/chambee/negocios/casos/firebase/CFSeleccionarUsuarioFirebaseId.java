package com.gps.chambee.negocios.casos.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.gps.chambee.entidades.UsuarioFirebase;
import com.gps.chambee.negocios.presentadores.firebase.PresentadorFBUsuarioFirebase;
import com.gps.chambee.servicios.firebase.ServicioFirebase;
import com.gps.chambee.servicios.firebase.peticiones.SFSeleccionarUsuarioFirebaseId;

public class CFSeleccionarUsuarioFirebaseId extends CasoUsoFirebase<UsuarioFirebase> {

    public CFSeleccionarUsuarioFirebaseId(EventoPeticionAceptada<UsuarioFirebase> eventoPeticionAceptada, EventoPeticionRechazada eventoPeticionRechazada) {
        super(eventoPeticionAceptada, eventoPeticionRechazada);
    }

    @Override
    protected ServicioFirebase definirServicioFirebase() {
        return new SFSeleccionarUsuarioFirebaseId(new ServicioFirebase.EventoTareaCompletada<DataSnapshot>() {

            @Override
            public void alCompletarTarea(DataSnapshot snapshot) {
                PresentadorFBUsuarioFirebase presentador = new PresentadorFBUsuarioFirebase();
                UsuarioFirebase usuarioFirebase = presentador.procesar(snapshot);
                eventoPeticionAceptada.alAceptarPeticion(usuarioFirebase);
            }

        }, new ServicioFirebase.EventoTareaCancelada() {

            @Override
            public void alCancelarTarea(DatabaseError databaseError) {
                eventoPeticionRechazada.alRechazarOperacion(databaseError);
            }

        });
    }

}
