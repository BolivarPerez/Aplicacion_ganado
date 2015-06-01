package com.example.boli.aplicacion_ganado;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.boli.aplicacion_ganado.adaptadores.adaptadorvacas;
import com.example.boli.aplicacion_ganado.modelos.modelo_vacas;

import java.util.ArrayList;
import java.util.List;


public class vista_todo extends ActionBarActivity {

    // Se declaran variables
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    // Metodo para mostrar en lista las consultas de la base de datos.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_todo);

        List<modelo_vacas> items = new ArrayList<>();


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ganado", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("select n_arete, f_nacimiento, nombre, sexo, f_gestacion, f_parto from ganado", null);

        for (fila.moveToFirst(); !fila.isAfterLast(); fila.moveToNext()) {
            items.add(new modelo_vacas(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4), fila.getString(5)));

        }

        recycler = (RecyclerView) findViewById(R.id.lista);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);


        adapter = new adaptadorvacas(items);
        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vista_todo, menu);
        return true;
    }


    // Agregar funcionalidad a los menus.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /* int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */

        switch (item.getItemId()) {
            case R.id.nue:
                Intent intent = new Intent(vista_todo.this, registro_vacas.class);
                startActivity(intent);
                return true;

            case R.id.bus:
                Intent intent2 = new Intent(vista_todo.this, busqueda_vacas.class);
                startActivity(intent2);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}


