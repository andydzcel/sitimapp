package com.example.sitimappcolombia.clases;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.util.LocaleData;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

public class Mensajes {
    private Context contexto;

    public Mensajes(Context contexto) {
        this.contexto = contexto;
    }

    public void alerta(String titulo, String cuerpo)
    {
        AlertDialog.Builder msj = new AlertDialog.Builder(this.contexto);
        msj.setTitle(titulo);
        msj.setMessage(cuerpo);
        msj.create();
        msj.show();
    }

    public void confirmacion(String titulo, String cuerpo)
    {
        AlertDialog.Builder msj = new AlertDialog.Builder(this.contexto);
        msj.setTitle(titulo);
        msj.setMessage(cuerpo);
        msj.setPositiveButton("Listo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
            }
        });
        msj.create();
        msj.show();
    }

    public void toast(String cuerpo)
    {
        Toast.makeText(this.contexto, cuerpo, Toast.LENGTH_LONG).show();
    }

    public void snackbar(View vista, String cuerpo)
    {
       Snackbar.make(vista,cuerpo,Snackbar.LENGTH_LONG).show();
    }
}
