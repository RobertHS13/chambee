package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gps.chambee.R;
import com.gps.chambee.negocios.validadores.propiedades.ValidadorContrasenia;

public class OlvideContrasenaActivity extends AppCompatActivity {

    private Button btnSiguienteCorreo;
    private TextView correoRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvide_contrasena);

        correoRecuperar = findViewById(R.id.etCorreoRecuperar);
        btnSiguienteCorreo = findViewById(R.id.btnSiguienteCorreo);

        btnSiguienteCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String correoElectronico = correoRecuperar.getText().toString();
                ValidadorCorreo validadorCorreo = new ValidadorCorreo(correoElectronico);

                if(!validadorCorreo.validar()){
                    Toast.makeText(OlvideContrasenaActivity.this, validadorCorreo.ultimoError().mensajeError(), Toast.LENGTH_LONG).show();
                    return;
                }

                startActivity(new Intent(OlvideContrasenaActivity.this,RecuperarPasswordActivity.class ));
            }
        });

    }
}