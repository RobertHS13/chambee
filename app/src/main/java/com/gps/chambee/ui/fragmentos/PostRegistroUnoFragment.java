package com.gps.chambee.ui.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gps.chambee.R;

import androidx.fragment.app.Fragment;

public class PostRegistroUnoFragment extends Fragment {

    private ImageView civFotoPost;
    private EditText etAcercaDeMi;

    public View onCreateView(LayoutInflater inflater, ViewGroup context, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_post_parte_1, context, false);

        civFotoPost = view.findViewById(R.id.civFotoPost);
        etAcercaDeMi = view.findViewById(R.id.etAcercaDeMi);

        civFotoPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),"Subir Foto",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
