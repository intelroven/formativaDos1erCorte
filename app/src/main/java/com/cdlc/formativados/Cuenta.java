package com.cdlc.formativados;

import android.os.Parcel;
import android.os.Parcelable;

public class Cuenta implements Parcelable {
    private String nombreCliente;
    private int numeroCuenta;
    private String tipoCuenta;
    private double saldo;


    protected Cuenta(Parcel in) {
        nombreCliente = in.readString();
        numeroCuenta = in.readInt();
        tipoCuenta = in.readString();
        saldo = in.readDouble();
    }

    public static final Creator<Cuenta> CREATOR = new Creator<Cuenta>() {
        @Override
        public Cuenta createFromParcel(Parcel in) {
            return new Cuenta(in);
        }

        @Override
        public Cuenta[] newArray(int size) {
            return new Cuenta[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombreCliente);
        dest.writeInt(numeroCuenta);
        dest.writeString(tipoCuenta);
        dest.writeDouble(saldo);
    }

    public Cuenta(String nombreCliente, int numeroCuenta, String tipoCuenta, double saldo) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toStringNumeroCuenta() {
        return " " + numeroCuenta;
    }

    public String toStringSaldo() {
        return ""+ saldo;
    }
}
