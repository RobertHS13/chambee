package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.chambee.R;

public class PasswordActivity extends AppCompatActivity {

    private TextView tvOlvidasteContrasena;
    private EditText etContrasenaActualSeguridad;
    private EditText etConfirmarContrasenaSeguridad;
    private EditText etNuevaContrasenaSeguridad;
    private ImageView ivRegresarContrasena;
    private Button btnListoContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        etNuevaContrasenaSeguridad = findViewById(R.id.etNuevaContrasenaSeguridad);
        tvOlvidasteContrasena = findViewById(R.id.tvOlvidasteContrasena);
        etContrasenaActualSeguridad = findViewById(R.id.etContrasenaActualSeguridad);
        etConfirmarContrasenaSeguridad = findViewById(R.id.etConfirmarContrasenaSeguridad);
        ivRegresarContrasena = findViewById(R.id.ivRegresarContrasena);
        btnListoContrasena = findViewById(R.id.btnListoContrasena);

        btnListoContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PasswordActivity.super.onBackPressed();
            }
        });

        ivRegresarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PasswordActivity.super.onBackPressed();
            }
        });

        tvOlvidasteContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PasswordActivity.this, OlvideContrasenaActivity.class));
            }
        });

    }
}
