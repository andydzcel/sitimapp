package com.example.sitimappcolombia;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;

public class activity_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Bar);
        setContentView(R.layout.activity_map);

        /*FloatingActionButton fbtnAdd = (FloatingActionButton) findViewById(R.id.fbtn_activity_map_add);
        fbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),listaFavoritos.class);
                startActivity(i);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater propiedades = getMenuInflater();
        propiedades.inflate(R.menu.menumap,menu);

        return super.onCreateOptionsMenu(menu);
    }
}