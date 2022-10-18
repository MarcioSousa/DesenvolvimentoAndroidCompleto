package com.cursoandroid.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cria um arquivo xml para salvar as informações ou dados.
                SharedPreferences preferences = getSharedPreferences(
                        ARQUIVO_PREFERENCIA,
                        0 //0 = PRIVADO
                );
                SharedPreferences.Editor editor = preferences.edit();

                //Validar o Nome
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o nome.", Toast.LENGTH_LONG).show();
                }else{
                    //SALVAR OS DADOS
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textResultado.setText("Olá, " + nome);
                }

            }
        });

        //RECUPERAR DADOS SALVOS
        SharedPreferences preferences = getSharedPreferences(
                ARQUIVO_PREFERENCIA,
                0 //0 = PRIVADO
        );

        //VALIDA SE TEMOS O NOME EM PREFERENCIAS
        if(preferences.contains("nome")){
            String nome = preferences.getString("nome","usuário não definido.");
            textResultado.setText("Olá, " + nome);
        }else{
            textResultado.setText("Olá, usuário não definido.");
        }

    }
}