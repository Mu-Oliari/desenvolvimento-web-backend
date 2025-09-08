package com.mu.oliari.desenvolvimento_web_backend.service;

import com.mu.oliari.desenvolvimento_web_backend.model.Tarefa;
import com.mu.oliari.desenvolvimento_web_backend.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa create(Tarefa task){
        return tarefaRepository.save(task);
    }

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Tarefa findById(long id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.get();
    }

    public Tarefa update(long id, Tarefa taskUpdate) {
        ResponseEntity<Tarefa> optional = tarefaRepository.findById(id).map(task -> {
            task.setNome(taskUpdate.getNome());
            task.setDataEntrega(taskUpdate.getDataEntrega());
            task.setResponsavel(taskUpdate.getResponsavel());
            return ResponseEntity.ok(tarefaRepository.save(task));
        }).orElseThrow();
        return taskUpdate;
    }

    public boolean delete(long id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        tarefaRepository.delete(optional.get());
        return true;
    }

}
