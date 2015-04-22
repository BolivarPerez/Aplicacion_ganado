package com.example.boli.aplicacion_ganado;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity  {
    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
*/

        switch (item.getItemId()) {
            case R.id.nue:
                Intent intent = new Intent(MainActivity.this, registro_vacas.class);
                startActivity(intent);
                return true;

            case R.id.bus:
                Intent intent2 = new Intent(MainActivity.this, busqueda_vacas.class);
                startActivity(intent2);
                return true;

            case R.id.verT:
               Intent intent3 = new Intent(MainActivity.this, vista_todo.class);
                startActivity(intent3);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}
       /* @Override
        public void onClick (View v){
            switch (v.getId()) {

                case R.id.btnIniciar:

                    Intent intent = new Intent(getBaseContext(), registro_vacas.class);
                    startActivity(intent);

                    break;

            }

      */


