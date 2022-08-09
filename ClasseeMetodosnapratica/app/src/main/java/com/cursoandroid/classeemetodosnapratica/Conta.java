package com.cursoandroid.classeemetodosnapratica;
/*
==== Modificadores de acesso ====
1) public    -> todas as classes terão acesso
2) private   -> apenas pode ser acessado de dentro da classe
3) protected -> pode ser acessado estando dentro do mesmo pacote e/ou subclasses
4) default   -> CAso não teha sido definido nenhum modificador, permitindo o acesso dentro do pacote.
 */

public class Conta {
    protected int numeroConta;
    private double saldo = 100;

    public double recuperarSaldo(){
        return this.saldo;
    }

    public void depositar(double valorDeposito){
        this.saldo = this.saldo + valorDeposito;
    }

    public void sacar(double valorSaque){
        this.saldo = this.saldo - valorSaque;
    }

}
