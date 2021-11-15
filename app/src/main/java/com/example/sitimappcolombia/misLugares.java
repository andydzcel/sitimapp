package com.example.sitimappcolombia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

public class misLugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_lugares);

        ImageButton btnGuardar = (ImageButton) findViewById(R.id.id_btn_mislugares_guardar);
        Spinner spnLugares = (Spinner) findViewById(R.id.id_Sp_mis_lugares_seleccion);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
            }
        });
    }
}