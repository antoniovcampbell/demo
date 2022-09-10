package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    // Listar
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    // criar
    public Usuario salvar(Usuario produto) {
        return usuarioRepository.save(produto);
    }
    // exibir
    public Usuario exibir(Long id) {
        return usuarioRepository.findById(id).get();
    }
    // atualizar
    public Usuario atualizar(Usuario produto) {
        return this.salvar(produto);
    }
    // excluir
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
    
}


