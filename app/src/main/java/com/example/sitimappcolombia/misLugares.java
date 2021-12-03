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

import com.example.sitimappcolombia.clases.Mensajes;
import com.example.sitimappcolombia.dao.LugaresDAO;
import com.example.sitimappcolombia.modelos.Lugares;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class misLugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_lugares);

        EditText txtnombre= (EditText) findViewById(R.id.id_txt_mislugares_nombre);
        EditText txtdescripcion= (EditText) findViewById(R.id.id_txt_mislugares_editar_descripcion);
        EditText txtLongitud = (EditText) findViewById(R.id.id_txt_mislugares_longitud);
        EditText txtLatitud = (EditText) findViewById(R.id.id_txt_mislugares_Latitud);
        RatingBar rtbcalificacion = (RatingBar) findViewById(R.id.id_rb_mislugares_calificacion);
        Button btnGuardar = (Button) findViewById(R.id.id_btn_mislugares_guardar);
        Spinner spnLugares = (Spinner) findViewById(R.id.id_Sp_mis_lugares_seleccion);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre=txtnombre.getText().toString();
                String descripcion = txtdescripcion.getText().toString();
                String longitud= txtLongitud.getText().toString();
                String latitud= txtLatitud.getText().toString();
                Float calificacion = rtbcalificacion.getRating();
                String categoria = spnLugares.getSelectedItem().toString();

                if(nombre.isEmpty()|| descripcion.isEmpty() || longitud.isEmpty()|| latitud.isEmpty()) {
                    new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
                }
                else{
                    long id =insertar(txtnombre,txtdescripcion,txtLongitud,txtLatitud,rtbcalificacion,spnLugares);
                    new Mensajes(view.getContext()).confirmacion("Lugar guardado", "Usted ha guardado el lugar " + (txtnombre.getText().toString())+" y ha sido guardado exitosamente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent in = new Intent(view.getContext(), activity_home_view.class);
                        startActivity(in);

                    }});
                }}
        });
    }

    private long insertar(EditText nombres,EditText descripcion,EditText longitud, EditText latitud, RatingBar calificacion, Spinner categoria)
    {
        long id_lug =0;

        Lugares lug = new Lugares();
        lug.setNombre(nombres.getText().toString());
        lug.setDescripcion(descripcion.getText().toString());
        lug.setLongitud(Double.parseDouble(longitud.getText().toString()));
        lug.setLatitud(Double.parseDouble(latitud.getText().toString()));
        lug.setCalificacion(calificacion.getRating());
        lug.setCategoria(categoria.getSelectedItem().toString());

        LugaresDAO lugdao = new LugaresDAO(this);
        id_lug = lugdao.insertar(lug);

        lug.setId_lug((int) id_lug);

        //ArrayList<Lugares> mislugares = lugdao.listar();

        //Insertar en Firebase Real-Time
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        database.getReference().child("Lugar").child(UUID.randomUUID().toString()).setValue(lug);



        return id_lug;

        //Hacer un if para el caso del boton editar cuando id_lug no es 0
    }

}
