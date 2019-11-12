package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gps.chambee.R;
import com.gps.chambee.entidades.Usuario;
import com.gps.chambee.negocios.casos.CUIniciarSesion;
import com.gps.chambee.negocios.casos.CURegistrarUsuario;
import com.gps.chambee.negocios.casos.CasoUso;
import com.gps.chambee.negocios.validadores.ValidadorUsuario;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvIniciar;
    private Button btnRegister;
    private EditText etNombre;
    private EditText etApellidos;
    private EditText etCorreo;
    private EditText etContrasena;
    private EditText etConfirmarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvIniciar = findViewById(R.id.tvIniciar);
        btnRegister = findViewById(R.id.bRegister);
        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        etConfirmarContrasena = findViewById(R.id.etConfirmarContrasena);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, PostRegistroActivity.class));
                finish();
            }
        });


        String nombre = etNombre.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String correo = etCorreo.getText().toString();
        String contrasena = etContrasena.getText().toString();
        String contrasenaConfimada = etConfirmarContrasena.getText().toString();

        if (contrasena == contrasenaConfimada){
            Usuario usuario = new Usuario.UsuarioBuilder()
                    .setNombre(nombre)
                    .setApellidos(apellidos)
                    .setCorreoElectronico(correo)
                    .setContrasenia(contrasena)

                    .build();


            ValidadorUsuario validadorUsuario = new ValidadorUsuario(usuario);
            if (validadorUsuario.validar() == true) {

                CURegistrarUsuario cuRegister = new CURegistrarUsuario(RegisterActivity.this, new CasoUso.EventoPeticionAceptada<String>() {
                    @Override
                    public void alAceptarPeticion(String s) {
                        Intent sharedIntent = new Intent(RegisterActivity.this, PostRegistroActivity.class);
                        startActivity(sharedIntent);
                        finish();


                    }
                }, new CasoUso.EventoPeticionRechazada() {
                    @Override
                    public void alRechazarOperacion() {
                        Toast.makeText(RegisterActivity.this, "No se registra usuario", Toast.LENGTH_SHORT).show();

                    }
                });


                tvIniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RegisterActivity.super.onBackPressed();
                    }
                });

                cuRegister.enviarPeticion(usuario);

            }else {
                Toast.makeText(RegisterActivity.this, validadorUsuario.ultimoError().mensajeError(), Toast.LENGTH_SHORT).show();

            }

        }




    }
}
