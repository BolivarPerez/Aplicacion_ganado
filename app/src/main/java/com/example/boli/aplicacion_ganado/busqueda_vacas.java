package com.example.boli.aplicacion_ganado;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class busqueda_vacas extends ActionBarActivity {
    EditText ed_no_arete, ed_fecha_nacimiento, ed_nombre, ed_sexo, ed_fecha_gestacion, ed_fecha_parto;
    private int mYear, mMonth, mDay;
    CheckBox macho, hembra;
    String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda_vacas);

        ed_no_arete = (EditText) findViewById(R.id.ed_no_arete);
        ed_fecha_nacimiento = (EditText) findViewById(R.id.ed_fecha_nacimiento);
        ed_nombre = (EditText) findViewById(R.id.ed_nombre);
        ed_sexo = (EditText) findViewById(R.id.ed_sexo);
        ed_fecha_gestacion = (EditText) findViewById(R.id.ed_fecha_gestacion);
        ed_fecha_parto = (EditText) findViewById(R.id.ed_fecha_parto);

        macho = (CheckBox) findViewById(R.id.chec1);
        hembra = (CheckBox) findViewById(R.id.chec2);
    }

    public void Buscar(View v) {

        if (ed_no_arete.getText().toString().equals("")) {

            Toast.makeText(this,R.string.debes , Toast.LENGTH_SHORT).show();
        } else {

            try {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ganado", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                String narete = ed_no_arete.getText().toString();
                Cursor fila = bd.rawQuery("select f_nacimiento, nombre, sexo, f_gestacion, f_parto from ganado where n_arete=" + narete, null);
                if (fila.moveToFirst()) {
                    ed_fecha_nacimiento.setText(fila.getString(0));
                    ed_nombre.setText(fila.getString(1));
                    ed_sexo.setText(fila.getString(2));
                    ed_fecha_gestacion.setText(fila.getString(3));
                    ed_fecha_parto.setText(fila.getString(4));

                    if (ed_sexo.getText().toString().equals("MACHO")) {
                        macho.setChecked(true);
                    } else if (ed_sexo.getText().toString().equals("HEMBRA")) {
                        hembra.setChecked(true);
                    }

                } else {
                    Toast.makeText(this, R.string.no_se_emcontro, Toast.LENGTH_SHORT).show();
                }
                bd.close();

            } catch (Exception e) {
                Toast.makeText(this, R.string.no_bus, Toast.LENGTH_SHORT).show();

            }

        }
    }


    public void Editar(View v){

        if (ed_no_arete.getText().toString().equals("")) {

            Toast.makeText(this, R.string.primero, Toast.LENGTH_SHORT).show();
        } else {

            try {

                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ganado", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();

                String narete = ed_no_arete.getText().toString();
                String f_nacimiento = ed_fecha_nacimiento.getText().toString();
                String nombre = ed_nombre.getText().toString();
                String sex = ed_sexo.getText().toString();
                String f_gestacion = ed_fecha_gestacion.getText().toString();
                String f_parto = ed_fecha_parto.getText().toString();

                if (macho.isChecked() == true) {
                    sex = "MACHO";
                } else if (hembra.isChecked() == true) {
                    sex = "HEMBRA";
                }

                ContentValues registro = new ContentValues();
                registro.put("n_arete", narete);
                registro.put("f_nacimiento", f_nacimiento);
                registro.put("nombre", nombre);
                registro.put("sexo", sex);
                registro.put("f_gestacion", f_gestacion);
                registro.put("f_parto", f_parto);

                int cant = bd.update("ganado", registro, "n_arete=" + narete, null);
                bd.close();

                if (cant == 1) {

                    Toast.makeText(this, R.string.modif, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, R.string.no_existe, Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, R.string.no_editar, Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void Eliminar(View v){

        if (ed_no_arete.getText().toString().equals("")) {

            Toast.makeText(this, R.string.debes, Toast.LENGTH_SHORT).show();
        } else {

            try {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ganado", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String narete = ed_no_arete.getText().toString();
        int cant = bd.delete("ganado", "n_arete=" + narete, null);
        bd.close();

        ed_no_arete.setText("");
        ed_fecha_nacimiento.setText("");
        ed_nombre.setText("");
        ed_sexo.setText("");
        ed_fecha_gestacion.setText("");
        ed_fecha_parto.setText("");
        macho.setChecked(false);
        hembra.setChecked(false);

        if (cant == 1) {
            Toast.makeText(this, R.string.se_elim, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.no_elim, Toast.LENGTH_SHORT).show();
        }

        } catch (Exception e) {
                Toast.makeText(this, R.string.no_se_puede, Toast.LENGTH_SHORT).show();
         }
     }
 }

    public void Limpiar(View v){

        ed_no_arete.setText("");
        ed_fecha_nacimiento.setText("");
        ed_nombre.setText("");
        ed_sexo.setText("");
        ed_fecha_gestacion.setText("");
        ed_fecha_parto.setText("");
        macho.setChecked(false);
        hembra.setChecked(false);
    }

    public void Fecha_1(View v){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Setear valor en editText
                        ed_fecha_nacimiento.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        dpd.show();

    }

    public void Fecha_2(View v){

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Setear valor en editText
                        ed_fecha_gestacion.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        dpd.show();

    }

    public void Fecha_3(View v){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Setear valor en editText
                        ed_fecha_parto.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void macho (View v){
        hembra.setChecked(false);
    }

    public void hembra(View v){
        macho.setChecked(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_busqueda_vacas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
