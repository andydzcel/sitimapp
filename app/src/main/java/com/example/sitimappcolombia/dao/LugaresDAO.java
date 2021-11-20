package com.example.sitimappcolombia.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import com.example.sitimappcolombia.clases.SqliteConex;
import com.example.sitimappcolombia.modelos.Lugares;

import java.util.ArrayList;

public class LugaresDAO extends SqliteConex {

    private Context contexto;

    public LugaresDAO(@Nullable Context c)
    {
        super(c);
        this.contexto = c;
    }

    public long insertar(Lugares lug)
    {
        long id_lug = 0;

        try
        {
            SqliteConex dbc = new SqliteConex(this.contexto);
            SQLiteDatabase db = dbc.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombre",lug.getNombre());
            valores.put("descripcion",lug.getDescripcion());
            valores.put("longitud",lug.getLongitud());
            valores.put("latitud",lug.getLatitud());
            valores.put("categoria",lug.getCategoria());
            valores.put("calificacion",lug.getCalificacion());

            id_lug=db.insert("mislugares","null",valores);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return id_lug;
    }

    public ArrayList<Lugares> listar(@Nullable String criterioBusqueda)
    {
        SqliteConex dbc = new SqliteConex(this.contexto);
        SQLiteDatabase db = dbc.getWritableDatabase();

        String consultaDB = "select * from mislugares";

        if (criterioBusqueda!=null) {
            consultaDB += " where nombre like '%" + criterioBusqueda + "%' or categoria like '%" + criterioBusqueda + "%'";
        }

        ArrayList<Lugares> lugares = new ArrayList<>();

        Cursor cregistros = db.rawQuery(consultaDB,null);

        if(cregistros.moveToFirst())
            do{
                Lugares lug = new Lugares();
                lug.setNombre(cregistros.getString(1));
                lug.setDescripcion(cregistros.getString(2));
                lug.setLongitud(cregistros.getString(3));
                lug.setLatitud(cregistros.getString(4));
                lug.setCategoria(cregistros.getString(5));
                lug.setCalificacion(cregistros.getFloat(6));


                lugares.add(lug);
            }while(cregistros.moveToNext());

        cregistros.close();

        return lugares;

        }
}

