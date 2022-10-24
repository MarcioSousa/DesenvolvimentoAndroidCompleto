package com.cursoandroid.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cursoandroid.listadetarefas.model.Tarefa;

import java.util.List;

//DAO -- Data Access Object -- Salvar, Atualizar, Deletar e Listar todas as tarefas.

public class TarefaDAO implements ITarefaDAO{
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        //cv.put("nome", "teste");
        //cv.put("status", "E");

        try {
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.e("INFO","Tarefa salva com sucesso!");
        }catch (Exception e){
            Log.e("INFO","Erro ao salvar tarefa." + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }



}
