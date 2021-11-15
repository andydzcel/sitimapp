package com.example.sitimappcolombia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.ImageButton;

public class listaFavoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favoritos);

        ImageButton img_button = (ImageButton) findViewById(R.id.imgbtn_itemslistafavoritos_vermas);
        img_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(listaFavoritos.this, img_button);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_listafavoritos, popup.getMenu());

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method
    }
}