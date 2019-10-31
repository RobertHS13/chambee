package com.gps.chambee.ui.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gps.chambee.R;
import com.gps.chambee.ui.adaptadores.PostRegistroAdapter;
import com.gps.chambee.ui.fragmentos.PostRegistroDosFragment;
import com.gps.chambee.ui.fragmentos.PostRegistroTresFragment;
import com.gps.chambee.ui.fragmentos.PostRegistroUnoFragment;

import java.util.ArrayList;
import java.util.List;

public class PostRegistroActivity extends AppCompatActivity {

    private ViewPager vpPostRegistro;
    private PostRegistroAdapter prAdapter;
    private LinearLayout rlPuntos;
    private ImageView[] dots;
    private Button btnSiguientePuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_registro2);

        List<Fragment> lista = new ArrayList<>();
        lista.add(new PostRegistroUnoFragment());
        lista.add(new PostRegistroDosFragment());
        lista.add(new PostRegistroTresFragment());


        vpPostRegistro = findViewById(R.id.vpPostRegistro);

        prAdapter = new PostRegistroAdapter(getSupportFragmentManager(),lista);

        vpPostRegistro.setAdapter(prAdapter);

        rlPuntos = findViewById(R.id.rlPuntos);
        btnSiguientePuntos = findViewById(R.id.btnSiguientePost);
        btnSiguientePuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextSlide = vpPostRegistro.getCurrentItem()+1;
                if(nextSlide<3){
                    vpPostRegistro.setCurrentItem(nextSlide);
                }else{
                    startActivity(new Intent(PostRegistroActivity.this,MainActivity.class));
                    finish();
                }
            }
        });

        createDots(0);
        vpPostRegistro.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if(position == 2){
                    btnSiguientePuntos.setText("Terminar");
                }else{
                    btnSiguientePuntos.setText("Avanzar");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int currentPosition){
        if(rlPuntos!=null)
            rlPuntos.removeAllViews();

        dots = new ImageView[3];
        for(int i = 0; i < 3; i++){
            dots[i]=new ImageView(this);
            if(i == currentPosition){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active));
            } else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            rlPuntos.addView(dots[i],params);
        }
    }
    private void nextSlide(){
        int nextSlide =  vpPostRegistro.getCurrentItem()+1;
        if(nextSlide < 3){
            vpPostRegistro.setCurrentItem(nextSlide);
        } else {

        }
    }
}