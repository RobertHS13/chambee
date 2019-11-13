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
import com.gps.chambee.negocios.validadores.ValidadorCorreo;

public class CorreoElectronicoActivity extends AppCompatActivity {

    private TextView tvActualCorreoElectronico;
    private EditText etNuevoCorreo;
    private ImageView ivRegresarCorreo;
    private Button btnListoCorreo;

    Usuario usuario = (Usuario) SingletonSesion.getInstance().getObjetosSesion().get("Usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);

        tvActualCorreoElectronico = findViewById(R.id.tvActualCorreoElectronico);
        etNuevoCorreo = findViewById(R.id.etNuevoCorreo);
        ivRegresarCorreo = findViewById(R.id.ivRegresarCorreo);
        btnListoCorreo = findViewById(R.id.btnListoCorreo);

        btnListoCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String correoElectronico = etNuevoCorreo.getText().toString();
                ValidadorCorreo validadorCorreo = new ValidadorCorreo(correoElectronico);

                if(!validadorCorreo.validar()){
                    Toast.makeText(CorreoElectronicoActivity.this, validadorCorreo.ultimoError().mensajeError(), Toast.LENGTH_LONG).show();
                    return;
                }

                CUActualizarUsuario cuActualizarUsuario = new CUActualizarUsuario(
                        CorreoElectronicoActivity.this,
                        new CasoUso.EventoPeticionAceptada<String>() {
                            @Override
                            public void alAceptarPeticion(String s) {
                                finish();
                            }
                        }, new CasoUso.EventoPeticionRechazada() {
                    @Override
                    public void alRechazarOperacion() {
                        Toast.makeText(CorreoElectronicoActivity.this, "No tienes internet.", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                );

                usuario.setCorreoElectronico(correoElectronico);

                CorreoElectronicoActivity.super.onBackPressed();
            }
        });

        ivRegresarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CorreoElectronicoActivity.super.onBackPressed();
            }
        });

        tvActualCorreoElectronico.setText(usuario.getCorreoElectronico());

    }
}
