package com.gps.chambee.ui.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gps.chambee.R;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class PublicacionPersonaAdapter extends RecyclerView.Adapter<PublicacionPersonaAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView civFotoPerfilPersona;
        TextView tvNombrePersonaPublicacion;
        TextView tvTiempoPublicacionPersona;
        TextView tvEtiquetaPublicacionPersona;
        TextView tvLikesPersona;
        TextView tvComentariosPersona;
        TextView tvVistosPersona;
        TextView tvDescripcionPersona;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            civFotoPerfilPersona = itemView.findViewById(R.id.civFotoPerfil);
            tvNombrePersonaPublicacion = itemView.findViewById(R.id.tvNombrePersonaPublicacion);
            tvTiempoPublicacionPersona = itemView.findViewById(R.id.tvTiempoPublicacionPersona);
            tvEtiquetaPublicacionPersona = itemView.findViewById(R.id.tvEtiquetaPublicacionPersona);
            tvLikesPersona = itemView.findViewById(R.id.tvLikesPersona);
            tvComentariosPersona = itemView.findViewById(R.id.tvComentariosPersona);
            tvVistosPersona = itemView.findViewById(R.id.tvVistosPersona);
            tvDescripcionPersona = itemView.findViewById(R.id.tvDescripcionPersona);

        }
    }

    private Context context;
    private List<Object> lista;

    public PublicacionPersonaAdapter(Context context,List<Object> lista){
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_publicacion_persona,parent,false);
        return new PublicacionPersonaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicacionPersonaAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
