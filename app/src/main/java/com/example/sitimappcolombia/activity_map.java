package com.example.sitimappcolombia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class activity_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater propiedades = getMenuInflater();
        propiedades.inflate(R.menu.menumap,menu);

        return super.onCreateOptionsMenu(menu);
    }
}