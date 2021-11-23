package com.example.sitimappcolombia.adaprters;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.sitimappcolombia.R;

public class ViewSp_Adpater_mis_lugares implements SpinnerAdapter {

    private final String[] datos;

    public ViewSp_Adpater_mis_lugares(String[] datos) {
        this.datos = datos;
    }

    @Override
    public View getDropDownView( int i, View view, ViewGroup viewGroup){
        TextView tv=(TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item,viewGroup,false);
        tv.setText(datos[i]);
        return tv;
    }

    @Override
    public void registerDataSetObserver (DataSetObserver dataSetObserver){

    }

    @Override
    public void unregisterDataSetObserver (DataSetObserver observer){

    }

    @Override
    public int getCount () {
        return datos.length;
    }

    @Override
    public Object getItem ( int i){
        return datos[i];
    }

    @Override
    public long getItemId ( int i){
        return i;
    }

    @Override
    public boolean hasStableIds () {
        return false;
    }

    @Override
    public View getView ( int i, View view, ViewGroup viewGroup){
        TextView tv = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, viewGroup, false);
        tv.setText(datos[i]);
        return tv;
    }

    @Override
    public int getItemViewType ( int i){
        return i;
    }

    @Override
    public int getViewTypeCount () {
        return 1;
    }

    @Override
    public boolean isEmpty () {
        return false;
    }
}

