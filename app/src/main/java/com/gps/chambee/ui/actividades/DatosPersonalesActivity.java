package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gps.chambee.R;
import com.gps.chambee.entidades.SingletonSesion;
import com.gps.chambee.entidades.Usuario;

public class DatosPersonalesActivity extends AppCompatActivity {

    private LinearLayout llNombre;
    private LinearLayout llCorreoElectronico;
    private LinearLayout llTelefono;
    private ImageView ivRegresarDatosPersonales;
    private TextView tvUserName;
    private TextView tvUserEmailAddress;
    private TextView tvUserPhone;

    Usuario usuario = (Usuario) SingletonSesion.getInstance().getObjetosSesion().get("Usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        llTelefono = findViewById(R.id.llTelefono);
        llNombre = findViewById(R.id.llNombre);
        llCorreoElectronico = findViewById(R.id.llCorreoElectronico);
        ivRegresarDatosPersonales = findViewById(R.id.ivRegresarDatosPersonales);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserEmailAddress = findViewById(R.id.tvUserEmailAddress);
        tvUserPhone = findViewById(R.id.tvUserPhone);

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

        tvUserName.setText(usuario.getNombre() + usuario.getApellidos());
        tvUserEmailAddress.setText(usuario.getCorreoElectronico());
        tvUserPhone.setText(usuario.getTelefono());
    }
}
