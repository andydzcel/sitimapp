package com.example.sitimappcolombia;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sitimappcolombia.adaprters.itemsAdapter;
import com.example.sitimappcolombia.dao.LugaresDAO;

public class listaFavoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favoritos);

        actualizarRecycler();

        ImageButton btnBuscar;


        btnBuscar = (ImageButton) findViewById(R.id.imgbtn_listafavoritos_buscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actualizarRecycler();

            }
        });

    }

    @Override
    protected void onResume() {  //Método que permite actualizar la lista de los nuevos sitios guardados, en tiempo real.
        super.onResume();

        actualizarRecycler();
    }

    private void actualizarRecycler() {

        EditText txtBusqueda = (EditText) findViewById(R.id.txt_listafavoritos_busqueda);

        RecyclerView recyclerFavoritos = (RecyclerView) findViewById(R.id.recyclerview_listafavoritos_misfavoritos);
        recyclerFavoritos.setLayoutManager(new LinearLayoutManager(this));  //Agrego un layout lineal en el recycler para mostrar los sitios guardados uno debajo del otro.

        LugaresDAO db = new LugaresDAO(this);
        itemsAdapter itemAdapter = new itemsAdapter(db.listar(txtBusqueda.getText().toString()));  //Metodo listar en clase asociada a la base de datos.

        recyclerFavoritos.setAdapter(itemAdapter);
    }
}