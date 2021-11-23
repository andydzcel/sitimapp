package com.example.sitimappcolombia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sitimappcolombia.adaprters.ViewSp_Adpater_mis_lugares;
import com.example.sitimappcolombia.clases.Mensajes;
import com.example.sitimappcolombia.dao.LugaresDAO;
import com.example.sitimappcolombia.modelos.Lugares;

public class misLugares_editar extends AppCompatActivity {

    private Lugares mislugaresActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_lugares_editar);

        Bundle parametrosObtenidos = getIntent().getExtras();
        EditText txtnombre= (EditText) findViewById(R.id.id_txt_mislugares_editar_nombre);
        EditText txtdescripcion= (EditText) findViewById(R.id.id_txt_mislugares_editar_descripcion);
        EditText txtLongitud = (EditText) findViewById(R.id.id_txt_mislugares_editar_longitud);
        EditText txtLatitud = (EditText) findViewById(R.id.id_txt_mislugares_editar_Latitud);
        RatingBar rtbcalificacion = (RatingBar) findViewById(R.id.id_rb_mislugares_editar_calificacion);
        Button btnActualizar = (Button) findViewById(R.id.id_btn_mislugares_editar_guardar);
        Spinner spnLugares = (Spinner) findViewById(R.id.id_Sp_mis_lugares_editar_seleccion);



        if(parametrosObtenidos.containsKey("id_lug")){
            int id_lug = parametrosObtenidos.getInt("id_lug");
            LugaresDAO db = new LugaresDAO(this);
            this.mislugaresActual = db.obtenerLugares(id_lug);

            ViewSp_Adpater_mis_lugares adapter = new ViewSp_Adpater_mis_lugares(new String[]{
                    "Restaurantes","Comida","Hospedaje","Cultura","Diversión","Compras"});



            txtnombre.setText(this.mislugaresActual.getNombre());
            txtdescripcion.setText(this.mislugaresActual.getDescripcion());
            txtLongitud.setText(this.mislugaresActual.getLongitud().toString());
            txtLatitud.setText(this.mislugaresActual.getLatitud().toString());
            rtbcalificacion.setRating(this.mislugaresActual.getCalificacion());

            spnLugares.setAdapter(adapter);

        }


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre=txtnombre.getText().toString();
                String descripcion = txtdescripcion.getText().toString();
                String longitud= txtLongitud.getText().toString();
                String latitud= txtLatitud.getText().toString();
                Float calificacion = rtbcalificacion.getRating();
                String categoria = (String) spnLugares.getSelectedItem();

                if(nombre.isEmpty()|| descripcion.isEmpty() || longitud.isEmpty()|| latitud.isEmpty()) {
                    new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
                }
                else{

                    mislugaresActual.setNombre(nombre);
                    mislugaresActual.setDescripcion(descripcion);
                    mislugaresActual.setLongitud(Double.parseDouble(longitud));
                    mislugaresActual.setLatitud(Double.parseDouble(latitud));
                    mislugaresActual.setCalificacion(calificacion);
                    mislugaresActual.setCategoria(categoria);


                    LugaresDAO db = new LugaresDAO(view.getContext());
                    db.editar(mislugaresActual);
                    new Mensajes(view.getContext()).confirmacion("Registro editado", "Usted ha editado el lugar " + ( txtnombre.getText().toString())+" y ha sido guardado exitosamente", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent in = new Intent(view.getContext(), listaFavoritos.class);
                            startActivity(in);

                        }});
                }

            }

        });




    }
}