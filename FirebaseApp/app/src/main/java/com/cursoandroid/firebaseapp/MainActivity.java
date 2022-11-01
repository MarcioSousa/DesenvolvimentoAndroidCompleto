package com.cursoandroid.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("usuarios");
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando somente um dado.
        //DatabaseReference usuarios = referencia.child("usuarios").child("001");
        DatabaseReference usuarios = referencia.child("usuarios");
        DatabaseReference produtos = referencia.child("produtos");

        //Recuperar dados do Firebase
        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //É chamado sempre que conseguir recuperar os dados e alterados.
                Log.i("Firebase", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Cancelamento de requisição

            }
        });

        /*Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setSobrenome("Souza");
        usuario.setIdade(22);

        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();

        produto1.setDescricao("Pilha");
        produto1.setMarca("Haiovak");
        produto1.setPreco(120.3);

        produto2.setDescricao("Toalha");
        produto2.setMarca("Hanson");
        produto2.setPreco(18.90);

        produto3.setDescricao("Celular");
        produto3.setMarca("Motorola");
        produto3.setPreco(1234.1);

        produtos.child("001").setValue(produto1);
        produtos.child("002").setValue(produto2);
        produtos.child("003").setValue(produto3);*/

        //usuarios.child("002").setValue(usuario);

        //referencia.child("pontos").setValue("100");
        //referencia.child("usuarios2").child("002").child("nome").setValue("Marcio Sousa");
        //referencia.child("usuarios2").child("002").child("nome").setValue("Marcio Sousa");



    }

}