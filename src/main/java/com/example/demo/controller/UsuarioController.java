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
    public ResponseEntity listar() {
        var usuarios = usuarioService.listar();
        if (usuarios.isEmpty())
            return ResponseEntity.ok().body("Lista vazia.");
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity exibir(@PathVariable long id) {
        try {
            var produto = usuarioService.exibir(id);
            return ResponseEntity.ok().body(produto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(404)
                    .body("Nenhum Usuario encontrado.");
        }

    }

    @PostMapping
    public ResponseEntity inserir(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getTelefone() == null)
            return ResponseEntity.status(400)
                    .body("Dados incorretos.");

        usuario = usuarioService.salvar(usuario);
        if (usuario.getId() != 0)
            return ResponseEntity.status(201).body(usuario);

        return ResponseEntity.status(500).body("Erro interno.");
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getTelefone() == null)
            return ResponseEntity.status(400).body("Dados incorretos.");
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
    public ResponseEntity remover(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().body("Usuario excluido.");
    }

}
