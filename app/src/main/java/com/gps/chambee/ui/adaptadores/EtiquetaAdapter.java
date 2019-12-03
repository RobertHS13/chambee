package com.gps.chambee.ui.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gps.chambee.R;
import com.gps.chambee.entidades.Categoria;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EtiquetaAdapter extends RecyclerView.Adapter<EtiquetaAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvEtiqueta;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            tvEtiqueta = itemView.findViewById(R.id.tvEtiqueta);
        }
    }
    private Context context;
    private List<Categoria> lista;

    public EtiquetaAdapter(Context context, List<Categoria> lista){
        this.context=context;
        this.lista=lista;
    }

    @NonNull
    @Override
    public EtiquetaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_etiquetas,parent,false);
        return new EtiquetaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EtiquetaAdapter.ViewHolder holder, int position) {
        holder.tvEtiqueta.setText(lista.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}