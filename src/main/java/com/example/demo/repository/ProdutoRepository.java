package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Produto;

@Repository
public interface ProdutoRepository 
    extends CrudRepository<Produto, Long> {}