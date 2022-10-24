package com.cursoandroid.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cursoandroid.listadetarefas.model.Tarefa;

import java.util.ArrayList;
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
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        //cv.put("status",tarefas.getStatus());

        try {
            String[] args = {tarefa.getId().toString()};
            //String[] args = {"5", "E"};
            //escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=? AND status = ?", args);
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args);
            Log.e("INFO","Tarefa atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO","Erro ao atualizar tarefa." + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + ";";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){
            Tarefa tarefa = new Tarefa();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            tarefas.add(tarefa);
        }

        return tarefas;
    }



}
