package com.gps.chambee.ui.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.chambee.R;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RegistroTrabajosAdapter extends RecyclerView.Adapter<RegistroTrabajosAdapter.ViewHolder> {

    private Context context;
    private List<Object> lista;

    public RegistroTrabajosAdapter(Context context, List<Object> lista){
        this.context=context;
        this.lista=lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_registro_trabajos,parent,false);

        return new RegistroTrabajosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView ivFotoPuestoTrabajo;
        TextView tvNombrePuesto;
        TextView tvEmpresaRegistro;
        TextView tvCalificacionEstrellas;
        TextView tvNumeroCalificacionTrabajos;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivFotoPuestoTrabajo = itemView.findViewById(R.id.ivFotoPuestoTrabajo);
            tvNombrePuesto = itemView.findViewById(R.id.tvNombrePuesto);
            tvEmpresaRegistro = itemView.findViewById(R.id.tvEmpresaRegistro);
            tvCalificacionEstrellas = itemView.findViewById(R.id.tvCalificacionEstrellas);
            tvNumeroCalificacionTrabajos = itemView.findViewById(R.id.tvNumeroCalificacionTrabajos);
        }
    }
}
