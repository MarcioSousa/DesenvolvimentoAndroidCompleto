package com.cursoandroid.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
   public static int VERSION = 1;
   public static String NOME_DB = "DB_TAREFAS";
   public static String TABELA_TAREFAS = "tarefas";

   public DbHelper(@Nullable Context context) {
      super(context, NOME_DB, null, VERSION);
   }

   //onCreate é executado somente uma vez no celular do cliente.
   @Override
   public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS + " (" +
              "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
              "nome TEXT NOT NULL)";

      try {
         sqLiteDatabase.execSQL(sql);
         Log.i("INFO DB","Sucesso ao criar a tabela.");
      }catch (Exception ex){
         Log.i("INFO DB","Erro ao criar a tabela." + ex.getMessage());
      }

   }

   @Override
   public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
      String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;";
      //String sql = "ALTER TABLE " + TABELA_TAREFAS + " ADD COLUMN status VARCHAR(2)";

      try {
         sqLiteDatabase.execSQL(sql);
         onCreate(sqLiteDatabase);
         Log.i("INFO DB","Sucesso ao atualizar App.");
      }catch (Exception ex){
         Log.i("INFO DB","Erro ao atualizar App." + ex.getMessage());
      }
   }

}
