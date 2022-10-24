package com.cursoandroid.listadetarefas.helper;

//I de interface
//Salvar, Atualizar, Deletar e Listar todas as tarefas.

import com.cursoandroid.listadetarefas.model.Tarefa;

import java.util.List;

public interface ITarefaDAO {
    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();
}
