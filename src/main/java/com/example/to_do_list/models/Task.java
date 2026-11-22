/**
 * 
 * 
 * 
 */

package com.example.to_do_list.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = Task.TABLE_NAME) //Define o nome da tabela através da variável

public class Task {
    public static final String TABLE_NAME = "tasks"; //Nome da tabela

    public interface CreateTask {} //Interface para validação de criação de tarefa

    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) //Gera um valor único para o id, como se fosse um auto incremento
    @Column(name = "id", unique = true) //Usa o unique para garantia para não duplicar valor
    private Long id; //Identificador único da tarefa        

    @ManyToOne 
    @JoinColumn (name = "user_id", nullable = false) //Define a coluna que será usada para fazer o relacionamento com a tabela de usuários
    private User user;  

    @Column(name = "description", length = 255, nullable = false) //Define o nome da coluna, tamanho máximo e se é obrigatório
    @NotNull(groups = CreateTask.class) //Garante que o valor não seja nulo
    @NotEmpty(groups = CreateTask.class) //Garante que o valor não seja vazio
    @Size(groups = CreateTask.class, min = 3, max = 255) //Define o tamanho mínimo e máximo do valor


    private String description; //Descrição da tarefa

    public Task() {
        // Construtor padrão necessário para o JPA
    }   

    public Task(Long id, User user, String description) {
        this.id = id;
        this.user = user;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override //Sobrescreve o método equals para comparar objetos da classe Task com base no id
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        // Casting do objeto para Task
        Task other = (Task) obj;

        return id != null ? id.equals(other.id) : other.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    }
