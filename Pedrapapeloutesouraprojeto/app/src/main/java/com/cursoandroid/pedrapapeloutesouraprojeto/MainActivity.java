package com.cursoandroid.pedrapapeloutesouraprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");

    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView txtAviso = findViewById(R.id.txtAviso);

        int numero = new Random().nextInt(3); //0, 1, 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            default:
                imgResultado.setImageResource(R.drawable.tesoura);
        }

        if((opcaoSelecionada == "pedra" && opcaoApp == "pedra") || (opcaoSelecionada == "papel" && opcaoApp == "papel") || (opcaoSelecionada == "tesoura" && opcaoApp == "tesoura")){
            txtAviso.setText("VOCÊ EMPATOU! ;)");
        }else if((opcaoSelecionada == "pedra" && opcaoApp == "tesoura") || (opcaoSelecionada == "papel" && opcaoApp == "pedra") || (opcaoSelecionada == "tesoura" && opcaoApp == "papel")){
            txtAviso.setText("VOCÊ GANHOU! :)");
        }else{
            txtAviso.setText("VOCÊ PERDEU! :(");
        }

    }

}
