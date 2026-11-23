/** Funcionalidade: Interface para operações de banco de dados relacionadas a usuários
 * Fornece métodos prontos para realizar operações de persistência de dados, como salvar, atualizar, excluir e consultar usuários no banco de dados.
 */

package com.example.to_do_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.to_do_list.models.User;



@Repository 
public interface UserRepository  extends JpaRepository<User, Long> {
    // Interface para operações de banco de dados relacionadas a usuários
    
}
