package com.example.sitimappcolombia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sitimappcolombia.clases.Mensajes;

public class registroUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        Button btn_registrarse = (Button) findViewById(R.id.btn_registrousuarios_registrarse);
        EditText txtNombreCompleto = (EditText) findViewById(R.id.btn_registrousuarios_nombreapellido);
        EditText txtEmail = (EditText) findViewById(R.id.btn_registrousuarios_email);
        EditText txtClave = (EditText) findViewById(R.id.btn_registrousuarios_contrasenia);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombreCompleto.getText().toString();
                String email = txtEmail.getText().toString();
                String clave = txtClave.getText().toString();

                if(email.isEmpty() || clave.isEmpty() || nombre.isEmpty()) {
                   new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
                }
                else
                {
                    new Mensajes(view.getContext()).confirmacion("Registro completado", "Ya estás listo para usar Sitimapp Colombia.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent in = new Intent(view.getContext(), login.class);
                            startActivity(in);
                        }
                    });
                }
            }
        });
    }
}