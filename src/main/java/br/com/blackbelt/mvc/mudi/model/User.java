package br.com.blackbelt.mvc.mudi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    private String username;
    private String password;
    private Boolean enabled;

    //Um usuáruio possui vários produtos em sua lista
    //Mapeia o usuário la na tabela pedido
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user", //nome da classe
            fetch = FetchType.LAZY
    )
    private List<Produto> produtos;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Perfil> perfis = new ArrayList<>();

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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
