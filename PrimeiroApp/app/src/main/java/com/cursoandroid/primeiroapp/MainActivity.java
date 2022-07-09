package com.cursoandroid.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alterarTexto(View view){

        TextView texto = findViewById(R.id.txtExibicao);

        if(texto.getText() == "Marcio Sousa."){
            texto.setText("Clique Abaixo!");
        }else{
            texto.setText("Marcio Sousa.");
        }


    }

}
