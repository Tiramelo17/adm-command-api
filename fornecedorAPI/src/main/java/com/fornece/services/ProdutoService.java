package com.fornece.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fornece.models.Produto;
import com.fornece.respositories.ProdutoRepositories;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepositories produtoRepositories;
	
	@Transactional
	public List<Produto> obterProdutosDisponiveis() {
		return produtoRepositories.findAll();
	}
	
	@Transactional
	public Produto inserirProduto(Produto produto) {
		 return produtoRepositories.save(produto);
	}
}
