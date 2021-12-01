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
import com.example.sitimappcolombia.dao.UsuarioDAO;
import com.example.sitimappcolombia.modelos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class registroUsuarios extends AppCompatActivity {

    private FirebaseAuth autenticacionFirebase;
    private static final int RC_SIGN_IN = 9001;
    private String email = "";
    private String clave = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        autenticacionFirebase = FirebaseAuth.getInstance();
        //autenticacionFirebase.sendPasswordResetEmail(email);

        setContentView(R.layout.activity_registro_usuarios);

        Button btnRegistro = (Button) findViewById(R.id.usuariosinsertar_btnRegistrarse);


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarCampos()) {
                    autenticacionFirebase.createUserWithEmailAndPassword(email, clave).
                            addOnCompleteListener((Activity) view.getContext(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                        irLogin(email);
                                    else
                                        verMensaje("Ocurrió un error al registrar el usuario.");
                                }
                            });
                } else
                    new Mensajes(view.getContext()).alerta("Advertencia", "Digite los campos vacíos.");
            }
        });

    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Activity activityAcual = this;

        if (requestCode == RC_SIGN_IN) {
            try {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                GoogleSignInAccount cuenta = task.getResult(ApiException.class);
                AuthCredential credencial = GoogleAuthProvider.getCredential(cuenta.getIdToken(), null);
                autenticacionFirebase.signInWithCredential(credencial).addOnCompleteListener(activityAcual, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser usuario = autenticacionFirebase.getCurrentUser();
                            irMenu(usuario.getEmail());
                        }
                    }
                });
            } catch (Exception ex) {

            }


        }

    }*/

    private boolean validarCampos() {
        boolean camposDiligenciados = false;

        EditText txtEmail = (EditText) findViewById(R.id.usuariosinsertar_txtEmail);
        EditText txtClave = (EditText) findViewById(R.id.usuariosinsertar_txtClave);

        if (!txtEmail.getText().toString().isEmpty() && !txtClave.getText().toString().isEmpty()) {
            this.email = txtEmail.getText().toString();
            this.clave = txtClave.getText().toString();
            camposDiligenciados = true;
        }

        return camposDiligenciados;
    }

    private void verMensaje(String cuerpo) {
        AlertDialog.Builder msj = new AlertDialog.Builder(this);
        msj.setMessage(cuerpo);
        msj.create();
        msj.show();
    }

    private void irLogin(String email) {
        Intent i = new Intent(this, login.class);
        i.putExtra("email", email);
        startActivity(i);
    }
}
