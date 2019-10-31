package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gps.chambee.R;

public class ConfiguracionesActivity extends AppCompatActivity {

    private LinearLayout llDatosPersonales;
    private LinearLayout llSeguridad;
    private ImageView ivRegresarConfiguracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones);

        llSeguridad = findViewById(R.id.llSeguridad);
        llDatosPersonales = findViewById(R.id.llDatosPersonales);
        ivRegresarConfiguracion = findViewById(R.id.ivRegresarConfiguracion);

        ivRegresarConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfiguracionesActivity.super.onBackPressed();
            }
        });

        llSeguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfiguracionesActivity.this, SeguridadActivity.class));
            }
        });

        llDatosPersonales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfiguracionesActivity.this, DatosPersonalesActivity.class));
            }
        });
    }
}
