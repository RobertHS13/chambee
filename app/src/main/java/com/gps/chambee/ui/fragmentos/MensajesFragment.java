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

import com.gps.chambee.R;
import com.gps.chambee.ui.actividades.ChatActivity;
import com.gps.chambee.ui.adaptadores.MensajesAdapter;

import java.util.ArrayList;
import java.util.List;


public class MensajesFragment extends Fragment {

    private RecyclerView rvMensajes;
    private ImageView ivCrearMensaje;
    private EditText etBuscarMensajes;

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

        List<Object> lista = new ArrayList<>();
        lista.add(0);
        lista.add(0);
        lista.add(0);
        lista.add(0);
        lista.add(0);
        lista.add(0);
        lista.add(0);
        lista.add(0);

        MensajesAdapter adapter = new MensajesAdapter(view.getContext(),lista);
        rvMensajes.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvMensajes.setAdapter(adapter);

        return view;
    }

}
