package com.example.sitimappcolombia;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sitimappcolombia.clases.Mensajes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private FirebaseAuth autenticacionFirebase;
    private static final int RC_SIGN_IN = 9001;
    private String email = "";
    private String clave = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        autenticacionFirebase = FirebaseAuth.getInstance();
        //autenticacionFirebase.sendPasswordResetEmail(email);

        FirebaseUser usuario = autenticacionFirebase.getCurrentUser();
        if (usuario != null)
            irMenu(usuario.getEmail());

        setContentView(R.layout.activity_login);

        Button btnAcceder = (Button) findViewById(R.id.btn_login_ingresar);
        Button btnQuieroRegistrarme = (Button) findViewById(R.id.btn_login_registrarse);

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarCampos())
                    autenticacionFirebase.signInWithEmailAndPassword(email, clave).
                            addOnCompleteListener((Activity) view.getContext(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                        irMenu(email);
                                    else
                                        new Mensajes(view.getContext()).confirmacion("Verifique usuario o contraseña", "Los datos no coinciden. Intente de nuevo.", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {

                                                    }
                                                });

                                }
                            });
                else{
                    new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
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
        private boolean validarCampos() {
            boolean camposDiligenciados = false;

            EditText txtEmail = (EditText) findViewById(R.id.btn_login_email);
            EditText txtClave = (EditText) findViewById(R.id.btn_login_contrasenia);

            if (!txtEmail.getText().toString().isEmpty() && !txtClave.getText().toString().isEmpty()) {
                this.email = txtEmail.getText().toString();
                this.clave = txtClave.getText().toString();
                camposDiligenciados = true;
            }

            return camposDiligenciados;
        }


        private void irMenu(String email) {
            Intent i = new Intent(this, activity_home_view.class);
            i.putExtra("email", email);
            startActivity(i);
        }

}

