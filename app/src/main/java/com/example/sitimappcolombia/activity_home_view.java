package com.example.sitimappcolombia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_home_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        Button btn_AcercaDe = (Button) findViewById(R.id.btn_acercade);
        btn_AcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AcercaDe.class);
                startActivity(i);
            }
        });

        Button btn_favoritos = (Button) findViewById(R.id.btn_favoritos);
        btn_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),listaFavoritos.class);
                startActivity(i);
            }
        });

        Button btn_agregarlugar =(Button) findViewById(R.id.btn_agregarlugar);
        btn_agregarlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),misLugares.class);
                startActivity(i);
            }
        });

        Button btn_salir =(Button) findViewById(R.id.btn_salir);
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(v.getContext(),login.class);
                startActivity(i);
            }
        });
    }
}