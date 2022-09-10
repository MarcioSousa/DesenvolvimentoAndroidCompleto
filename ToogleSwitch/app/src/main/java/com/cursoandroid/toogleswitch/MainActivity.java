package com.cursoandroid.toogleswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleSenha;
    private Switch switchSenha;
    private TextView textResultado;
    private CheckBox checkSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSenha = findViewById(R.id.toggleSenha);
        switchSenha = findViewById(R.id.switchSenha);
        textResultado = findViewById(R.id.textResultado);
        checkSenha = findViewById(R.id.checkBox);

        adicionarListener();
    }

    public void adicionarListener(){
        toggleSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    textResultado.setText("Ligado.");
                }else{
                    textResultado.setText("Desligado");
                }
            }
        });

        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    textResultado.setText("Ligado.");
                }else{
                    textResultado.setText("Desligado");
                }
            }
        });

        checkSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    textResultado.setText("Ligado.");
                }else{
                    textResultado.setText("Desligado");
                }
            }
        });
    }

    public void enviar(View view){
        //switchSenha.isChecked()
        //toggleSenha.isChecked()
        if(checkSenha.isChecked()){
            textResultado.setText("Check ligado.");
        }else{
            textResultado.setText("Check desligado");
        }

        /*
        if(toggleSenha.isChecked()){
            textResultado.setText("Toggle ligado.");
        }else{
            textResultado.setText("Toggle desligado");
        }

        if(switchSenha.isChecked()){
            textResultado.setText("Switch ligado.");
        }else{
            textResultado.setText("Switch desligado");
        }
        */

    }

}
