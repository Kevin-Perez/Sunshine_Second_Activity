package com.example.kevin.sunshine_second_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Kevin on 04/06/2015.
 */
public abstract class ClimaAdapter extends BaseAdapter {
    private ArrayList<?> entradas;
    private int resource;
    private Context context;

    public ClimaAdapter(Context context, int resource, ArrayList<?> entradas) {
        super();
        this.context = context;
        this.resource = resource;
        this.entradas = entradas;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup pariente) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(resource, null);
        }
        onEntrada (entradas.get(posicion), view);
        return view;
    }

    @Override
    public int getCount() {
        return entradas.size();
    }

    @Override
    public Object getItem(int posicion) {
        return entradas.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    public abstract void onEntrada (Object entrada, View view);
}
