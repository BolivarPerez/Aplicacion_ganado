package com.example.boli.aplicacion_ganado;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Crear la base de datos.
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Crear la tabla en la base de datos.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ganado (n_arete integer primary key unique, f_nacimiento text, nombre text unique, sexo text, f_gestacion text, f_parto text null) ");
    }

    // Actualiza la tabla en la base de datos.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ganado");
        db.execSQL("create table ganado (n_arete integer primary key unique, f_nacimiento text, nombre text unique, sexo text, f_gestacion text, f_parto tex null) ");

    }

}
