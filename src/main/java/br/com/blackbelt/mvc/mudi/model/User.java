package br.com.blackbelt.mvc.mudi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String password;
    private Boolean enabled;

    //Um usuárui possui vários produtos em sua lista
    //Mapeia o usuário la na tabela pedido
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user", //nome da classe
            fetch = FetchType.LAZY
    )
    private List<Produto> produtos;

    public User() {
    }

    public User(String username, String password, Boolean enable, List<Produto> produtos) {
        this.username = username;
        this.password = password;
        this.enabled = enable;
        this.produtos = produtos;
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

    public Boolean getEnable() {
        return enabled;
    }

    public void setEnable(Boolean enable) {
        this.enabled = enable;
    }
}
