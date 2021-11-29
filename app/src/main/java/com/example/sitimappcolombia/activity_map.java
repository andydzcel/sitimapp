package com.example.sitimappcolombia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.sitimappcolombia.modelos.Lugares;
import com.example.sitimappcolombia.viewmodels.LugarViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Bar);
        setContentView(R.layout.activity_map);
        Bundle parametros = getIntent().getExtras();
        if(parametros!=null)
            if(!parametros.isEmpty())
            {
                LugarViewModel vmlugares = ViewModelProviders.of(this).get(LugarViewModel.class);
                Lugares l = new Lugares();
                l.setNombre(parametros.getString("nombre"));
                l.setLatitud(parametros.getDouble("latitud"));
                l.setLongitud(parametros.getDouble("longitud"));
                vmlugares.setLugar(l);
            }


        FloatingActionButton fbtnAdd = (FloatingActionButton) findViewById(R.id.fbtn_acrivitymap_add);
        fbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),misLugares.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater propiedades = getMenuInflater();
        propiedades.inflate(R.menu.menumap,menu);

        return super.onCreateOptionsMenu(menu);
    }
}