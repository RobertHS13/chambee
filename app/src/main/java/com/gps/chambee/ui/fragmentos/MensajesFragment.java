package com.gps.chambee.ui.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.gps.chambee.R;
import com.gps.chambee.entidades.UsuarioFirebase;
import com.gps.chambee.entidades.vistas.VistaChat;
import com.gps.chambee.negocios.casos.firebase.CFListarChats;
import com.gps.chambee.negocios.casos.firebase.CasoUsoFirebase;
import com.gps.chambee.negocios.presentadores.firebase.PresentadorFBUsuario;
import com.gps.chambee.ui.actividades.ChatActivity;
import com.gps.chambee.ui.adaptadores.MensajesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MensajesFragment extends Fragment {

    private RecyclerView rvMensajes;
    private ImageView ivCrearMensaje;
    private EditText etBuscarMensajes;

    private UsuarioFirebase usuarioFirebase;
    private List<VistaChat> mensajes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mensajes, container, false);

        etBuscarMensajes = view.findViewById(R.id.etBuscarMensajes);
        rvMensajes = view.findViewById(R.id.rvMensajes);
        ivCrearMensaje = view.findViewById(R.id.ivCrearMensaje);

        ivCrearMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ChatActivity.class));
            }
        });

        mensajes.add(new VistaChat.Builder().build());
        mensajes.add(new VistaChat.Builder().build());
        mensajes.add(new VistaChat.Builder().build());
        mensajes.add(new VistaChat.Builder().build());
        mensajes.add(new VistaChat.Builder().build());

        MensajesAdapter adapter = new MensajesAdapter(view.getContext(), mensajes);
        rvMensajes.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvMensajes.setAdapter(adapter);

        llenarMensajes();

        return view;
    }

    private void llenarMensajes() {
        new CFListarChats(usuarioFirebase.getId(), new CasoUsoFirebase.EventoPeticionAceptada<List<VistaChat>>() {
            @Override
            public void alAceptarPeticion(List<VistaChat> vistaChats) {

                mensajes = vistaChats;
                MensajesAdapter adapter = new MensajesAdapter(getContext(), mensajes);
                rvMensajes.setLayoutManager(new LinearLayoutManager(getContext()));
                rvMensajes.setAdapter(adapter);

            }
        }, new CasoUsoFirebase.EventoPeticionRechazada() {
            @Override
            public void alRechazarOperacion(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.toString(), Toast.LENGTH_SHORT).show();
            }
        }).enviarPeticion();
    }
}
