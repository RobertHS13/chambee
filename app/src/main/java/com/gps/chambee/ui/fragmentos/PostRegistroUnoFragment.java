package com.gps.chambee.ui.fragmentos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gps.chambee.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class PostRegistroUnoFragment extends Fragment {

    public static final int PETICION_CAMARA = 1;
    public static final int PETICION_GALERIA = 2;



    private ImageView civFotoPost;
    private EditText etAcercaDeMi;


    public View onCreateView(LayoutInflater inflater, ViewGroup context, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_post_parte_1, context, false);

        civFotoPost = view.findViewById(R.id.civFotoPost);
        etAcercaDeMi = view.findViewById(R.id.etAcercaDeMi);

        String acerca = etAcercaDeMi.getText().toString();
        civFotoPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarOpcionesImagen();
            }
        });

        civFotoPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mostrarOpcionesImagen();
                Toast.makeText(view.getContext(),"Subir Foto",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private void mostrarOpcionesImagen() {
        final CharSequence[] opciones = {"Tomar foto","Elegir de galeria","Cancelar"};

        final AlertDialog.Builder builer = new AlertDialog.Builder(getContext())
        .setTitle("Elige una opcion")
        .setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0: {
                        abrirCamara();
                        break;
                    }
                    case 1: {
                        abrirGaleria();
                        break;
                    }
                    case 2: {
                        dialog.dismiss();
                        break;
                    }
                }
            }
        });
        builer.show();
    }

    private void abrirGaleria() {
        String action = Intent.ACTION_PICK;
        Intent intent = new Intent(action, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        intent.setType("image/");
        startActivityForResult(Intent.createChooser(intent,"Seleccione imagen"),PETICION_GALERIA);
    }

    private void abrirCamara() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(camera,PETICION_CAMARA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


    }
}
