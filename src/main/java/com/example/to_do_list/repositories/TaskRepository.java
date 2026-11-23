package com.example.to_do_list.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.to_do_list.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Interface para operações de banco de dados relacionadas a tarefas

    List<Task> findByUserId(Long userId); // Método para buscar tarefas por ID do usuário
    
}

// Exemplo com JPQL: Buscar todas as tarefas associadas a um usuário específico
// @Query("SELECT t FROM Task t WHERE t.user.id = :userId")
// List<Task> findTasksByUserId(@Param("userId") Long userId);


// Exemplo: Buscar tarefas pela descrição, ignorando diferenças entre maiúsculas e minúsculas
// @Query("SELECT t FROM Task t WHERE LOWER(t.description) LIKE LOWER(CONCAT('%', :description, '%'))")
// List<Task> findTasksByDescription(@Param("description") String description);