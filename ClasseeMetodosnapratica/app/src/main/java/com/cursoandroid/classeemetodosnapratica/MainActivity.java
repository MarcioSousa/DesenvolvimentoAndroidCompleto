package com.cursoandroid.classeemetodosnapratica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cursoandroid.classeemetodosnapratica.classes.Animal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OutroNome outroNome = new OutroNome();
        outroNome.direitosDeveres();



 /*
        ContaBancaria conta = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria(10);



        Pessoa pessoa = new Pessoa();
        pessoa.exibirDados("Marcio Sousa");
        pessoa.exibirDados("Marcio Sousa",38);


        Conta conta = new Conta();
        conta.depositar(100); // 200
        conta.sacar(50); //150

        System.out.println(conta.recuperarSaldo());




    Passaro passaro = new Passaro();
        passaro.correr();

        Cao cao = new Cao();
        cao.correr();

        //passaro.correr();
        //passaro.dormir();
        //passaro.voar();

        //cao.setCor("Azul");
        //System.out.println(cao.getCor());

        //cao.dormir();
        //cao.latir();


        Animal animal = new Animal();
        animal.correr();

        Funcionario funcionario = new Funcionario();
        funcionario.nome = "Marcio";

        funcionario.salario = 920;

        double salarioRecuperado = funcionario.recuperarSalario(120, 20);
        System.out.println("O salário do Marcio é: "+ salarioRecuperado);


        //int numero = 10;
        Casa minhaCasa = new Casa();

        //Casa minhaCasa2;
        //minhaCasa2 = new Casa();

        minhaCasa.cor = "Azul";
        System.out.println(minhaCasa.cor);
        minhaCasa.abrirPorta();
        */
    }
}
