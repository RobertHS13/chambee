package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.chambee.R;

public class CorreoElectronicoActivity extends AppCompatActivity {

    private TextView tvActualCorreoElectronico;
    private EditText etNuevoCorreo;
    private ImageView ivRegresarCorreo;
    private Button btnListoCorreo;

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
                CorreoElectronicoActivity.super.onBackPressed();
            }
        });

        ivRegresarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CorreoElectronicoActivity.super.onBackPressed();
            }
        });

    }
}
