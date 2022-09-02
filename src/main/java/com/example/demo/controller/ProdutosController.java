package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Produto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/produtos")
@RestController
public class ProdutosController {

    List<Produto> ps = new ArrayList<Produto>();

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Remover(@PathVariable Long id) {
        List<Produto> filtro = ps.stream().filter(prod -> prod.getId() == id).toList();
        if (ps.remove(filtro.get(0))) {
            return ResponseEntity.status(200).body(filtro.get(0));
        } else {
            return ResponseEntity.status(500).body("Produto não foi removido");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> Substituir(@PathVariable Long id, @RequestBody Produto p) {
        List<Produto> filtro = ps.stream().filter(prod -> prod.getId() == id).toList();
        Produto p1 = new Produto(p.getNome(), p.getMarca(), p.getPreco(), filtro.get(0).getId());
        int idp = Math.toIntExact(filtro.get(0).getId());
        try  {
            ps.add(idp-1,p1);
            ps.remove(filtro.get(0));
            return ResponseEntity.status(200).body(p1);
        } catch(Exception e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("Produto não foi atualizado");
        }

    }

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody Produto p){
        Long LastProduct = 0L;
        if(ps != null && !ps.isEmpty()){
            LastProduct = ps.get(ps.size() - 1).getId();
            p.setId(++LastProduct);
        }
        
        if(ps.add(p)){
            return ResponseEntity.status(201).body(p);
        }else{
            return ResponseEntity.status(500).body("Produto não foi Inserido");
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> Atualizar(@PathVariable long id, @RequestBody Produto p) {
        List<Produto> filtro = ps.stream().filter(prod -> prod.getId() == id).toList();
        Produto p1 = new Produto(p.getNome(), p.getMarca(), p.getPreco(),filtro.get(0).getId());
        int idp = Math.toIntExact(filtro.get(0).getId());
        try {
            ps.add(idp-1,p1);
            ps.remove(filtro.get(0));
            return ResponseEntity.status(205).body(p1);
        } catch(Exception e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("Produto não foi substituido");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> Obter(@PathVariable long id) {
        List<Produto> filtro = ps.stream().filter(prod -> prod.getId() == id).toList();
        if (!filtro.isEmpty()) {
            return ResponseEntity.status(200).body(filtro.get(0));
        } else {
            return ResponseEntity.status(404).body("Produto não Encontrado");
        }

    }

    @GetMapping
    public ResponseEntity<Object> Listar() {
        List<Produto> spr = new ArrayList<Produto>();
        for (Produto p : ps) {
            spr.add(p);
        }
        if (!spr.isEmpty()) {
            return ResponseEntity.status(200).body(spr);
        } else {
            return ResponseEntity.status(404).body("Lista Vazia");
        }

    }
}