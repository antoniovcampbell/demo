package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "usuarios")
<<<<<<< HEAD
public class Usuario implements UserDetails{
=======
public class Usuario implements UserDetails {
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String cep;
<<<<<<< HEAD
    
=======

>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
    private String password;
    private String username;
    private Boolean enabled = true;
    private Boolean credentialsNonExpired = true;
    private Boolean accountNonExpired = true;
<<<<<<< HEAD
    private Boolean accountNonLocked= true;
    private String authorities = "USER";



=======
    private Boolean accountNonLocked = true;
    private String authorities = "USER";
    
    
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
    public Usuario(){

    }
    public Usuario(long id,String nome,String email,String telefone,String cep){
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setCep(cep);
    }
    public Usuario(String nome,String email,String telefone,String cep){
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setCep(cep);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
<<<<<<< HEAD
=======

    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

<<<<<<< HEAD
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

=======
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
    
}