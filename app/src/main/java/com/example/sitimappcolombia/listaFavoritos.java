package com.example.sitimappcolombia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sitimappcolombia.adaprters.itemsAdapter;
import com.example.sitimappcolombia.dao.LugaresDAO;

public class listaFavoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favoritos);

        actualizarRecycler();
    }

    @Override
    protected void onResume() {  //Método que permite actualizar la lista de los nuevos sitios guardados, en tiempo real.
        super.onResume();

        actualizarRecycler();
    }

    private void actualizarRecycler() {

        RecyclerView recyclerFavoritos = (RecyclerView) findViewById(R.id.recyclerview_listafavoritos_misfavoritos);
        recyclerFavoritos.setLayoutManager(new LinearLayoutManager(this));  //Agrego un layout lineal en el recycler para mostrar los sitios guardados uno debajo del otro.

        LugaresDAO db = new LugaresDAO(this);
        itemsAdapter itemAdapter = new itemsAdapter(db.listar());  //Metodo listar en clase asociada a la base de datos.

        recyclerFavoritos.setAdapter(itemAdapter);
    }
}