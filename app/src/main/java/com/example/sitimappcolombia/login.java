package com.example.sitimappcolombia;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sitimappcolombia.clases.Mensajes;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

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
        ImageButton btnGoogle = (ImageButton) findViewById(R.id.btn_login_google);

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

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GoogleSignInOptions gso = new
                        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.llave_cliente_web))
                        .requestEmail()
                        .build();

                Intent signInIntent = GoogleSignIn.getClient(view.getContext(), gso).getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);




            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Activity activityActual = this;

        if(requestCode == RC_SIGN_IN)
        {
            try {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                GoogleSignInAccount cuenta = task.getResult(ApiException.class);
                AuthCredential credencial = GoogleAuthProvider.getCredential(cuenta.getIdToken(), null);
                autenticacionFirebase.signInWithCredential(credencial).addOnCompleteListener(activityActual, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            FirebaseUser usuario = autenticacionFirebase.getCurrentUser();
                            irMenu(usuario.getEmail());
                        }
                    }
                });
            }
            catch (Exception ex)
            {

            }


        }

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

