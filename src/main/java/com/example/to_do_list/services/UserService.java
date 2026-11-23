package com.example.to_do_list.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.to_do_list.models.User;
import com.example.to_do_list.repositories.TaskRepository;
import com.example.to_do_list.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service 
public class UserService {

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId); 
        return user.orElseThrow(() -> new RuntimeException("User not found")); // Retorna o usuário encontrado ou lança uma exceção se não existir
}
    
    @Transactional 
    public User createUser(User obj) {
        obj.setId(null); // Garante que o ID seja nulo para criar um novo usuário
        obj = this.userRepository.save(obj); // Salva o usuário no banco de dados
        this.taskRepository.saveAll(obj.getTasks()); // Salva todas as tarefas associadas ao usuário
        return obj; // Retorna o usuário salvo  
    }

    @Transactional
    public User update(User obj) {
        User newObj = findUserById(obj.getId());
        newObj.setPassword(obj.getPassword()); // Atualiza a senha do usuário
        return this.userRepository.save(newObj); // Salva as alterações no banco de dados
    }

    public void delete(Long userId) {
        try {
            this.userRepository.deleteById(userId); // Tenta remover o usuário pelo ID
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir pois há entidades associadas ao ID: " + userId, e); // Lança uma exceção se ocorrer algum erro
        }
    }

}
