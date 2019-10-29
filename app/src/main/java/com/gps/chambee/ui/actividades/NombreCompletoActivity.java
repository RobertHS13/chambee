package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.chambee.R;

public class NombreCompletoActivity extends AppCompatActivity {

    private TextView etNombreActual;
    private EditText etNuevoNombre;
    private Button btnListoNombre;
    private ImageView ivRegresarNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_completo);

        etNombreActual = findViewById(R.id.tvNombreActual);
        etNuevoNombre = findViewById(R.id.etNuevoNombre);
        btnListoNombre = findViewById(R.id.btnListoNombre);
        ivRegresarNombre = findViewById(R.id.ivRegresarNombre);

        ivRegresarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NombreCompletoActivity.super.onBackPressed();
            }
        });

        btnListoNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NombreCompletoActivity.super.onBackPressed();
            }
        });

    }
}
