package com.mu.oliari.desenvolvimento_web_backend.repository;

import com.mu.oliari.desenvolvimento_web_backend.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
