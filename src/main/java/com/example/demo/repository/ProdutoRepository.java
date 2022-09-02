package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pro.aguiar.apiservice.model.Produto;

@Repository
public interface ProdutoRepository 
    extends JpaRepository<Produto, Long> {}