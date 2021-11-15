package com.example.sitimappcolombia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sitimappcolombia.clases.Mensajes;
import com.example.sitimappcolombia.dao.UsuarioDAO;
import com.example.sitimappcolombia.modelos.Usuario;

import java.util.ArrayList;

public class registroUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        EditText txtNombres =(EditText) findViewById(R.id.usuariosinsertar_txtNombres);
        EditText txtEmail =(EditText) findViewById(R.id.usuariosinsertar_txtEmail);
        EditText txtClave =(EditText) findViewById(R.id.usuariosinsertar_txtClave);
        Button btn_registrarse = (Button) findViewById(R.id.usuariosinsertar_btnRegistrarse);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres = txtNombres.getText().toString();
                String email = txtEmail.getText().toString();
                String clave = txtClave.getText().toString();

                if(email.isEmpty() || clave.isEmpty() || nombres.isEmpty()) {
                   new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
                }
                else
                {
                    long id =insertar(txtNombres,txtEmail,txtClave);
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

    private long insertar(EditText nombres,EditText email,EditText clave)
    {
        long id =0;

        Usuario us = new Usuario();
        us.setNombres(nombres.getText().toString());
        us.setEmail(email.getText().toString());
        us.setClave(clave.getText().toString());

        UsuarioDAO usdao = new UsuarioDAO(this);
        id = usdao.insertar(us);

        ArrayList<Usuario> usuarios = usdao.listar();

        return id;
    }

}