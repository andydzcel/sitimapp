package com.example.sitimappcolombia.clases;

import android.app.AlertDialog;
import android.content.Context;

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
}
