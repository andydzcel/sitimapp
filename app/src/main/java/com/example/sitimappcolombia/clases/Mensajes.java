package com.example.sitimappcolombia.clases;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.util.LocaleData;
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

    public void confirmacion(String titulo, String cuerpo, DialogInterface.OnClickListener btnOk)
    {
        AlertDialog.Builder msj = new AlertDialog.Builder(this.contexto);
        msj.setTitle(titulo);
        msj.setMessage(cuerpo);
        msj.setPositiveButton("Listo", btnOk);
        msj.create();
        msj.show();
    }

    public void toast(String cuerpo)
    {
        Toast.makeText(this.contexto, cuerpo, Toast.LENGTH_LONG).show();
    }

}
