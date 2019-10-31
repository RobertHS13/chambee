package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.chambee.R;

public class TelefonoActivity extends AppCompatActivity {

    private ImageView ivRegresarTelefono;
    private TextView tvTelefonoActual;
    private EditText etNuevoCorreo;
    private Button btnListoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);

        tvTelefonoActual = findViewById(R.id.tvTelefonoActual);
        etNuevoCorreo = findViewById(R.id.etNuevoCorreo);
        btnListoTelefono = findViewById(R.id.btnListoTelefono);
        ivRegresarTelefono = findViewById(R.id.ivRegresarTelefono);

        ivRegresarTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelefonoActivity.super.onBackPressed();
            }
        });

        btnListoTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelefonoActivity.super.onBackPressed();
            }
        });
    }
}
