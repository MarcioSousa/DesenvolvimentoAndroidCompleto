package com.cursoandroid.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    private CheckBox cbxVerde, cbxBranco, cbxVermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);

        //Checkbox
        cbxVerde = findViewById(R.id.cbxVerde);
        cbxBranco = findViewById(R.id.cbxBranco);
        cbxVermelho = findViewById(R.id.cbxVermelho);
    }

    public void checkbox(){
        String texto = "";


        if(cbxVerde.isChecked()){
            texto = "Verde selecionado - ";
            //String corSelecionada = cbxVerde.getText().toString();
            //texto = corSelecionada;
        }

        if(cbxBranco.isChecked()){
            texto = texto + "Branco selecionado - ";
        }

        if(cbxVermelho.isChecked()){
            texto = texto + "Vermelho selecionado - ";
        }



        textoResultado.setText(texto);

    }

    public void enviar(View view){
        /*
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textoResultado.setText("Nome: " + nome + ", e-mail: " + email);
        */

        checkbox();

    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
    }

}
