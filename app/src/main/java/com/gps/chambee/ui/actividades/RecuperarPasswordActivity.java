package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gps.chambee.R;

public class RecuperarPasswordActivity extends AppCompatActivity {

    private Button btnVerificarCodigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_password);



        btnVerificarCodigo = findViewById(R.id.btnVerificarCodigo);
        btnVerificarCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecuperarPasswordActivity.this, PasswordNuevaActivity.class));
            }
        });
    }
}
