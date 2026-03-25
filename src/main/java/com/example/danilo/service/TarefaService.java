package com.example.danilo.service;

import com.example.danilo.entity.Tarefa;
import com.example.danilo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> findAll(){
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> findById(Long id){
        return tarefaRepository.findById(id);
    }

    public Tarefa save(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public void deleteById(Long id){
        tarefaRepository.deleteById(id);
    }

    public Tarefa update(Long id, Tarefa tarefa){
        Tarefa novaTarefa = tarefaRepository.findById(id).get();

        novaTarefa.setDescricao(tarefa.getDescricao());
        novaTarefa.setConclusao(tarefa.getConclusao());
        novaTarefa.setDataVencimento(tarefa.getDataVencimento());

        return tarefaRepository.save(novaTarefa);
    }
}
