package com.example.sitimappcolombia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sitimappcolombia.clases.Mensajes;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnIngresar = (Button) findViewById(R.id.btn_login_ingresar);
        Button btnQuieroRegistrarme = (Button) findViewById(R.id.btn_login_registrarse);
        EditText txtEmail = (EditText) findViewById(R.id.btn_login_email);
        EditText txtClave = (EditText) findViewById(R.id.btn_login_contrasenia);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtEmail.getText().toString();
                String clave = txtClave.getText().toString();
                camposVacios(email,clave);
                if(email.isEmpty() || clave.isEmpty()) {
                    new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
                }
                else
                {
                    Intent i = new Intent(view.getContext(), activity_home_view.class);
                    startActivity(i);
                }
            }


        });

        btnQuieroRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(), registroUsuarios.class);
                startActivity(in);
            }
        });


    }

    public static boolean camposVacios(String email, String clave)
    {
        boolean vacios = false;
        if(email.isEmpty()|| clave.isEmpty()) {
            vacios = true;
        }
        return vacios;
    }

}