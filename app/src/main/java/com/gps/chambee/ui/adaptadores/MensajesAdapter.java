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

public class MensajesAdapter extends RecyclerView.Adapter<MensajesAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mensajes,parent,false);
        return new MensajesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView civFotoMensajes;
        TextView tvUsuarioChat;
        TextView tvMensaje;
        TextView tvNumeroMensaje;
        TextView tvFechaChat;

        public ViewHolder (View itemView){
            super(itemView);
            civFotoMensajes = itemView.findViewById(R.id.civFotoMensajes);
            tvUsuarioChat = itemView.findViewById(R.id.tvUsuarioChat);
            tvMensaje = itemView.findViewById(R.id.tvMensaje);
            tvNumeroMensaje = itemView.findViewById(R.id.tvNumeroMensaje);
            tvFechaChat = itemView.findViewById(R.id.tvFechaChat);
        }
    }

    private Context context;
    private List<Object> lista;

    public MensajesAdapter (Context context, List<Object> lista){
        this.context = context;
        this.lista = lista;
    }
}
