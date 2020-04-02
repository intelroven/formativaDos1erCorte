package com.cdlc.formativados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CuentaAdapter extends ArrayAdapter<Cuenta> {

    private LayoutInflater inflater = null;

    public CuentaAdapter(@NonNull Context context, @NonNull ArrayList<Cuenta> cuentas) {
        super(context, 0, cuentas);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.listado_cuentas, null);
            // Do some initialization

            //Retrieve the view on the item layout and set the value.
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //Retrieve your object
        Cuenta data = getItem(position);


        viewHolder.nombre.setText(data.getNombreCliente());
        viewHolder.numeroCuenta.setText(data.toStringNumeroCuenta());
        viewHolder.tipoCuenta.setText(data.getTipoCuenta());
        viewHolder.saldo.setText(data.toStringSaldo());

        return view;

    }

    private class ViewHolder {
        private final TextView nombre;
        private final TextView numeroCuenta;
        private final TextView tipoCuenta;
        private final TextView saldo;

        private ViewHolder(View view) {
            nombre = view.findViewById(R.id.txtNombreC);
            numeroCuenta = view.findViewById(R.id.txtNumeroCuenta);
            tipoCuenta = view.findViewById(R.id.txtTipoC);
            saldo = view.findViewById(R.id.txtSaldo);
        }
    }
}
