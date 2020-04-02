package com.cdlc.formativados;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button grabar, cancelar;
    ImageButton listarr;
    RadioButton ahorro, corriente;
    RadioGroup tipocuenta;
    EditText nombres, ncuenta, saldos;
    ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grabar = findViewById(R.id.btnRegistrar);
        grabar.setOnClickListener(this);

        cancelar = findViewById(R.id.btnCancelar);
        cancelar.setOnClickListener(this);

        listarr= findViewById(R.id.btnListar);
        listarr.setOnClickListener(this);

        ncuenta = findViewById(R.id.txtNumeroC);
        nombres = findViewById(R.id.txtNombre);
        saldos = findViewById(R.id.txtSaldo);
        tipocuenta = findViewById(R.id.rdTipo);
        ahorro = findViewById(R.id.rdAhorro);
        corriente= findViewById(R.id.rdCorriente);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnRegistrar:
                if (nombres.getText().toString().equals("") || ncuenta.getText().equals("")||saldos.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Rellene los campos especificados", Toast.LENGTH_SHORT).show();

                } else {
                    // String Mensaje = "¿Desea guardar la cuenta?";
                    // Insertar(Mensaje);
                    RegistrarCuenta();
                    break;
                }

            case R.id.btnCancelar:
                Toast.makeText(getApplicationContext(), "Hasta luego", Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.btnListar:

                Intent i = new Intent(this, Listar.class);
                i.putParcelableArrayListExtra("est", cuentas);
                startActivity(i);
                break;

        }

    }

    public void Insertar(String mensaje) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Importante");
        dialog.setMessage(mensaje);
        dialog.setCancelable(false);
        dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();

            }
        });
        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialog.show();

    }

    public void aceptar() {
        Toast t = Toast.makeText(this, "Se ha ejecutado la accion", Toast.LENGTH_SHORT);
        t.show();
        RegistrarCuenta();
    }

    public void cancelar() {
        finish();
    }

    private void RegistrarCuenta() {

        String nombre = nombres.getText().toString();
        int numeroCuenta = Integer.parseInt(ncuenta.getText().toString());
        double saldo = Double.parseDouble(saldos.getText().toString());
        String tipoCuenta = "";

        if(corriente.getId()==tipocuenta.getCheckedRadioButtonId()){
            tipoCuenta="Corriente";
        }else{
            if(ahorro.getId()==tipocuenta.getCheckedRadioButtonId()){
                tipoCuenta="Ahorro";
            }
        }
        cuentas.add(new Cuenta(nombre, numeroCuenta, tipoCuenta, saldo));
        Toast.makeText(getApplicationContext(), "registro completado", Toast.LENGTH_SHORT).show();
    }
}
