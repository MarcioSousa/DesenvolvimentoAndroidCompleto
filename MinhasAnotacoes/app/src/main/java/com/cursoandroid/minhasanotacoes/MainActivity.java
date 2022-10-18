package com.cursoandroid.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cursoandroid.minhasanotacoes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validar se o usuário digitor algo.
                String textoRecuperado = editAnotacao.getText().toString();

                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                }else{
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }

                //Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

            }
        });

        //Recuperar a anotação
        String anotacao = preferencias.recuperarAnotacao();

        //Verificar se tem alguma anotação gravada.
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }

    }

}