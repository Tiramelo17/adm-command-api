package com.adm.command.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.command.appService.ProdutosFornecedorAppService;
import com.adm.command.models.Produto;

@RestController
public class ProdutosFornecedorController {
	
	@Autowired
	ProdutosFornecedorAppService produtoService;
	
	@GetMapping("produtos/fornecedor")
	public List<Produto> buscarProdutosFornecedor() {
		return produtoService.obterProdutosFornecedor();
	}
}
