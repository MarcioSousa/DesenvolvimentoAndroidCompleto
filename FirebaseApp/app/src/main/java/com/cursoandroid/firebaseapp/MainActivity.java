package com.cursoandroid.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //Salvar dados no Firebase
    //private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("usuarios");
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = referencia.child("usuarios");

        /*Aplicando filtros
        DatabaseReference usuarioPesquisa = usuarios.child("-NFotL5V_6oiQqsSN7CH");
        Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Marcio");
        Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);
        Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);*/

        /*Maior ou igual (>=)
        Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(35);*/

        /*Menos ou igual (<=)
        Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(22);*/

        /*Entre dois valores
        Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(15).endAt(30);*/

        /*Filtrar palavras (SEMPRE COLOCAR O \uf8ff igual está abaixo)*/
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("Ma").endAt("Me" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*Usuario dadosUsuario = snapshot.getValue(Usuario.class);
                Log.i("Dados usuario ", " nome: " + dadosUsuario.getNome() +
                        " idade: " + dadosUsuario.getIdade() +
                        " sobrenome: " + dadosUsuario.getSobrenome());*/
                Log.i("Dados usuario ", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*Usuario usuario = new Usuario();
        usuario.setNome("Rodrigo");
        usuario.setSobrenome("Matos");
        usuario.setIdade(35);

        //usuarios.child("001")
        /*Gerando identificador único
        usuarios.push().setValue(usuario);*/

        /*Deslogar usuário
        usuario.signOut();*/

        /*Logar usuario
        usuario.signInWithEmailAndPassword("marcio22@gmail.com","a1b2c3d4")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("SIGNIN","Sucesso ao Logar Usuário.");
                        }else{
                            Log.i("SIGNIN","Erro ao Logar Usuário.");
                        }
                    }
                });*/

        /*Verifica usuario logado
        if(usuario.getCurrentUser() != null){
            //Está logado
            Log.i("CurrentUser", "Usuário logado.");
        }else{
            Log.i("CurrentUser", "Usuário não logado.");
        }*/


        /*Cadastro de usuario
        usuario.createUserWithEmailAndPassword("marcio22@gmail.com","a1b2c3d4")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CREATEUSER", "Sucesso ao cadastrar o usuário.");
                        }else{
                            Log.i("CREATEUSER", "Erro ao cadastrar o usuário.");
                        }
                    }
                });*/

        /*
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

        Usuario usuario = new Usuario();
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