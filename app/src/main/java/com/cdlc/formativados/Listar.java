package com.cdlc.formativados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Listar extends AppCompatActivity {

    ListView listado;
    ArrayAdapter<Cuenta> arrayAdapter;
    ArrayList<Cuenta> cuentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar1);

        Intent in = getIntent();
        cuentas = in.getParcelableArrayListExtra("est");

        listado = findViewById(R.id.listCuentas);
        arrayAdapter = new CuentaAdapter(this, cuentas);
        arrayAdapter.notifyDataSetChanged();
        listado.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listar, menu);
        return true;
    }

    public void ordenarSaldo() {

        Collections.sort(cuentas, new Comparator<Cuenta>() {

            public int compare(Cuenta p1, Cuenta p2) {
                return new Double(p1.getSaldo()).compareTo(new Double(p2.getSaldo()));
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mnOrdenarSaldo:
                ordenarSaldo();
                arrayAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
