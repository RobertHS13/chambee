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

public class TelefonoActivity extends AppCompatActivity {

    private ImageView ivRegresarTelefono;
    private TextView tvTelefonoActual;
    private EditText etNuevoCorreo;
    private Button btnListoTelefono;

    Usuario usuario = (Usuario) SingletonSesion.getInstance().getObjetosSesion().get("Usuario");

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

                String telefono = etNuevoCorreo.getText().toString();
                ValidadorTelefono validadorTelefono = new ValidadorTelefono();

                if(!validadorTelefono.validar()){
                    Toast.makeText(TelefonoActivity.this, validadorTelefono.ultimoError().mensajeError(), Toast.LENGTH_LONG).show();
                    return;
                }

                CUActualizarUsuario cuActualizarUsuario = new CUActualizarUsuario(
                        TelefonoActivity.this,
                        new CasoUso.EventoPeticionAceptada<String>() {
                            @Override
                            public void alAceptarPeticion(String s) {
                                finish();
                            }
                        }, new CasoUso.EventoPeticionRechazada() {
                    @Override
                    public void alRechazarOperacion() {
                        Toast.makeText(TelefonoActivity.this, "No tienes internet.", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                );

                usuario.setTelefono(telefono);

                TelefonoActivity.super.onBackPressed();
            }
        });

        tvTelefonoActual.setText(usuario.getCorreoElectronico());
    }
}
