package com.cursoandroid.classeemetodosnapratica.classes;

public class Animal {
    protected int tamanho;
    protected  String cor;
    protected double peso;

    //Getter e Setter
    public void setCor(String cor){
        //Formatação ou validação
        this.cor = cor;
    }

    public String getCor(){
        return this.cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    void dormir(){
        System.out.println("Dormir como um animal.");
    }

    void correr(){
        System.out.println("Correr como um ");
    }
}
