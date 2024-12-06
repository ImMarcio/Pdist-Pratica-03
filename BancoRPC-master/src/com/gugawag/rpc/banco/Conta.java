package com.gugawag.rpc.banco;
public class Conta {
    String numero;
    private double saldo;

    public Conta(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public String getNumero(){
        return this.numero;
    }


    @Override
    public String toString() {
      
        return "Número: " + this.numero + "\nSaldo: " + this.saldo;
    }
}
