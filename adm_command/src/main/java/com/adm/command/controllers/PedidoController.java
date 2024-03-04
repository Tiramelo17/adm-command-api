package com.adm.command.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adm.command.appService.PedidoAppService;
import com.adm.command.models.Item;
import com.adm.command.models.Pedido;
import com.adm.command.models.Produto;

@RestController
public class PedidoController {
	
	@Autowired
	PedidoAppService pedidoAppService;
	
	@GetMapping("/pedido")
	public Pedido findPedidoById(@RequestParam(name = "id") Integer id) {
		return pedidoAppService.findPedidoById(id);
	}
	
	
	@PostMapping("/pedido/create")
	public Pedido createNewPedido(@RequestBody Pedido pedido) {
		return pedidoAppService.createPedido(pedido);
	}
	
	@PutMapping("/pedido/update")
	public Pedido addNewProdutoPedido(@RequestParam(name = "idPedido") Integer idPedido, @RequestBody Produto produto) {
		return pedidoAppService.addNewProdutoPedido(idPedido,produto);
	}
	
	@PostMapping("/pedido/finish")
	public boolean finissPedido(@RequestParam(name = "numMesa") int numMesa) {
		return pedidoAppService.gerarFinalizacaoPedido(numMesa);
	}
}
