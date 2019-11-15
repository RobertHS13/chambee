package com.gps.chambee.ui.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gps.chambee.R;
import com.gps.chambee.entidades.vistas.PublicacionEmpresa;
import com.gps.chambee.negocios.casos.CUListarPublicacionesEmpresas;
import com.gps.chambee.negocios.casos.CasoUso;
import com.gps.chambee.ui.adaptadores.PublicacionEmpresaAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExplorarEmpleosFragment extends Fragment {

    private RecyclerView rvEmpleos;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.fragment_explorar_empleos, container, false);

        rvEmpleos = view.findViewById(R.id.rvEmpleos);
        List<PublicacionEmpresa> lista = new ArrayList<>();

        rvEmpleos.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //PublicacionEmpresaAdapter adapter = new PublicacionEmpresaAdapter(view.getContext(),lista);
        //rvEmpleos.setAdapter(adapter);

        new CUListarPublicacionesEmpresas(getContext(), new CasoUso.EventoPeticionAceptada<List<PublicacionEmpresa>>() {

            @Override
            public void alAceptarPeticion(List<PublicacionEmpresa> publicaciones) {
                llenarPublicacionesEmpresas(publicaciones, view);
            }
        }, new CasoUso.EventoPeticionRechazada() {
            @Override
            public void alRechazarOperacion() {
            }
        }).enviarPeticion();

        return view;
    }

    private void llenarPublicacionesEmpresas(List<PublicacionEmpresa> publicaciones, View view){
        PublicacionEmpresaAdapter adapter = new PublicacionEmpresaAdapter(view.getContext(), publicaciones);
        rvEmpleos.setLayoutManager(new LinearLayoutManager(view.getContext()){
            @Override
            public boolean canScrollVertically(){return false;}
        });
        rvEmpleos.setHasFixedSize(true);
        rvEmpleos.setAdapter(adapter);
    }
}