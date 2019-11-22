package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gps.chambee.R;

public class ChatActivity extends AppCompatActivity {

    private ImageView ivCalificar;

    private String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ivCalificar = findViewById(R.id.ivCalificar);
        ivCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatActivity.this,CalificarUsuarioActivity.class));
            }
        });
    }
}
