package com.cursoandroid.classeemetodosnapratica;

public class ContaBancaria {

    private int numeroConta;
    private double saldo;

    public ContaBancaria(){
        System.out.println("Contrutor chamado.");
    }

    public ContaBancaria(int nConta){
        this.numeroConta = nConta;
        System.out.println("Contrutor chamado com numero " + this.numeroConta);
    }

}
