package com.gps.chambee.ui.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.chambee.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class PublicacionEmpresaAdapter extends RecyclerView.Adapter<PublicacionEmpresaAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreReclutador;
        CircleImageView civFotoPerfilEmpresa;
        TextView tvTiempoPublicacion;
        TextView tvEtiquetaPrincipal;
        TextView tvInteresados;
        TextView tvComentariosEmpresa;
        TextView tvVistos;
        TextView tvNombreTrabajoPublicacion;
        TextView tvDescripcionPublicacionTrabajo;
        ImageView ivImagenPublicacionTrabajo;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tvNombreReclutador = itemView.findViewById(R.id.tvNombreReclutador);
            civFotoPerfilEmpresa = itemView.findViewById(R.id.civFotoPerfilEmpresa);
            tvTiempoPublicacion = itemView.findViewById(R.id.tvTiempoPublicacion);
            tvEtiquetaPrincipal = itemView.findViewById(R.id.tvEtiquetaPrincipal);
            tvInteresados = itemView.findViewById(R.id.tvInteresados);
            tvComentariosEmpresa = itemView.findViewById(R.id.tvComentariosEmpresa);
            tvVistos = itemView.findViewById(R.id.tvVistos);
            tvNombreTrabajoPublicacion = itemView.findViewById(R.id.tvNombreTrabajoPublicacion);
            tvDescripcionPublicacionTrabajo = itemView.findViewById(R.id.tvDescripcionPublicacionTrabajo);
            ivImagenPublicacionTrabajo = itemView.findViewById(R.id.ivImagenPublicacionTrabajo);

        }
    }

    private Context context;
    private List<Object> lista;

    public PublicacionEmpresaAdapter(Context context, List<Object> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_publicacion_empresa, parent, false);
        return new PublicacionEmpresaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}
