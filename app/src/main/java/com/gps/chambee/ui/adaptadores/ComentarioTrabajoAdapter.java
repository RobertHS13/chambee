package com.gps.chambee.ui.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gps.chambee.R;
import com.gps.chambee.entidades.Comentario;
import com.gps.chambee.entidades.vistas.ComentarioPublicacion;
import com.gps.chambee.negocios.casos.CUObtenerImagen;
import com.gps.chambee.negocios.casos.CasoUso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class ComentarioTrabajoAdapter extends RecyclerView.Adapter<ComentarioTrabajoAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView civFotoComentario;
        TextView tvComentarioPersona;
        TextView tvComentario;
        //TextView tvLikesComentario;
        TextView tvComentariosComentario;
        TextView tvTiempoComentario;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            civFotoComentario = itemView.findViewById(R.id.civFotoComentario);
            tvComentarioPersona = itemView.findViewById(R.id.tvComentariosPersona);
            tvComentario = itemView.findViewById(R.id.tvComentario);
            //tvLikesComentario = itemView.findViewById(R.id.tvLikesComentario);
            tvComentariosComentario = itemView.findViewById(R.id.tvComentariosComentario);
            tvTiempoComentario = itemView.findViewById(R.id.tvTiempoComentario);

        }
    }

    private Context context;
    private List<ComentarioPublicacion> lista;

    public ComentarioTrabajoAdapter(Context context, List<ComentarioPublicacion> lista){
        this.context=context;
        this.lista=lista;
    }

    @NonNull
    @Override
    public ComentarioTrabajoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_comentario,parent,false);
        return new ComentarioTrabajoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ComentarioTrabajoAdapter.ViewHolder holder, int position) {
        ComentarioPublicacion comentario = lista.get(position);

        new CUObtenerImagen(
                context,
                new CasoUso.EventoPeticionAceptada<Bitmap>() {
                    @Override
                    public void alAceptarPeticion(Bitmap bitmap) {
                        holder.civFotoComentario.setImageBitmap(bitmap);
                    }
                },
                new CasoUso.EventoPeticionRechazada() {
                    @Override
                    public void alRechazarOperacion() {
                        Bitmap imagen = BitmapFactory.decodeResource(
                                context.getResources(),
                                R.drawable.ic_person
                        );
                        holder.civFotoComentario.setImageBitmap(imagen);
                    }
                }
        ).enviarPeticion(comentario.getUrl_imagen());

        String comentarioCompelto = comentario.getComentario();
        String usuario = comentario.getNombreUsuario();
        String tiempo  = comentario.getTiempo();
        String likes = comentario.getInteresados();

        String EMPTY = "EMPTY STRING";

        if (comentarioCompelto != null) holder.tvComentario.setText(comentarioCompelto);
        else holder.tvComentario.setText(EMPTY);

        if (!usuario.isEmpty()) holder.tvComentarioPersona.setText(usuario);
        else holder.tvComentarioPersona.setText(EMPTY);

        if (!tiempo.isEmpty()) holder.tvTiempoComentario.setText(tiempo);
        else holder.tvTiempoComentario.setText(EMPTY);

       /* if (!likes.isEmpty()) holder.tvLikesComentario.setText(likes);
        else holder.tvLikesComentario.setText(EMPTY);*/
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
