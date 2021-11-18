package com.example.sitimappcolombia.adaprters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sitimappcolombia.R;
import com.example.sitimappcolombia.modelos.Lugares;

import java.util.ArrayList;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.ViewHolderFavoritos> {


    ArrayList<Lugares> sitios;

    public itemsAdapter (ArrayList<Lugares> sitio) {
        this.sitios = sitio; //Se piden los sitios que se agregan
    }

    @NonNull
    @Override
    public ViewHolderFavoritos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {  //Método que hace algo cuando se crea un item en la lista

        //Inflater permite seleccionar y cargar una vista/layout

        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_listafavoritos, null, false);  //root quiere decir que si el layout en cuestion hace parte de un MainActivity; en este caso como es un layout suelto, se pone "null"
        return new ViewHolderFavoritos (vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavoritos viewHolderFavoritos, int i) {  //Método que se activa cuando se asigna o conecta un item de la lista.

        viewHolderFavoritos.cargarDatos(sitios.get(i));  //Obtiene la posición del sitio agregado.

    }

    @Override
    public int getItemCount() {  //Método para conocer la cantidad de registros agregados
        return this.sitios.size();
    }

    public class ViewHolderFavoritos extends RecyclerView.ViewHolder {  //ViewHolder es una clase que guarda la referencia de los CardView, que son modificados dinamicamente

        int id;
        TextView txtNombreSitio, txtCategoria;
        RatingBar rtbarCalificacion;

        public ViewHolderFavoritos(@NonNull View itemView) {
            super(itemView);

            txtNombreSitio = (TextView) itemView.findViewById(R.id.txt_itemslistafavoritos_nombre);
            txtCategoria = (TextView) itemView.findViewById(R.id.txt_itemslistafavoritos_categoria);
            rtbarCalificacion = (RatingBar) itemView.findViewById(R.id.rtbar_listafavoritos_calificacion);


            ImageButton btnVerMas = (ImageButton) itemView.findViewById(R.id.imgbtn_itemslistafavoritos_vermas);
            ImageButton btnEliminar = (ImageButton) itemView.findViewById(R.id.imgbtn_itemslistafavoritos_eliminar);


        }

        public void cargarDatos (Lugares sitio) {

            txtNombreSitio.setText(sitio.getNombre());
            txtCategoria.setText(sitio.getCategoria());
            rtbarCalificacion.setRating(sitio.getCalificacion());
            //id = sitio.getId();

        }
    }
}

/*public class itemsAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_listafavoritos);

        ImageButton btnVermas = (ImageButton) findViewById(R.id.imgbtn_itemslistafavoritos_vermas);
        btnVermas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(itemsAdapter.this, btnVermas);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_listafavoritos, popup.getMenu());

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method
    }
}*/
