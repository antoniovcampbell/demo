package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    // Listar
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }
    
    // criar
    
    // exibir

    // atualizar

    // excluir
    
}
