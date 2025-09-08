package com.mu.oliari.desenvolvimento_web_backend.controller;

import com.mu.oliari.desenvolvimento_web_backend.model.Tarefa;
import com.mu.oliari.desenvolvimento_web_backend.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Tarefa tarefa) {
        Tarefa task = tarefaService.create(tarefa);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao criar usuário.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Tarefa> task = tarefaService.findAll();
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar usuários.");
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        Tarefa task = tarefaService.findById(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID: " + id + " não encontrado.");
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa) {
        Tarefa task = tarefaService.update(id, tarefa);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao atualizar usuário com ID: " + id);
        }
        return ResponseEntity.ok(task);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        boolean task = tarefaService.delete(id);
        if (!task) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar usuário com ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
