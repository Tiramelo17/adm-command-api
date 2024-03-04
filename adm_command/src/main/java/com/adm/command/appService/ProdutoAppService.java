package com.adm.command.appService;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adm.command.models.Produto;

@Component
public class ProdutoAppService {

	public void calcValorProdutos(List<Produto> produtos) {
		for(Produto p : produtos) {
			p.setValue(p.getQtdItens() * p.getItem().getValue());
		}
	}
}
