package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.gps.chambee.R;
import com.gps.chambee.negocios.casos.firebase.CFAutenticarUsuario;
import com.gps.chambee.negocios.casos.firebase.CasoUsoFirebase;

public class LoginActivity extends AppCompatActivity {

    private TextView tvRegistrate;
    private LinearLayout llNombre,llSociales;
    private RelativeLayout rlAbajo;
    private ImageView ivLogo;
    private EditText etUsuario;
    private EditText etContrasenaLogin;
    private Button btnIniciarSesion;
    private TextView tvOlvideContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvOlvideContrasena = findViewById(R.id.tvOlvideContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        etContrasenaLogin = findViewById(R.id.etContrasenaLogin);
        etUsuario = findViewById(R.id.etUsuario);
        ivLogo = findViewById(R.id.ivLogo);
        tvRegistrate = findViewById(R.id.tvRegistrate);
        rlAbajo = findViewById(R.id.rlAbajo);
        llNombre = findViewById(R.id.llNombre);
        llSociales = findViewById(R.id.llSociales);

        tvOlvideContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, OlvideContrasenaActivity.class));
            }
        });

        tvRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharedIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                Pair[] pair = new Pair[3];
                pair[0] = new Pair<View,String>(ivLogo,"imageTransition");
                pair[1] = new Pair<View,String>(llNombre,"layoutTransition");
                pair[2] = new Pair<View,String>(rlAbajo,"linearTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pair);
                startActivity(sharedIntent,options.toBundle());
                overridePendingTransition(0, 0);
            }
        });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });
    }

    private void iniciarSesion() {
        String correo = etUsuario.getText().toString();
        String contrasena = etContrasenaLogin.getText().toString();

        new CFAutenticarUsuario(new CasoUsoFirebase.EventoPeticionAceptada<String>() {
            @Override
            public void alAceptarPeticion(String s) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                // TODO agregar usuario al singleton de sesion

            }
        }, new CasoUsoFirebase.EventoPeticionRechazada() {
            @Override
            public void alRechazarOperacion(DatabaseError databaseError) {

                Toast.makeText(LoginActivity.this, "Las credenciales son incorrectas", Toast.LENGTH_LONG).show();

            }
        }).enviarPeticion(correo, contrasena);
    }

    @Override
    public void onBackPressed() {
        ivLogo.setVisibility(View.INVISIBLE);
        super.onBackPressed();
    }
}
