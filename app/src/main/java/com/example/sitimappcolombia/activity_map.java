package com.example.sitimappcolombia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.sitimappcolombia.clases.Mensajes;

public class activity_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        FloatingActionButton btn_add = (FloatingActionButton) findViewById(R.id.fbtn_map_agregar);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(v.getContext(),misLugares.class);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mni_menumap_aotroslesgusto:
                new Mensajes(this).alerta("Mapa","Has seleccionado 'A otros les gusto'");
                break;
            case R.id.mni_menumap_compras:
                new Mensajes(this).alerta("Mapa","Has seleccionado 'Compras'");
                break;
            case R.id.mni_menumap_cultura:
                new Mensajes(this).alerta("Mapa","Has seleccionado 'Cultura'");
                break;
            case R.id.mni_menumap_diversion:
                new Mensajes(this).alerta("Mapa","Has seleccionado 'Diversion'");
                break;
            case R.id.mni_menumap_favoritos:
                new Mensajes(this).alerta("Mapa","Has seleccionado 'Favoritos'");
                break;
            case R.id.mni_menumap_home:
                Intent i = new Intent(this,activity_home_view.class);
                startActivity(i);
                new Mensajes(this).alerta("Mapa","Has seleccionado 'Home'");
                break;
            case R.id.mni_menumap_hospedaje:
                new Mensajes(this).alerta("Mapa","Has seleccionado 'Hospedaje'");
                break;
            case R.id.mni_menumap_restaurante:
                new Mensajes(this).alerta("Mapa","Has seleccionado 'Restaurantes'");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}