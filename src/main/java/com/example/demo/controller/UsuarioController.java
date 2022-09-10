package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Cliente;

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

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
    List<Cliente> clis = new ArrayList<Cliente>();

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Remover(@PathVariable Long id){
        List<Cliente> filtro = clis.stream().filter(cli -> cli.getId() == id).toList();
        if(clis.remove(filtro.get(0))){
            return ResponseEntity.status(200).body(filtro.get(0));
        }else{
            return ResponseEntity.status(500).body("Cliente não doi removido");
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> Substituir(@PathVariable Long id, @RequestBody Cliente c){
        List<Cliente> filtro = clis.stream().filter(cli -> cli.getId() == id).toList();
        Cliente c1 = new Cliente(c.getNome(),c.getIdade(),filtro.get(0).getId(),c.getEmail());
        int idc = Math.toIntExact(filtro.get(0).getId());
        try{
            clis.add(idc-1,c1);
            clis.remove(filtro.get(0));
            return ResponseEntity.status(201).body(c1);
        }catch(Exception e){
            System.out.println(e);
            return ResponseEntity.status(500).body("Cliente não foi atualizado");
        }
        
       
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody Cliente c){
        Long LastClient = 0L;
        if(clis != null && !clis.isEmpty())
        LastClient = clis.get(clis.size() - 1).getId();
        c.setId(++LastClient);
        if(clis.add(c)){
            return ResponseEntity.status(201).body(c);
        }else{
            return ResponseEntity.status(500).body("Usuario não foi inserido");
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> Atualizar(@PathVariable long id, @RequestBody Cliente c){
        List<Cliente> filtro = clis.stream().filter(cli -> cli.getId() == id).toList();
        Cliente c1 = new Cliente(c.getNome(),c.getIdade(),filtro.get(0).getId(),c.getEmail());
        int idc = Math.toIntExact(filtro.get(0).getId());
        
        try{
            clis.add(idc-1,c1);
            clis.remove(filtro.get(0));
            return ResponseEntity.status(205).body(c1);
        }catch(Exception e){
            System.out.println(e);
            return ResponseEntity.status(500).body("Usuario não foi substituido");
        }
    
        
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> Obter(@PathVariable long id){
        List<Cliente> filtro = clis.stream().filter(cli -> cli.getId() == id).toList();
        if(!filtro.isEmpty()){
           return ResponseEntity.status(200).body(filtro.get(0));
        }else{
           return ResponseEntity.status(404).body("Nao Encontrado");
        }
        
    }
    @GetMapping
    public ResponseEntity<Object> Listar(){
        
        if(!clis.isEmpty()){
            return ResponseEntity.status(200).body(clis);
        }else{
            return ResponseEntity.status(404).body("Lista Vazia");
        }

    }


}
