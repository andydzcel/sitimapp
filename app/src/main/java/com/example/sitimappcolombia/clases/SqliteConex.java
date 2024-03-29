package com.example.sitimappcolombia.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SqliteConex extends SQLiteOpenHelper {

    public static final String nombredb ="Sitimapp.db";

    public SqliteConex(@Nullable Context c) {

        super(c,nombredb, null,2);

    }

    @Override
    public void onCreate(SQLiteDatabase SQLiteDatabase) {
        SQLiteDatabase.execSQL("CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombres TEXT NOT NULL,email TEXT NOT NULL, clave TEXT NOT NULL)");
        SQLiteDatabase.execSQL("CREATE TABLE mislugares (id_lug INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT NOT NULL, descripcion TEXT NOT NULL,longitud decimal(3,9) NOT NULL,latitud decimal(3,9) NOT NULL,categoria TEXT NOT NULL,calificacion DECIMAL(2,1) NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDatabase, int oldVersion, int newVersion) {
        SQLiteDatabase.execSQL("DROP TABLE usuarios");
        SQLiteDatabase.execSQL("DROP TABLE mislugares");
        onCreate(SQLiteDatabase);

    }
}
