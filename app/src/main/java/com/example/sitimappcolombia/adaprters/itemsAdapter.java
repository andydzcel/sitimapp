package com.example.sitimappcolombia.adaprters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sitimappcolombia.R;
import com.example.sitimappcolombia.activity_map;
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

        int id_lug;
        TextView txtNombreSitio, txtCategoria;
        RatingBar rtbarCalificacion;
        ImageButton btnMapa, btnEditar, btnEliminar;

        public ViewHolderFavoritos(@NonNull View itemView) {
            super(itemView);

            txtNombreSitio = (TextView) itemView.findViewById(R.id.txt_itemslistafavoritos_nombre);
            txtCategoria = (TextView) itemView.findViewById(R.id.txt_itemslistafavoritos_categoria);
            rtbarCalificacion = (RatingBar) itemView.findViewById(R.id.rtbar_listafavoritos_calificacion);


            btnMapa = (ImageButton) itemView.findViewById(R.id.imgbtn_itemslistafavoritos_vermapa);
            btnEditar = (ImageButton) itemView.findViewById(R.id.imgbtn_itemslistafavoritos_editar);
            btnEliminar = (ImageButton) itemView.findViewById(R.id.imgbtn_itemslistafavoritos_eliminar);


            btnMapa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(itemView.getContext(), activity_map.class);  //El profe plantea cargar la vista del mapa en un fragment
                    itemView.getContext().startActivity(i);

                }
            });


            /*btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(itemView.getContext(), editarFavoritos.class);
                    i.putExtra("id", id_lug);
                    itemView.getContext().startActivity(i);

                }
            });*/


        }

        public void cargarDatos (Lugares sitio) {

            txtNombreSitio.setText(sitio.getNombre());
            txtCategoria.setText(sitio.getCategoria());
            rtbarCalificacion.setRating(sitio.getCalificacion());
            id_lug = sitio.getId();

        }
    }
}
