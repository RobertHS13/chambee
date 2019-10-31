package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gps.chambee.R;

public class DatosPersonalesActivity extends AppCompatActivity {

    private LinearLayout llNombre;
    private LinearLayout llCorreoElectronico;
    private LinearLayout llTelefono;
    private ImageView ivRegresarDatosPersonales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        llTelefono = findViewById(R.id.llTelefono);
        llNombre = findViewById(R.id.llNombre);
        llCorreoElectronico = findViewById(R.id.llCorreoElectronico);
        ivRegresarDatosPersonales = findViewById(R.id.ivRegresarDatosPersonales);

        ivRegresarDatosPersonales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatosPersonalesActivity.super.onBackPressed();
            }
        });

        llTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatosPersonalesActivity.this, TelefonoActivity.class));
            }
        });

        llCorreoElectronico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatosPersonalesActivity.this,CorreoElectronicoActivity.class));
            }
        });

        llNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatosPersonalesActivity.this,NombreCompletoActivity.class));
            }
        });
    }
}
