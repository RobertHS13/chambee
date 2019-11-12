package com.gps.chambee.servicios.firebase;

import com.google.firebase.database.DatabaseError;

public abstract class ServicioFirebase {

    public interface EventoTareaCompletada<T> {
        void alCompletarTarea(T t);
    }

    public interface EventoTareaCancelada {
        void alCancelarTarea(DatabaseError databaseError);
    }

    protected EventoTareaCompletada eventoTareaCompletada;
    protected EventoTareaCancelada eventoTareaCancelada;

    public ServicioFirebase(EventoTareaCompletada eventoTareaCompletada, EventoTareaCancelada eventoTareaCancelada) {
        this.eventoTareaCompletada = eventoTareaCompletada;
        this.eventoTareaCancelada = eventoTareaCancelada;
    }

    public abstract void ejecutarTarea(Object...args);
}
