package com.fornece.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fornece.models.Produto;
import com.fornece.services.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService; 

	@GetMapping("/produtos")
	public List<Produto> obterProdutos(){
		return produtoService.obterProdutosDisponiveis();
	}
	
	
	@PostMapping("/produtos/cadastro")
	public Produto inserirProduto(@RequestBody Produto produto) {
		return produtoService.inserirProduto(produto);
	}
}
