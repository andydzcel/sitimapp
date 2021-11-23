package com.example.sitimappcolombia.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.sitimappcolombia.clases.SqliteConex;
import com.example.sitimappcolombia.modelos.Usuario;

import java.util.ArrayList;

public class UsuarioDAO extends SqliteConex {

    private Context contexto;

    public UsuarioDAO(@Nullable Context c)
    {
        super(c);
        this.contexto = c;
    }

    public long insertar(Usuario us)
    {
        long id = 0;

        try
        {
            SqliteConex dbc = new SqliteConex(this.contexto);
            SQLiteDatabase db = dbc.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombres",us.getNombres());
            valores.put("email",us.getEmail());
            valores.put("clave",us.getClave());

            id=db.insert("usuarios","null",valores);

        }
        catch (Exception ex)
        {

        }

        return id;
    }

    public ArrayList<Usuario> listar()
    {
        SqliteConex dbc = new SqliteConex(this.contexto);
        SQLiteDatabase db = dbc.getWritableDatabase();

        ArrayList<Usuario> usuarios = new ArrayList<>();

        Cursor cregistros = db.rawQuery("select * from usuarios",null);

        if(cregistros.moveToFirst())
            do{
                Usuario us = new Usuario();
                us.setNombres(cregistros.getString(0));
                us.setEmail(cregistros.getString(1));
                us.setClave(cregistros.getString(2));

                usuarios.add(us);
            }while(cregistros.moveToNext());

            cregistros.close();

            return usuarios;
    }




}
