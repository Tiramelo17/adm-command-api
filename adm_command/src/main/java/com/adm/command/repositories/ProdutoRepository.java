package com.adm.command.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adm.command.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
