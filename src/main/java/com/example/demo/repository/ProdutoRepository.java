package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Produto;

@Repository
<<<<<<< HEAD
public interface ProdutoRepository 
    extends CrudRepository<Produto, Long> {}
=======
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
