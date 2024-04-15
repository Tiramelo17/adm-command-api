package com.fornece.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fornece.models.Produto;

@Repository
public interface ProdutoRepositories extends JpaRepository<Produto, Integer> {

}
