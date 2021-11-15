package com.example.sitimappcolombia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sitimappcolombia.clases.Mensajes;

public class activity_home_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        Button btn_AcercaDe = (Button) findViewById(R.id.btn_home_view_acercade);
        btn_AcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new Mensajes(view.getContext()).toast("Has seleccionado 'Acerca de'");
                Intent i = new Intent(view.getContext(), AcercaDe.class);
                startActivity(i);
            }
        });

        Button btn_favoritos = (Button) findViewById(R.id.btn_home_view_favoritos);
        btn_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Mensajes(v.getContext()).toast("Has seleccionado 'Favoritos'");
                Intent i = new Intent(v.getContext(),listaFavoritos.class);
                startActivity(i);
            }
        });

        Button btn_agregarlugar =(Button) findViewById(R.id.btn_home_view_agregarlugar);
        btn_agregarlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Mensajes(v.getContext()).toast("Has seleccionado 'Agregar lugar'");
                Intent i = new Intent(v.getContext(),misLugares.class);
                startActivity(i);
            }
        });

        Button btn_salir =(Button) findViewById(R.id.btn_home_view_salir);
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Mensajes(v.getContext()).toast("Has seleccionado 'Salir'");
                Intent i= new Intent(v.getContext(),login.class);
                startActivity(i);
            }
        });

        Button btn_sitios = (Button) findViewById(R.id.btn_home_view_sitios);
        btn_sitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Mensajes(v.getContext()).toast("Has seleccionado 'Sitios'");
                Intent i= new Intent(v.getContext(),activity_map.class);
                startActivity(i);
            }
        });

    }
}