package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        var usuarios = usuarioService.listar();
        if (usuarios.isEmpty())
            return ResponseEntity.ok().body("Lista vazia.");
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> exibir(@PathVariable long id) {
        try {
            var usuarios = usuarioService.exibir(id);
            return ResponseEntity.ok().body(usuarios);
        } catch (Exception e) {
            return ResponseEntity
                    .status(404)
                    .body("Nenhum Usuario encontrado.");
        }

    }

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getEmail() == null || usuario.getPassword() == null)
            return ResponseEntity.status(400)
                    .body("Username , Email e Senha Obrigatorios");

        usuario = usuarioService.salvar(usuario);
        if (usuario.getId() != 0)
            return ResponseEntity.status(201).body(usuario);

        return ResponseEntity.status(500).body("Erro interno.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getEmail() == null || usuario.getPassword() == null)
            return ResponseEntity.status(400).body("Username , Email e Senha Obrigatorios");
        usuario.setId(id);
        usuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    // @PatchMapping("/{id}")
    // public ResponseEntity alterar(@PathVariable Long id, @RequestBody Produto
    // produto) {
    // for (Produto p : produtos) {
    // if (p.getId() == id) {
    // var nome = produto.getNome();
    // p.setNome(nome);
    // var marca = produto.getMarca();
    // p.setMarca(marca);
    // return ResponseEntity.ok().body(p);
    // }
    // }
    // return ResponseEntity.status(500).body("Erro interno.");
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().body("Usuario excluido.");
    }

}
