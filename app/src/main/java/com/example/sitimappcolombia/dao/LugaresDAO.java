package com.example.sitimappcolombia.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.example.sitimappcolombia.clases.SqliteConex;
import com.example.sitimappcolombia.modelos.Lugares;
import com.example.sitimappcolombia.modelos.Usuario;

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
                lug.setId_lug(cregistros.getInt(0));
                lug.setNombre(cregistros.getString(1));
                lug.setDescripcion(cregistros.getString(2));
                lug.setLongitud(cregistros.getDouble(3));
                lug.setLatitud(cregistros.getDouble(4));
                lug.setCategoria(cregistros.getString(5));
                lug.setCalificacion(cregistros.getFloat(6));


                lugares.add(lug);
            }while(cregistros.moveToNext());

        cregistros.close();

        return lugares;

        }


    public boolean editar(Lugares lug)
    {
        boolean editado = false;

        SqliteConex conexion = new SqliteConex(this.contexto);
        SQLiteDatabase db = conexion.getWritableDatabase();

        try
        {
            db.execSQL("UPDATE mislugares SET nombre = '" + lug.getNombre() + "', descripcion = '" + lug.getDescripcion() + "', longitud = '" + String.valueOf(lug.getLongitud())+ "', latitud = '" + String.valueOf(lug.getLatitud())+ "', categoria = '" + lug.getCategoria()+ "', calificacion = '" + lug.getCalificacion()+ "' WHERE id_lug = " + lug.getId_lug());
            editado = true;
        }
        catch (Exception ex)
        {

        }

        return editado;
    }


        public boolean eliminar(long id_lug){

        boolean eliminado = false;

        SqliteConex conexion = new SqliteConex(this.contexto);
        SQLiteDatabase db = conexion.getWritableDatabase();


        try{
            db.execSQL("DELETE FROM mislugares" +
                    "    WHERE id_lug = '" + String.valueOf(id_lug)+"'");
            eliminado=true;

        }catch (Exception ex){



        }

        return eliminado;
        }

    public Lugares obtenerLugares(long id_lug)
    {
        Lugares lug = null;

        SqliteConex dbc = new SqliteConex(this.contexto);
        SQLiteDatabase db = dbc.getWritableDatabase();

        String consultaSQL = "SELECT id_lug, nombre, descripcion, longitud, latitud, calificacion, categoria FROM mislugares where id_lug = '" + String.valueOf(id_lug) + "'";

        try {
            Cursor cregistros = db.rawQuery(consultaSQL, null);

            if (cregistros.moveToFirst()) {
                lug = new Lugares();
                lug.setId_lug(cregistros.getInt(0));
                lug.setNombre(cregistros.getString(1));
                lug.setDescripcion(cregistros.getString(2));
                lug.setLongitud(cregistros.getDouble(3));
                lug.setLatitud(cregistros.getDouble(4));
                lug.setCalificacion(cregistros.getFloat(5));
                lug.setCategoria(cregistros.getString(6));

            }
            cregistros.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return lug;
    }

}

