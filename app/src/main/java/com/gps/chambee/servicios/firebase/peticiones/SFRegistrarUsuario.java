package com.gps.chambee.servicios.firebase.peticiones;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gps.chambee.servicios.firebase.ServicioFirebaseEscritura;

import java.util.HashMap;
import java.util.Map;

public class SFRegistrarUsuario extends ServicioFirebaseEscritura {

    public SFRegistrarUsuario(EventoTareaCompletada<String> eventoTareaCompletada, EventoTareaCancelada eventoTareaCancelada) {
        super(eventoTareaCompletada, eventoTareaCancelada);
    }

    @Override
    public void ejecutarTarea(Object... args) {
        final String nombreUsuario = args[0].toString();
        String correo = args[1].toString();
        String contrasena = args[2].toString();

        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(correo, contrasena);
        authResultTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    eventoTareaCancelada.alCancelarTarea(null);
                    return;
                }

                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                String idUsuario = firebaseUser.getUid();

                DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                        .getReference("usuarios")
                        .child(idUsuario);

                Map<String, String> datos = new HashMap<>();
                datos.put("id", idUsuario);
                datos.put("nombre_usuario", nombreUsuario);

                Task<Void> voidTask = databaseReference.setValue(datos);
                voidTask.addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                            eventoTareaCompletada.alCompletarTarea("exito");
                    }
                });
            }
        });
    }
}

