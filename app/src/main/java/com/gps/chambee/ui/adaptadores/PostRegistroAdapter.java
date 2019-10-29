package com.gps.chambee.ui.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gps.chambee.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class PostRegistroAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> lista;

    public PostRegistroAdapter(FragmentManager fm, List<Fragment> lista){
        super(fm);
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lista.get(position);
    }

}
