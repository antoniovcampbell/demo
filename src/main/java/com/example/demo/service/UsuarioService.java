package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    // Listar
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    // criar
    public Usuario salvar(Usuario usuario) throws IllegalArgumentException{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = usuario.getPassword();
        String bcryptPassword = encoder.encode(password);
        usuario.setPassword(bcryptPassword);
        return usuarioRepository.save(usuario);
    }
    // exibir
    public Usuario exibir(Long id) throws IllegalArgumentException{
        return usuarioRepository.findById(id).get();
    }
    // atualizar
    public Usuario atualizar(Usuario usuario) {
        return this.salvar(usuario);
    }
    // excluir
    public void excluir(Long id) throws IllegalArgumentException{
        usuarioRepository.deleteById(id);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
    
}


