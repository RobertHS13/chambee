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

public class MedallasAdapter extends RecyclerView.Adapter<MedallasAdapter.ViewHolder>  {

    private Context context;
    private List<Object> lista;

    public MedallasAdapter(Context context, List<Object> lista){
        this.context=context;
        this.lista=lista;
    }

    @NonNull
    @Override
    public MedallasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_medallas,parent,false);

        return new MedallasAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedallasAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView ivMedalla;
        TextView tvNumeroMedallas;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivMedalla = itemView.findViewById(R.id.ivMedalla);
            tvNumeroMedallas = itemView.findViewById(R.id.tvNumeroMedallas);
        }
    }
}
