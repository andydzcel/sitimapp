package com.example.sitimappcolombia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.sitimappcolombia.clases.Mensajes;

public class misLugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_lugares);

        EditText txtnombre= (EditText) findViewById(R.id.id_txt_mislugares_nombre);
        EditText txtLongitud = (EditText) findViewById(R.id.id_txt_mislugares__longitud);
        EditText txtLatitud = (EditText) findViewById(R.id.id_txt_mislugares_Latitud);

        ImageButton btnGuardar = (ImageButton) findViewById(R.id.id_btn_mislugares_guardar);
        Spinner spnLugares = (Spinner) findViewById(R.id.id_Sp_mis_lugares_seleccion);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre=txtnombre.getText().toString();
                String longitud= txtLongitud.getText().toString();
                String latitud= txtLatitud.getText().toString();


                if(nombre.isEmpty()|| longitud.isEmpty()|| latitud.isEmpty()) {
                    new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
                }
                else
                {
                    Intent i = new Intent(view.getContext(), activity_home_view.class);
                    startActivity(i);

                    AlertDialog.Builder mensaje = new AlertDialog.Builder(view.getContext());
                    mensaje.setTitle("Seleccion");
                    mensaje.setMessage("Usted ha seleccionado el Lugar" + ((String) spnLugares.getSelectedItem())+" Y ha sido guardado exitosamente");
                    mensaje.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            onBackPressed();
                        }

                    });
                    mensaje.create();
                    mensaje.show();
                }}
        });
    }
}
