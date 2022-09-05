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
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    // exibir
    public Produto exibir(Long id) {
        return produtoRepository.findById(id).get();
    }
    // atualizar
    public Produto atualizar(Produto produto) {
        return this.salvar(produto);
    }
    // excluir
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
    
}
