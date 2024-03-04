package com.adm.command.appService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adm.command.Handler.BusinessException;
import com.adm.command.models.Pedido;
import com.adm.command.models.Produto;
import com.adm.command.repositories.ProdutoRepository;
import com.adm.command.services.PedidoService;

@Component
public class PedidoAppService {
	
	
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	UserAppService userAppService;
	
	@Autowired
	ProdutoAppService produtoAppService;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Pedido createPedido(Pedido pedido) {
		preenchimentoValoresPedido(pedido);
		pedido.setAtendente(userAppService.findByUsername(pedido.getAtendente().getUserName()));
		
		try {
		System.out.println(pedido.getProdutos());
		//produtoRepository.save(pedido.getProdutos().get(2));
		return pedidoService.createPedido(pedido);
		} catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
	
	public Pedido findPedidoById(Integer id) {
		Pedido pedido;
		try {
			pedido = pedidoService.findPedidoById(id);
			pedido.setAtendente(userAppService.masckUser(pedido.getAtendente()));
			return pedido;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	private boolean findPedidoByNumMesa(int numMesa) {
		Pedido pedido;
		try {
			return pedidoService.findPedidoByNumMesa(numMesa);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	public void preenchimentoValoresPedido(Pedido pedido) {
		produtoAppService.calcValorProdutos(pedido.getProdutos());
		calcValorTotalPedido(pedido);
	}
	
	
	public void calcValorTotalPedido(Pedido pedido) {
		Double valorTotal = 0.0;
		
		for(Produto p : pedido.getProdutos()) {
			valorTotal += p.getValue();
		}
		pedido.setValue(valorTotal);
	}
	
	public Pedido addNewProdutoPedido(Integer idPedido,Produto produto) {
		Pedido pedido = findPedidoById(idPedido);
		if(pedido != null) {
			pedido.getProdutos().add(produto);
			return createPedido(pedido);
		}
		return pedido;
	}
	
	
	public boolean gerarFinalizacaoPedido(int numMesa) {
		return findPedidoByNumMesa(numMesa);
	}	
}
