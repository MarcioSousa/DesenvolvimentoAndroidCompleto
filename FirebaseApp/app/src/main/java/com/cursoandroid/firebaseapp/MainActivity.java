package com.cursoandroid.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    //Salvar dados no Firebase
    //private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("usuarios");
    /*private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();*/
    private ImageView imageFoto;
    private Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonUpload = findViewById(R.id.buttonUpload);
        imageFoto = findViewById(R.id.imageFoto);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Configura para imagem ser salva em memória
                imageFoto.setDrawingCacheEnabled(true);
                imageFoto.buildDrawingCache();

                //Recupera bitmap da imagem (image a ser carregada)
                Bitmap bitmap = imageFoto.getDrawingCache();

                //Comprimi bitmap para um formato png/jpeg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);

                //Converte o baos para pixel brutos em uma matriz de bytes
                //(dados da imagem)
                byte[] dadosImagem = baos.toByteArray();

                //Define nós para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                //StorageReference imagens = storageReference.child("imagens").child("foto-perfil");
                StorageReference imagens = storageReference.child("imagens");
                StorageReference imagemRef = imagens.child("celular.jpeg");

                /*Download do arquivo ou imagem do Storage
                Glide.with(MainActivity.this)
                        .using(new FirebaseImageLoader())
                        .load(imagemRef)
                        .into(imageFoto);*/
                imagemRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Glide.with(MainActivity.this).load(uri).into(imageFoto);
                        Toast.makeText(MainActivity.this,
                                "Sucesso ao alterar.",
                                Toast.LENGTH_LONG).show();
                    }
                });

                /*Deletar uma imagem ou arquivo do Storage
                imagemRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "Erro ao deletar",
                                Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this,
                                "Sucesso ao deletar o arquivo.",
                                Toast.LENGTH_LONG).show();
                    }
                });*/

                /*Nome da imagem
                String nomeArquivo = UUID.randomUUID().toString();
                StorageReference imagemRef = imagens.child("celular.jpeg");*/

                /*Retorna objeto que irá controlar o upload
                UploadTask uploadTask = imagemRef.putBytes(dadosImagem);

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "Upload da imagem falhou: " + e.getMessage().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //Versoes antigas
                        //Uri url = taskSnapshot.getDownloadUrl();
                        imagemRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                Uri url = task.getResult();
                                Toast.makeText(MainActivity.this,
                                        "Sucesso ao fazer upload: " + url.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });*/
            }
        });

        /*DatabaseReference usuarios = referencia.child("usuarios");

        Aplicando filtros
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

        /*Filtrar palavras (SEMPRE COLOCAR O \uf8ff igual está abaixo)
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("Ma").endAt("Me" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*Usuario dadosUsuario = snapshot.getValue(Usuario.class);
                Log.i("Dados usuario ", " nome: " + dadosUsuario.getNome() +
                        " idade: " + dadosUsuario.getIdade() +
                        " sobrenome: " + dadosUsuario.getSobrenome());
                Log.i("Dados usuario ", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

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

