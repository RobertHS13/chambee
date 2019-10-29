package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gps.chambee.R;

public class SeguridadActivity extends AppCompatActivity {

    private LinearLayout llContrasena;
    private ImageView ivRegresarSeguridad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad);

        llContrasena = findViewById(R.id.llContrasena);
        ivRegresarSeguridad = findViewById(R.id.ivRegresarSeguridad);

        ivRegresarSeguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeguridadActivity.super.onBackPressed();
            }
        });

        llContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SeguridadActivity.this,PasswordActivity.class));
            }
        });

    }
}
