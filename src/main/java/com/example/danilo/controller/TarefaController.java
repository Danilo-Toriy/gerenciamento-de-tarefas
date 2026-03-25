package com.example.danilo.controller;

import com.example.danilo.entity.Tarefa;
import com.example.danilo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> save(@RequestBody Tarefa novaTarefa){
        Tarefa tarefa = tarefaService.save(novaTarefa);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> tarefaList = tarefaService.findAll();
        return tarefaList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(tarefaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id){
        Optional<Tarefa> tarefaAchada = tarefaService.findById(id);
        return tarefaAchada.isPresent()
                ? ResponseEntity.ok().body(tarefaAchada.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada){
        Tarefa tarefa = tarefaService.update(id, tarefaAtualizada);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        tarefaService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
