package com.cursoandroid.classeemetodosnapratica.classes;

public class Passaro extends Animal {
    void voar(){
        System.out.println("Voar como um pássado");
    }

    void correr(){
        super.correr();
        System.out.println("pássaro.");
    }
}
