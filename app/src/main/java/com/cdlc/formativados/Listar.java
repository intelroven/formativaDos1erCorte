package com.cdlc.formativados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Listar extends AppCompatActivity {

    ListView listado;
    ArrayAdapter<Cuenta> arrayAdapter;
    ArrayList<Cuenta> cuentas;
    EditText filtro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar1);

       filtro = findViewById(R.id.txtFiltro);


        Intent in = getIntent();
        cuentas = in.getParcelableArrayListExtra("est");

        listado = findViewById(R.id.listCuentas);
        arrayAdapter = new CuentaAdapter(this, cuentas);
        listado.setAdapter(arrayAdapter);


        filtro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





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
