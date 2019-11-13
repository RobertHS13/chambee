package com.gps.chambee.ui.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.chambee.R;
import com.gps.chambee.entidades.PublicacionEmpresa;
import com.gps.chambee.negocios.casos.CUObtenerImagen;
import com.gps.chambee.negocios.casos.CasoUso;

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
    private List<PublicacionEmpresa> lista;

    public PublicacionEmpresaAdapter(Context context, List<PublicacionEmpresa> lista) {
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
      
        PublicacionEmpresa publicacion = (PublicacionEmpresa) lista.get(position);

        holder.tvComentariosEmpresa.setText(publicacion.getComentarios());
        holder.tvDescripcionPublicacionTrabajo.setText(publicacion.getDescripcion());
        holder.tvEtiquetaPrincipal.setText(publicacion.getEtiqueta());
        holder.tvInteresados.setText(publicacion.getInteresados());
        holder.tvNombreReclutador.setText(publicacion.getNombreEmpresa());
        holder.tvTiempoPublicacion.setText(publicacion.getTiempo());
        holder.tvNombreTrabajoPublicacion.setText(publicacion.getNombreTrabajo());
        holder.tvVistos.setText(publicacion.getVistos());

        new CUObtenerImagen(context, new CasoUso.EventoPeticionAceptada<Bitmap>() {
            @Override
            public void alAceptarPeticion(Bitmap bitmap) {
                holder.civFotoPerfilEmpresa.setImageBitmap(bitmap);
            }
        }, new CasoUso.EventoPeticionRechazada() {
            @Override
            public void alRechazarOperacion() {

            }
        }).enviarPeticion(publicacion.getUrlImagenEmpresa());

        new CUObtenerImagen(context, new CasoUso.EventoPeticionAceptada<Bitmap>() {
            @Override
            public void alAceptarPeticion(Bitmap bitmap) {
                holder.ivImagenPublicacionTrabajo.setImageBitmap(bitmap);
            }
        }, new CasoUso.EventoPeticionRechazada() {
            @Override
            public void alRechazarOperacion() {

            }
        }).enviarPeticion(publicacion.getUrlImagenTrabajo());
        final Bitmap imagenTrabajo = null;
        Bitmap imagenEmpresa = null;

        new CUObtenerImagen(
                context,
                new CasoUso.EventoPeticionAceptada<Bitmap>() {

                    @Override
                    public void alAceptarPeticion(Bitmap bitmap) {
                        holder.civFotoPerfilEmpresa.setImageBitmap(bitmap);
                    }
                },
                new CasoUso.EventoPeticionRechazada() {
                    @Override
                    public void alRechazarOperacion() {
                        Bitmap imagen = BitmapFactory.decodeResource(
                                context.getResources(),
                                R.drawable.ic_person);
                        holder.civFotoPerfilEmpresa.setImageBitmap(imagen);
                    }
                }).enviarPeticion(publicacion.getUrlImagenEmpresa());

        new CUObtenerImagen(
                context,
                new CasoUso.EventoPeticionAceptada<Bitmap>() {
                    @Override
                    public void alAceptarPeticion(Bitmap bitmap) {
                        holder.ivImagenPublicacionTrabajo.setImageBitmap(bitmap);
                    }
                },
                new CasoUso.EventoPeticionRechazada() {
                    @Override
                    public void alRechazarOperacion() {
                        Bitmap imagen = BitmapFactory.decodeResource(
                                context.getResources(),
                                R.drawable.ic_person);
                        holder.civFotoPerfilEmpresa.setImageBitmap(imagen);
                    }
                }
        ).enviarPeticion(publicacion.getUrlImagenTrabajo());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}