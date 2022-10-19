package com.cursoandroid.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //CRIAR BANCO DE DADOS
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //CRIAR TABELA
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

            //INSERIR DADOS
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Marcio Sousa', 22)");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Gabriel Paz', 32)");

            //RECUPERAR PESSOAS
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

            //INDICES DA TABELA
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null){
                Log.i("RESULTADO - nome: ", cursor.getString(indiceNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceIdade));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}