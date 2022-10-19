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
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Marcio Sousa', 22)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Gabriel Paz', 32)");

            //RECUPERAR PESSOAS
            /*String consulta =
                    "SELECT nome, idade " +
                    "FROM pessoas";
            String consulta =
                    "SELECT nome, idade " +
                    "FROM pessoas WHERE idade > 20";
            String consulta =
                    "SELECT nome, idade " +
                    "FROM pessoas WHERE idade >= 35 OR idade = 18";
            String consulta =
                    "SELECT nome, idade " +
                    "FROM pessoasWHERE idade IN(18, 32)";
            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE idade BETWEEN 30 AND 35";
            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE nome LIKE 'mar%'";
            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE nome LIKE 'mar%'";
            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE 1=1 ORDER BY idade ASC";*///DESC
            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE 1=1 ORDER BY idade DESC LIMIT 2";
            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //INDICES DA TABELA
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null){

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - nome ", nome + " , idade: " + idade);
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}