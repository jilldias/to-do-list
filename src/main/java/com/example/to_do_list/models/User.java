/** Classe User que representa um usuário no sistema de lista de tarefas.
 * Responsável pelas regras de negócio relacionadas aos usuários, incluindo a criação e gerenciamento de contas.
 * 
 * */


package com.example.to_do_list.models;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity //Cria uma tabela no banco de dados
@Table(name = User.TABLE_NAME) //Define o nome da tabela através da variável

public class User {

    public interface CreateUser {} //Interface para validação de criação de usuário
    public interface UpdateUser {} //Interface para validação de atualização de usuário

    public static final String TABLE_NAME = "users"; //Nome da tabela

    
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) //Gera um valor único para o id, como se fosse um auto incremento
    @Column(name = "id", unique = true) //Usa o unique para garantia para não duplicar valor
    private Long id; //Identificador único do usuário

    
    @Column(name = "name", length = 100, nullable = false) //Define o nome da coluna, tamanho máximo e se é obrigatório
    @NotNull(groups = CreateUser.class) //Garante que o valor não seja nulo
    @NotEmpty(groups = CreateUser.class) //Garante que o valor não seja vazio
    @Size(groups = CreateUser.class, min = 3, max = 100) //Define o tamanho mínimo e máximo do valor
    private String username; //Nome do usuário


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Define que o campo só pode ser escrito, não lido
    @Column(name = "password", length = 100, nullable = false) //Define o nome da coluna, tamanho máximo e se é obrigatório
    @NotNull(groups = {CreateUser.class, UpdateUser.class}) //Garante que o valor não seja nulo
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class}) //Garante que o valor não seja vazio
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 6, max = 100) //Define o tamanho mínimo e máximo do valor
    private String password; //Senha do usuário

    //private List<Task> tasks = new ArrayList<>(); //Lista de tarefas associadas ao usuário

    public User() {
        // Construtor padrão necessário para o JPA
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //Getters e Setters para os atributos da classe User

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override //Sobrescreve o método equals para comparar objetos User com base no id
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        //Casting do objeto para User para comparar os ids
        User user = (User) obj;
        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override //Sobrescreve o método hashCode para garantir que objetos iguais tenham o mesmo hash code
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}