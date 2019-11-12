package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gps.chambee.R;
import com.gps.chambee.entidades.SingletonSesion;
import com.gps.chambee.entidades.Usuario;
import com.gps.chambee.negocios.casos.CUActualizarUsuario;
import com.gps.chambee.negocios.casos.CasoUso;
import com.gps.chambee.negocios.validadores.propiedades.ValidadorNombre;

public class NombreCompletoActivity extends AppCompatActivity {

    private TextView etNombreActual;
    private EditText etNuevoNombre;
    private Button btnListoNombre;
    private ImageView ivRegresarNombre;

    Usuario usuario = (Usuario) SingletonSesion.getInstance().getObjetosSesion().get("Usuario");

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
                String nombreCompleto = etNuevoNombre.getText().toString();
                ValidadorNombre validadorNombre = new ValidadorNombre(nombreCompleto);

                if(!validadorNombre.validar()) {
                    Toast.makeText(NombreCompletoActivity.this, validadorNombre.ultimoError().mensajeError(), Toast.LENGTH_LONG).show();
                    return;
                }

                CUActualizarUsuario cuActualizarUsuario = new CUActualizarUsuario(
                        NombreCompletoActivity.this,
                        new CasoUso.EventoPeticionAceptada<String>() {
                            @Override
                            public void alAceptarPeticion(String s) {
                                finish();
                            }
                        }, new CasoUso.EventoPeticionRechazada() {
                    @Override
                    public void alRechazarOperacion() {
                        Toast.makeText(NombreCompletoActivity.this, "No tienes internet.", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                );

                usuario.setNombre(nombreCompleto);

                NombreCompletoActivity.super.onBackPressed();
            }
        });

        etNombreActual.setText(usuario.getNombre());
    }
}
