package com.adm.command;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.adm.command.appService.PedidoAppService;
import com.adm.command.models.Pedido;
import com.adm.command.models.Produto;

public class PedidoAppServiceTest {
	
	
	
	
	@Test
	void validarCalculoPedido() {
		// Exemplo de condicional para execução do teste
		Assumptions.assumeFalse("gmelo3".equals(System.getProperty("user")));
		Pedido pedido = new Pedido();
		pedido.setProdutos(new ArrayList());
		
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		
		produto1.setValue(100.00);
		produto2.setValue(32.00);
		
		pedido.getProdutos().add(produto1);
		pedido.getProdutos().add(produto2);
		PedidoAppService pedidoAppService  = new PedidoAppService();
				
		pedidoAppService.calcValorTotalPedido(pedido);
		
		Assertions.assertEquals(132.00, pedido.getValue());
	}

}
