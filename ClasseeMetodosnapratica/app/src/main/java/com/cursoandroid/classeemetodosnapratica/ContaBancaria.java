package com.cursoandroid.classeemetodosnapratica;

/*
    ======= INTERFACE ========
    Pode-se dizer a grosso modo, que uma interface é um contrato
    que quando assumido por uma classe, deve ser implementado

    Interface é utilizada pois podemos ter muitos objetos (classes)
    que podem possuir a mesma ação (métodos) porém, podem
    executá-las de maneiras diferentes.
*/

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
