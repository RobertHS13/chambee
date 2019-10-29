package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gps.chambee.R;

public class OlvideContrasenaActivity extends AppCompatActivity {

    private Button btnSiguienteCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvide_contrasena);

        btnSiguienteCorreo = findViewById(R.id.btnSiguienteCorreo);
        btnSiguienteCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OlvideContrasenaActivity.this,RecuperarPasswordActivity.class ));
            }
        });

    }
}
